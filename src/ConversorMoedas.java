import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConversorMoedas {

    private static final String API_KEY = "60dfe47aa9ab20480b000444";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    // Metodo que faz a requisição e retorna a taxa de conversão
    public static double getTaxa(String from, String to) {
        try {
            String urlStr = BASE_URL + API_KEY + "/pair/" + from + "/" + to;
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            Scanner sc = new Scanner(conn.getInputStream());
            StringBuilder resposta = new StringBuilder();
            while (sc.hasNext()) {
                resposta.append(sc.nextLine());
            }
            sc.close();

            // Desserialização com Gson
            Gson gson = new Gson();
            JsonObject json = gson.fromJson(resposta.toString(), JsonObject.class);

            return json.get("conversion_rate").getAsDouble();


        } catch (Exception e) {
            System.out.println("Erro ao acessar a API: " + e.getMessage());
            return -1;
        }
    }
}

