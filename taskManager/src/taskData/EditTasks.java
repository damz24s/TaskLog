package taskData;
import java.util.InputMismatchException;   
import java.util.Scanner;

import model.Task;

public class EditTasks {
	   private ViewTasks view = new ViewTasks();
	   private Scanner sc;
	   
	public EditTasks(Scanner sc) {
		this.sc = sc;
	}
	
	public void editATask() {
        view.viewAllTasks();
        if(DataManager.allTasks.isEmpty()) {
    		return;
    	} 
        
        while(true) {
        	System.out.println("Enter the ID of the task you want to edit:");

            if (!sc.hasNextInt()) {
                System.out.println("Input must be a number!\n");
                sc.nextLine();
                continue;
            }

	        int enterTaskId = sc.nextInt();
	        sc.nextLine(); 
	        
	        boolean found = false;
	        for(Task task: DataManager.allTasks) {
		        if(enterTaskId == task.getId()) {
	                System.out.println("ID: " + task.getId() + 
	                        " | Name: " + task.getTaskName() + 
	                        " | Priority Level: " + task.getPriorityLvl() + 
	                        " | Status: " + task.getStatus());
	                found = true;
	                
		        	System.out.println("\nTo change the task's name enter: 'name'\n"
		        						+ "To change the task's priority level enter: 'priority level'");
		        	try {
		        		
			        	String choice = sc.nextLine().toLowerCase().trim();
			        	
			        	if(choice.equals("name")) {
			        		System.out.println("\nEnter the new task name:");
			        		String newName = sc.nextLine().trim();
			        		task.setTaskName(newName);
			        		System.out.println("Task name has been changed to " + "'" + newName + "'");
			        		return;
			        		
			        	}else if(choice.equals("priority level")) {
			        		System.out.println("\nEnter the new priority level, (low, medium, high): ");
			        		String newPriority = sc.nextLine().trim();
			        		task.setTaskName(newPriority);
			        		System.out.println("Task name has been changed to " + "'" + newPriority + "'");
			        		return;
			        		
			        	} else {
			        		System.out.println("Task name or Priority level cannot be blank\n");
			        		
			        	}
		        	} catch (InputMismatchException e) {
		                System.out.println("Input must be a valid string!\n");
		                sc.nextLine();
		            }
		        }
		        
	        } if (!found) {
	            System.out.println("\n----Task does not exist!-----\n");
	            break;
	        }
        }
	}
}
