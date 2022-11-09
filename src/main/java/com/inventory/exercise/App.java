package com.inventory.exercise;

import com.inventory.exercise.report.CsvReport;
import com.inventory.exercise.report.HtmlReport;
import com.inventory.exercise.store.ParsingItem;

import java.util.Scanner;

public class App {





	public static void main(String[] args) {
		System.out.println(message());
		Scanner userInput = new Scanner(System.in);
		while (userInput.hasNext()) {
			String input = userInput.nextLine();
			if(input.equals("exit")){
				break;
			}
			switch (input) {
				case "1":
					storeInventory();
					System.out.println(message());
					break;
				case "2":
					report();
					System.out.println(message());
					break;
				default:
					System.out.println("The options entered are not valid");
					break;

			}
		}
	}

	private static String message(){
		return "Please type 1 for Insert Data or 2 for getting a Report and press Enter.\n" +
				"In case you want to exit type 'exit' and press Enter.." ;

	}
	public static void storeInventory(){
		System.out.println("Enter the name of the inventory, serial number and value separated by comma.  If you want to go back, type 'back'");
		Scanner userInput = new Scanner(System.in);
		ParsingItem parsingItem = new ParsingItem();
		while (userInput.hasNext()) {
			String input = userInput.nextLine();
			if(input.equals("back")){
				break;
			}
			if (parsingItem.parsingUserInput(input)) {
				System.out.println("Item saved.");

			} else {
				System.out.println(parsingItem.getErrorMessage());
				System.out.println("Enter the name of the inventory, serial number and value: ");
			}
		}
	}

	public static void report(){
		System.out.println("Please enter 1 for Html Report and 2 for CSV report. If you want to go back, type 'back' ");
		Scanner userInput = new Scanner(System.in);
		while (userInput.hasNext()) {
				String input = userInput.nextLine();
				if(input.equals("back")){
					break;
				}
				switch (input) {
					case "1":
						System.out.println(new HtmlReport().createHtmlReport());
						break;
					case "2":
						new CsvReport().createCsvReport();
						break;
					default:
						System.out.println("The options entered are not valid");
						break;
				}

			}
	}
}
