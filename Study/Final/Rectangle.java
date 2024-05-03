public class Rectangle{
  private int length;
  private int width;

  //part a - constructor
  public Rec(int length, int width){
    this.length = length;
    this.width = width;
  }

  //part b - getLength
  public int getLength(){
    return length;
  }

  public int getWidth(){
    return width;
  }

  //part c - getArea
  public int getArea(){
    return length * width;
  }

  //part d - isSquare
  public Boolean isSquare(){
    if(length == witdth)   
      return true;
    else
      return false;
  }

  //part e - equals
  public Boolean equals(Rec rec){
    if(length == rec.length && width == rec.width)
      return true;
    else
      return false;
  }

  public static void main (String[] args){
    //part f - using the Rectangle Data Type)
    Rec r1 = new Rec(5, 7);
    Rec r2 = new Rec(6, 4);
    int Area_r1 = r1.getArea;
    Boolean is_equal = r1.equals(r2);
  }
}