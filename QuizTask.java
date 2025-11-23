// QuizTask.java
public class QuizTask extends Task {
    public QuizTask(String title, int diff, int hours, String deadline){
        super(title, diff, hours, deadline);
    }

    @Override
    public int calculatePriority() {
        return difficulty + 1;
    }

    @Override
    public String getType() {
        return "Quiz";
    }
}
