/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theatremanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author osmanmatin
 */
public class TheatreShow {

    private ArrayList<Actor> actors = new ArrayList<>(); // ArrayList that holds all Actor objetcs
    private ArrayList<Director> directors = new ArrayList<>(); // ArrayList that holds all Director objetcs
    private ArrayList<Actor> cast; // ArrayList that holds all Actor objects that are assigned in shows
    private ArrayList<TheatreShow> shows = new ArrayList(); // ArrayList that holds all TheatreShow objects
    private ArrayList<Audition> auditions = new ArrayList(); // ArrayList that holds all audition objects

    private String showName; // Name of the show
    private String showTime; // Time of the show
    private String showDate; // Date of the show

    /**
     * Constructor for TheatreShow
     */
    public TheatreShow() {
        //adds default actors, directors, shows and auditions
        defActors();
        defDirectors();

        //initializes the fields
        showName = "";
        showTime = "";
        showDate = "";
        cast = new ArrayList();
    }

    /**
     * Sets up all necessary information to run the program
     */
    public void setup() {

        // initialize scanner for user inputs
        Scanner input = new Scanner(System.in);
        // boolean for the while loop to keep looping
        boolean userCheck = false;

        try {
            // While loop keeps going until the right input is entered
            while (userCheck == false) {
                // Options for the user to choose from
                System.out.println("Would you like to login, create an account or view scheduled shows?");
                System.out.println("Enter 1 to login");
                System.out.println("Enter 2 to create an account");
                System.out.println("Enter 3 to view scheduled shows");
                System.out.println("Enter 4 to view scheduled auditons");
                System.out.println("Enter 5 to end the program");
                int userInput = input.nextInt();

                //switch cases to take user to selected input
                switch (userInput) {
                    case 1:
                        userCheck = true;
                        login();
                        break;
                    case 2:
                        userCheck = true;
                        createAccount();
                        break;
                    case 3:
                        userCheck = true;
                        viewShow();
                        break;
                    case 4:
                        viewAuditons();
                        break;
                    case 5:
                        logout();
                        break;
                    default:
                        System.out.println("Incorrect input.");
                }

            }
            // Catches input mismatch exceptions and takes the user back to the start
        } catch (InputMismatchException ime) {
            System.out.println("Incorrect input.");
            setup();
        }

    }

    /**
     * Method for user accounts to login
     *
     */
    public void login() {
        Scanner input = new Scanner(System.in);
        // Prompt for user input
        System.out.println("Log in as actor or director.");
        System.out.println("Enter 1 to login as a director");
        System.out.println("Enter 2 to login as a actor");
        System.out.println("Enter 3 to return to main menu");
        // boolean  for while loop
        boolean userLogin = false;

        try {
            // while loop iterates until correct input is entered
            while (userLogin == false) {
                // holds user input
                int user = input.nextInt();
                // switch cases to take user to selected input
                switch (user) {
                    // Case 1 for directors
                    case 1:
                        // prompt for director name
                        System.out.println("Enter name");
                        input.nextLine();
                        // field that takes the user eneterd name
                        String directorName = input.nextLine();

                        System.out.println("Enter Password");
                        // field that takes the user eneterd password
                        String directorPass = input.nextLine();
                        //Iterates through all the directors
                        for (int i = 0; i < directors.size(); i++) {
                            // checks if the user entered name and password match with any director objects in arraylist
                            if (directorName.compareTo(directors.get(i).getName()) == 0 && directorPass.compareTo(directors.get(i).getPassword()) == 0) {
                                // if user inputs match, boolean field is set to true
                                userLogin = true;
                                // user is taken to director menu
                                directorConsole();

                            }

                        }
                        // if user inputs are incorrect, user is taken back to the start of the login method
                        System.out.println("Incorrect username or password.");
                        login();
                        break;
                    // Case 2 for actors
                    case 2:
                        // prompt for actor's name
                        System.out.println("Enter name");
                        input.nextLine();
                        // holds user input for name
                        String actorName = input.nextLine();
                        // prompt for actor password
                        System.out.println("Enter Password");
                        // holds actor password
                        String actorPass = input.nextLine();
                        // iterates through arrayList of actors
                        for (int i = 0; i < actors.size(); i++) {
                            // checks if the user entered name and password match with any actor objects in arraylist
                            if (actorName.compareTo(actors.get(i).getName()) == 0 && actorPass.compareTo(actors.get(i).getPassword()) == 0) {
                                // if user inputs match, boolean field is set to true
                                userLogin = true;
                                // user is taken to actor menu (stub method)
                                actorConsole();

                            }
                        }
                        // if user inputs are incorrect, user is taken back to the start of the login method
                        System.out.println("Incorrect username or password. Try again.");
                        login();
                        break;
                    // sends back to main menu  
                    case 3:
                        setup();
                        break;
                    // checks for any other inputs, prompts for correct user input
                    default:
                        System.out.println("Incorrect input");
                        System.out.println("Enter 1 to login as a director");
                        System.out.println("Enter 2 to login as a actor");
                        System.out.println("Enter 3 to return to main menu");

                }
            }
            // Catches input mismatch exceptions and takes the user back to the start
        } catch (InputMismatchException ime) {
            System.out.println("Incorrect input");
            login();
        }

    }

