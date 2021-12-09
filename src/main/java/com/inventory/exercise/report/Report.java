package com.inventory.exercise.report;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventory.exercise.Conf;
import com.inventory.exercise.Item;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Report {

    //Read the json file and return String lines
    public List<String> readFile() {
        try {
            return Files.readAllLines(Conf.fileStorePath);
        } catch (IOException e) {
            System.out.println("Could not read the file");
            throw new RuntimeException(e);
        }
    }
    //Convert the lines (json format) returned from the file to Item Objects
    public List<Item> convertToItems(List<String> file){
        ObjectMapper mapper = new ObjectMapper();
        List<Item> items = new ArrayList();
        try {
            for (String record: file){
                items.add(mapper.readValue(record, Item.class));
            }
        }catch (Exception e){
            System.err.println(e);
            System.out.println("Something went wrong in convertToItems");
        }
        return items;
    }

}
