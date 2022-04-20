import java.io.File; // Import the File class
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner; // Import the Scanner class to read text files

import aircraftRelated.*;
import myExceptions.*;
import weatherRelated.*;

public class Main {
    static Scanner myReader;
    static int simulationCyclesNbr;
    static WeatherTower tower = new WeatherTower();

    public static void main(String[] args) {
        try {
            String type;
            String name;
            int longtitude;
            int latitude;
            int height;
            ArrayList<Flyable> flyableObjs = new ArrayList<Flyable>();

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
                // System.out.println(line);
                if (line.length() <= 0) {
                    throw new MyCustomException("There is an Empty Line\n");
                }
                if (lineCounter != 1 && line.split(" ").length != 5) {
                    throw new MyCustomException("The Line Format is Wrong\n");
                }
                if (lineCounter == 1) {
                    simulationCyclesNbr = Integer.parseInt(line);
                    if (simulationCyclesNbr <= 0) {
                        throw new MyCustomException("Cycles nbr Must be Positive\n");
                    }
                } else {
                    String params[] = line.split(" ");
                    // for(String param : params)
                    // {
                    // if (param.isEmpty())
                    // throw new MyCustomException("Space As AirCraft Name Is Not Allowed.\n");//
                    // splite doesn't detect the space
                    // }

                    type = params[0];
                    name = params[1];
                    if ((name.matches("^[A-Z][A-z0-9]+$")) == false)
                        throw new MyCustomException("AireCraft Name Starts With UpperCase Alpha\n");
                    longtitude = Integer.parseInt(params[2]);
                    latitude = Integer.parseInt(params[3]);
                    height = Integer.parseInt(params[4]);
                    height = (height > 100) ? 100 : height;

                    Flyable flb = AircraftFactory.newAircraft(
                            type,
                            name,
                            longtitude,
                            latitude,
                            height);
                    if (flb == null)
                        throw new MyCustomException("AircraftFactory Failed\n");
                    flyableObjs.add(flb);
                }
                lineCounter++;
            }

            for (Flyable flb : flyableObjs)
                flb.registerTower(tower);

            for (int i = 0; i <= simulationCyclesNbr; i++)
                tower.changeWeather();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myReader.close();
        }

    }
}
