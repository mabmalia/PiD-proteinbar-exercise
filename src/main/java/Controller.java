import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import xmlparser.XmlHandler;
import proteinbar.*;

/**
 *
 */
public class Controller {
    private Scanner scan;
    public ArrayList<ProteinBar> proteinBars;
    View view;

    /**
     * Controller constructor.
     */
    public Controller() {
        view = new View();
        scan = new Scanner(System.in);
        proteinBars = new ArrayList<>(XmlHandler.readProteinBarList("src/main/resources/"));

    }

    /**
     *
     */
    public void start() {
        view.printWelcome();
        while (true) {
            view.printMenu();
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
                    view.quantityOfChar("maximum", "fiber");
                    filterBarsByFiber(convertIndexToInt(userInput()));
                    break;
                case "5":
                    // Find all protein bars with more than X protein
                    // reviewed by Y (X and Y should be entered from the user).
                    view.quantityOfChar("minimum", "protein");
                    int userProtein = convertIndexToInt(userInput());
                    if (userProtein != -1){
                        view.printPersonId();
                        filterBarsByProteinAndUser(userProtein, userInput());
                    }
                    else{
                        System.out.println("Invalid protein number.");
                    }
                    break;
                case "6":
                    return;
                default:
                    view.printInvalidInput();
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
