/*
 *
 * Write the Buses program inside the main method
 * according to the assignment description.
 * 
 * To compile:
 *        javac Buses.java
 * To execute:
 *        java Buses 7302
 * 
 * DO NOT change the class name
 * DO NOT use System.exit()
 * DO NOT change add import statements
 * DO NOT add project statement
 * 
 */

public class Buses {
    public static void main(String[] args) {

        int num = Integer.parseInt(args[0]);
        int sum = 0;
        int digit = 0;
        if (num < 0){
            System.out.println("ERROR");
        }
        else {
            for ( int i = 0; i < 4; i++){
                digit = num % 10;
                sum += digit;
                num = num / 10;
            }
          if ((sum%2) == 0){
              System.out.println("LX");
          }
          else{
              System.out.println("H");
          }
        }



    }
}
