public class Customer implements Comparable<Customer> {
    private int customerNumber; // Contains the number in order in which it was added.
    private double entryTime; // Contains the time part of the file.
    private int items; // Contains the amount of items from the file.
    private double browseTime;  // Contains the another part of time of how customer browses.
    private double nextEventTime; // Contains the time the customer will do on next action.
    private int conditionIndex = 0; // 0 = Arrival condition, 1 = End Shopping condition, 2 = End Checkout condition, 3 = left the store.
    private double startWaitTime; // Start of wait time using by calculating the average.
    private double endWaitTime;  // End of wait time.
    private int shoppingLineIndex; // Indexing the customers of what lines they were in.
    private int foundInLine; // Displays the amount of people in line.
    // Class for Customer for setting the numbers, time, and items.
    public Customer(int customerNumber, Double entryTime, int items, Double browseTime) {
        this.customerNumber = customerNumber;
        this.entryTime = entryTime;
        this.items = items;
        this.browseTime = browseTime;
        nextEventTime = entryTime;
    }
    // Getters for getting the objects.
    public int getNumber() {
        return customerNumber;
    }
    public double getArrival() {
        return entryTime;
    }
    public int getItems() {
        return items;
    }
    public double getEndShopping() {
        return items * browseTime;
    }
    public double getEndCheckoutRegular() {
        return 0.05 * items + 2.0;
    }
    public double getEndCheckoutExpress() {
        return 0.10 * items + 1.0;
    }
    public double getNextEventTime() {
        return nextEventTime;
    }
    public int getConditionIndex() {
        return conditionIndex;
    }
    public double getEndWaitTime() {
        return endWaitTime;
    }
    public double getWaitTime() {
        return endWaitTime - startWaitTime;
    }
    public int getShoppingLineIndex() {
        return shoppingLineIndex;
    }
    public int getFoundInLine() {
        return foundInLine;
    }
    public void setNextEventTime(double value) {
        nextEventTime = value;
    }
    public void setConditionIndex(int value) {
        conditionIndex = value;
    }
    public void setStartWaitTime(double value) {
        startWaitTime = value;
    }
    public void setEndWaitTime(double value) {
        endWaitTime = value;
    }
    public void setShoppingLineIndex(int value) {
        shoppingLineIndex = value;
    }
    public void setFoundInLine(int value) {
        foundInLine = value;
    }
    // Comparator.
    public int compareTo(Customer c) {
        if (nextEventTime - c.getNextEventTime() > 0) {
            return 1;
        } else if (nextEventTime - c.getNextEventTime() < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}