package moedas;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class Opcao2 {
        public static void main(String[] args) throws IOException, InterruptedException {
            Scanner scanner = new Scanner(System.in);

            // Mapa com opções do menu e os pares de moedas (origem -> destino)
            Map<Integer, String[]> opcoes = new LinkedHashMap<>();
            opcoes.put(1, new String[]{"USD", "ARS"});
            opcoes.put(2, new String[]{"ARS", "USD"});
            opcoes.put(3, new String[]{"USD", "BRL"});
            opcoes.put(4, new String[]{"BRL", "USD"});
            opcoes.put(5, new String[]{"USD", "COP"});
            opcoes.put(6, new String[]{"COP", "USD"});

            int escolha = 0;

            while (escolha != 7) {
                System.out.println("*********************************************");
                System.out.println("Seja bem-vindo/a ao Conversor de Moeda =]");
                for (Map.Entry<Integer, String[]> entrada : opcoes.entrySet()) {
                    int opcao = entrada.getKey();
                    String[] moedas = entrada.getValue();
                    System.out.println(opcao + ") " + nomeMoeda(moedas[0]) + " =>> " + nomeMoeda(moedas[1]));
                }
                System.out.println("7) Sair");
                System.out.print("Escolha uma opção válida: ");
                System.out.println("\n*********************************************");

                try {
                    escolha = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Digite um número de 1 a 7.\n");
                    continue;
                }

                if (escolha == 7) {
                    System.out.println("Programa encerrado. Obrigado!");
                    break;
                }

                if (!opcoes.containsKey(escolha)) {
                    System.out.println("Opção inválida. Tente novamente.\n");
                    continue;
                }

                String moedaOrigem = opcoes.get(escolha)[0];
                String moedaDestino = opcoes.get(escolha)[1];

                System.out.print("Digite o valor que deseja converter: ");
                double valor;
                try {
                    valor = Double.parseDouble(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Valor inválido.\n");
                    continue;
                }

                String url = "https://v6.exchangerate-api.com/v6/028c0349d7f37794b50dce8c/latest/" + moedaOrigem;
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                JsonObject conversionRates = JsonParser.parseString(response.body())
                        .getAsJsonObject()
                        .getAsJsonObject("conversion_rates");

                if (conversionRates.has(moedaDestino)) {
                    double taxa = conversionRates.get(moedaDestino).getAsDouble();
                    double convertido = valor * taxa;
                    System.out.printf("Valor %.2f [%s] corresponde ao valor final de =>>> %.2f [%s]\n\n",
                            valor, moedaOrigem, convertido, moedaDestino);
                } else {
                    System.out.println("Moeda de destino não encontrada na resposta da API.");
                }
            }
        }

        // Nome amigável para o menu
        private static String nomeMoeda(String codigo) {
            return switch (codigo) {
                case "USD" -> "Dólar";
                case "ARS" -> "Peso argentino";
                case "BRL" -> "Real brasileiro";
                case "COP" -> "Peso colombiano";
                case "BOB" -> "Boliviano";
                case "CLP" -> "Peso chileno";
                default -> codigo;
            };
        }
    }


