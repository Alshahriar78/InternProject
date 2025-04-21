public class Main {
    public static void main(String[] args) {

        int n = 5; // number of rows

//        for (int i = n; i >= 1; i--) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
        for (int i =1; i <= n; i++) {
            for (int j =n; j >= i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }


        // pyramid



        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // Print stars
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}