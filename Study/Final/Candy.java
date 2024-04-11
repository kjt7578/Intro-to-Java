public class Candy{

//instance variables
private String name; //name of the candy
private String color; //color of the candy
private boolean isSour; //true - sour, false - sweet
private double price; //price of the candy
private int pieces;

//constructor(s)
public Candy(String name, String color, boolean isSour, double price, int pieces){
    this.name = name;
    this.color = color;
    this.isSour = isSour;
    this.price=price;
    this.pieces = pieces;
}

//operations/methods using instance variables
public void eatCandy(int piecesEaten){ //6 pieces, eatCandy(8)
    //"Eating <num> pieces..."
    if (pieces >= piecesEaten){
        System.out.println("Eating "+piecesEaten+" pieces...");
        pieces = pieces - piecesEaten;
    }
    else{
        int leftover = piecesEaten - pieces;
        pieces = 0;
        System.out.println("Not enough candy! Need "+leftover+" more.");
    }
}

//getprice()
public double getPrice(){ //candy.getPrice()
    return price;
}

public double calculateTotalPrice(int amountToBuy){ //candy.calculateTotalPrice(6)
    return amountToBuy*price;
}

//based on color, display flavor of candy
public void flavor(){ //candy.flavor()
    System.out.print("The flavor is ");
    if (color.equals("blue"))
        System.out.println("Blue Raspberry");
    if (color.equals("green"))
        System.out.println("Green Apple");
    if (color.equals("red"))
        System.out.println("Cherry");
}

public String toString(){
    //<CandyName> has <pieces> pieces, is <color>, and is <price> dollars. 
    String str = name + " has "+ pieces + " pieces, is "+ color +", and is "+price+" dollars.";
    return str;
}

}