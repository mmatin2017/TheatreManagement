/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theatremanagementsystem;

import java.util.ArrayList;

/**
 *
 * @author osmanmatin
 */
public class Audition {

    private String date; // Date of the Audition
    private String time; // Time of the Audition
    private TheatreShow show; // Show for which the Audition is held

    /**
     * Constructor that initialize fields so they can be changed later.
     */
    public Audition() {
        date = null;
        time = null;
        show = null;

    }

    /**
     * Getter for date
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     * Getter for time
     * @return
     */
    public String getTime() {
        return time;
    }

    /**
     * Getter for show
     * @return
     */
    public TheatreShow getShow() {
        return show;
    }

    /**
     * Setter for date
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Setter for time
     * @param time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Setter for show
     * @param show
     */
    public void setShow(TheatreShow show) {
        this.show = show;
    }

}
