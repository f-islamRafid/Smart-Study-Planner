import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudyPlannerEngine {

    private static StudyPlannerEngine instance = null;

    private final List<Task> tasks;           // store all tasks
    private SchedulerStrategy strategy;       // current scheduling strategy

    // Private constructor (Singleton)
    private StudyPlannerEngine() {
        tasks = new ArrayList<>();
    }

    // Thread-safe singleton accessor (Double-checked locking)
    public static synchronized StudyPlannerEngine getInstance() {
        if (instance == null) {
            instance = new StudyPlannerEngine();
        }
        return instance;
    }

    // Add a new task (prevents duplicates)
    public void addTask(Task task) {
        if (task == null) {
            System.out.println("Cannot add null task.");
            return;
        }

        if (tasks.contains(task)) {
            System.out.println("Task already exists: " + task.getTitle());
            return;
        }

        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    // Remove a task
    public boolean removeTask(Task task) {
        if (task == null) return false;

        boolean removed = tasks.remove(task);
        if (removed) {
            System.out.println("Task removed: " + task.getTitle());
        } else {
            System.out.println("Task not found.");
        }
        return removed;
    }

    // Choose scheduling strategy
    public void setStrategy(SchedulerStrategy strategy) {
        if (strategy == null) {
            System.out.println("Strategy cannot be null.");
            return;
        }
        this.strategy = strategy;
        System.out.println("Scheduling strategy updated.");
    }

    // Generate a study plan
    public StudyPlan generateStudyPlan() {
        if (strategy == null) {
            System.out.println("No scheduling strategy set!");
            return new StudyPlan();  // return empty plan
        }

        if (tasks.isEmpty()) {
            System.out.println("No tasks available to schedule.");
            return new StudyPlan();
        }

        return strategy.schedule(tasks);
    }

    // Show all tasks with clean formatting
    public void showTasks() {
        System.out.println("\n=== Current Tasks ===");
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        for (Task t : tasks) {
            t.display();
            System.out.println("---------------------------");
        }
    }

    public List<Task> getAllTasks() {
        return Collections.unmodifiableList(tasks);
    }
}
