package com.inventory.exercise.store;

import com.inventory.exercise.Item;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParsingItemTest {

    ParsingItem parsingItem;

    @Before
    public void setUp() {
        parsingItem = new ParsingItem();
    }
    @Test
    public void createItem()
    {
        Item item = new Item("XBOX", "984565655SDG", new BigDecimal(300));
        assertTrue( item.equals(parsingItem.parseItem("XBOX, 984565655SDG, 300")));
    }
    @Test
    public void inputDatashouldBe3()
    {
        parsingItem.parseItem("Katerina XBOX, 150");
        assertEquals("Please enter the 3 data required", parsingItem.getErrorMessage());
    }
    @Test
    public void inputDataShouldBeCommaSeperated()
    {
        parsingItem.parseItem("Katerina XBOX 150");
        assertEquals("Please enter valid data separated by ,", parsingItem.getErrorMessage());
    }

    @Test
    public void saveItem()
    {
        assertTrue(parsingItem.saveItem(new Item("Katerina", "XBOX",  new BigDecimal(150))));
    }
}
