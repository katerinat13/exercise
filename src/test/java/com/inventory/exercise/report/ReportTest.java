package com.inventory.exercise.report;

import com.inventory.exercise.Item;
import com.inventory.exercise.report.Report;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ReportTest {

    Report report;

    @Before
    public void setUp() {
        report = new Report();
    }



    @Test
    public void convertToItems()
    {
        List<String> file = new ArrayList<>();
        file.add("{\"name\":\"XBOX\",\"serialNumber\":\"AVB123AXY\",\"value\":399.00}");
        file.add("{\"name\":\"XBOX\",\"serialNumber\":\"AVB123AXY\",\"value\":399.00}");
        List<Item> items = report.convertToItems(file);

        assertTrue( items.size()==2);
    }
}
