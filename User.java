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
public class User {

    private String name; // Name field for user accounts 

    /**
     * Constructor that takes name to create a user object
     * @param name
     */
    public User(String name) {
        this.name = name;

    }

    /**
     * Getter for name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

}
