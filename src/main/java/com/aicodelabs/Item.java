package com.aicodelabs; // Keep your package name if it exists, otherwise remove this line

public class Item {
    // Private attributes
    private int itemCode;
    private String itemName;
    private int itemQty;

    // Default constructor
    public Item() {
    }

    // Parameterized constructor
    public Item(int itemCode, String itemName, int itemQty) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemQty = itemQty;
    }

    // Getters and Setters
    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemQty() {
        return itemQty;
    }

    public void setItemQty(int itemQty) {
        this.itemQty = itemQty;
    }

    // Static display method
    public static void display(Item[] itemArr) {
        if (itemArr.length == 0) {
            System.out.println("Cart is Empty"); //
            return;
        }

        for (Item item : itemArr) {
            System.out.println("Item code: " + item.getItemCode());
            System.out.println("Item name: " + item.getItemName());
            System.out.println("Item quantity: " + item.getItemQty());
            System.out.println(); // Adding a newline for cleaner separation
        }
    }
}
