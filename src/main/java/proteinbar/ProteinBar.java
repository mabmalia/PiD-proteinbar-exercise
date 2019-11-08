package proteinbar;

import java.util.ArrayList;

/**
 *
 * This class holds the details of a protein bar.
 */
public class ProteinBar {
    private String name;
    private double fett;
    private double energy;
    private double kolhydrat;
    private double protein;
    private double fiber;
    private ArrayList<Review> reviews;

    /**
     * Create a protein bar just with name.
     * @param name
     */
    public ProteinBar(String name){
        this.name = name;
        reviews = new ArrayList<>();
    }

    /**
     * Return the reviews of the bar.
     * @return a list of reviews.
     */
    public ArrayList<Review> getReviews()
    {
        return reviews;
    }

    /**
     * Return the name of the bar.
     * @return the name of the bar as a String.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Return the protein of the bar.
     * @return the protein of the bar as a double.
     */
    public double getProtein()
    {
        return protein;
    }

    /**
     * Return the fat of the bar.
     * @return the fat of the bar as a double.
     */
    public double getFat()
    {
        return fett;
    }

    /**
     * Return the fiber of the bar.
     * @return the fiber of the bar as a double.
     */
    public double getFiber()
    {
        return fiber;
    }

    /**
     * Set protein bar fat
     * @param fett as a double
     */
    public void setFett(double fett) {
        this.fett = fett;
    }

    /**
     * Set protein bar energy
     * @param energy as a double
     */
    public void setEnergy(double energy) {
        this.energy = energy;
    }

    /**
     * Set protein bar kolhydrat
     * @param kolhydrat as a double
     */
    public void setKolhydrat(double kolhydrat) {
        this.kolhydrat = kolhydrat;
    }

    /**
     * Set protein bar energy
     * @param protein as a double
     */
    public void setProtein(double protein) {
        this.protein = protein;
    }

    /**
     * Set fiber bar energy
     * @param fiber as a double
     */
    public void setFiber(double fiber) {
        this.fiber = fiber;
    }

    /**
     * Add review to protein bar
     * @param review as a double
     */
    public void addReview(Review review) {
        reviews.add(review);
    }

    /**
     * Return a detailed description of the protein bar.
     */
    @Override
    public String toString() {
        return "name = \'" + name
                + "\', fat = \'" + fett
                + "\', energy = " + energy
                + "\', carbohydrate = " + kolhydrat
                + ", protein = \'" + protein
                + ", fiber = \'" + fiber + "\'";
    }
}