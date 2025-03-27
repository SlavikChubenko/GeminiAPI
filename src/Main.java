import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String fileName = "newFile.txt";

        try{
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String textFromFile = scanner.nextLine();
                System.out.println(textFromFile);
            }
            scanner.close();
        }
        catch (IOException e){
            System.out.println("An error 0 !!!");
            e.printStackTrace();
        }

        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("file.createNewFile(): " + file.getName());
            } else {
                System.out.println("file.createNewFile() - exist file");
            }
        }
        catch (IOException e){
            System.out.println("An error 1 !!! file.createNewFile() - not ok");
            e.printStackTrace();
        }

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            System.out.println("FileWriter fileWriter - ok");
        }
        catch (IOException e){
            System.out.println("An error 2 !!! FileWriter fileWriter - not ok");
            e.printStackTrace();
        }

        /// файл постоянно перезаписывается, исправить это надо!!!!
        /// https://www.w3schools.com/java/java_files_read.asp

        ModelConfig modelConfig = new ModelConfig("", "gemini-2.0-flash-lite");
        JSONParser jsonParser = new JSONParser(modelConfig.getApiKey(), modelConfig.getNameModel(), fileName);

        System.out.println( "Write it for exit: 0"+"\n" +"Write it for change: 1");

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while(true) {
            String question = scanner.nextLine();
            list.add(question);

            if(!Objects.equals(question, ""))
                switch (question){
                    case "1":
                        System.out.println("Write the api, for example: " + "AIzaSyDo-mvS_lpehX9tjAoMdZol_hkwJsjz7wQ");
                        String apiKey = modelConfig.getApiKey();
                        apiKey = scanner.nextLine();

                        System.out.println("Write name of model, for example: " + "gemini-2.0-flash-lite");
                        String nameModel = modelConfig.getNameModel();
                        nameModel = scanner.nextLine();
                        break;
                    case "0":
                        try {
                            FileWriter fileWriter = new FileWriter(fileName);
                            fileWriter.close();
                            System.out.println("fileWriter.close() - ok");
                        }
                        catch (IOException e){
                            System.out.println("An error 3 !!! fileWriter.close() - not ok");
                            e.printStackTrace();
                        }

                        System.exit(0);
                        break;
                    case "":
                        break;
                    default:
                        try {
                            FileWriter fileWriter = new FileWriter(fileName);
                            JSONParser.htmlOutput(fileWriter, modelConfig.getApiKey(), modelConfig.getNameModel(), list, fileName);
                            System.out.println("JSONParser.htmlOutput(fileWriter, modelConfig.getApiKey(), modelConfig.getNameModel(), list, fileName) - ok");
                        }
                        catch (IOException e){
                            System.out.println("An error 4 !!! JSONParser.htmlOutput(fileWriter, modelConfig.getApiKey(), modelConfig.getNameModel(), list, fileName) - not ok");
                            e.printStackTrace();
                        }
                        JSONParser.Output(list);
                        break;

                }
        }
    }

}