public class Item {
    private final String name; // Label for an item such as "Jewelry".
    private final double weight; //Weight of the item in pounds (lb).
    private final int value; //The value of the item rounded to nearest dollar. ($)
    private boolean included = false; // Indicates if the item should be included or not.

    public Item(String name, double weight, int value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    } // Initializes the Item's fields to the values that are passed.

    public Item(Item other) {
        this.name = other.name;
        this.weight = other.weight;
        this.value = other.value;
        this.included = other.included;
    } // Initializes the item's fields to be the same as others.

    public double getWeight() {
        return weight;
    }
    public int getValue() {
        return value;
    }
    public boolean isIncluded() {
        return included;
    }
    //Getters for item's fields.

    public void setIncluded(boolean included) {
        this.included = included;
    } // Setter for item's included field.

    public String toString() {
        String out = name+" ("+weight+" lbs, $"+value+")";
        return out;
    } // Displays the item in the form <name>, <weight> lbs, $<value>)
}