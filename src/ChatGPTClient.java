import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import okhttp3.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ChatGPTClient {

    private static String apiKey = "";
    private static String apiUrl = "https://api.openai.com/v1/chat/completions";
    private static final OkHttpClient client = new OkHttpClient();
    private static final Gson gson = new Gson();

    public ChatGPTClient() {
        loadApiKey();
    }

    private void loadApiKey() {
        Properties properties = new Properties();
        try (InputStream input = ChatGPTClient.class.getResourceAsStream("/config.properties")) {
            if (input == null) {
                System.err.println("Fichier config.properties introuvable !");
                return;
            }
            properties.load(input);
            apiKey = properties.getProperty("openai.api.key");
            apiUrl = properties.getProperty("openai.api.url", apiUrl); // Utilise l'URL par défaut si non définie
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String genererTexte(String prompt) {
        try {
            JsonObject requestBodyJson = new JsonObject();
            requestBodyJson.addProperty("model", "gpt-3.5-turbo");

            JsonArray messagesArray = new JsonArray();
            JsonObject userMessage = new JsonObject();
            userMessage.addProperty("role", "user");
            userMessage.addProperty("content", prompt);
            messagesArray.add(userMessage);

            requestBodyJson.add("messages", messagesArray);

            String jsonString = gson.toJson(requestBodyJson);

            RequestBody body = RequestBody.create(
                    jsonString,
                    MediaType.parse("application/json; charset=utf-8")
            );

            Request request = new Request.Builder()
                    .url(apiUrl)
                    .addHeader("Authorization", "Bearer " + apiKey)
                    .addHeader("Content-Type", "application/json")
                    .post(body)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful()) {
                    throw new IOException("Erreur lors de l'appel API : " + response);
                }

                String responseBody = response.body().string();
                JsonObject responseJson = gson.fromJson(responseBody, JsonObject.class);

                JsonArray choicesArray = responseJson.getAsJsonArray("choices");
                if (choicesArray != null && choicesArray.size() > 0) {
                    JsonObject firstChoice = choicesArray.get(0).getAsJsonObject();
                    JsonObject messageObject = firstChoice.getAsJsonObject("message");
                    return messageObject.get("content").getAsString();
                } else {
                    return "Aucune réponse disponible.";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Erreur lors de l'appel à l'API.";
        }
    }

    public static void main(String[] args) {
        ChatGPTClient client = new ChatGPTClient();
        String prompt = "Donne-moi une idée de projet pour un développeur débutant.";
        String response = client.genererTexte(prompt);

        System.out.println("Réponse de ChatGPT :");
        System.out.println(response);

        System.out.println("\nQuestion théorique :");
        System.out.println("Pourquoi est-il important de ne pas inclure la clé API directement dans le code source ?");
        System.out.println("Mettre les clés Api en dur  dans le code peut etre dangereux les mettres dans un fichier à pars permet de les sécuriser pour que personnes nous les voles pour les utiliser il est aussi bien de les mettre le fichier config.properties dans le gitignore pour éviter de le publier sur git ");
    }
}