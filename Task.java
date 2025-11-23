// Task.java (abstract class)
public abstract class Task {
    protected String title;
    protected int difficulty;
    protected int estimatedHours;
    protected String deadline;

    public Task(String title, int difficulty, int hours, String deadline){
        this.title = title;
        this.difficulty = difficulty;
        this.estimatedHours = hours;
        this.deadline = deadline;
    }

    public abstract int calculatePriority();
    public abstract String getType();

    public void display(){
        System.out.println(getType() + ": " + title + ", Difficulty: " + difficulty + ", Hours: " + estimatedHours + ", Deadline: " + deadline);
    }
}
