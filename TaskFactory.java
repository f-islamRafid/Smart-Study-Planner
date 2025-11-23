// TaskFactory.java
public class TaskFactory {
    public static Task createTask(String type, String title, int diff, int hours, String deadline){
        switch(type.toLowerCase()){
            case "assignment": return new AssignmentTask(title, diff, hours, deadline);
            case "exam": return new ExamTask(title, diff, hours, deadline);
            case "quiz": return new QuizTask(title, diff, hours, deadline);
            case "project": return new ProjectTask(title, diff, hours, deadline);
            default: return null;
        }
    }
}
