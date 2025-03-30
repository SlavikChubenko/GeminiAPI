import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        int countOfFile = 2;
//        String secondFileName = "second.txt";
        String question = "";
        String apiKey = "";
        String modelName = "gemini-2.0-flash-lite";

        /// could am I easier that code?
//        File firstFile = new File(firstFileName);
//        File secondFile = new File(secondFileName);
//        String firstFileName = "first.txt";
//        FileWriter firstFileWriter = new FileWriter(firstFileName, true);
//        FileWriter secondFileWriter = new FileWriter(secondFile, true);
        /// could am I easier that code?
//        System.out.println(firstFile);

        Scanner scanner1 = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        while (true) {
            for (int i = 0; i < countOfFile; i++) {
                File myObj = new File("filename" + i + ".txt");
                FileWriter firstFileWriter = new FileWriter("filename" + i + ".txt", true);
                GUI.previuosOutput(myObj, true);
                GUI.mainOutput(question, scanner1, list, apiKey, modelName, firstFileWriter,
                        true);
            }

            question = scanner1.nextLine();
            list.add(question);

            System.out.println("Write it for exit: 0" + "\n" + "Write it for change: 1");

        }
    }
}