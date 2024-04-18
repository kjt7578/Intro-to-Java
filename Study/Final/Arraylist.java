import java.util.ArrayList;

public class Arraylist{
  
  public static void main(String[] args){
    print_List();
    call_numWordsOfLength();
    call_removeWordsOfLength();



  }
  
  public static void call_removeWordsOfLength(){
    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String> newList = new ArrayList<>();
    list.add("cat");
    list.add("dog");
    list.add("mouse");
    list.add("rat");
    list.add("frog");
    newList.addAll(list);
    removeWordsOfLength(list, 3);
    System.out.println(list);
    list.clear();
    list.addAll(newList);
    removeWordsOfLength(list, 4);
    System.out.println(list);
    list.clear();
    list.addAll(newList);
    removeWordsOfLength(list, 2);
    System.out.println(list);

  }
  
  public static void removeWordsOfLength(ArrayList<String> list, int len){

    for(int i = 0; i < list.size(); i++){
      if(list.get(i).length() == len)
        list.remove(i);
    }

    }

  public static void call_numWordsOfLength(){
    ArrayList<String> list = new ArrayList<String>();
    list.add("cat");
    list.add("dog");
    list.add("mouse");
    list.add("rat");
    list.add("frog");
    System.out.println("numWordsOfLength(list,3): " + numWordsOfLength(list,3));
    System.out.println("numWordsOfLength(list,4): " + numWordsOfLength(list,4));
    System.out.println("numWordsOfLength(list,1): " + numWordsOfLength(list,1));
  }

  public static int numWordsOfLength(ArrayList<String> list, int len){
    int ct = 0;
    for(int i = 0; i < list.size(); i++){
      if(list.get(i).length() == len)
        ct++;
    }

    return ct;
  }

  public static void print_List(){
    ArrayList<String> list = new ArrayList<String>();
    list.add("amy");
    list.add("bob");
    list.add("carlost");
    for(int i = 0; i < list.size(); i++){
      System.out.print(list.get(i) + " -> ");
    }
    System.out.println();

    list.add(1,"betty");
    for(int i = 0; i < list.size(); i++){
      System.out.print(list.get(i) + " -> ");
    }
    System.out.println();

    list.remove(2);
    for(int i = 0; i < list.size(); i++){
      System.out.print(list.get(i) + " -> ");
    }
    System.out.println();
  }

  
}