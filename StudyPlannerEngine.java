// StudyPlannerEngine.java
import java.util.ArrayList;
import java.util.List;

public class StudyPlannerEngine {
    private static StudyPlannerEngine instance = null;
    private List<Task> tasks;
    private SchedulerStrategy strategy;

    private StudyPlannerEngine(){
        tasks = new ArrayList<>();
    }

    public static StudyPlannerEngine getInstance(){
        if(instance == null){
            instance = new StudyPlannerEngine();
        }
        return instance;
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public void setStrategy(SchedulerStrategy strategy){
        this.strategy = strategy;
    }

    public StudyPlan generateStudyPlan(){
        if(strategy == null){
            System.out.println("No scheduling strategy set!");
            return new StudyPlan();
        }
        return strategy.schedule(tasks);
    }

    public void showTasks(){
        System.out.println("\nCurrent Tasks:");
        for(Task t : tasks){
            t.display();
        }
    }
}
