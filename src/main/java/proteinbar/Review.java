package proteinbar;

import java.time.LocalDate;

/**
 *
 * This class holds the details of a review of a bar.
 */
public class Review {
    private String personId;
    private LocalDate date;
    private int score;

    /**
     * Create a review.
     *
     * @param personId The person ID.
     */
    public Review(String personId, LocalDate date, int score) {
        this.personId = personId;
        this.date = date;
        this.score = score;
    }

    /**
     * Return the reviewer ID. of the review.
     * @return the reviewer ID as a String.
     */
    public String getPersonID()
    {
        return personId;
    }

    /**
     * Return the date of the review.
     * @return the date of the review as a LocalDate.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Return the score of the review.
     * @return the score of the review as a int.
     */
    public int getScore() {
        return score;
    }
}
