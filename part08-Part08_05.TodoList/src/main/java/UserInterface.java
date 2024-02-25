
import java.util.Scanner;

public class UserInterface {

    private TodoList todoList;
    private Scanner scanner;

    public UserInterface(TodoList todoList, Scanner scanner) {
        this.todoList = todoList;
        this.scanner = scanner;
    }

    public void start() {

        while (true) {
            System.out.println("Command: ");
            String scan = scanner.nextLine();
            switch (scan) {
                case "add":
                    System.out.println("To add:");
                    scan = scanner.nextLine();
                    todoList.add(scan);
                    break;
                case "list":
                    todoList.print();
                    break;
                case "remove":
                    System.out.println("Which one is removed?");
                    int input = Integer.valueOf(scanner.nextLine());
                    todoList.remove(input);
                    break;
                case "stop":
                    return;
            }
        }
    }

}// class

