package com.inventory.exercise.report;

import com.inventory.exercise.Item;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class HtmlReportTest {

    HtmlReport report;

    @Before
    public void setUp() {
        report = new HtmlReport();
    }

    //File is rendered and return html elements
    @Test
    public void createHtmlReport(){
        String reportString =report.createHtmlReport();
        assertTrue(!reportString.isEmpty() && reportString.contains("<html>"));
    }

    @Test
    public void getTheHtml() throws IOException {
        List<Item> itemList = new ArrayList<>();
        Item item = new Item("XBOX", "984565655SDG", new BigDecimal(300));
        itemList.add(item);

        String htmlFinal = report.getTheHtml(itemList);
        assertTrue(htmlExpected().equals(htmlFinal));

    }

    private String htmlExpected(){
        return "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\"><html><head>    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">    <title>My Inventory</title></head><body><table>    <th>Name</th>    <th>Serial Number</th>    <th>Value</th>    <tr><td>XBOX</td><td>984565655SDG</td><td>300</td></tr></table></body></html>";

    }

    @Test
    public void getTheHtmlMultipleLines() throws IOException {
        List<Item> itemList = new ArrayList<>();
        Item item = new Item("XBOX", "984565655SDG", new BigDecimal(300));
        Item item2 = new Item("PS5", "545454454DGD", new BigDecimal(500));
        itemList.add(item);
        itemList.add(item2);
        String htmlFinal = report.getTheHtml(itemList);
        assertTrue(htmlFinal.contains("XBOX") && htmlFinal.contains("PS5")) ;

    }

}
