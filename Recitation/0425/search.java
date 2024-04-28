public class search{
  
  public static int sequentialSearch(int [] arr, int x){
    for(int i = 0; i < arr.length; i++){
      if(arr[i] == x)
        return i;
    }
  return -1;
  }

  public static int binarySearch(int [] arr, int x){
    int hi = arr.legnth;
    int low = 0;
    int mid = low + (hi - low) / 2;
    
    boolean found = false;
    while(!found){
      mid = low +(hi - low) / 2;
      if(x == arr[mid]){
        found = true;
      }
      else if ( x < arr[mid]){
        hi = mid;
      }
      else if ( x > arr[mid]){
        low = mid + 1;
      }
      else{
        mid = -1;
      }
    }
    return mid;
  }

  //insertion sort
  15 2 8 1 17 5
  2 15 8 1 17 5
  2 8 15 1 17 5
  1 2 8 15 17 5
  1 2 5 8 15 17
  
  public static void main(String[] args){
    int [] arr = {1,3,5,6,12,19,20,25,28,33};
    int x = 8;
    int loc_s = sequentialSearch(arr, x);
    int loc_b = binarySearch(arr,x);
    System.out.println("loc_s : " + loc_s + "\nloc_b : " + loc_b);
  }
}