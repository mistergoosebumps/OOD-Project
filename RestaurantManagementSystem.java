import java.util.*;

public class RestaurantManagementSystem {

    static class MenuItem {
        String name;
        double price;

        public MenuItem(String name, double price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return name + " - $" + price;
        }
    }

    static class Order {
        List<MenuItem> items;
        double total;

        public Order() {
            items = new ArrayList<>();
            total = 0.0;
        }

        public void addItem(MenuItem item) {
            items.add(item);
            total += item.price;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Order Summary:\n");
            items.forEach(item -> sb.append(item).append("\n"));
            sb.append("Total: $").append(String.format("%.2f", total));
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<MenuItem> menu = Arrays.asList(
                new MenuItem("Burger", 5.99),
                new MenuItem("Pizza", 8.99),
                new MenuItem("Pasta", 6.99),
                new MenuItem("Salad", 4.99)
        );

        Order currentOrder = new Order();

        while (true) {
            System.out.println("\nRestaurant Management System");
            System.out.println("1. View Menu");
            System.out.println("2. Place Order");
            System.out.println("3. View Order");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Menu:");
                    menu.forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    MenuItem selectedItem = menu.stream()
                            .filter(item -> item.name.equalsIgnoreCase(itemName))
                            .findFirst()
                            .orElse(null);
                    if (selectedItem != null) {
                        currentOrder.addItem(selectedItem);
                        System.out.println("Item added to order.");
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;
                case 3:
                    System.out.println(currentOrder);
                    break;
                case 4:
                    System.out.println(currentOrder);
                    System.out.println("Thank you for your order!");
                    currentOrder = new Order();
                    break;  
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}