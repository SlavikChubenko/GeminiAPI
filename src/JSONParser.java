import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;

public class JSONParser {
    private String apiKey;
    private String nameModel;
    private String fileName;

    JSONParser(String apiKey, String nameModel, String fileName){
        this.apiKey = apiKey;
        this.nameModel = nameModel;
        this.fileName = fileName;
    }

    public static void htmlOutput(FileWriter fileWriter, String apiKey, String nameModel, ArrayList<String> list,
                                  String fileName) throws IOException, InterruptedException {
        String apiUrl = "https://generativelanguage.googleapis.com/v1beta/models/" + nameModel +
                ":generateContent?key=" + apiKey;
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(15)) // Немного увеличим таймаут
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .headers("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{ \"contents\": [{ \"parts\":[{\"text\": \"" +
                        list + "\"}]}]}"))
                .timeout(Duration.ofSeconds(60))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

        fileWriter.append(response.body());
        fileWriter.flush();
    }

    public static void Output(ArrayList<String> list){
        for(String output : list){
            System.out.println(output);
        }
    }
}



















//    public static void addArray(){
//        for(String questions : list){
//            System.out.println(questions);
//        }
//    }
