import java.util.List;

public interface SchedulerStrategy {
    StudyPlan schedule(List<Task> tasks);
}
