package com.inventory.exercise.report;

import com.inventory.exercise.Conf;
import com.inventory.exercise.Item;

import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class CsvReport extends  Report{

    //Create a csvFIle
    public void createCsvReport(){
        List<Item> items = convertToItems(readFile());
        try {
            Files.writeString(Conf.fileReportCsvPath, convertToCSV(items), StandardOpenOption.APPEND);
            System.out.println("CSV report created successfully");
        }catch (Exception e){
            System.err.println("Something went wrong with the report");
        }

    }
    //convert the List of Items to a String separated by comma. Add line when multiple data
    public String convertToCSV( List<Item> data) {
        return data.stream().map(item-> itemLineWithComma(item))
                .collect(Collectors.joining("\n"));
    }

    public String itemLineWithComma(Item item){
        return item.getName()+Conf.DELIMITER+item.getSerialNumber()+ Conf.DELIMITER+item.getValue();
    }
}
