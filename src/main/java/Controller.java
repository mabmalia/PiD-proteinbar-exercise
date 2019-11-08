import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import util.Utility;
import xmlparser.XmlHandler;
import proteinbar.*;

/**
 * This is the main class of the application.
 */
public class Controller {
    private ArrayList<ProteinBar> proteinBars;
    private View view;

    /**
     * Controller constructor.
     */
    public Controller() {
        view = new View();
        proteinBars = new ArrayList<>(XmlHandler.readProteinBarList("src/main/resources/"));
    }

    /**
     * This method represents the main menu of the application.
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
                    filterBarsByFiber(Utility.convertIndexToInt(userInput()));
                    break;
                case "5":
                    // Show all reviews of a specific bar.
                    view.printAskBarName();
                    showReviewsByBar(userInput());
                    break;
                case "6":
                    return;
                default:
                    view.printInvalidInput();
            }
            view.printReturnMenu();
            userInput();
        }
    }

    /**
     * Collect user input.
     * @return user input as a String.
     */
    public String userInput() {
        Scanner scan = new Scanner(System.in);
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
     * Sort bars based on highest protein content.
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
        if (filter != -1) {
            proteinBars.stream()
                    .filter(bars -> bars.getFiber() < filter)
                    .sorted(Comparator.comparing(ProteinBar::getFiber).reversed())
                    .map(ProteinBar::toString)
                    .forEach(System.out::println);
        }
        else{
            view.printInvalidInput();
        }
    }

    /**
     * Show all the reviews of a specific protein bar.
     * @param name nane of protein bar.
     */
    public void showReviewsByBar(String name) {
        proteinBars.stream()
                .filter(bars -> bars.getName().equals(name))
                .map(ProteinBar::getReviews)
                .flatMap(ArrayList::stream)
                .forEach(System.out::println);
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