    /**
     * Creates account for user as actor or director
     */
    public void createAccount() {
        Scanner input = new Scanner(System.in);
        //prompts user for input
        System.out.println("Would you like to create an account as an actor or director? ");
        System.out.println("Enter 1 to create an account as a director");
        System.out.println("Enter 2 to create an account as an actor");
        System.out.println("Enter 3 to return to main menu");
        // boolean for while loop
        boolean userCreate = false;
        try {
            // while loop to continue through incorrect inputs
            while (userCreate == false) {
                // holds user input
                int accountType = input.nextInt();
                // switch cases to take user to selected input
                switch (accountType) {
                    // Case for actors
                    case 2:
                        // prompt for user
                        System.out.println("Enter username");
                        input.nextLine();
                        // holds actor name
                        String aName = input.nextLine();

                        System.out.println("Enter password");
                        // holds actor password
                        String aPassword = input.nextLine();
                        // creates Actor object p with user input information
                        Actor p = new Actor(aName, aPassword);
                        // adds newly created actor to arraylist
                        actors.add(p);
                        // boolean turns to true and breaks looop
                        userCreate = true;
                        break;
                    // Case for directors
                    case 1:
                        // prompt for the user
                        System.out.println("Enter username");
                        input.nextLine();
                        // holds name for director
                        String dName = input.nextLine();

                        System.out.println("Enter password");
                        // holds name for director
                        String dPassword = input.nextLine();
                        // creates new director object with user input information
                        Director d = new Director(dName, dPassword);
                        // adds to director arraylist
                        directors.add(d);
                        // boolean turns to true and breaks loop
                        userCreate = true;

                        break;
                    // sends back to main menu  
                    case 3:
                        setup();
                        break;
                    // checks for wrong inputs and prompts for the right input
                    default:
                        System.out.println("Incorrect input.");
                        System.out.println("Enter 1 to create an account as a director");
                        System.out.println("Enter 2 to create an account as an actor");
                        System.out.println("Enter 3 to return to main menu");

                }
            }
            // Catches input mismatch exceptions and takes the user back to the start
        } catch (InputMismatchException ime) {
            System.out.println("Incorrect input.");
            createAccount();
        }
        // After accounts are created, user is taken back to main menu
        setup();
    }

    /**
     * Main menu that would prompt user for specified actions that are only for
     * actors
     */
    public void actorConsole() {
        System.out.println("Actor console stub method. Returnong to main menu");
        setup();
    }

