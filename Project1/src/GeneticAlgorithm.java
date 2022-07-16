import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class GeneticAlgorithm {
    public static ArrayList<Item> readData(String filename)throws FileNotFoundException {
        File file = new File(filename);
        Scanner read = new Scanner(file);
        ArrayList<Item> itemsFile = new ArrayList<>();

        while (read.hasNextLine()) {
            String line = read.nextLine();
            String[] tokens = line.split(", ");
            String name = tokens[0];
            double weight = Double.parseDouble(tokens[1]);
            int value = Integer.parseInt(tokens[2]);
            //Splits the line of each file into tokens of seperate datatypes
            itemsFile.add(new Item(name, weight, value));
        }
        read.close();
        return itemsFile;
    }

    // Reads the data file in a format shown below and returns an ArrayList of Item objects.
    // item1_label, item1_weight, item1 value ...
    public static ArrayList<Chromosome> initializePopulation(ArrayList<Item> items, int populationSize)  {
        ArrayList<Chromosome> population = new ArrayList<>();
        for (int i = 0; i < populationSize; i++) {
            population.add(new Chromosome(items));
        }
        return population;
    };
    // Creates and returns an ArrayList of Chromosome objects that will contain the Items in respect to their included field.
    public static void main(String[] args) throws FileNotFoundException {
        //Initializing variables that will be used to compute the genetic algorithm
        Random rng = new Random();
        ArrayList<Item> itemSet = new ArrayList<>();
        ArrayList<Chromosome> currentGen = new ArrayList<>();
        ArrayList<Chromosome> nextGen = new ArrayList<>();
        //Editable variables for tweaking and modifying the genetic algorithm
        int populationSize = 100;
        int repeatTimes = 20;
        // Reads the data from items.txt (or more_items.txt) in order to process through the data.
        itemSet = readData("src/items.txt");

        // Create a set of ten random items as the initial population.
        currentGen = initializePopulation(itemSet, populationSize);

        for (int e = 0; e < repeatTimes; e++) {
            // Second, add each of the items and perform crossover to create an offspring and add it to the next generation.
            for (int i = 0; i < populationSize/2; i++) {
                nextGen.add(currentGen.get(i*2).crossover(currentGen.get(i*2+1)));
            }
            // Third, randomly pair items and perform crossover to create an offspring and add it to the next generation after.
            for (int i = 0; i < populationSize/2; i++) {
                nextGen.add(currentGen.get(rng.nextInt(populationSize)).crossover(currentGen.get(rng.nextInt(populationSize))));
            }
            // Fourth, randomly choose ten items in the population in the next generation to get a chance of exposure to mutation.
            for (Chromosome r : nextGen) {
                if (rng.nextInt(10)==1) {
                    r.mutate();
                }
            }
            // Fifth, sort the items in the next generation according to their fitness to survive.
            Collections.sort(nextGen);
            // Sixth, clear out the current population size and add the top ten of the next back into the population size.
            currentGen.clear();
            for (int i = 0; i < populationSize; i++) {
                currentGen.add(nextGen.get(i));
            }
            nextGen.clear();
            // Seventh, repeat the same steps from 2 to 6 at least 20 times.
        }

        // Lastly, sort the population and display the fittest to the console after execution.
        System.out.println("The top creature after "+repeatTimes+" generations of "+populationSize+" creatures: ");
        System.out.println(currentGen.get(0));
    }
}
