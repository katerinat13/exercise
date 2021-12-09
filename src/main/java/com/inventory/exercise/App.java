package com.inventory.exercise;

import com.inventory.exercise.report.CsvReport;
import com.inventory.exercise.report.HtmlReport;
import com.inventory.exercise.store.ParsingItem;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		System.out.println("Please enter 1 for Insert Data or 2 for getting a Report");
		Scanner userInput = new Scanner(System.in);
		while (userInput.hasNext()) {
			if (userInput.hasNextInt()) {
				switch (userInput.nextInt()) {
					case 1:
						storeInventory();
						break;
					case 2:
						report();
						break;
				}
			} else {
				System.out.println("Please enter a 1 or 2 as an option ");
			}
		}
	}

	public static void storeInventory(){
		System.out.println("Enter the name of the inventory, serial number and value: ");
		Scanner userInput = new Scanner(System.in);
		ParsingItem parsingItem = new ParsingItem();
		while (userInput.hasNext()) {
			if (parsingItem.parsingUserInput(userInput.nextLine())) {
				System.out.println("Item saved.");
			} else {
				System.out.println(parsingItem.getErrorMessage());
				System.out.println("Enter the name of the inventory, serial number and value: ");
			}
		}
	}

	public static void report(){
		System.out.println("Please enter 1 for Html Report and 2 for CSV report ");
		Scanner userInput = new Scanner(System.in);
		if (userInput.hasNextInt()) {
			switch (userInput.nextInt()) {
				case 1:
					System.out.println(new HtmlReport().createHtmlReport());
					break;
				case 2:
					new CsvReport().createCsvReport();

					break;
			}
		} else {
			System.out.println("Please enter a 1(HTML) or 2(CSV) as an option for Report type ");
		}

	}

}
