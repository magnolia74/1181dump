import java.util.Random;
import java.util.ArrayList;
public class Chromosome extends ArrayList<Item> implements Comparable<Chromosome> {
    // Random number generation.
    private static Random rng = new Random();
    public static long dummy = 0;


    public Chromosome() {}
    // This is an no-arg and the costructor can be empty.
    public Chromosome(ArrayList<Item> items, boolean allFalse) {
        for (Item i : items) {
            this.add(new Item(i));
        }
    }
    // Create chromosome for genetic algorithm
    public Chromosome(ArrayList<Item> items) {
        for (Item i : items) {
            this.add(new Item(i));
        }
        for (int i = 0; i < this.size(); i++) {
            this.get(i).setIncluded(Math.random() <= 1.0/this.size());
        }
    }
    /*Adds a copy of each of the items passed in to this Chromosome. Uses a random number to decide whether each
    item’s included field is set to true or false.*/
    public Chromosome crossover(Chromosome other) {
        Chromosome child = new Chromosome();
        for (int i = 0; i < this.size(); i++) {
            child.add(new Item(this.get(i)));
            if (rng.nextInt(10)<5) {
                child.get(i).setIncluded(this.get(i).isIncluded());
            } else {
                child.get(i).setIncluded(other.get(i).isIncluded());
            }
        }
        return child;
    }
    // Creates and returns a new offspring chromosome by performing crossover operation.
    public void mutate() {
        for (int i = 0; i < this.size(); i++) {
            if (rng.nextInt(10) == 1) {
                boolean flip = (this.get(i).isIncluded()) ? false : true;
                this.get(i).setIncluded(flip);
            }
        }
    }

    public int getFitness() {
        dummy = 0;
        for (int i = 0; i < this.size()*1000; i++) {
            dummy += i;
        }
        int fitness = 0;
        double weight = 0;
        for (int i = 0; i < this.size(); i++) {
            if(this.get(i).isIncluded()) {
                fitness+= this.get(i).getValue();
                weight+= this.get(i).getWeight();
            }
        }
        return (weight < 10) ? fitness : 0;
    }
    // Returns the fitness of the chromosome. If the sum is greater than 10, the fitness is zero. Therefore, the fitness is equal to sume of all values.
    public int compareTo(Chromosome other) {
        int compare = other.getFitness() - this.getFitness();
        return compare;
    }
    // Returns -1 if the chromosome's fitness is greater than other and +1 if the chromosome's fitness is less than others. If it's 0, their fitness would be same.
    public String toString() {
        String result = "";
        for (int i = 0; i < this.size(); i++) {
            if(this.get(i).isIncluded()) {
                result+=this.get(i).toString()+"\n";
            }
        }
        result+="Fitness: "+this.getFitness()+"\n";
        return result;
    }
}