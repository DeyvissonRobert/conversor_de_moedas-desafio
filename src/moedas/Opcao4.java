package moedas;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.*; // importa List, Map, Scanner etc.
import com.google.gson.*; // importa classes para ler JSON

public class Opcao4 {
        public static void main(String[] args) throws Exception {

            Scanner scanner = new Scanner(System.in); // cria leitor de entrada do usuário

            // Lista de moedas disponíveis para conversão
            List<String> moedas = Arrays.asList("USD", "BRL", "ARS", "BOB", "CLP", "COP");

            // Mapa com os nomes completos das moedas
            Map<String, String> nomesMoedas = new HashMap<>();
            nomesMoedas.put("USD", "Dólar Americano");
            nomesMoedas.put("BRL", "Real Brasileiro");
            nomesMoedas.put("ARS", "Peso Argentino");
            nomesMoedas.put("BOB", "Boliviano");
            nomesMoedas.put("CLP", "Peso Chileno");
            nomesMoedas.put("COP", "Peso Colombiano");

            // Loop principal do menu
            while (true) {
                System.out.println("\n======= CONVERSOR DE MOEDAS =======");
                System.out.println("Escolha a moeda de origem:");
                for (int i = 0; i < moedas.size(); i++) {
                    System.out.println((i + 1) + " - " + moedas.get(i) + " (" + nomesMoedas.get(moedas.get(i)) + ")");
                }
                System.out.println("0 - Sair");

                int escolhaOrigem;
                try {
                    escolhaOrigem = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Opção inválida.");
                    continue;
                }

                if (escolhaOrigem == 0) break;
                if (escolhaOrigem < 1 || escolhaOrigem > moedas.size()) {
                    System.out.println("Opção inválida.");
                    continue;
                }

                String moedaOrigem = moedas.get(escolhaOrigem - 1);

                // Escolhe moeda de destino
                System.out.println("\nEscolha a moeda de destino:");
                for (int i = 0; i < moedas.size(); i++) {
                    if (i == escolhaOrigem - 1) continue; // não mostra a mesma
                    System.out.println((i + 1) + " - " + moedas.get(i) + " (" + nomesMoedas.get(moedas.get(i)) + ")");
                }

                int escolhaDestino;
                try {
                    escolhaDestino = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Opção inválida.");
                    continue;
                }

                if (escolhaDestino == escolhaOrigem || escolhaDestino < 1 || escolhaDestino > moedas.size()) {
                    System.out.println("Destino inválido.");
                    continue;
                }

                String moedaDestino = moedas.get(escolhaDestino - 1);

                // Lê o valor que será convertido
                System.out.print("\nDigite o valor que deseja converter: ");
                double valor;
                try {
                    valor = Double.parseDouble(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Valor inválido.");
                    continue;
                }

                // Monta a URL com a moeda de origem
                String url = "https://v6.exchangerate-api.com/v6/028c0349d7f37794b50dce8c/latest/" + moedaOrigem;

                // Faz a requisição HTTP para pegar as taxas de câmbio
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                // Lê a resposta JSON e pega o valor da moeda destino
                JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
                JsonObject rates = json.getAsJsonObject("conversion_rates");

                if (!rates.has(moedaDestino)) {
                    System.out.println("Moeda de destino não encontrada na resposta.");
                    continue;
                }

                double taxa = rates.get(moedaDestino).getAsDouble();
                double convertido = valor * taxa;

                // Exibe o resultado no estilo da imagem
                System.out.println("\n==============================");
                System.out.printf("  %.2f [%s] -> %.2f [%s]\n",
                        valor, moedaOrigem, convertido, moedaDestino);
                System.out.printf("  %s para %s\n",
                        nomesMoedas.get(moedaOrigem), nomesMoedas.get(moedaDestino));
                System.out.println("==============================");
            }

            System.out.println("Programa encerrado.");
        }
    }


