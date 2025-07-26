package moedas;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Opcao1 {
            public static void main(String[] args) throws IOException, InterruptedException {
                Scanner scanner = new Scanner(System.in);
                int opcao;

                do {
                    System.out.println("*********************************************");
                    System.out.println("Seja bem-vindo/a ao Conversor de Moeda =]");
                    System.out.println("1) Dólar =>> Peso argentino");
                    System.out.println("2) Peso argentino =>> Dólar");
                    System.out.println("3) Dólar =>> Real brasileiro");
                    System.out.println("4) Real brasileiro =>> Dólar");
                    System.out.println("5) Dólar =>> Peso colombiano");
                    System.out.println("6) Peso colombiano =>> Dólar");
                    System.out.println("7) Sair");
                    System.out.print("Escolha uma opção válida: ");
                    System.out.println("\n*********************************************");

                    opcao = scanner.nextInt();
                    scanner.nextLine(); // limpar buffer

                    String moedaOrigem = "";
                    String moedaDestino = "";

                    switch (opcao) {
                        case 1 -> {
                            moedaOrigem = "USD";
                            moedaDestino = "ARS";
                        }
                        case 2 -> {
                            moedaOrigem = "ARS";
                            moedaDestino = "USD";
                        }
                        case 3 -> {
                            moedaOrigem = "USD";
                            moedaDestino = "BRL";
                        }
                        case 4 -> {
                            moedaOrigem = "BRL";
                            moedaDestino = "USD";
                        }
                        case 5 -> {
                            moedaOrigem = "USD";
                            moedaDestino = "COP";
                        }
                        case 6 -> {
                            moedaOrigem = "COP";
                            moedaDestino = "USD";
                        }
                        case 7 -> {
                            System.out.println("Programa finalizado. Até logo!");
                            continue;
                        }
                        default -> {
                            System.out.println("Opção inválida. Tente novamente.\n");
                            continue;
                        }
                    }

                    System.out.print("\nDigite o valor que deseja converter: ");
                    double valor = scanner.nextDouble();

                    String url = "https://v6.exchangerate-api.com/v6/028c0349d7f37794b50dce8c/latest/" + moedaOrigem;
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(url))
                            .build();

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
                        System.out.println("Erro ao obter taxa de conversão para: " + moedaDestino);
                    }

                } while (opcao != 7);
            }
        }

