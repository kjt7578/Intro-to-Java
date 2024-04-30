import java.util.ArrayList;
/*
Big-O complexity chart
O(log n), O(1) < O(n) < O(n log n) < O(n^2) < O(2^n) < O(n1)


Sort        Best      Average      Worst
Insertion   O(n)      O(n^2)       O(n^2)
Selection   O(n^2)    O(n^2)       O(n^2)
Merge       O(nlogn)  O(nlogn)     O(nlogn)

            Search   
Linear      O(N)
Binary     O(log N)
ㄴ mid = low + (hi - low) / 2;
if(mid > target) hi =mid;
if(mid < target) low = mid + 1;

*/


public class Search{
  public static void main(String[] args){
    int n = StdIn.readInt();
    ArrayList <String> words = new ArrayList <String>();
    String wordTBF = StdIn.readString();
    StdOut.println("Word to find: " + wordTBF);
    for(int i = 0; i < n; i++){
      words.add(StdIn.readString());
      StdOut.println(words.get(i));
    }

    insertion_sort(words);                // N^2
    StdOut.println("intertion sotred" + words);
    linear_search(wordTBF, words);        // N
    selection_sort(words);                // N^2
    StdOut.println("selection sotred" + words);
    binary_search(wordTBF, words, 0, n);  //log N
  }

  public static void selection_sort(ArrayList<String> words){
    for(int i = 0; i < words.size(); i++){
      int min = i;
      for(int j = i+1; j < words.size(); j++){
        if (words.get(j).compareTo(words.get(min)) < 0) {
          min = j;
        }
      }
      String temp = words.get(i);
      words.set(i, words.get(min));
      words.set(min, temp);
    }
  }
  
  public static void insertion_sort(ArrayList<String> words){
    for(int i = 0; i < words.size(); i++){
      for(int j = i; j > 0; j--){
        if(words.get(j-1).compareTo(words.get(j)) > 0){
          String temp = words.get(j-1);
          words.set(j-1, words.get(j));
          words.set(j, temp);
        }
        else
          break;
      }
    }
  }

  //txt file to read from Binaray search is should be sorted 
  public static int binary_search(String n, ArrayList<String> words, int lo, int hi){
    if (lo >= hi) {
        System.out.println(n + " is not found");
        return -1;  // Indicates that the search failed to find the key
    }
    
    int mid = lo + (hi - lo) / 2;  // Avoids potential overflow
    int cmp = words.get(mid).compareTo(n);
    if (cmp == 0) {
        System.out.println(n + " is located at index " + mid);
        return mid;  // Returns the index where the element is found
    } else if (cmp > 0) {
        return binary_search(n, words, lo, mid);  // Search in the left half
    } else {
        return binary_search(n, words, mid + 1, hi);  // Search in the right half
    }
  }
      
  
  public static int linear_search(String n, ArrayList<String> words){
    for(int i = 0; i < words.size(); i++){
      if(words.get(i).equals(n)){
        System.out.println( n + " is located in " + i);
        return i;
      }
    }
    System.out.println(n + " does not exsists");
    return -1;
  }

  //
}
