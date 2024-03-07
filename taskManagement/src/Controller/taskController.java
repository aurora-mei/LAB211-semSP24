package Controller;

import Model.Task;
import View.Menu;
import View.viewTask;
import common.libraryTask;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class taskController extends Menu {

    List<Task> tasks;
    viewTask v = new viewTask();
    libraryTask lib = new libraryTask();
    public taskController() {
        super("Task program", Arrays.asList(new String[]{"Add Task", "Delete task", "Display Task", "Exit"}));
        tasks = new ArrayList();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1 -> {
            try {
                v.displayResultFunction(v.createTask(tasks), "Add");
            } catch (Exception ex) {
                Logger.getLogger(taskController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }case 2->{
            try {
                lib.deleteTask(tasks, v.validInputID());
            } catch (Exception ex) {
                Logger.getLogger(taskController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }case 3->{
                v.displayAll(lib.getDataTasks(tasks));
            }case 4->{
                System.exit(0);
            }
        }
    }

}
