/*
 * Write your program inside the main method to find the order
 * which the bus the student needs to take will arrive
 * according to the assignemnt description. 
 *
 * To compile:
 *        javac BusStop.java
 * 
 * DO NOT change the class name
 * DO NOT use System.exit()
 * DO NOT change add import statements
 * DO NOT add project statement
 * 
 */
public class BusStop {

    public static void main(String[] args) {

      int n = args.length - 1;
      char bus[];
      bus = new char [n];

      for (int i = 0; i < n; i++){
      bus[i] = args[i].charAt(0); 
      }
      char loc = args[n].charAt(0);

      int count = 0;
      
      for(int i = 0; i < n; i++){
        if( loc == bus[i] ){      
          count++;
          System.out.println(count);
          break;
        }
        else{
          count++;
          if(count == n)
            System.out.println("-1");
        }
      }


      
    }
}
