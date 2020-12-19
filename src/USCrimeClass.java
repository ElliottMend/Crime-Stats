/*
Elliott Mendibles
CMIS 141
Final Project
March 2, 2020
Access crime statistics to find specified information

 */

import java.util.ArrayList;
import java.util.List;

public class USCrimeClass {

    //Declares vars
    private String[] statistics;
    private List<Integer> year = new ArrayList<>();
    private List<Integer> population = new ArrayList<>();
    private List<Float> murderRate = new ArrayList<>();
    private List<Float> robberyRate = new ArrayList<>();

    //sorts lines of 2D array and adds to arraylist of var needed
    public  USCrimeClass(float[][] myArray, long startTime) {

        for (int i = 0; i < myArray.length; i++) {
            year.add((int) myArray[i][0]);
            }

        for (int i = 0; i < myArray.length; i++) {
            population.add((int) myArray[i][1]);
        }

        for (int i = 0; i < myArray.length; i++) {
            murderRate.add( myArray[i][5]);
        }

        for (int i = 0; i < myArray.length; i++) {
            robberyRate.add( myArray[i][9]);
        }
        MainCrime mainCrime = new MainCrime(year, population, robberyRate, murderRate, startTime);
        }

        //Getters
        public List<Integer> getYear() {
            return year;
        }

        public List<Integer> getPopulation () {
            return population;
        }

        public List<Float> getMurderRate () {
            return murderRate;
        }

        public List<Float> getRobberyRate () {
            return robberyRate;
        }

        public static void Lowest(String[] statistics){
        }
    }
