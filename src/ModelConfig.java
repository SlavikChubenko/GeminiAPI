import java.util.Scanner;

public class ModelConfig {
    private String apiKey;
    private String modelName;

    ModelConfig(String apiKey, String modelName){
        this.apiKey = apiKey;
        this.modelName = modelName;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getModelName() {
        return modelName;
    }
    
    public String getScanner(){
        Scanner scanner = new Scanner(System.in);
        return apiKey = scanner.nextLine();
    }

}
