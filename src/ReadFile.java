import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public void outputContent(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String textFromFile = scanner.nextLine();
            System.out.println(textFromFile);
        }
        scanner.close();
    }
}
