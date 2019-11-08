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
     * Create a review just with person ID.
     *
     * @param personId The person ID.
     */
    public Review(String personId) {
        this.personId = personId;
    }

    /**
     * Sets the date of the review.
     * @param date the date of the review as a LocalDate.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Sets the score of the review.
     * @param score the score of the review as an int.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Return a detailed description of the review.
     */
    @Override
    public String toString() {
        return "personId = '" + personId +
                "\', date = '" + date +
                "\', score ='" + score +
                "\'";
    }
}
