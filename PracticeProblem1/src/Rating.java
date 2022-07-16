public class Rating implements Comparable<Rating>{
    // The sum of all ratings.
    private double sumOfRatings;

    private int raters;

    //Intialize both fields to zero.
    public Rating() {
        sumOfRatings = 0;
        raters = 0;
    }
    //Intialize fields to parameter values.
    public Rating(double sumOfRatings, int raters) {
        this.sumOfRatings = sumOfRatings;
        this.raters = raters;
    }
    // Increase the sum of ratings, raters, and newRating to one.
    public void addRating(double newRating) {
        sumOfRatings += newRating;
        raters++;
    }
    // Return the average rating by averaging the ratings.
    public double getAverageRating() {
        double averageRating = (raters == 0) ? 0: (double) sumOfRatings / raters;
        return averageRating;
    }
    // Display the ratings
    public String toString() {
        String returnString = getAverageRating() + " based on " + raters + " reviews";
        return returnString;
    }

    // compareTo function to put the reviews in order as per the requirements states.
    public int compareTo(Rating otherRating) {
        int compareValue = 0;
        if(getAverageRating() == otherRating.getAverageRating()) {
            compareValue = (raters > otherRating.raters) ? -1: 1;
        } else {
            compareValue = (getAverageRating() > otherRating.getAverageRating()) ? -1: 1;
        }
        return compareValue;
    }

}
