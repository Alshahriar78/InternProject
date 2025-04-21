import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, String> phoneBook = new HashMap<>();


        phoneBook.put("Sourov", "01755684137");
        phoneBook.put("Shaon", "01771572108");
        phoneBook.put("Bubly", "01786491322");


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name to search: ");
        String name = scanner.nextLine();


        if (phoneBook.containsKey(name)) {
            System.out.println(name + "'s Phone Number: " + phoneBook.get(name));
        } else {
            System.out.println("Contact not found for: " + name);
        }

        scanner.close();
    }
}