public class Activity{
  private String sport;
  private int stepsEquivalent;

  public Activity(String sport, int stepsEquivalent){
    this.sport = sport;
    this.stepsEquivalent = stepsEquivalent;
  }
  
  public String toString(){
    return this.sport +" " + this.stepsEquivalent + " steps";
  }

  public String getSport(){
    return this.sport;
  }

  public int getSteps() {
    return this.stepsEquivalent;
  }
