// AssignmentTask.java
public class AssignmentTask extends Task {
    public AssignmentTask(String title, int diff, int hours, String deadline){
        super(title, diff, hours, deadline);
    }

    @Override
    public int calculatePriority() {
        return difficulty + estimatedHours;
    }

    @Override
    public String getType() {
        return "Assignment";
    }
}
