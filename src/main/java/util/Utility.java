package util;

import java.time.DateTimeException;
import java.time.LocalDate;

/**
 * This class incorporate methods that validate and convert variables.
 */
public class Utility {
    /**
     * Converts date from a string to local date type.
     * @param date
     * @return
     */
    public static LocalDate convertDate(String date) {
        LocalDate convertedDate;
        try {
            convertedDate = LocalDate.parse(date);
        } catch (DateTimeException e) {
            return null;
        }
        return convertedDate;
    }

    /**
     * Collect accurate user input, that can be turned into int, otherwise return -1
     * @param number
     * @return
     */
    public static int convertIndexToInt(String number) {
        int convertedIndex;
        try {
            convertedIndex = Integer.parseInt(number);
            return convertedIndex;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
