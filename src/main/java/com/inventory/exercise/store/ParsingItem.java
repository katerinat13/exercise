package com.inventory.exercise.store;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventory.exercise.Conf;
import com.inventory.exercise.Item;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.StringTokenizer;

public class ParsingItem {
    private String errorMessage;
    private final static int NUMBEROFDATA = 3;
    private static final String NEW_LINE = System.lineSeparator();



    //Parsing the User's Input
    public boolean parsingUserInput(String userInput){
        Item item = parseItem(userInput);
        if(item != null){
            return saveItem(item);
        }
        return false;
    }


    // Create an Item from the user's data
    public Item parseItem(String userInput){

        if (userInput.isEmpty() || !userInput.contains(",")){
            errorMessage = "Please enter valid data separated by ,";
            return null;
        }

        StringTokenizer line = new StringTokenizer(userInput, Conf.DELIMITER);
        if(line.countTokens()!=NUMBEROFDATA){
            errorMessage = "Please enter the 3 data required";
            return null;
        }

        while (line.hasMoreTokens()) {
            return createItem(line);
        }
        errorMessage = "Something went wrong. Please try again";
        return null;
    }

    private Item createItem(StringTokenizer line) {
        try {
            String name = line.nextToken().trim();
            String serialNumber = line.nextToken().trim();
            BigDecimal value = new BigDecimal((String)line.nextToken().trim());
            return new Item(name, serialNumber, value);
        } catch (NumberFormatException e) {
            errorMessage = "The value should be numeric";
            return null;
        } catch (Exception e) {
            errorMessage = "Please check the data entered";
        }
        return null;
    }

    //Save the Item as a Json format in a File
    public boolean saveItem(Item item){
        ObjectMapper Obj = new ObjectMapper();
        try {
            // Converting the Java object into a JSON string in order to save it later on in the file
            String jsonStr = Obj.writeValueAsString(item)+ NEW_LINE;
            Files.writeString(Conf.fileStorePath, jsonStr, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
        catch (Exception e) {
            errorMessage = "Problem while saving the Item";
            return false;
        }
        return true;
    }


    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
