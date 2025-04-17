import java.util.Scanner;

class Person {
    String name;

    void displayDetails() {
        System.out.println("Name: " + name);
    }
}

class Student extends Person {
    int rollNumber;

    @Override
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student s = new Student();
        s.name = scanner.nextLine();
        s.rollNumber = scanner.nextInt();

        s.displayDetails();

        scanner.close();
    }
}

