/* Main.java */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudyPlannerEngine planner = StudyPlannerEngine.getInstance();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Smart Study Planner!");

        while(true){
            System.out.println("\n1. Add Task\n2. Generate Study Plan\n3. Show Tasks\n4. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch(choice){
                case 1:
                    System.out.print("Enter Task Type (Assignment/Exam/Quiz/Project): ");
                    String type = sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Difficulty (1-5): ");
                    int diff = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Estimated Hours: ");
                    int hours = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Deadline (yyyy-mm-dd): ");
                    String deadline = sc.nextLine();

                    Task task = TaskFactory.createTask(type, title, diff, hours, deadline);
                    if(task != null){
                        planner.addTask(task);
                        System.out.println("Task added successfully!");
                    } else {
                        System.out.println("Invalid task type!");
                    }
                    break;
                case 2:
                    planner.setStrategy(new PriorityBasedStrategy());
                    StudyPlan plan = planner.generateStudyPlan();
                    plan.displayPlan();
                    break;
                case 3:
                    planner.showTasks();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
