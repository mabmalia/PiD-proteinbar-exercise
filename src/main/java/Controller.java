import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import proteinbar.*;
import xmlparser.XmlParser;

/**
 *
 */
public class Controller {
    private Scanner scan;
    public ArrayList<ProteinBar> proteinBars;

    /**
     * Controller constructor.
     */
    public Controller() {
        scan = new Scanner(System.in);
        proteinBars = new ArrayList<>();

        //read XML file and fetch data
        XmlParser parseXML = new XmlParser();
        addAllBars(parseXML.xmlParser());
    }

    /**
     * Print out a Welcome message to the user.
     */
    private void printWelcome() {
        System.out.println("Welcome to our Protein bar catalogue!");
    }

    /**
     *
     */
    public void start() {
        printWelcome();
        while (true) {
            printMenu();
            switch (userInput()) {
                case "1":
                    // show the list of protein bar names
                    showListOfBars();
                    break;
                case "2":
                    // sort bars from highest to lowest protein content
                    sortBarsByProtein();
                    break;
                case "3":
                    // sort by fat content
                    sortBarsByFat();
                    break;
                case "4":
                    // Filter bars which has less than"some number from the user" fiber
                    // and sort them from highest to lowest.
                    System.out.println("Please, type in the maximum amount of fiber you want in your bar:");
                    filterBarsByFiber(convertIndexToInt(userInput()));
                    break;
                case "5":
                    // Find all protein bars with more than X protein
                    // reviewed by Y (X and Y should be entered from the user).
                    System.out.println("Please, type in the minimum amount of protein you want in your bar:");
                    int userProtein = convertIndexToInt(userInput());
                    if (userProtein != -1){
                        System.out.println("Type the Id of a person to check the bars reviewed:");
                        filterBarsByProteinAndUser(userProtein, userInput());
                    }
                    else{
                        System.out.println("Invalid protein number.");
                    }

                    break;
                case "6":
                    return;
                default:
                    System.out.println("Sorry, invalid option.");
            }
            printReturnMenu();
        }
    }

    /**
     * Print a message asking for any input to return to the main menu
     */
    public void printReturnMenu() {
        System.out.println("Please, press Enter to return to the menu");
        userInput();
    }

    /**
     * Print out the main menu to the user.
     */
    private void printMenu() {
        System.out.println("Pick an option:");
        String[] actions = {"(1) Show protein bars names", "(2) Sort by protein content", "(3) Sort by fat content",
                "(4) Filter by fiber content", "(5) Filter by protein and date", "(6) Quit"};
        for (int i = 0; i < actions.length; i++) {
            System.out.println(actions[i]);
        }
    }

    /**
     * Collect user input.
     * @return user input as a String.
     */
    public String userInput() {
        return scan.nextLine();
    }

    /**
     * Display all the bars the list
     */
    private void showListOfBars() {
        proteinBars.stream()
                .map(ProteinBar::getName)
                .forEach(System.out::println);
    }

    /**
     * Sort bars based on highest protein content
     */
    public void sortBarsByProtein() {
        proteinBars.stream()
                .sorted(Comparator.comparing(ProteinBar::getProtein).reversed())
                .map(ProteinBar::toString)
                .forEach(System.out::println);
    }

    /**
     * Sort bars based on highest fat content.
     */
    public void sortBarsByFat() {
        proteinBars.stream()
                .sorted(Comparator.comparing(ProteinBar::getFat).reversed())
                .map(ProteinBar::toString)
                .forEach(System.out::println);
    }

    /**
     * Filter bars which have less than "some number from the user" fiber and sort them from highest to lowest.
     * @param filter
     */
    public void filterBarsByFiber(int filter) {
        proteinBars.stream()
                .filter(bars -> bars.getFiber() < filter)
                .sorted(Comparator.comparing(ProteinBar::getFiber).reversed())
                .map(ProteinBar::toString)
                .forEach(System.out::println);
    }

    /**
     * Find all protein bars with more than X protein reviewed by Y (X and Y should be entered from the user).
     * @param protein
     */
    public void filterBarsByProteinAndUser(int protein, String user) {
        proteinBars.stream()
                .filter(bars -> bars.getProtein() >= protein)
                .filter(bars -> bars.getPersonID(user))
                .map(ProteinBar::toString)
                .forEach(System.out::println);
    }

    /**
     *
     * @param proteinBars
     */
    public void addAllBars(ArrayList<ProteinBar> proteinBars) {
        this.proteinBars.addAll(proteinBars);
    }

    /**
     * Collect accurate user input, that can be turned into int, otherwise return -1
     * @param number
     * @return
     */
    private int convertIndexToInt(String number) {
        int convertedIndex;
        try {
            convertedIndex = Integer.parseInt(number);
            return convertedIndex;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Point where the application starts.
     * @param args
     */
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.start();
    }
}
