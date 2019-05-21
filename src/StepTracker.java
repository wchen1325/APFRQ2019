public class StepTracker {
    private int activeDays;
    private int days;
    private int totalSteps;
    private int minSteps;

    public StepTracker(int minSteps){
        this.minSteps = minSteps;
        activeDays = 0;
        totalSteps = 0;
        days=0;
    }

    public void addDailySteps (int steps){
        totalSteps+=steps;
        days++;
        if(steps>=minSteps){
            activeDays++;
        }
    }

    public int activeDays(){
        return activeDays;
    }

    public double averageSteps(){
        return ((double)totalSteps)/days;
    }
}
