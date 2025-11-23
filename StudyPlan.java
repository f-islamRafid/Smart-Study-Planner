// StudyPlan.java
import java.util.ArrayList;
import java.util.List;

public class StudyPlan {
    private List<ScheduledItem> scheduledItems;

    public StudyPlan(){
        scheduledItems = new ArrayList<>();
    }

    public void addScheduledItem(ScheduledItem item){
        scheduledItems.add(item);
    }

    public void displayPlan(){
        System.out.println("\n--- Study Plan ---");
        for(ScheduledItem item : scheduledItems){
            System.out.println(item.getTask().getType() + ": " + item.getTask().title + ", Priority: " + item.getTask().calculatePriority());
        }
    }
}
