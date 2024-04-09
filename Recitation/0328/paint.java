public class paint{

  public static int maxHouses(int[] houseSizes, int gallonsOfPaint, int houseNumber){
    //this code assume array is assending order
    if(houseSizes[houseNumber] <= gallonsOfPaint){
      int gallonsRemaining = gallonsOfPaint - houseSizes[houseNumber];
      return 1 + maxHouses(houseSizes, gallonsRemaining, houseNumber++);
    }
    /* if (gallonsOfPaint < houseSizes.length - houseSizes[houseNumber]){
      return houseSizes.length - houseNumber;
    }
    else{
     return maxHouses(houseSizes, (gallonsOfPaint - houseSizes[houseSizes.length - houseNumber]), houseNumber - 1);
    }
    */
  }
  
  public static void main(String[] args){
    int [] arr = {10,15,20,25};
    System.out.println(maxHouses(arr,35,4));
  }
}