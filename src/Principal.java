
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.*;

public class Principal {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        List<String> moedas = Arrays.asList("USD", "BRL", "ARS", "BOB", "CLP", "COP", "EUR", "JPY");

        Map<String, String> nomesMoedas = new HashMap<>();
        nomesMoedas.put("USD", "Dólar Americano");
        nomesMoedas.put("BRL", "Real Brasileiro");
        nomesMoedas.put("ARS", "Peso Argentino");
        nomesMoedas.put("BOB", "Boliviano");
        nomesMoedas.put("CLP", "Peso Chileno");
        nomesMoedas.put("COP", "Peso Colombiano");
        nomesMoedas.put("EUR", "Euro");
        nomesMoedas.put("JPY", "Iene Japonês");


        List<String> historico = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

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

            System.out.println("\nEscolha a moeda de destino:");
            for (int i = 0; i < moedas.size(); i++) {
                if (i == escolhaOrigem - 1) continue;
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

            System.out.print("\nDigite o valor que deseja converter: ");
            double valor;
            try {
                valor = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido.");
                continue;
            }

            String url = "https://v6.exchangerate-api.com/v6/028c0349d7f37794b50dce8c/latest/" + moedaOrigem;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject rates = json.getAsJsonObject("conversion_rates");

            if (!rates.has(moedaDestino)) {
                System.out.println("Moeda de destino não encontrada.");
                continue;
            }

            double taxa = rates.get(moedaDestino).getAsDouble();
            double convertido = valor * taxa;

            System.out.println("\n==============================");
            System.out.printf("  %.2f [%s] -> %.2f [%s]\n", valor, moedaOrigem, convertido, moedaDestino);
            System.out.printf("  %s para %s\n", nomesMoedas.get(moedaOrigem), nomesMoedas.get(moedaDestino));
            System.out.println("==============================");

            String dataHora = LocalDateTime.now().format(formatter);
            String registro = String.format("[%s] %.2f [%s] -> %.2f [%s] (%s para %s)",
                    dataHora, valor, moedaOrigem, convertido, moedaDestino,
                    nomesMoedas.get(moedaOrigem), nomesMoedas.get(moedaDestino));
            historico.add(registro);
        }

        System.out.println("\n==== HISTÓRICO DE CONVERSÕES ====");
        for (String item : historico) {
            System.out.println(item);
        }

        System.out.println("Programa encerrado.");
    }
}
