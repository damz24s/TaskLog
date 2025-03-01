package taskData;

import java.util.InputMismatchException; 
import java.util.Scanner;

import model.Task;

public class AddTask {
    private DataManager dm = new DataManager();
    private ViewTasks view = new ViewTasks();
    private Scanner sc;

    public AddTask(Scanner sc) {
        this.sc = sc;
    }

    public void createNewTask() {
        while (true) {
            try {
                System.out.println("Enter Task Name: ");
                String tName = sc.nextLine().trim();

                System.out.println("Enter Priority Level (Low, Medium, High): ");
                String pLvl = sc.nextLine().trim();

                if (tName.isEmpty() || pLvl.isEmpty()) {
                    System.out.println("Task name or Priority level cannot be blank\n");
                    continue;
                }

                String status = "pending";
                dm.maxId++;
                Task task = new Task(dm.maxId, tName, pLvl, status);
                DataManager.allTasks.add(task);
                System.out.println("'" + task.getTaskName() + "'" + " has been added.");
                break;

            } catch (InputMismatchException e) {
                System.out.println("Input must be a valid string!\n");
                sc.nextLine();
            }
        }
    }

    public void markAsComplete() {
        view.viewAllTasks();
        if(DataManager.allTasks.isEmpty()) {
    		return;
    	} 
        System.out.println("Enter ID of task you want to mark as complete:");

        if (!sc.hasNextInt()) {
            System.out.println("Input must be a number!\n");
            sc.nextLine();
            return;
        }

        int enterTaskId = sc.nextInt();
        sc.nextLine();

        boolean found = false;
        for (Task task : DataManager.allTasks) {
            if (enterTaskId == task.getId()) {
                task.setStatus("completed");
                System.out.println("'" + task.getTaskName() + "'" + " has been marked as completed!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Task does not exist!\n");
        }
    }
}
