public class Snack{
  private String name;
  private double price;
  private int amount;
  private String color;

  public Snack(String name, double price, int amount, String color){
    this.name = name;
    this.price = price;
    this.amount = amount;
    this.color = color;
  }

  public String toString(){
    String str = name + " is $" + price + ".\n" + amount + "left and color is " + color;
    return str;
  }

  public int eatten(int eatten){
    int left = this.amount;
    if (left - eatten < 0 ){
      System.out.println("You cannot eat more than " + left);
      return left;
    }
    else{
      left = left - eatten;
      System.out.println("You ate " + eatten + " and " + left + " left");
    return left;
    }
  }
  
  public static void main(String[] args){
  //(String name, double price, int amount, String color)
    Snack SunChip = new Snack("SunChip",3.99,3,"Yellow");
    System.out.println(SunChip.toString());
    System.out.println("How many you want to eat?");
    int eatten = StdIn.readInt();
    SunChip.amount = SunChip.eatten(eatten);
      
    }
}