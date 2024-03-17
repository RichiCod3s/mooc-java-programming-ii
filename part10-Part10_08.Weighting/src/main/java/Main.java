public class Main {
    public static void main(String[] args) {
        // Create items
        Item item1 = new Item("Book", 2);
        Item item2 = new Item("Laptop", 5);
        Item item3 = new Item("Clothes", 3);

        // Create a suitcase
        Suitcase suitcase1 = new Suitcase(10);
        suitcase1.addItem(item1);
        suitcase1.addItem(item2);

        // Create another suitcase
        Suitcase suitcase2 = new Suitcase(8);
        suitcase2.addItem(item3);

        // Create a hold
        Hold hold = new Hold(15);
        hold.addSuitcase(suitcase1);
        hold.addSuitcase(suitcase2);

        // Print the hold information
        System.out.println(hold);

        // Print items in each suitcase
        hold.printItems();

        // Print the heaviest item in each suitcase
        System.out.println("Heaviest item in each suitcase:");
        System.out.println("Suitcase 1: " + suitcase1.heaviestItem());
        System.out.println("Suitcase 2: " + suitcase2.heaviestItem());
    }
}
