import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String string = scanner.nextLine();

        // Convert to lowercase and remove spaces for accurate comparison (optional)
        string = string.toLowerCase().replaceAll("\\s+", "");

        boolean isPalindrome = true;
        int start = 0;
        int end = string.length() - 1;

        while (start < end) {
            if (string.charAt(start) != string.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        if (isPalindrome) {
            System.out.println(" The string is a palindrome.❤️");
        } else {
            System.out.println(" The string is not a palindrome.😒");
        }
    }
}