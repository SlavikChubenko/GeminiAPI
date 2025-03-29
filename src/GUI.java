import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GUI {
    public void mainOutput(String question, Scanner scanner1, ArrayList<String> list, String apiKey,
                           String modelName, FileWriter firstFileWriter, boolean switcher) throws IOException, InterruptedException {
        question = scanner1.nextLine();
        list.add(question);

        switch (question) {
            case "1":
                System.out.println("Write the api, for example: " +
                        "AIzaSyDfEL2giMCLr7LHGq0o56_F3UHS_M7wLWY");
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
                JSONParser.htmlOutput(firstFileWriter, apiKey, modelName, list);
                if(switcher)
                    JSONParser.output(list);
        }
    }
    public void periosOutput(File file, boolean switcher) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        if(switcher)
            while (scanner.hasNextLine()) {
                String textFromFile = scanner.nextLine();
                System.out.println(textFromFile);
            }
            scanner.close();
    }
}