    /**
     * Main menu that prompts user for specified actions that are only for
     * directors
     */
    public void directorConsole() {
        Scanner input = new Scanner(System.in);
        // prompts for user
        System.out.println("What would you like to do?");
        System.out.println("Enter 1 to set rating for actors");
        System.out.println("Enter 2 to schedule a show");
        System.out.println("Enter 3 to log out and return to the main menu");
        try {
            // boolean for while loop
            boolean userLogin = false;
            // while loop to continue through for incorrect inputs
            while (userLogin == false) {
                // holds user input
                int userIn = input.nextInt();
                // switch cases to take user to selected input
                switch (userIn) {
                    // takes user to set actor rating
                    case 1:
                        setActorRating();
                        break;
                    // takes user to create a new show
                    case 2:
                        setShow();
                        break;
                    // takes user back to main menu    
                    case 3:
                        setup();
                    // checks for wrong inputs and prompts for the right input  
                    default:
                        System.out.println("Incorrect input.");
                        System.out.println("Enter 1 to view actors");
                        System.out.println("Enter 2 to schedule a show");
                        System.out.println("Enter 3 to log out and return to the main menu");

                }
            }
            // Catches input mismatch exceptions and takes the user back to the start
        } catch (InputMismatchException ime) {
            System.out.println("Incorrect input.");
            directorConsole();
        }

    }

    /**
     * Sets actor rating that can only be accessed by directors
     */
    public void setActorRating() {
        Scanner input = new Scanner(System.in);
        // boolean for while loop
        boolean offset = true;
        try {
            // while loop to continue through for incorrect inputs
            while (offset == true) {
                // prompts user to choose an actor
                System.out.println("Choose the actor you want to set the rating for");
                // iterates through actors arraylist
                for (int i = 0; i < actors.size(); i++) {
                    // prints out all actors numbered 
                    System.out.println(i + ". " + actors.get(i).getName() + ", " + actors.get(i).getRating());
                }
                // takes user input
                int actorChosen = input.nextInt();
                // checks for wrong input
                if (actorChosen >= actors.size() || actorChosen < 0) {
                    System.out.println("Invalid input");
                } else {
                    // prompts user for new rating
                    System.out.println("Give a new  rating between 0 - 10");
                    // takes user input
                    double newRating = input.nextDouble();
                    // checks for wrong input
                    if (newRating < 0 || newRating > 10) {
                        System.out.println("Incorrect input.");
                    } else {
                        // sets new actor rating
                        actors.get(actorChosen).setRating(newRating);
                    }

                }
                // iterates through actors arraylist
                for (int i = 0; i < actors.size(); i++) {
                    // prints out all actors numbered with new ratings
                    System.out.println(i + ". " + actors.get(i).getName() + ", " + actors.get(i).getRating());
                }
                // prompts user to set another rating or not 
                System.out.println("Do you want to change another rating? 1 for yes, 2 for no");
                int cont = input.nextInt();
                // switch cases for user input
                switch (cont) {
                    // sets another rating
                    case 1:

                        break;
                    // takes user back to director menu
                    case 2:
                        directorConsole();
                        break;
                    // checks for wrong inputs and prompts for the right input 
                    default:
                        System.out.println("Inorrect input. returning to main menu");
                        directorConsole();

                }

            }
            // Catches input mismatch exceptions and takes the user back to the director menu
        } catch (InputMismatchException ime) {
            System.out.println("Incorrect input. Returning to main menu");
            directorConsole();

        }
    }

