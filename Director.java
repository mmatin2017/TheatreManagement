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
public class Director extends User {

    private String password; // Password for director accounts

    /**
     * Constructor that takes name and password to create a new Actor object
     * @param name
     * @param password
     */
    public Director(String name, String password) {
        super(name);
        this.password = password;
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
