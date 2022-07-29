import java.util.ArrayList;

public class ComboFinder {
    private ArrayList<Item> totalItemList = new ArrayList<>();
    private ArrayList<Chromosome> allCombos =  new ArrayList<>();

    public ComboFinder(ArrayList<Item> items) throws InvalidArguementException{
        totalItemList = items;
        if (totalItemList.size() >= 10) {
            throw new InvalidArguementException();
        }
    }
    // Recursive function is created to calculate all possible combinations.
    private ArrayList<Item> calculateAllCombos(ArrayList<Item> itemList) {
        int itemIndex = itemList.size()-1;
        // lowest possible step
        if (itemList.size()==1) {
            allCombos.add(new Chromosome(totalItemList, false));
            allCombos.add(new Chromosome(totalItemList, false));
            allCombos.get(0).get(itemIndex).setIncluded(true);
            return itemList;
        }
        // Call the function with less items.
        ArrayList<Item> smallerList = new ArrayList<>(itemList);
        smallerList.remove(smallerList.size()-1);
        calculateAllCombos(smallerList);
        // Calculate and return the output.
        int temp = allCombos.size();
        for (int i = 0; i < temp; i++) {
            allCombos.add(new Chromosome(allCombos.get(i), false));
        }
        for (int i = 0; i < allCombos.size()/2; i++) {
            allCombos.get(i).get(itemIndex).setIncluded(true);
        }
        return itemList;
    }
    // Create a best function by sorting the output from the recursive function.
    public ArrayList<Chromosome> getAllCombos() {
        allCombos.clear();
        calculateAllCombos(totalItemList);
        return allCombos;
    }
}