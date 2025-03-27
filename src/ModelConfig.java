import java.util.Scanner;

public class ModelConfig {
    private String apiKey;
    private String nameModel;

    ModelConfig(String apiKey, String nameModel){
        this.apiKey = apiKey;
        this.nameModel = nameModel;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getNameModel() {
        return nameModel;
    }
    
    public String getScanner(){
        Scanner scanner = new Scanner(System.in);
        return apiKey = scanner.nextLine();
    }

}
