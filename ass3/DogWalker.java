/*
 *  
 * Write the DogWalker program inside the main method
 * according to the assignment description.
 * 
 * To compile:
 *        javac DogWalker.java
 * To execute:
 *        java DogWalker 5
 * 
 * DO NOT change the class name
 * DO NOT use System.exit()
 * DO NOT change add import statements
 * DO NOT add project statement
 * 
 *
 */
public class DogWalker {

    public static void main(String[] args) {
      int step = Integer.parseInt(args[0]);
      if (step < 0){
        System.out.println("ERROR");
      }
      else{
        int x = 0;
        int y = 0;

        for (int i = 0; i < step; i++){
          int x_or_y = ((int)(Math.random() * 2));  // 0:x, 1:y
          int p_or_n = ((int)(Math.random() * 2));  // 0:positive, 1:negative
          if (x_or_y == 0){
            if (p_or_n == 0){
              x++;
            }
            else{
              x--;
            }
          }
          else {
            if (p_or_n == 0){
              y++;
            }
            else{
              y--;
            }
          }
          System.out.println("(" + x + "," + y + ")");
          }
        System.out.println("Squared distance =");
        System.out.println((double)(x*x + y*y));
        
      }	   
    }
}
