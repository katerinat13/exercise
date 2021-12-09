package com.inventory.exercise.report;

import com.inventory.exercise.Conf;
import com.inventory.exercise.Item;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class HtmlReport extends Report{

    private static final String NEW_LINE = System.lineSeparator();

    public String createHtmlReport(){
        List<Item> items = convertToItems(readFile());
        try {
            return getTheHtml(items);
        }catch (Exception e){
            System.err.println("Something went wrong with the report");
        }
        return "Something went wrong";
    }

    //get the template.html file and fill it with the Items in html format
    public String getTheHtml(List<Item> items) throws IOException {
        String itemsHtml = items
                .stream()
                .map(i -> rowHtml(i))
                .collect(Collectors.joining(NEW_LINE));

        File htmlTemplateFile = new File(Conf.fileReportHtmlPath);
        String htmlString = FileUtils.readFileToString(htmlTemplateFile);
        htmlString = htmlString.replace("$bodyTable", itemsHtml);
        return  htmlString;
    }


    private String rowHtml(Item item) {
        return String.format(
                "<tr><td>%s</td><td>%s</td><td>%s</td></tr>",  item.getName(), item.getSerialNumber(),item.getValue()
        );
    }

}
