// ProjectTask.java
public class ProjectTask extends Task {
    public ProjectTask(String title, int diff, int hours, String deadline){
        super(title, diff, hours, deadline);
    }

    @Override
    public int calculatePriority() {
        return difficulty * 3 + estimatedHours;
    }

    @Override
    public String getType() {
        return "Project";
    }
}
