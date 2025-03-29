import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String firstFileName = "first.txt";
        String secondFileName = "second.txt";
        String question = "";
        String apiKey = "";
        String modelName = "gemini-2.0-flash-lite";

        File firstFile = new File(firstFileName);
        File secondFile = new File(secondFileName);

        FileWriter firstFileWriter = new FileWriter(firstFileName, true);
        FileWriter secondFileWriter = new FileWriter(secondFile, true);

        Scanner scanner1 = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        while (true) {
            GUI.previuosOutput(firstFile, true);
            GUI.mainOutput(question, scanner1, list, apiKey, modelName, firstFileWriter,
                    true);
            System.out.println("Write it for exit: 0" + "\n" + "Write it for change: 1");

        }
    }
}