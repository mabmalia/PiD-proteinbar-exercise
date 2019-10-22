package proteinbar;

/**
 *
 * This class holds the details of a review of a bar.
 *
 * @author  Miguel Mália
 * @version 2019.10.22
 */
public class Review {
    private String personId;

    /**
     * Create a review.
     *
     * @param personId The person ID.
     */
    public Review(String personId) {
        this.personId = personId;
    }

    /**
     * Return the score of the review.
     * @return the score of the review as a int.
     */
    public String getPersonID()
    {
        return personId;
    }
}
