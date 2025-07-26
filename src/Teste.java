import com.google.gson.JsonParser;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;

public class Teste {
    public static void main(String[] args) {
        String jsonString = "{\"result\":\"success\",\n" +
                " \"documentation\":\"https://www.exchangerate-api.com/docs\",\n" +
                " \"terms_of_use\":\"https://www.exchangerate-api.com/terms\",\n" +
                " \"time_last_update_unix\":1753488001,\n" +
                " \"time_last_update_utc\":\"Sat, 26 Jul 2025 00:00:01 +0000\",\n" +
                " \"time_next_update_unix\":1753574401,\n" +
                " \"time_next_update_utc\":\"Sun, 27 Jul 2025 00:00:01 +0000\",\n" +
                " \"base_code\":\"USD\",\n" +
                " \"conversion_rates\":{\n" +
                " \"USD\":1,\n" +
                " \"AED\":3.6725,\n" +
                " \"AFN\":68.9353,\n" +
                " \"ALL\":82.9871,\n" +
                " \"AMD\":383.9310,\n" +
                " \"ANG\":1.7900,\n" +
                " \"AOA\":919.1506,\n" +
                " \"ARS\":1277.7500,\n" +
                " \"AUD\":1.5228,\n" +
                " \"AWG\":1.7900,\n" +
                " \"AZN\":1.7004,\n" +
                " \"BAM\":1.6659,\n" +
                " \"BBD\":2.0000,\n" +
                " \"BDT\":122.2224,\n" +
                " \"BGN\":1.6662,\n" +
                " \"BHD\":0.3760,\n" +
                " \"BIF\":2962.8981,\n" +
                " \"BMD\":1.0000,\n" +
                " \"BND\":1.2808,\n" +
                " \"BOB\":6.9188,\n" +
                " \"BRL\":5.5218,\n" +
                " \"BSD\":1.0000,\n" +
                " \"BTN\":86.5209,\n" +
                " \"BWP\":13.8308,\n" +
                " \"BYN\":3.0488,\n" +
                " \"BZD\":2.0000,\n" +
                " \"CAD\":1.3690,\n" +
                " \"CDF\":2885.5850,\n" +
                " \"CHF\":0.7956,\n" +
                " \"CLP\":949.4934,\n" +
                " \"CNY\":7.1650,\n" +
                " \"COP\":4059.1129,\n" +
                " \"CRC\":504.7477,\n" +
                " \"CUP\":24.0000,\n" +
                " \"CVE\":93.9217,\n" +
                " \"CZK\":20.9117,\n" +
                " \"DJF\":177.7210,\n" +
                " \"DKK\":6.3574,\n" +
                " \"DOP\":60.5254,\n" +
                " \"DZD\":129.6005,\n" +
                " \"EGP\":49.0710,\n" +
                " \"ERN\":15.0000,\n" +
                " \"ETB\":137.0161,\n" +
                " \"EUR\":0.8518,\n" +
                " \"FJD\":2.2315,\n" +
                " \"FKP\":0.7442,\n" +
                " \"FOK\":6.3574,\n" +
                " \"GBP\":0.7442,\n" +
                " \"GEL\":2.7084,\n" +
                " \"GGP\":0.7442,\n" +
                " \"GHS\":11.0785,\n" +
                " \"GIP\":0.7442,\n" +
                " \"GMD\":72.7843,\n" +
                " \"GNF\":8684.1163,\n" +
                " \"GTQ\":7.6726,\n" +
                " \"GYD\":209.1959,\n" +
                " \"HKD\":7.8494,\n" +
                " \"HNL\":26.1801,\n" +
                " \"HRK\":6.4177,\n" +
                " \"HTG\":131.0234,\n" +
                " \"HUF\":338.0466,\n" +
                " \"IDR\":16337.0248,\n" +
                " \"ILS\":3.3527,\n" +
                " \"IMP\":0.7442,\n" +
                " \"INR\":86.5209,\n" +
                " \"IQD\":1309.1039,\n" +
                " \"IRR\":42208.3105,\n" +
                " \"ISK\":121.2321,\n" +
                " \"JEP\":0.7442,\n" +
                " \"JMD\":160.2567,\n" +
                " \"JOD\":0.7090,\n" +
                " \"JPY\":147.6103,\n" +
                " \"KES\":129.1323,\n" +
                " \"KGS\":87.2873,\n" +
                " \"KHR\":4010.1586,\n" +
                " \"KID\":1.5228,\n" +
                " \"KMF\":419.0490,\n" +
                " \"KRW\":1380.6871,\n" +
                " \"KWD\":0.3052,\n" +
                " \"KYD\":0.8333,\n" +
                " \"KZT\":544.8237,\n" +
                " \"LAK\":21632.5784,\n" +
                " \"LBP\":89500.0000,\n" +
                " \"LKR\":301.7454,\n" +
                " \"LRD\":200.3626,\n" +
                " \"LSL\":17.7374,\n" +
                " \"LYD\":5.4135,\n" +
                " \"MAD\":9.0007,\n" +
                " \"MDL\":16.8706,\n" +
                " \"MGA\":4423.2824,\n" +
                " \"MKD\":52.5525,\n" +
                " \"MMK\":2100.6600,\n" +
                " \"MNT\":3552.4687,\n" +
                " \"MOP\":8.0852,\n" +
                " \"MRU\":39.9699,\n" +
                " \"MUR\":45.2866,\n" +
                " \"MVR\":15.4436,\n" +
                " \"MWK\":1744.5513,\n" +
                " \"MXN\":18.5551,\n" +
                " \"MYR\":4.2218,\n" +
                " \"MZN\":63.6839,\n" +
                " \"NAD\":17.7374,\n" +
                " \"NGN\":1529.1674,\n" +
                " \"NIO\":36.7836,\n" +
                " \"NOK\":10.1619,\n" +
                " \"NPR\":138.4334,\n" +
                " \"NZD\":1.6624,\n" +
                " \"OMR\":0.3845,\n" +
                " \"PAB\":1.0000,\n" +
                " \"PEN\":3.5453,\n" +
                " \"PGK\":4.1897,\n" +
                " \"PHP\":57.1344,\n" +
                " \"PKR\":285.1463,\n" +
                " \"PLN\":3.6212,\n" +
                " \"PYG\":7545.1370,\n" +
                " \"QAR\":3.6400,\n" +
                " \"RON\":4.3196,\n" +
                " \"RSD\":99.8866,\n" +
                " \"RUB\":79.2844,\n" +
                " \"RWF\":1448.3695,\n" +
                " \"SAR\":3.7500,\n" +
                " \"SBD\":8.1990,\n" +
                " \"SCR\":14.3267,\n" +
                " \"SDG\":510.4197,\n" +
                " \"SEK\":9.5228,\n" +
                " \"SGD\":1.2808,\n" +
                " \"SHP\":0.7442,\n" +
                " \"SLE\":22.8886,\n" +
                " \"SLL\":22888.6115,\n" +
                " \"SOS\":571.8011,\n" +
                " \"SRD\":36.7207,\n" +
                " \"SSP\":4671.3414,\n" +
                " \"STN\":20.8686,\n" +
                " \"SYP\":13099.0447,\n" +
                " \"SZL\":17.7374,\n" +
                " \"THB\":32.3714,\n" +
                " \"TJS\":9.6496,\n" +
                " \"TMT\":3.5003,\n" +
                " \"TND\":2.8654,\n" +
                " \"TOP\":2.3795,\n" +
                " \"TRY\":40.5884,\n" +
                " \"TTD\":6.7740,\n" +
                " \"TVD\":1.5228,\n" +
                " \"TWD\":29.4093,\n" +
                " \"TZS\":2557.8780,\n" +
                " \"UAH\":41.7902,\n" +
                " \"UGX\":3581.0115,\n" +
                " \"UYU\":40.0806,\n" +
                " \"UZS\":12608.8079,\n" +
                " \"VES\":122.1700,\n" +
                " \"VND\":26095.0914,\n" +
                " \"VUV\":119.1103,\n" +
                " \"WST\":2.7201,\n" +
                " \"XAF\":558.7320,\n" +
                " \"XCD\":2.7000,\n" +
                " \"XCG\":1.7900,\n" +
                " \"XDR\":0.7292,\n" +
                " \"XOF\":558.7320,\n" +
                " \"XPF\":101.6448,\n" +
                " \"YER\":240.8242,\n" +
                " \"ZAR\":17.7376,\n" +
                " \"ZMW\":23.3547,\n" +
                " \"ZWL\":26.7805\n" +
                " }\n" +
                "}";;

        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(jsonString);

        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            // Acessa o objeto "conversion_rates"
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

            // Verifica se a chave "BRL" existe e não é nula
            if (conversionRates.has("BRL") && !conversionRates.get("BRL").isJsonNull()) {
                // Extrai a taxa de câmbio de USD para BRL
                double brlRate = conversionRates.get("BRL").getAsDouble();
                System.out.println("Taxa de câmbio de USD para BRL: " + brlRate);
            } else {
                System.out.println("A taxa de câmbio para BRL não foi encontrada.");
            }
        } else {
            System.out.println("O JSON não é um objeto.");
        }
    }
}