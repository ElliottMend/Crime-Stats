/*
Elliott Mendibles
CMIS 141
Final Project
March 2, 2020
Access crime statistics to find specified information
 */

import java.io.*;
import java.util.Scanner;



public class TestCrime {
    private static Scanner input;
    private static BufferedReader inputStream = null;

    public static void main(String[] args) throws IOException {

        long startTime = System.nanoTime(); //starts timer

        File fileOne = new File(args[0]); //prompts command line arg
        try {
            Scanner fileReader = new Scanner(new FileInputStream( //reads file
                    new File(String.valueOf(fileOne))));
            fileReader.nextLine();

            int rows = 20;  //initializes 2d array
            int columns = 20;
            float[][] myArray = new float[rows][columns];
            while (fileReader.hasNextLine()) {
                for (int i = 0; i < myArray.length; i++) {
                    String[] line;
                    line = fileReader.nextLine().trim().split(",");
                    for (int j = 0; j < line.length; j++) {
                        myArray[i][j] = Float.parseFloat(line[j]);
                    }
                }
                USCrimeClass usCrimeClass = new USCrimeClass(myArray, startTime);
            }

        } catch (FileNotFoundException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}