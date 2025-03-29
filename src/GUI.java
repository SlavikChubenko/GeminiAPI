import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GUI {
    public static void mainOutput(String question, Scanner scanner1, ArrayList<String> list, String apiKey,
                           String modelName, FileWriter firstFileWriter, boolean switcher) throws IOException, InterruptedException {
        JSONParser.htmlOutput(firstFileWriter, apiKey, modelName, list);
        if(switcher)
            JSONParser.output(list);
    }
    public static void previuosOutput(File file, boolean switcher) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        if(switcher)
            while (scanner.hasNextLine()) {
                String textFromFile = scanner.nextLine();
                System.out.println(textFromFile);
            }
            scanner.close();
    }
}
