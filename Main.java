import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import myExceptions.*;
// import myExceptions.myExceptions.*;

public class Main {
    static Scanner myReader;
    static int cyclesNbr;

    public static void main(String[] args) {
        try {
            String type;
            String name;
            int longtitude;
            int latitude;
            int height;

            if (args.length != 1) {
                throw new MyCustomException("Invalid Argument");
            }
            String pathname = "scenario.txt";
            if (pathname.compareTo(args[0]) != 0)
                throw new MyCustomException("Wrong File name");
            File myObj = new File(pathname);
            myReader = new Scanner(myObj);
            int lineCounter = 1;
            if (!myReader.hasNextLine()) {
                throw new MyCustomException("Empty File");
            }
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                System.out.println(line);
                if (line.length() <= 0) {
                    throw new MyCustomException("There is an Empty Line");
                }
                if (lineCounter != 1 && line.split(" ").length != 5) {
                    throw new MyCustomException("The Line Format is Wrong");
                }
                if (lineCounter == 1) {
                    cyclesNbr = Integer.parseInt(line);
                    if (cyclesNbr <= 0) {
                        throw new MyCustomException("Must be Positive");
                    }
                } else {
                    type = line.split(" ")[0];
                    name = line.split(" ")[1];
                    longtitude = Integer.parseInt(line.split(" ")[2]);
                    latitude = Integer.parseInt(line.split(" ")[3]);
                    height = Integer.parseInt(line.split(" ")[4]);

                    System.out.println("    " + type + "/" + name + "/" + longtitude + "/" + latitude + "/" + height);
                }

                lineCounter++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            // myReader.close();
            e.printStackTrace();
        }

    }
}
