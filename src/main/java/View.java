/**
 * This class represents an user interface.
 */
public class View {

    /**
     * Constructor of View class.
     */
    public View() {
    }

    /**
     * Print out a Welcome message to the user.
     */
    public void printWelcome() {
        System.out.println("Welcome to our Protein bar catalogue!");
    }

    /**
     * Print max / min amount of something in the bar
     */
    public void quantityOfChar(String quantity, String type){
        System.out.println("Please, type in the " + quantity + " amount of " + type + " you want in your bar:");
    }

    /**
     * Print a message stating that it was an invalid input.
     */
    public void printInvalidInput() {
        System.out.println("Invalid input.");
    }

    /**
     * Print out the main menu to the user.
     */
    public void printMenu() {
        System.out.println("Pick an option:");
        String[] actions = {"(1) Show protein bars names", "(2) Sort by protein content", "(3) Sort by fat content",
                "(4) Filter by fiber content", "(5) Filter by protein and date", "(6) Quit"};
        for (int i = 0; i < actions.length; i++) {
            System.out.println(actions[i]);
        }
    }

    /**
     * Print out the main menu to the user.
     */
    public void printPersonId(){
        System.out.println("Type the Id of a person to check the bars reviewed:");
    }
}