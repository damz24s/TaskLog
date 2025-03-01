package taskData;

import java.util.Scanner;
import model.Task;

public class RemoveTask {
    private ViewTasks view = new ViewTasks();
    private Scanner sc;

    public RemoveTask(Scanner sc) {
        this.sc = sc;
    }

    public void removeATask() {
    	view.viewAllTasks();
    	if(DataManager.allTasks.isEmpty()) {
    		return;
    	} 
        System.out.println("Enter the ID of the Task you want to remove: ");
        
        if (!sc.hasNextInt()) {
            System.out.println("Input must be an integer!");
            sc.nextLine();
            return;
        }

        int enterTaskId = sc.nextInt();
        sc.nextLine();

        boolean found = false;
        for (Task task : DataManager.allTasks) {
            if (enterTaskId == task.getId()) {
                System.out.println("Are you sure you want to delete " + "'" + task.getTaskName() + "'" + "? (y/n)");
                String choice = sc.nextLine().trim().toLowerCase();

                if (choice.equals("y")) {
                    DataManager.allTasks.remove(task);
                    System.out.println("'" + task.getTaskName() + "'" + " has been removed!");
                    
                    
                } else {
                    System.out.println("Request cancelled\n");
                }
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Task does not exist!\n");
        }
    }
    
    
    public void removeAllTasks() {
    	if(DataManager.allTasks.isEmpty()) {
    		System.out.println("There are no Tasks!");
    		return;
    	}
    	
        System.out.println("\nAre you sure you want to remove ALL tasks? (y/n): ");
        if (!sc.hasNextLine()) {
            System.out.println("Input must be an String!");
            sc.nextLine();
            return;
        }
        
        String choice = sc.nextLine().trim().toLowerCase();
        
        if (choice.equals("y")) {
    		DataManager.allTasks.removeAll(DataManager.allTasks);
    		
    		if(DataManager.allTasks.isEmpty()) {
        		System.out.println("\nAll Tasks have been deleted!");
        		return;
    		}
    		
        } else {
            System.out.println("Request cancelled\n");
        }
    }
}
