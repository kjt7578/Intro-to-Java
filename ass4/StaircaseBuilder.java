/*
 * Write your program inside the main method to build
 * a staicase in a 2D array of characters according
 * to the assignment description
 *
 * To compile:
 *        javac StaircaseBuilder.java
 * 
 * DO NOT change the class name
 * DO NOT use System.exit()
 * DO NOT change add import statements
 * DO NOT add project statement
 * 
 */
public class StaircaseBuilder {
    
    public static void main(String[] args) {

      int d = Integer.parseInt(args[0]);
      int num = Integer.parseInt(args[1]);

      char block [][];                    // 3 6
      block = new char[d][d];             // 2 2 (0~2) (0~2)
      for(int i = 0; i < d; i++){         //Starting from row 0

          for(int j = 0; j < d; j++){
            block[j][i] = ' ';
          }

        
        for(int j = d-1; j >= d-i-1; j--){      //Starting from end of col
          if(num > 0){
          block[j][i] = 'X';
          num--;
          }
         }
      }


      
      for(int i = 0; i < d; i++){        // Print
        for(int j = 0; j < d; j++){
          System.out.print(block[i][j]);
        }
        System.out.println("");
      }


      System.out.println("Bricks remaining: " + num);
    }
      
  }
