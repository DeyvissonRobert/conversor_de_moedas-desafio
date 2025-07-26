import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import moedas.Moedas;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Qual moeda você quer converter? ");
        var converteDe = leitura.nextLine();

        String endereco = "https://v6.exchangerate-api.com/v6/028c0349d7f37794b50dce8c/latest/" + converteDe;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        System.out.println(json);

        Gson gson = new Gson();
//        Moedas minhasMoedas = gson.fromJson(json, Moedas.class);
//        System.out.println(minhasMoedas);



        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(json);

        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            // Acessa o objeto "conversion_rates"
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

            // Verifica se a chave "BRL" existe e não é nula
            if (conversionRates.has("USD") && !conversionRates.get("USD").isJsonNull()) {
                // Extrai O valor convertido de USD para BRL
                double brlRate = conversionRates.get("USD").getAsDouble();
                System.out.println("O valor convertido de USD para BRL: " + brlRate);
            } else {
                System.out.println(" BRL não foi encontrada.");
            }
        }
    }
}