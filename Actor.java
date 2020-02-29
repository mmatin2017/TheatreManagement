/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theatremanagementsystem;

/**
 *
 * @author osmanmatin
 */
public class Actor extends User {

    private String password; //Password for actor accounts
    private double rating; // rating for the actor

    /**
     * Constructor that takes name and password to create a new Actor object
     * @param name
     * @param p
     */
    public Actor(String name, String p) {
        super(name);
        this.password = p;
        rating = 0;
    }

    /**
     * Constructor that takes only the name to create actor object
     * @param name
     */
    public Actor(String name) {
        super(name);
        rating = 0;
        password = null;
    }

    /**
     * Getter for rating
     * @return
     */
    public double getRating() {
        return rating;
    }

    /**
     * Setter for Rating
     * @param rating
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * Getter for password
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    

}
