package testes;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class Opcao3 {
        public static void main(String[] args) throws IOException, InterruptedException {
            Scanner scanner = new Scanner(System.in);

            // Lista de moedas válidas
            List<String> moedas = Arrays.asList("USD", "BRL", "ARS", "BOB", "CLP", "COP");

            Map<String, String> nomesMoedas = new HashMap<>();
            nomesMoedas.put("USD", "Dólar");
            nomesMoedas.put("BRL", "Real brasileiro");
            nomesMoedas.put("ARS", "Peso argentino");
            nomesMoedas.put("BOB", "Boliviano");
            nomesMoedas.put("CLP", "Peso chileno");
            nomesMoedas.put("COP", "Peso colombiano");

            while (true) {
                System.out.println("*********************************************");
                System.out.println("Seja bem-vindo/a ao Conversor de Moeda =]");
                System.out.println("Moedas disponíveis para conversão:");
                for (int i = 0; i < moedas.size(); i++) {
                    System.out.printf("%d) %s\n", i + 1, nomesMoedas.get(moedas.get(i)));
                }
                System.out.println("7) Sair");
                System.out.print("Escolha a moeda de ORIGEM: ");
                System.out.println("\n*********************************************");

                int opcaoOrigem;
                try {
                    opcaoOrigem = Integer.parseInt(scanner.nextLine());
                    if (opcaoOrigem == 7) {
                        System.out.println("Programa finalizado. Até a próxima!");
                        break;
                    }
                    if (opcaoOrigem < 1 || opcaoOrigem > 6) {
                        System.out.println("Opção inválida. Tente novamente.\n");
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida.\n");
                    continue;
                }

                String moedaOrigem = moedas.get(opcaoOrigem - 1);

                System.out.println("\n*********************************************");
                System.out.println("Escolha a moeda de DESTINO:");
                for (int i = 0; i < moedas.size(); i++) {
                    if (i != (opcaoOrigem - 1)) {
                        System.out.printf("%d) %s\n", i + 1, nomesMoedas.get(moedas.get(i)));
                    }
                }
                System.out.print("Digite a opção: ");

                int opcaoDestino;
                try {
                    opcaoDestino = Integer.parseInt(scanner.nextLine());
                    if (opcaoDestino < 1 || opcaoDestino > 6 || opcaoDestino == opcaoOrigem) {
                        System.out.println("Opção inválida. Tente novamente.\n");
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida.\n");
                    continue;
                }

                String moedaDestino = moedas.get(opcaoDestino - 1);

                System.out.print("\nDigite o valor que deseja converter: ");
                double valor;
                try {
                    valor = Double.parseDouble(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Valor inválido.\n");
                    continue;
                }

                // Chamada da API
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
                    System.out.printf("\nValor %.2f [%s] corresponde ao valor final de =>>> %.2f [%s]\n\n",
                            valor, moedaOrigem, convertido, moedaDestino);
                } else {
                    System.out.println("Moeda de destino não encontrada na resposta da API.");
                }
            }
        }
    }