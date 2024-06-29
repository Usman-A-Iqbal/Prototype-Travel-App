/**
 * 
 */
package astonTravel;

import java.util.Scanner;
import java.lang.Math;


/**
 * A simple text-based user interface for the AstonTravel system -- for testing purpose.
 * 
 * @author Sylvia Wong and Hai Wang
 * @version 30/11/2023
 */
public class TUI {

	private Controller controller;  

	private Scanner stdIn;
	
	public TUI(Controller controller) {
		
		this.controller = controller;
		
		// Creates a Scanner object for obtaining user input
		stdIn = new Scanner(System.in);
		
		while (true) {
			displayMenu();
			getAndProcessUserOption();
		}
	}

	/**
	 * Displays the header of this application and a summary of menu options.
	 */
	private void displayMenu() {
		display(header());
		display(menu());
	}
	
	/**
	 * Obtains an user option and processes it.
	 */
	private void getAndProcessUserOption() {
		String command = stdIn.nextLine().trim();
		
		switch (command) {
		case "1" : // List information about either all destination cities or a specific city.
			display("List information about either all destination cities or a specific city...");
// 			display(controller.listDestinations("Edinburgh"));
			display(controller.listDestinations("all"));
			break;
		case "2" : // List nearby destination cities. 
			display("List nearby destination cities of a location....");
         	display(controller.listNearbyDestinations(51.9,-2.34,900));
			//display(controller.listNearbyDestinations(51.9,-2.34,200));

			
			break;
		case "3" : // List and store the distances between any two destinations
			display("List and store the distances between any two destinations...");
			display(controller.listDistances());
			break;
		case "4" : // List the shortest travel path that covers all the desired cities.
			display("List the shortest travel path that covers all the desired cities...");
			String[] cities = {"Bath", "Oxford", "London", "Liverpool","Cambridge"};
			display(controller.listShortestPath(cities));
			break;
		case "5" : // Exits the application
			display("Goodbye!");
			System.exit(0);
			break;
		default : // Not a known command option
			display(unrecogniseCommandErrorMsg(command));
		}
	}
	
	/*
	 * Returns a string representation of a brief title for this application as the header.
	 * @return	a header
	 */
	private static String header() {
		return "\n AstonTravel System\n";
	}
	
	/*
	 * Returns a string representation of the user menu.
	 * @return	the user menu
	 */
	private static String menu() {
		return "Enter the number associated with your chosen menu option.\n" +
			   "1: Lists information about either all destination cities or a specific city.\n" +
			   "2: List nearby destination cities of a location.\n" +
			   "3: List and store the distances between any two destinations. \n" +
			   "4: List the shortest travel path that covers all the desired cities.\n" +
			   "5: Exit this application\n";
	}
	
	/*
	 * Displays the specified info for the user to view.
	 * @param info	info to be displayed on the screen
	 */
	private void display(String info) {
		System.out.println(info);
	}
	
    /*
     * Returns an error message for an unrecognised command.
     * 
     * @param error the unrecognised command
     * @return      an error message
     */
    private static String unrecogniseCommandErrorMsg(String error) {
            return String.format("Cannot recognise the given command: %s.%n", error);
    }
    

}
