package testes;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Teste2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Qual moeda você quer converter?");
        String moedaOrigem = leitura.nextLine().toUpperCase();

        System.out.println("Para qual moeda?");
        String moedaDestino = leitura.nextLine().toUpperCase();

        System.out.println("Qual valor deseja converter?");
        double valor = leitura.nextDouble();

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
            System.out.printf("%.2f %s = %.2f %s%n", valor, moedaOrigem, convertido, moedaDestino);
        } else {
            System.out.println("Moeda de destino não encontrada.");
        }

    }
}
