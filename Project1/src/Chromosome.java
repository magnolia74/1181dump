import java.util.Random;
import java.util.ArrayList;
public class Chromosome extends ArrayList<Item> implements Comparable<Chromosome> {
    // Random number generation.
    private static Random rng = new Random();

    public Chromosome() {}
    // This is an no-arg and the costructor can be empty.

    public Chromosome(ArrayList<Item> items) {
        for (Item i : items) {
            this.add(new Item(i));
        }
        for (int i = 0; i < this.size(); i++) {
            this.get(i).setIncluded(rng.nextBoolean());
        }
    }
    /* Adds the copy of each of the items passed into the chromosome. Also it uses a random number to decide if
       the item is included in the field set to true or false.
    */
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
    // Performs a mutation operation on the chromosome.
    public int getFitness() {
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
