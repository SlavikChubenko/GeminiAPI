import java.io.*;
import java.util.ArrayList;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException{
        String firstFileName = "first.txt";
        String secondFileName = "second.txt";
        String question = "";
        String apiKey = "";
        String modelName = "gemini-2.0-flash-lite";

        File firstFile = new File(firstFileName);
        File secondFile = new File(secondFileName);

        FileWriter firstFileWriter = new FileWriter(firstFileName, true);
        FileWriter secondFileWriter = new FileWriter(secondFile, true);

        ReadFile readFirstFile = new ReadFile();
        readFirstFile.outputContent(firstFile);
        ReadFile readSecondFile = new ReadFile();
        readSecondFile.outputContent(secondFile);

        ModelConfig modelConfig = new ModelConfig(apiKey, modelName);

        System.out.println("Write it for exit: 0" + "\n" + "Write it for change: 1");
        Scanner scanner1 = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        while (true) {
            question = scanner1.nextLine();
            list.add(question);

            switch (question) {
                case "1":
                    System.out.println("Write the api, for example: " + "AIzaSyDfEL2giMCLr7LHGq0o56_F3UHS_M7wLWY");
                    apiKey = scanner1.nextLine();

                    System.out.println("Write name of model, for example: " + "gemini-2.0-flash-lite");
                    modelName = scanner1.nextLine();
                    break;
                case "0":
                    firstFileWriter.close();
                    System.exit(0);
                    break;
                case "":
                    break;
                default:
                    JSONParser.htmlOutput(firstFileWriter, modelConfig.getApiKey(), modelConfig.getModelName(), list);
                    JSONParser.output(list);
                    break;
                }
        }
    }
}