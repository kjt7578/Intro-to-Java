/**
 * An International Standard Book Number, or ISBN, is a number that uniquely
 * identifies a book.
 * 
 * Publishers can buy or recieve ISBNs from the International ISBN Agency.
 * 
 * There are two types of ISBNs -- ISBN-10 and ISBN-13, which are 10- and
 * 13-digits long, respectively.
 * 
 * ISBN-10 has a pattern, where the last digit can be found using the first 9.
 * ISBN-10 can also be used to calculate its ISBN-13 equivalent (and vice
 * versa).
 * 
 * Refer to the assignment description on the website for steps on how
 * complete these two functions
 * 
 * @author Aastha Gandhi
 */

public class ISBN {
    /**
     * Calculate the 10th digit of an ISBN number, using the first 9 digits
     * provided.
     * Refer to the assignment description on the website for steps on how to 
     * implement this function.
     * 
     * @param isbn An integer array of size 10, where the first 9 numbers are the
     *             correct ISBN number.
     * @return Return an integer array with complete 10-digit ISBN number.
     */
    public static void calculateISBN10(int[] isbn) {
      int sumOfProducts = (10*isbn[0])+(9*isbn[1])+(8*isbn[2])+(7*isbn[3])+(6*isbn[4])+(5*isbn[5])+(4*isbn[6])+(3*isbn[7])+(2*isbn[8]);
      int rem = sumOfProducts % 11;
      int diff = 11 - rem;
      isbn[9] =  diff % 11;
    }

    /**
     * Calculate the 13-digit ISBN number from the 10-digit ISBN number provided.
     * Refer to the assignment description on the website for steps on how to 
     * implement this function.
     * 
     * @param shortIsbn An integer array of a complete 10-digit ISBN number.
     * @return Return an integer array with complete 13-digit ISBN number.
     */
    public static int[] calculateISBN13(int[] shortIsbn) {
      int [ ] isbn_13 = new int [13];
      isbn_13[0] = 9;
      isbn_13[1] = 7;
      isbn_13[2] = 8;
      int ct = 0;
      for ( int i= 3; i < isbn_13.length; i++){
        isbn_13[i] = shortIsbn[ct];
        ct++;
      }
      int sumOfProducts = (1*isbn_13[0] + 3*isbn_13[1] + 1*isbn_13[2] + 3*isbn_13[3] + 1*isbn_13[4] + 3*isbn_13[5] + 1*isbn_13[6] + 3*isbn_13[7] + 1*isbn_13[8] + 3*isbn_13[9] + 1*isbn_13[10] + 3*isbn_13[11]);
      int rem = sumOfProducts % 10;
      if (rem == 0){
        isbn_13[12] = 0;
      }
      else{
        isbn_13[12] = 10 - rem;
      }

      return isbn_13;
    }


    /*
     * This is the main method, which loads up the file for testing and runs allTests.txt or any other given txt file.
     * The code outputs and displays a list of book names followed by their unique ISBN-10 and ISBN-13 code, simulating
     * a database of a library.
     */
    public static void main(String[] args) {
        
        // DO NOT EDIT THIS CODE
        
        int[] isbn = new int[10];
        int[] isbn_13 = new int[13];

        int numOfBooks = StdIn.readInt();     // reads an integer from the file

        for ( int i = 0; i < numOfBooks; i++ ) {

            StdIn.readLine();                 // reads an entire line from the file (the remaining of the line)
            String name = StdIn.readLine();   // reads an entire line from the file (the book's name)
            System.out.println(name);

            // Reads all the 9 integers
            for ( int j = 0; j < 9; j++ ) {
                isbn[j] = StdIn.readInt();    // reads an integer from the file
            }

            calculateISBN10(isbn);            // calls calculateISBN10
            System.out.print("ISBN-10 - ");

            // Enhanced for-loop to display the array that has been updated by calculateISBN10
            for ( int n : isbn ) {
                if ( n == 10 ) {
                    System.out.print("X");
                } else
                    System.out.print(n);
            }
            System.out.println();

            isbn_13 = calculateISBN13(isbn);   // calls calculateISBN13
            System.out.print("ISBN-13 - ");

            // Enhanced for-loop to display the array that has been updated by calculateISBN13
            for ( int n : isbn_13 ) {
                if ( n == 10 ) {
                    System.out.print("0");
                } else {
                    System.out.print(n);
                }
            }
            System.out.println();
        }
    }
}
