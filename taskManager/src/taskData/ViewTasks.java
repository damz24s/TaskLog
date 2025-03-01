package taskData;

import model.Task; 
import java.util.Scanner;

public class ViewTasks {
    public void viewAllTasks() {
        if (DataManager.allTasks.isEmpty()) {
            System.out.println("There are no tasks right now!");
            return;
        }

        for (Task task : DataManager.allTasks) {
            System.out.println("ID: " + task.getId() + 
                               " | Name: " + task.getTaskName() + 
                               " | Priority Level: " + task.getPriorityLvl() + 
                               " | Status: " + task.getStatus());
        }
    }

    public void viewIndividualTask() {
    	if (DataManager.allTasks.isEmpty()) {
            System.out.println("There are no tasks right now!");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID of the task you want to view:");

        if (!sc.hasNextInt()) {
            System.out.println("Input must be an integer!");
            sc.nextLine();
            return;
        }

        int enterTaskId = sc.nextInt();
        sc.nextLine();

        for (Task task : DataManager.allTasks) {
            if (enterTaskId == task.getId()) {
                System.out.println("ID: " + task.getId() + 
                                   " | Name: " + task.getTaskName() + 
                                   " | Priority Level: " + task.getPriorityLvl() + 
                                   " | Status: " + task.getStatus());
                return;
            }
        }
        System.out.println("This Task ID does not exist.");
    }
}
