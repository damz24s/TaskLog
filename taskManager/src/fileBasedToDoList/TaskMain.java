package fileBasedToDoList;
import java.util.Scanner;  

import taskData.AddTask;
import taskData.RemoveTask;
import taskData.ViewTasks;
import taskData.DataManager;
import taskData.EditTasks;

public class TaskMain {    
    public static void main(String[] args) throws ClassNotFoundException {

        Scanner sc = new Scanner(System.in);
        AddTask add = new AddTask(sc);
        RemoveTask remove = new RemoveTask(sc);
        EditTasks edit = new EditTasks(sc);
        ViewTasks view = new ViewTasks();
        DataManager dm = new DataManager();
        dm.loadData();
        
        System.out.println("\n-----WELCOME TO THE TASK MANAGER-----\n");

        while (true) {
            System.out.println("\nSelect an option from 1-8\n");
            System.out.println("1) Add a Task");
            System.out.println("2) Delete a Task");
            System.out.println("3) Delete all Tasks");
            System.out.println("4) Edit a Task");
            System.out.println("5) View all Tasks");
            System.out.println("6) View an individual Task");
            System.out.println("7) Mark a Task as complete");
            System.out.println("8) Quit");

            if (!sc.hasNextInt()) { 
                System.out.println("Input must be a valid number!");
                sc.nextLine(); 
                continue;
            }

            int options = sc.nextInt();
            sc.nextLine();

            switch (options) {
                case 1 -> add.createNewTask();
                case 2 -> remove.removeATask();
                case 3 -> remove.removeAllTasks();
                case 4 -> edit.editATask();
                case 5 -> view.viewAllTasks();
                case 6 -> view.viewIndividualTask();
                case 7 -> add.markAsComplete();
                case 8 ->{
                    dm.storeData();
                    System.out.println("\n------Goodbye------\n");
                    sc.close();
                    return;
                }
                default -> System.out.println("\nInput must be a number between 1 and 8!\n");
            }
        }
    }
}
