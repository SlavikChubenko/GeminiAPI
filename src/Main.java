import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, NullPointerException {
        String fileName = "newFile.txt";
        String question = "";

        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(fileName, true);

        ReadFile readFile = new ReadFile();
        readFile.outputContent(file);

        ModelConfig modelConfig = new ModelConfig("", "gemini-2.0-flash-lite");
        JSONParser jsonParser = new JSONParser(modelConfig.getApiKey(), modelConfig.getModelName(), fileName);

        System.out.println("Write it for exit: 0" + "\n" + "Write it for change: 1");
        Scanner scanner1 = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        while (true) {
            question = scanner1.nextLine();
            list.add(question);
            if (!Objects.equals(question, ""))
                switch (question) {
                    case "1":
                        System.out.println("Write the api, for example: " + "AIzaSyDfEL2giMCLr7LHGq0o56_F3UHS_M7wLWY");
                        String apiKey = modelConfig.getApiKey();
                        apiKey = scanner1.nextLine();

                        System.out.println("Write name of model, for example: " + "gemini-2.0-flash-lite");
                        String modelName = modelConfig.getModelName();
                        modelName = scanner1.nextLine();
                        break;
                    case "0":
                        fileWriter.close();
                        System.exit(0);
                        break;
                    case "":
                        break;
                    default:
                        JSONParser.htmlOutput(fileWriter, modelConfig.getApiKey(), modelConfig.getModelName(), list, fileName);
                        JSONParser.Output(list);
                        break;
                }
        }
    }
}