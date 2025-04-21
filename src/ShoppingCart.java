import java.util.ArrayList;
import java.util.Scanner;

class Item {
    String name;
    int quantity;

    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

 
    public String toString() {
        return name + " (Quantity: " + quantity + ")";
    }
}

public class Main {
    private static ArrayList<Item> cart = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n1. Add Item  2. View Cart  3. Remove Item  4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    viewCart();
                    break;
                case 3:
                    removeItem();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        } while (choice != 4);
    }

    private static void addItem() {
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        cart.add(new Item(name, quantity));
        System.out.println("Item added to the cart.");
    }

    private static void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Items in your cart:");
            for (Item item : cart) {
                System.out.println(item);
            }
        }
    }

    private static void removeItem() {
        System.out.print("Enter the name of the item to remove: ");
        String name = scanner.nextLine();

        boolean itemFound = false;
        for (Item item : cart) {
            if (item.name.equalsIgnoreCase(name)) {
                cart.remove(item);
                itemFound = true;
                System.out.println("Item removed from the cart.");
                break;
            }
        }

        if (!itemFound) {
            System.out.println("Item not found in the cart.");
        }
    }
}

