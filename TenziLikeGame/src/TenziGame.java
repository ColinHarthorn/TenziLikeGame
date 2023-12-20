import java.util.ArrayList;

/**
 * The TenziGame class is where Die objects are created and all user interaction for each game will happen. 
 * 
 * @author Colin Harthorn
 *
 */
public class TenziGame {
    //instance variables
    /**
     * The variable turns tracks the number of turns the player has taken during the game of tenzi as an integer
     */
    private int turns;
    /**
     * The variable startTime records the time the game of Tenzi starts to the millisecond in Unix Epoch time as a long integer
     */
    private long startTime;
    /**
     * The variable endTime records the time the game of Tenzi ends to the millisecond in Unix Epoch time as a long integer
     */
    private long endTime;
    /**
     * The variable theDice is an array list of type Die that will contain the 10 Die objects the player will be rolling in the game of Tenzi
     */
    private ArrayList<Die> theDice; 
    
    
    //Constructors
    /**
     * Constructor to create a new TenziGame by setting turns to 0, creating an empty ArrayList of class Die, getting the Unix Epoch timestamp 
     * of the time the game was started, creating 10 die objects and adding them to the empty ArrayList, and then rolling each die once.
     * 
     */
    public TenziGame () {
        this.turns = 0;
        this.theDice = new ArrayList<Die>();
        this.startTime = System.currentTimeMillis();;
        
        for (int i = 1; i <= 10; i++) {
            theDice.add(new Die());
        }
        for(int i = 0; i <= 9; i++) {
            theDice.get(i).roll();
        }
    }
    //Methods
    /**
     * The method will return true or false depending on whether or not the game is over.
     * 
     * @return boolean the method will return a true if the game is over and false if the game is not over.
     */
    public boolean isOver() { 
        // over tracks the number of positive checks of the matching of 2 die objects in consecutive order in theDice
        int over = 0;
        for (int i = 0; i < theDice.size()-1; i++) {
            // if the dice at the current value of the index and the next value in the index are the same the over variable is increased by 1
            if (theDice.get(i).getFaceValue() == (theDice.get(i+1).getFaceValue())) {
                over = over + 1;
            }
        }
        // when all dice have the same value the over variable will be 9 and return true, the game is over.
        if (over == 9) {
            return true;
        }
        // all other states of theDice will return false by default.
        return false;
    }
    /**
     * This method will take user input as an array of integers and roll the dice corresponding to the user input in the array list of dice.
     * 
     * @param dice is an array of the dice numbers the user wishes to roll.
     */
    public void roll(int[] dice) {
        // this loop will roll the die corresponding to the value contained at each index in the dice array
        for (int i = 0; i < dice.length; i++) {
            theDice.get(dice[i]).roll();
        }
        // The turn variable will be incremented by 1 after the dice are rolled
        this.turns = turns + 1;

    }
    /**
     * This method will subtract the start time from the end time to return the total time elapsed in milliseconds.
     * 
     * @return long the return value is the time in milliseconds elapsed during the game
     */
    public long getTimeElapsed() {
        this.endTime = System.currentTimeMillis();
        long timeElapsed;
        timeElapsed = this.endTime - this.startTime;
        return timeElapsed;
    }
    /**
     * Getter for the private turns variable.
     * 
     * @return int the return value is an integer of the number of turns in the game.
     */
    public int getTurns() {
        return turns;
    }
    /*
     * toString will override the default java toString method to allow human readable printing of the values of all 10 dice
     *  
     * @return diceValues the override toString method in tenzi game will return a string of dice values numbered from 0-9
     */
    @Override
    public String toString() {
        String diceValues = "";
        for(int i = 0; i <= 9; i++) {
            diceValues = diceValues + i + ": " + theDice.get(i)+"\n";
        }
        diceValues = diceValues + "\n";
        return diceValues;
    }
}
