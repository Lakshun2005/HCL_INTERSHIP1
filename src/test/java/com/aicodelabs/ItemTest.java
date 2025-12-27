package com.aicodelabs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

    @Test
    public void testItemConstructorAndGetters() {
        Item item = new Item(101, "Test Item", 5);
        assertEquals(101, item.getItemCode());
        assertEquals("Test Item", item.getItemName());
        assertEquals(5, item.getItemQty());
    }

    @Test
    public void testItemSetters() {
        Item item = new Item();
        item.setItemCode(102);
        item.setItemName("Another Item");
        item.setItemQty(10);

        assertEquals(102, item.getItemCode());
        assertEquals("Another Item", item.getItemName());
        assertEquals(10, item.getItemQty());
    }
}
