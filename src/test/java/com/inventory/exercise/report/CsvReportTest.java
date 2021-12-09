package com.inventory.exercise.report;

import com.inventory.exercise.Item;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CsvReportTest {
    CsvReport report;
    @Before
    public void setUp() {
        report = new CsvReport();
    }

    @Test
    public void convertToCSV(){
        List<Item> itemList = new ArrayList<>();
        Item item = new Item("XBOX", "984565655SDG", new BigDecimal(300));
        itemList.add(item);
        String csvlFinal = report.convertToCSV(itemList);
        assertTrue(csvExpected().equals(csvlFinal));
    }

    private String csvExpected(){
        return "XBOX,984565655SDG,300";
    }

    @Test
    public void convertToCSVMultipleLines(){
        List<Item> itemList = new ArrayList<>();
        Item item = new Item("XBOX", "984565655SDG", new BigDecimal(300));
        Item item2 = new Item("PS5", "545454454DGD", new BigDecimal(500));
        itemList.add(item);
        itemList.add(item2);
        String csvlFinal = report.convertToCSV(itemList);
        assertTrue(csvExpectedMultipleLines().equals(csvlFinal));
    }

    private String csvExpectedMultipleLines(){
        return "XBOX,984565655SDG,300\n" +
                "PS5,545454454DGD,500";
    }
}
