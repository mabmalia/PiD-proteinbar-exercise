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
                "(4) Filter by fiber content", "(5) Show protein bar reviews", "(6) Quit"};
        for (int i = 0; i < actions.length; i++) {
            System.out.println(actions[i]);
        }
    }

    /**
     * Print a message asking for any input to return to the main menu
     */
    public void printReturnMenu() {
        System.out.println("Please, press Enter to return to the menu.");
    }

    /**
     * Print message requesting a bar name.
     */
    public void printAskBarName(){
        System.out.println("Type the name of a protein bar to check its reviews:");
    }
}