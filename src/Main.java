import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String fileName = "newFile.txt";



        FileReader fileReader = new FileReader(fileName);

        int i;
        while((i = fileReader.read()) != -1){
            System.out.printf("%c" ,(char)i);
        }

        fileReader.close();




        FileWriter fileWriter = new FileWriter(fileName);


        ModelConfig modelConfig = new ModelConfig(
                "AIzaSyDo-mvS_lpehX9tjAoMdZol_hkwJsjz7wQ",
                "gemini-2.0-flash-lite");
        JSONParser jsonParser = new JSONParser(
                modelConfig.getApiKey(),
                modelConfig.getNameModel(),
                fileName);

        System.out.println( "Write it for exit: 0"+"\n"
                            +"Write it for change: 1");

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while(true) {
            String question = scanner.nextLine();
            list.add(question);

            if(!Objects.equals(question, ""))
                switch (question){
                    case "1":
                        System.out.println("Write the api, for example: " +
                                "AIzaSyDo-mvS_lpehX9tjAoMdZol_hkwJsjz7wQ");
                        String apiKey = modelConfig.getApiKey();
                        apiKey = scanner.nextLine();

                        System.out.println("Write name of model, for example: " +
                                "gemini-2.0-flash-lite");
                        String nameModel = modelConfig.getNameModel();
                        nameModel = scanner.nextLine();
                        break;
                    case "0":
                        fileWriter.close();
                        System.exit(0);
                        break;
                    case "":
                        break;
                    default:
                        JSONParser.htmlOutput(fileWriter, modelConfig.getApiKey(),
                                modelConfig.getNameModel(), list, fileName);
                        JSONParser.Output(list);
                        break;

                }
        }
    }

}