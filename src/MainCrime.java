/*
Elliott Mendibles
CMIS 141
Final Project
March 2, 2020
Access crime statistics to find specified information
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainCrime {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Float> popGrowth = new ArrayList<>();


    public MainCrime(List<Integer> year, List<Integer> population, List<Float> robberyRate, List<Float> murderRate, long startTime) { //Constructor
        Inp(year, population, robberyRate, murderRate, startTime);
    }

    //Used to find population growth across years
    public static void PopulationGrowth(List<Integer> year, List<Integer> population, List<Float> robberyRate, List<Float> murderRate, long startTime) {
        System.out.println("\n************************************************************");
        for (int i = 0; i < population.size() - 1; i++) {
            popGrowth.add((float) (population.get(i + 1) - population.get(i)) / population.get(i) * 100);
            System.out.println("from Year: " + year.get(i) + " to Year: " + year.get(i + 1) + " Population Growth: " + popGrowth.get(i) + "%");
        }
        System.out.println("************************************************************\n");
        Inp(year, population, robberyRate, murderRate,startTime);
    }


    //Used to find the year with the lowest murder rate
    public static void LowMurderRate(List<Integer> year, List<Integer> population, List<Float> robberyRate, List<Float> murderRate, long startTime) {
        int years = 0;
        float rate = 0;

        years = year.get(0);
        rate = murderRate.get(0);

        for (int i = 1; i < murderRate.size(); i++) {
            if (rate > murderRate.get(i)) {
                years = year.get(i);
                rate = murderRate.get(i);
            }
        }
        System.out.println("\n********************************************************************** \n" +
                "The year with the lowest murder rate was: " + Integer.toString(years) +
                " which had a rate of " + Float.toString(rate) +
                "\n**********************************************************************\n");
        Inp(year, population, robberyRate, murderRate,startTime);

    }


    public static void HighMurderRate(List<Integer> year, List<Integer> population, List<Float> robberyRate, List<Float> murderRate, long startTime) {
        int years = 0;
        float rate = 0;
        years = year.get(0);
        rate = murderRate.get(0);

        for (int i = 1; i < murderRate.size(); i++) {
            if (rate < murderRate.get(i)) {
                years = year.get(i);
                rate = murderRate.get(i);
            }
        }
        System.out.println("\n*********************************************************************** \n" +
                "The year with the highest murder rate was: " + Integer.toString(years) +
                " which had a rate of " + Float.toString(rate) +
                "\n***********************************************************************\n");
        Inp(year, population, robberyRate, murderRate,startTime);

    }

    public static void LowRobberyRate(List<Integer> year, List<Integer> population, List<Float> robberyRate, List<Float> murderRate, long startTime)  {
        int years = 0;
        float rate = 0;
        years = year.get(0);
        rate = robberyRate.get(0);

        for (int i = 1; i < robberyRate.size(); i++) {
            if (rate > robberyRate.get(i)) {
                years = year.get(i);
                rate = robberyRate.get(i);
            }
        }
        System.out.println("\n************************************************************************* \n" +
                "The year with the lowest robbery rate was: " + Integer.toString(years) +
                " which had a rate of " + Float.toString(rate) +
                "\n*************************************************************************\n");
        Inp(year, population, robberyRate, murderRate,startTime);


    }

    public static void HighRobberyRate(List<Integer> year, List<Integer> population, List<Float> robberyRate, List<Float> murderRate, long startTime)  {
        int years = 0;
        float rate = 0;
        years = year.get(0);
        rate = robberyRate.get(0);

        for (int i = 1; i < robberyRate.size(); i++) {
            if (rate < robberyRate.get(i)) {
                years = year.get(i);
                rate = robberyRate.get(i);
            }
        }
        System.out.println("\n************************************************************************** \n" +
                "The year with the highest robbery rate was: " + Integer.toString(years) +
                " which had a rate of " + Float.toString(rate) +
                "\n**************************************************************************\n");
        Inp(year, population, robberyRate, murderRate,startTime);

    }

    public static void Quit() {
        System.exit(1);
    }

    //Used to end the timer
    public static void EndTime(long startTime){
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        totalTime = totalTime / 1000000000;
        System.out.println("\nThanks for using the crime database\n" +
                "You spent " + totalTime + " seconds using this program");
    }

    //prompts user for inputs and sends to method
    public static void Inp(List<Integer> year, List<Integer> population, List<Float> robberyRate, List<Float> murderRate, long startTime) {
        TestCrime testCrime = new TestCrime();

        System.out.println("Welcome to the Crime database. Please Select an option:\n" +
                "1. What were the percentages in population growth for each consecutive year from 1994 – 2013?\n" +
                "2. What year was the Murder rate the highest?\n" +
                "3. What year was the Murder rate the lowest?\n" +
                "4. What year was the Robbery rate the highest?\n" +
                "5. What year was the Robbery rate the lowest?\n" +
                "Q. Quit the program");

        String choiceInput = input.nextLine();

        switch (choiceInput) {
            case "1":
                PopulationGrowth(year, population, robberyRate, murderRate, startTime);
                break;

            case "2":
                HighMurderRate(year, population, robberyRate, murderRate, startTime);
                break;

            case "3":
                LowMurderRate(year, population, robberyRate, murderRate, startTime);
                break;

            case "4":
                HighRobberyRate(year, population, robberyRate, murderRate, startTime);
                break;

            case "5":
                LowRobberyRate(year, population, robberyRate, murderRate,startTime);
                break;

            case "Q":
                EndTime(startTime);
                Quit();
                break;

            default:
                System.out.println("\nInput is not valid\n");
                Inp(year, population, robberyRate, murderRate,startTime);

            }
    }
}