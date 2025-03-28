import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String fileName = "newFile.txt";
        String question = "";

        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(fileName, true);
        if(file.exists()){
            System.out.println("existed");
        }
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            String textFromFile = scanner.nextLine();
            System.out.println(textFromFile);
        }
        scanner.close();
        /// файл постоянно перезаписывается, исправить это надо!!!!
        /// https://www.w3schools.com/java/java_files_read.asp

        ModelConfig modelConfig = new ModelConfig("", "gemini-2.0-flash-lite");
        JSONParser jsonParser = new JSONParser(modelConfig.getApiKey(), modelConfig.getNameModel(), fileName);
        System.out.println( "Write it for exit: 0"+"\n" +"Write it for change: 1");
        Scanner scanner1 = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while(true) {
            try {
                question = scanner1.nextLine();
            } catch (RuntimeException e) {
                fileWriter.close();
            }
            list.add(question);
            if(!Objects.equals(question, ""))
                switch (question){
                    case "1":
                        System.out.println("Write the api, for example: " + "");
                        String apiKey = modelConfig.getApiKey();
                        apiKey = scanner1.nextLine();
                        System.out.println("Write name of model, for example: " + "gemini-2.0-flash-lite");
                        String nameModel = modelConfig.getNameModel();
                        nameModel = scanner1.nextLine();
                        break;
                    case "0":
                        fileWriter.close();
                        System.exit(0);
                        break;
                    case "":
                        break;
                    default:
                        JSONParser.htmlOutput(fileWriter, modelConfig.getApiKey(), modelConfig.getNameModel(), list, fileName);
                        JSONParser.Output(list);
                        break;

                }
        }
    }

}