    /**
     * Creates a new show that can only be done by directors
     *
     */
    public void setShow() {
        Actor showCast;
        TheatreShow play;

        Scanner input = new Scanner(System.in);
        // boolean for while loop 
        boolean keepCreate = true;
        // boolean to check for duplicate actors
        boolean duplicate = true;
        try {
            // while loop to continue through if user wants to create more shows
            while (keepCreate == true) {
                // creates new cast for new TheatreShow object
                cast = new ArrayList<>();
                /// creates a new TheatreShow object
                play = new TheatreShow();
                System.out.println("What is the name of your show?");
                // Prompts user for name
                play.setShowName(input.nextLine());
                // prompts user to hold auditions or finish creating show
                System.out.println("Would you like to hold auditions?");
                System.out.println("1 for yes");
                System.out.println("2 for no and finish creating your show");
                int userAudit = input.nextInt();
                // switch cases to take user to selected input
                switch (userAudit) {
                    // adds TheatreShow object to arraylist and goes to method that creates auditons
                    case 1:

                        shows.add(play);
                        scheduleAudition();
                        break;
                    // Finishes creating the show
                    case 2:
                        break;
                    // takes user back to director menu for incorrect input
                    default:
                        System.out.println("Icorrect input. Returning back to main menu");
                        directorConsole();
                }
                input.nextLine();
                // prompt for show date
                System.out.println("Set a show date. MM/DD/YYYY");

                play.setShowDate(input.nextLine());
                // prompt for show time
                System.out.println("Set a show time. 00:00 AM/PM");
                play.setShowTime(input.nextLine());
                // prompts user for number of cast members
                System.out.println("How many cast members would you like to add?");
                int castMem = input.nextInt();
                input.nextLine();
                // iterates through number of cast members
                for (int i = 0; i < castMem; i++) {
                    // takes cast membors name
                    System.out.println("Enter cast member's name");

                    String actorName = input.nextLine();
                    // creates a new actor object with the user entered name
                    showCast = new Actor(actorName);
                    // adds actor object to cast arraylist
                    cast.add(showCast);
                    // iterates through actor arraylist
                    for (Actor star : actors) {
                        // checks if new actor object is the same as an existing actor object
                        if (showCast.getName().compareTo(star.getName()) == 0) {
                            // sets duplicate to true and breaks loop
                            duplicate = true;
                            break;
                            // ses duplicat to false
                        } else {

                            duplicate = false;
                        }

                    }
                    // if duplicate is false, add the newly created actor to actors arrayList
                    if (duplicate == false) {
                        actors.add(showCast);
                    }

                }
                // sets the cast for the TheatreShow
                play.setCast(cast);
                // adds new TheatreShow to shows arrayList
                shows.add(play);
                // prints out the show details to user
                System.out.print("You have set a show called " + play.getShowName() + " that is scheduled for " + play.getShowDate() + " " + play.getShowTime()
                        + " featuring "
                );
                for (Actor mem : cast) {
                    System.out.println(mem.getName() + ", ");
                }
                // prompts user to create another show or return to main menu
                System.out.println("Would you like to create another show?");
                System.out.println("Enter 1 to create another show");
                System.out.println("Enter 2 to return to the main menu");
                int userInput = input.nextInt();
                // switch cases to take user to selected input
                switch (userInput) {
                    // creates another show
                    case 1:
                        break;
                    // returns back to director menu
                    case 2:
                        directorConsole();
                        break;
                    // takes user back to director menu for incorrect input
                    default:
                        System.out.println("Incorrect input. Returning to main menu");
                        directorConsole();
                }
                input.nextLine();
            }
            // Catches input mismatch exceptions and takes the user back to director menu
        } catch (InputMismatchException ime) {
            System.out.println("Incorrect input. Returning to main menu");
            directorConsole();

        }

    }

    /**
     * View shows that are scheduled or have been created
     *
     */
    public void viewShow() {
        Scanner input = new Scanner(System.in);
        // iterates through shows arraylist and prints out the shows
        for (TheatreShow play : shows) {

            System.out.println(play.getShowName() + " " + play.getShowDate() + " " + play.showTime);

        }
        System.out.println();
        // prompts user to return to main menu
        System.out.println("Enter 1 to return back to the main menu");
        try {
            int userInput = input.nextInt();
            switch (userInput) {
                case 1:
                    setup();
                    break;
                default:
                    System.out.println("Incorrect input. Returning to main menu");
                    setup();
            }
        } catch (InputMismatchException ime) {
            System.out.println("Incorrect input. Returning to main menu");
            setup();

        }

    }

    /**
     * Shuts the program down when the user is finished
     *
     */
    public void logout() {
        System.exit(0);
    }

