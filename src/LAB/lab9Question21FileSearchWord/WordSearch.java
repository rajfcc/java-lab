package LAB.lab9Question21FileSearchWord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordSearch {

    public static void main(String[] args) {


        String filePath = "D:\\Class\\7th Sem\\JAVA\\demo.txt";
        String searchWord = "Hello";

        try {
            searchWordInFile(filePath, searchWord);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    public static void searchWordInFile(String filePath, String searchWord) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.contains(searchWord)) {
                    System.out.println("Line " + lineNumber + ": " + line);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("The word \"" + searchWord + "\" was not found in the file.");
            }
        }
    }
}

