public class BigO{
  public static void main(String[] args){
    // Big(O) of reversing an array : O(n/2)
    int sum = 10;
    int [] arr = {1,2,3,5,6,7,8,9};
    for(int i = 0; i < arr.length; i++){
      for(int j = i+1; j < arr.length; j++){
        if(arr[i] + arr[j] == sum){
          System.out.println(arr[i] + " " + arr[j]);
        }
      }
    }

    int target = 6;
    for(int i = 0; i < arr.length; i++){
      if(arr[i] == 6 ){
        System.out.println(target +" is located in arr[" + i +"]");
      }
    }

    //O(n^2)
  }
}