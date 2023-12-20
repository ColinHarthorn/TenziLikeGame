import java.util.ArrayList;
/**
 * The leaderboard class tracks the times of a set of games of tenzi in an array list and displays the times in order of least to greatest.
 * 
 * @author Colin Harthorn
 *
 */
public class Leaderboard {
    
    //instance variables
    /**
     * bestTimes is an array list that will store times of games in milliseconds in order of least to greatest as a long integer 
     */
    private ArrayList<Long> bestTimes;
    
    
    //constructors
    /**
     * Constructor to initialize a new leaderboard. The bestTimes array list is set to an empty list.
     */
    public Leaderboard () {
        bestTimes = new ArrayList<Long>();
    }
    
    //methods
    /**
     *  Method to add a new time to the bestTimes array list while maintaining an ascending order of values.
     *  
     * @param newTime is the time in milliseconds it has taken for a tenzi game to be played, as a long integer. 
     */
    public void update(long newTime) {
        // If there are no times in the bestTimes list the first time will be added.
        if (bestTimes.size() == 0) {
            bestTimes.add(newTime);
        }
        // If there is 1 or more times in the bestTimes list the position is checked before the new time is added
        else {
            // variable used to track proper position in the current list to add a new time.
            int timePosition = -1;
            // loop to compare the current values of the list with the new value and return the position.
            for (int i = 0; i < bestTimes.size(); i++) {
                long currentTime = bestTimes.get(i);
                if (newTime < currentTime) {
                    timePosition = i;
                    break;
                }
                else if (newTime > currentTime) {
                    timePosition = -1;
                }
            }
            // If timePosition is unchanged from -1 there are no values on the list greater than the new time and it is added on the end.
            if (timePosition == -1) {
                bestTimes.add(newTime);
            }
            // If timePosition was updated from -1 in the above loop the newTime will be added into the list at the proper position.
            else {
                bestTimes.add(timePosition, newTime);
            }
        }    
    }    
    /**
     * Method to override the default toString method to return a list of the times on the current leaderboard in seconds.
     * 
     * @return allTimes is a string containing an ordered list of the best times of the leaderboard in seconds.
     */
    @Override
    public String toString() {
        //allTimes is the variable for the resulting string.
        String allTimes  = "";
        //displayTimes is a double for displaying human readable seconds to be added to the string
        Double displayTimes;
        for (int i = 0; i < bestTimes.size(); i ++) {
            displayTimes = bestTimes.get(i)/1000.0;
            allTimes = allTimes+(i+1)+": "+displayTimes+'\n';
        }
        
        return allTimes;
    }
   
}
