import java.util.Random;

/**
 * The Die class creates a Die object that can be 'rolled' using the roll method to generate a random value 1-6
 * which can then be displayed as a series of *'s
 * 
 * @author Colin Harthorn
 *
 */
public class Die {
        // Instance variables
        /** The current face value of the die.*/
        private int faceValue;
        
        //Constructors
        // The 'free' no argument constructor is used for the Die class
        
        /** 
         * getFaceValue returns the private faceValue variable in public methods within the die class.
         *  
         * @return faceValue  Returns the private variable faceValue in a public method. 
         */
        public int getFaceValue() {
            return faceValue;
        }
        //Methods
        /**
         * Method to reassign the private faceValue variable to a random number 1-6.
         */
        public void roll() {
            Random generator = new Random();           
            faceValue = generator.nextInt(6)+1;
            
        }
        /**
         * A toString method that will override the default java.lang.Object.toString to properly display the dice
         * 
         * @return currentValue The return value will be * separated by spaces to represent the private faceValue int as a string.
         */
        public String toString () {
            String currentValue = "";
                if (faceValue == 1) {
                    currentValue = currentValue+"*";
                } 
                else if (faceValue == 2) {
                    currentValue = currentValue+"* *";
                } 
                else if (faceValue == 3) {
                    currentValue = currentValue+"* * *";
                } 
                else if (faceValue == 4) {
                    currentValue = currentValue+"* * * *";
                } 
                else if (faceValue == 5) {
                    currentValue = currentValue+"* * * * *";
                } 
                else {
                    currentValue = currentValue+"* * * * * *";
                }           
            return currentValue;
        }
}
