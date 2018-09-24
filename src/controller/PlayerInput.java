package controller;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PlayerInput {

	private static final String INPUTPATTERN = "[1-3],[1-3]";
	private static final String QUITPATTERN = "q";

	public String obtainPlayerInput(Scanner scanner, int playerNumber, String playerToken){

		boolean validInput = false;
		String inputString = null;
		// Continue asking user for input if incorrect input has been provided
		while (!validInput) { 
			try {
				System.out.print( "Player "+ playerNumber +" enter a coord x,y to place your " + playerToken + " or enter 'q' to give up: ");
				inputString = scanner.next();
				// Check that the input is valid
				if(Pattern.matches(INPUTPATTERN, inputString) || Pattern.matches(QUITPATTERN, inputString)){
					validInput=true;
				} else {
					// throw exception if input is invalid
					throw new IllegalArgumentException();
				}

			} catch (IllegalArgumentException e) {
				System.out.println("\n" + "Please enter a valid coordinate with numbers between 1-3 and with a format of 'x,y' or quit the game with 'q'" + "\n");
			}
		}
		return inputString;
	}

}
