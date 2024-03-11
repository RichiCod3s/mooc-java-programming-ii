
public class Main {

    public static void main(String[] args) {
           // Creating some items
        Book book1 = new Book("Author 1", "Book 1", 0.5);
        CD cd1 = new CD("Artist 1", "CD 1", 2000);
        Book book2 = new Book("Author 2", "Book 2", 0.7);

        // Creating boxes
        Box box1 = new Box(2.0); // Box with a capacity of 2 kg
        Box box2 = new Box(1.0); // Box with a capacity of 1 kg
        Box box3 = new Box(5.0); // Box with a capacity of 5 kg

        // Adding items to boxes
        box1.add(book1);
        box1.add(cd1);
        box2.add(book2);

        // Trying to add a box to itself
         //box1.add(box1); // Uncommenting this line will cause an infinite loop

        // Adding smaller boxes to a larger box
        box3.add(box1);
        box3.add(box2);

        System.out.println(box1); // Output: Box: 2 items, total weight 0.6 kg
        System.out.println(box2); // Output: Box: 1 items, total weight 0.7 kg
        System.out.println(box3); // Output: Box: 2 items, total weight 1.3 kg
    }
    

}
