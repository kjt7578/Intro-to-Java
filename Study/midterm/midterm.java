public class midterm{

  //F23 Function Q2
  public static double averageOf3(int a, int b, int c){
  double avg;
  avg = (double)(a + b + c)/3;
  return avg;
  }
  //Q3
  public static double calculateWage(int hours, double rate){
  return((double)hours * rate);
  }

  //S23
  //I/P
  //Q1
  public static void TotalTime (){
  int totalSeconds = 0;
  int numSeconds = 0; 
  StdOut.println("Enter hours, minutes, seconds (each on a separate line) for each event time.");
  for(int i = 0; i < 3; i++) {
  int hours = StdIn.readInt();
  int minutes = StdIn.readInt();
  int seconds = StdIn.readInt();
  numSeconds = calculateSeconds(hours, minutes, seconds);
  totalSeconds += numSeconds;
  StdOut.println();
  }
  StdOut.print("Total time is: ");
  printTime(totalSeconds);
  }

  public static int calculateSeconds(int h, int m, int s) {
  return (h * 3600 + m * 60 + s);
  }

  public static void printTime(int secs) {
    int hours=0;
    int minutes=0;    
    while(secs >= 3600){
        secs = secs - 3600;
            hours++;
      }
    while(secs >= 60){
      secs = secs - 60;
        minutes++;
    }
    int seconds = secs;
  StdOut.println(hours + " hours, " + minutes + " minutes, " + seconds + " seconds");
  }



  //=====================================
  public static void main(String args[]){
    //F23
    //Section 2: Arrays
    //Q1
   int  [] arr = new int [10];
    for (int i = 0; i < arr.length; i++){
      arr[i] = 2 + 3 * i;
      System.out.println(arr[i]);
    }

    //Q3
    //we assume array is given. If not,
    //int [ ] [ ] arr2 = new int [3] [3];
    int[][] arr2 = {{1,2,3},{4,0,6},{7,8,9}};
    int min = arr2[0][0];
    for ( int i = 0; i < arr2.length; i++){
      for ( int j = 0; j < arr2[i].length; j++){
        if( arr2[i][j] < min){
          min = arr2[i][j];
        } 	
      }
    }
    System.out.print("Minimum numer in array is: ");
    System.out.println(min);

    //I/O
    //Q1
    int a = 5; //Integer.parseInt(args[0]);
    int b = 6; //Integer.parseInt(args[1]);
    System.out.print("Smallest is: ");
    if(a < b){
    System.out.println(a);}
    else{
    System.out.println(b);}

    //Function
    //Q2
    System.out.println(averageOf3(2,3,5));
    //Q3
    System.out.println(calculateWage(5,13.50));

    //S23
    //Array
    //Q4
    int [ ] arr3 = {1,2,3,4,5,6,7,8,9,10};
    int sum = 0;
    for( int i = 0; i < arr3.length; i++){
      if ( arr3[i] % 2 == 0){
        sum += arr3[i];}
    }
    System.out.println("Sum of even number: " + sum);
    //Q5
    int [ ] [ ] arr4 = {{1,2,3},{-1,-2,-3}};
    for( int i = 0; i < arr4.length; i++){
      for (int j = 0; j < arr4[i].length; j++){
        if ( arr4[i][j] < 0 ) {
          arr4[i][j] = arr4[i][j] * (-1);}
        System.out.print(arr4[i][j] + ", ");
      }
    }

    //S23
    //I/O Q1
    TotalTime();

    //F22
    //Q3.5

    int num = StdIn.readInt();
    
    
  }
}

