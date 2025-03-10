package taskData;
import java.util.ArrayList;      

import model.Task;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;

public class DataManager {
	static ArrayList<Task> allTasks = new ArrayList<>(); 
	int maxId = 0;

	
    public void loadData() {
        allTasks.clear();

    	try {
            File file = new File(System.getProperty("user.dir") + File.separator + "FileBasedToDoList" + File.separator + "taskManager" + File.separator + "taskObjects.txt");
            if(!file.exists()) {
            	file.createNewFile();
                System.out.println("No existing task data found, new file created.");
            }
		
	
	        try (FileInputStream fileIn = new FileInputStream(file);
	             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
	
	            while (true) {
	                try {
	                    Task task = (Task) objectIn.readObject();
	                    allTasks.add(task);
	                   
	                } catch (EOFException e) {
	                    break; 
	                } catch (ClassNotFoundException e) {
	                    System.err.println("Error: Task class not found.");
	                }
	            }
	
	        } catch (IOException e) {
	            System.err.println("Error reading taskObjects.txt.");
	        }
		} catch (IOException e) {
			return;
		}
    }

	
	
	public void storeData() {
		
		try {
			File file = new File(System.getProperty("user.dir") + File.separator + "FileBasedToDoList" + File.separator + "taskManager" + File.separator + "taskObjects.txt");
			file.getParentFile().mkdirs();
			FileOutputStream fileOut = new FileOutputStream(file);
			
			try(ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)){

				if(allTasks.size() > 0) {
					for(Task task : allTasks) {
						objectOut.writeObject(task);
					}
					System.out.println("Tasks have been saved!");

				}else {
					System.out.println("No tasks to save");
				}
			}
			
		}catch(IOException e) {
		}
	}

	


}

