import java.util.ArrayList;

public class ActivityTracker{
  private int myNumActivities;
  private int myNumSteps;
  private int stepGoal;
  private ArrayList<Activity> activities;

  public ActivityTracker(){
    myNumActivities = 0;
    myNumSteps = 0;
    stepGoal = 10000;
    activities = createActivityDataBase();
  }

  public void recordActivity(String s, int time){
    int pos = search(s);
  
  }

  public int getNumActivities(){return myNumActivities;}
  public int getNumSteps(){return myNumSteps;}
  public int getStepGoal(){return stepGoal;}

  private int search(String s){
    for(int i = 0; i < activities.size();i++){
      if(activities(i).equals(s)){
        return i;
      }      
    }
    return -1;
  }

  public void createActivityDataBase(){
    
  }

  public String toSAtring(){
    
  }

  public static void main(String[] args){
    ActivityTracker a1 = new ActivityTracker();
    
  }
}