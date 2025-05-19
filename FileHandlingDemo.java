import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandlingDemo {

    static String fileName = "myfile.txt";

    // Write content to a new file (overwrite if exists)
    public static void writeToFile(String text) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(text);
            writer.close();
            System.out.println("✅ File written successfully.");
        } catch (IOException e) {
            System.out.println("❌ Error writing to file: " + e.getMessage());
        }
    }

    // Read content from the file
    public static void readFile() {
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            System.out.println("📄 File Contents:");
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("❌ File not found.");
        }
    }

    // Append content to the file
    public static void appendToFile(String text) {
        try {
            FileWriter writer = new FileWriter(fileName, true); // true = append mode
            writer.write("\n" + text);
            writer.close();
            System.out.println("✅ Content appended.");
        } catch (IOException e) {
            System.out.println("❌ Error appending to file.");
        }
    }

    // Replace a word in the file with another word
    public static void modifyFile(String oldWord, String newWord) {
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            StringBuilder content = new StringBuilder();

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                content.append(line.replaceAll(oldWord, newWord)).append("\n");
            }
            reader.close();

            FileWriter writer = new FileWriter(fileName);
            writer.write(content.toString());
            writer.close();
            System.out.println("✅ File modified.");
        } catch (IOException e) {
            System.out.println("❌ Error modifying file.");
        }
    }

    public static void main(String[] args) {
        // Write initial content
        writeToFile("Hello, this is the original content.");

        // Read content
        readFile();

        // Append content
        appendToFile("This line was appended.");

        // Modify a word
        modifyFile("original", "updated");

        // Read again to see the changes
        readFile();
    }
}
