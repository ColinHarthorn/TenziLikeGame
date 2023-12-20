import java.util.Scanner;

/**
 * The tenzi driver class is where TenziGame objects are created to play the tenzi game and where the leaderboard object is made to track the
 * times of consecutive tenzi games.
 * 
 * @author Colin Harthorn
 *
 */
public class TenziDriver {
    /**
     * main is where the new TenziGame objects and Leaderboards are created and where the user's inputs are accepted to be used with the TenziGame
     * objects
     * 
     * @param args 
     */
    public static void main(String[] args) { 
        // playAgain is initially set to true to begin the first game
        Boolean playAgain = true;
        
        // the scanner that will be used for all userInput is created.
        Scanner userInput = new Scanner(System.in);
        
        // Leaderboard object is created for the games and assigned to tenziLeaderboard
        Leaderboard tenziLeaderboard = new Leaderboard();
        
        // A new game of tenzi will be made is playAgain equals true.
        while ( playAgain == true ) {
            // A new TenziGame object is created and displayed to the user.
            TenziGame gameOfTenzi = new TenziGame();
            System.out.println("\n"+gameOfTenzi.toString());
            
            // This loop checks to see if the game is over and prompts the user to make a turn if it is not
            while (gameOfTenzi.isOver() == false) {               
                System.out.print("Which to roll: ");
                
                String rolls = "";
                // The dice the user wishes to roll are assigned to the rolls string.
                rolls = userInput.next();
                
                // The roll method of TenziGame is called by splitting the input string into an array of Ints
                gameOfTenzi.roll(splitToInts(rolls));
                
                // The TenziGame object is then printed with the new values after rolling and the loop continues
                System.out.println("\n");
                System.out.println(gameOfTenzi.toString());
     
            }
            
            // When the game ends the getTimeElapsed method of TenziGame is assigned to the updateTime variable so there is no small differences 
            // when updating the leaderboard and displaying the information at the end of the game separate from the leaderboard.
            long updateTime;
            updateTime = gameOfTenzi.getTimeElapsed();
            
            // The user is displayed that the game is over, the number of turns, and the number of seconds the game took.
            System.out.println("Game over. You used "+gameOfTenzi.getTurns()+ " turns and "+updateTime/1000.0+ " seconds.");
            
            // The leaderboard is then updated with the same updateTime and displayed to the user.
            tenziLeaderboard.update(updateTime);
            System.out.println("--Current Leaderboard (in seconds)--");
            System.out.println(tenziLeaderboard);
            
            // The user is prompted to enter Y or N to play a new game.
            System.out.print("Play again? (Y/N) ");
            
            // The input is assigned to the string yesOrNo 
            String yesOrNo = "";
            yesOrNo = yesOrNo + userInput.next();
            
            // if the user inputs "Y", a new game will begin. If the user inputs anything else, the program will terminate.
            if (yesOrNo.equals("Y")) {
                playAgain = true;
            }
            else {
                playAgain = false;
            }

        }
    }    
    /**
     * splitToInts takes an input of a string containing integers and commas and returns an array of the integers from the original string.
     * 
     * 
     * @param diceToRoll is a string containing integers separated by commas entered by the user.
     * @return rollsForTurn is an array of type int containing the numbers inputed by the user.
     */
    public static int[] splitToInts(String diceToRoll) {
        // creates the variable of the int[] that will be returned.
        int[] rollsForTurn;
        // splits the diceToRoll string into an array of strings, separated by the commas
        String[] stringToArray = diceToRoll.split(",");
        // creates a new int[] the same length as the array of strings containing the integers from the input
        rollsForTurn = new int[stringToArray.length];
        // loops through the string array and parses the value at each index to the integer array.
        for (int i = 0; i < stringToArray.length; i++) {
            rollsForTurn[i] = Integer.parseInt(stringToArray[i]);
        }
        return rollsForTurn;         
    }
    

}