    /**
     * Schedules auditions which can only be done by directors
     */
    public void scheduleAudition() {

        Audition showChap;
        Scanner input = new Scanner(System.in);
        // boolean for while loop
        boolean keepCreate = true;

        try {
            // while loop to schedule more auditions
            while (keepCreate == true) {
                // create a new Audition object
                showChap = new Audition();
                // gets the last created TheatreShow and sets to the Audition object
                showChap.setShow(shows.get(shows.size() - 1));
                // prompt user for audition date
                System.out.println("Set an audition date");

                showChap.setDate(input.nextLine());
                // prompt user for audition time
                System.out.println("Set a audition time");
                showChap.setTime(input.nextLine());

                // Adds Audition object to auditions arrayList
                auditions.add(showChap);
                // prompts user to hold another audition or return to main menu
                System.out.println("Would you like to hold another audition for this show?");
                System.out.println("Enter 1 to hold another audition for this show");
                System.out.println("Enter 2 to return to the main menu");
                int userInput = input.nextInt();
                // switch cases to take user to selected input
                switch (userInput) {
                    // creates another audition 
                    case 1:
                        break;
                    // returns back to director menu
                    case 2:
                        directorConsole();
                        break;
                    // checks for incprrect input and returns user to director menu
                    default:
                        System.out.println("Incorrect input. Returning to main menu");
                        directorConsole();
                }
                input.nextLine();
            }
            // checks for incprrect input and returns user to director menu
        } catch (InputMismatchException ime) {
            System.out.println("Incorrect input. Returning to main menu");
            directorConsole();

        }

    }

    /**
     * views auditions that have been scheduled or created
     */
    public void viewAuditons() {
        // iterates through auditions arraylist and prints out the auditions
        Scanner input = new Scanner(System.in);
        for (Audition play : auditions) {

            System.out.println(play.getShow().getShowName() + " " + play.getDate()
                    + " " + play.getTime());

        }
        System.out.println();
        // prompts user to return to main menu
        System.out.println("Enter 1 to return back to the main menu");
        try {
            int userInput = input.nextInt();
            switch (userInput) {
                case 1:
                    setup();
                    break;
                default:
                    System.out.println("Incorrect input. Returning to main menu");
                    setup();
            }
        } catch (InputMismatchException ime) {
            System.out.println("Incorrect input. Returning to main menu");
            setup();

        }
    }

    /**
     * Default actors created and added to actor arrayList for testing
     *
     */
    public void defActors() {
        Actor actor1 = new Actor("John Krasinski", "password");
        Actor actor2 = new Actor("Steve Carell", "password");
        Actor actor3 = new Actor("Rainn Wilson", "password");
        Actor actor4 = new Actor("Jenna Fischer", "password");
        Actor actor5 = new Actor("Ed Helms", "password");
        actors.add(actor1);
        actors.add(actor2);
        actors.add(actor3);
        actors.add(actor4);
        actors.add(actor5);

    }

    /**
     * Default directors created and added to director Array List for testing
     *
     */
    public void defDirectors() {
        Director director1 = new Director("Martin Scorsese", "password");
        Director director2 = new Director("Quentin Tarintino", "password");
        Director director3 = new Director("Michael Bay", "explosions");

        directors.add(director1);
        directors.add(director2);
        directors.add(director3);

    }

    /**
     * Getter for show time
     *
     * @return
     */
    public String getShowTime() {
        return showTime;
    }

    /**
     * Getter for show date
     *
     * @return
     */
    public String getShowDate() {
        return showDate;
    }

    /**
     * Setter for show time
     *
     * @param showTime
     */
    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    /**
     * Setter for show date
     *
     * @param showDate
     */
    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    /**
     * Getter for cast ArrayList
     *
     * @return
     */
    public ArrayList<Actor> getCast() {
        return cast;
    }

    /**
     * Setter for cast ArrayList
     *
     * @param cast
     */
    public void setCast(ArrayList<Actor> cast) {
        this.cast = cast;
    }

    /**
     * getter for show name
     *
     * @return
     */
    public String getShowName() {
        return showName;
    }

    /**
     * Setter for show name
     *
     * @param showName
     */
    public void setShowName(String showName) {
        this.showName = showName;
    }

}
