// PriorityBasedStrategy.java
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PriorityBasedStrategy implements SchedulerStrategy {
    @Override
    public StudyPlan schedule(List<Task> tasks) {
        Collections.sort(tasks, Comparator.comparingInt(Task::calculatePriority).reversed());
        StudyPlan plan = new StudyPlan();
        for(Task t : tasks){
            plan.addScheduledItem(new ScheduledItem(t));
        }
        return plan;
    }
}
