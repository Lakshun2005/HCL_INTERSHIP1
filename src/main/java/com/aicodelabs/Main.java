package com.aicodelabs; // Keep your package name if it exists, otherwise remove this line

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize cart as empty array [cite: 40]
        Item[] cart = new Item[0];
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display menu [cite: 31]
            System.out.println("Shopping cart menu");
            System.out.println("1. Insert new item in cart");
            System.out.println("2. Remove an item from cart");
            System.out.println("3. View cart items");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline [cite: 44]

            switch (choice) {
                case 1:
                    // --- INSERT ITEM ---
                    System.out.print("Enter item code: ");
                    int code = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter item quantity: ");
                    int qty = scanner.nextInt();

                    Item newItem = new Item(code, name, qty);

                    // Array Resizing Logic: Add item [cite: 41]
                    // 1. Create new array with size + 1
                    Item[] newCartAdd = new Item[cart.length + 1];

                    // 2. Copy old items using System.arraycopy
                    if (cart.length > 0) {
                        System.arraycopy(cart, 0, newCartAdd, 0, cart.length);
                    }

                    // 3. Add new item to the last index
                    newCartAdd[newCartAdd.length - 1] = newItem;

                    // 4. Update reference
                    cart = newCartAdd;

                    // Display updated cart logic as per example [cite: 31]
                    Item.display(cart);
                    break;

                case 2:
                    // --- REMOVE ITEM ---
                    if (cart.length == 0) {
                        System.out.println("Cart is Empty");
                        break;
                    }

                    System.out.println("Enter the code of an item:");
                    int removeCode = scanner.nextInt();

                    int indexToRemove = -1;
                    // Search for item
                    for (int i = 0; i < cart.length; i++) {
                        if (cart[i].getItemCode() == removeCode) {
                            indexToRemove = i;
                            break;
                        }
                    }

                    if (indexToRemove != -1) {
                        // Array Resizing Logic: Remove item [cite: 41]
                        Item[] newCartRemove = new Item[cart.length - 1];

                        // Copy items BEFORE the index
                        if (indexToRemove > 0) {
                            System.arraycopy(cart, 0, newCartRemove, 0, indexToRemove);
                        }

                        // Copy items AFTER the index
                        if (indexToRemove < cart.length - 1) {
                            System.arraycopy(cart, indexToRemove + 1, newCartRemove, indexToRemove, cart.length - indexToRemove - 1);
                        }

                        cart = newCartRemove;
                        System.out.println("Remaining items in cart..");
                        Item.display(cart);
                    } else {
                        System.out.println("Item not found"); // [cite: 49]
                    }
                    break;

                case 3:
                    // --- VIEW ITEMS ---
                    Item.display(cart);
                    break;

                case 4:
                    // --- EXIT ---
                    System.out.println("Thank you!!!"); // [cite: 31]
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4); // Loop until exit [cite: 46]

        scanner.close();
    }
}
