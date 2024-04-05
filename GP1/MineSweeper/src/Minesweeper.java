/*
Author: David Hohn
Class: TCSS 360

If this program is run without file redirection then it will accept user input. This was done for testing purposes.
The output.txt file was created to compare my output with the official output.
 */

import java.util.Scanner;

/*
This class implements a basic version of the minesweeper game. creates the fields and has a helper method to count the mines.
 */
public class Minesweeper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // create the scanner to receive user input
        int fieldNumber = 0; // var to keep track of the number of fields created

        // loop will continue until intentionally broken
        while (true) {
            int n, m;

            // inner loop that ensures that n and m are within valid rangers of 0 to 100
            while (true) {
                n = scanner.nextInt(); //  num of rows
                m = scanner.nextInt(); // num of columns
                scanner.nextLine();

                // checking that user input is within the bounds
                if ((n >= 0 && n <= 100) && (m >= 0 && m <= 100)) {
                    break; // n and m are valid, break out of the loop
                } else {
                    System.out.println("Both 'N' and 'M' must be between 0 and 100. Please try again:");
                }
            }

            // if both inputs are 0 then break
            if (n == 0 && m == 0) {
                break;
            }

            // increment and print the field number
            fieldNumber++;
            System.out.println("Field #" + fieldNumber + ":");

            char[][] field = new char[n][m]; // initialize the field array
            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                field[i] = line.toCharArray(); //  convert to char arr and store
            }

            // displaying the field
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (field[i][j] == '*') {
                        System.out.print("*");
                    } else {
                        int mines = countMines(field, i, j, n, m);
                        System.out.print(mines);
                    }
                }
                System.out.println(); // moving to next line
            }
            System.out.println(); // spacing before next field
        }
        scanner.close();
    }

    /*
    Helper method to return the count of mines for the given cells.
     */
    private static int countMines(char[][] field, int x, int y, int n, int m) {
        int count = 0;
        for (int i = Math.max(0, x - 1); i <= Math.min(n - 1, x + 1); i++) {
            for (int j = Math.max(0, y - 1); j <= Math.min(m - 1, y + 1); j++) {
                if (field[i][j] == '*') {
                    count++;
                }
            }
        }
        return count;
    }
}


