// ExamTask.java
public class ExamTask extends Task {
    public ExamTask(String title, int diff, int hours, String deadline){
        super(title, diff, hours, deadline);
    }

    @Override
    public int calculatePriority() {
        return difficulty * 2 + estimatedHours;
    }

    @Override
    public String getType() {
        return "Exam";
    }
}
