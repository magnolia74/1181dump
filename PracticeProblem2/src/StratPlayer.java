public class StratPlayer extends Player {

    private double percentPaper;
    private double percentScissors;
    private double percentRock;

    public StratPlayer(double paper, double scissors, double rock) {
        percentPaper = paper;
        percentScissors = scissors;
        percentRock = rock;
    }

    public String go() {

        double random = Math.random();

        if (random < percentPaper) {
            return "Paper";
        } else if (random < percentPaper + percentScissors) {
            return "Scissors";
        } else if (random < percentPaper + percentScissors + percentRock){
            return "Rock";
        } else {
            return go();
        }
    }
}