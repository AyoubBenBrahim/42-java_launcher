import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import myExceptions.*;

public class Main {
    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                // System.err.println("Invalid input, exactly one argument required");
                // System.exit(1);
                throw new myExceptions.InvalidArg("GeeksGeeks");
            }

            File myObj = new File("scenario.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
