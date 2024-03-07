package common;

import Model.Task;
import java.util.Comparator;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class libraryTask {

    private int counter = 1;

    public int add(List<Task> tasks, String taskTypeID, String taskName, String assignee, String reviewer, Date date, double planTo, double planFrom) throws Exception {
        Task newTask = null;
        try {
            newTask = new Task(autoID(), taskTypeID, taskName, date, planFrom, planTo, assignee, reviewer);
            tasks.add(newTask);
        } catch (NumberFormatException ex) {
            System.out.println("Error in add to list action!");
            return -1;
        }
        return newTask.getID();
    }

    public int autoID() {
        return counter++;
    }

    public Task findExpense(List<Task> list, String idk) throws Exception {//tìm và trả về expense tương ứng
        try {
            int key = Integer.parseInt(idk);
            List<Task> res = list.stream().filter((a) -> a.getID() == key).collect(Collectors.toList());
            if (res.isEmpty()) {
                System.out.println("Can not find the task has ID " + key);
                return null;
            }
            if (!res.isEmpty()) {
                return res.get(0);
            }
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return null;
    }

    public void deleteTask(List<Task> tasks, String id) throws Exception {
        try {
            if (tasks.isEmpty()) {
                System.out.println("List is empty. Can't delete any task!");
                return;
            }
            Task t = findExpense(tasks, id);
            if (t!=null) {
                tasks.remove(t);
                System.out.println("Delete task " + id + " successful!");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Delete task " + id + " failed!");
        }
    }

    public int validTTID(String msg) {
        String types = "1.Code\n2.Test\n3.Design\n4.Review";
        Scanner sc = new Scanner(System.in);
        boolean check;
        int id = 0;
        int a;
        do {
            check = true;
            try {
                System.out.println(types);
                System.out.print(String.format("%s", msg));
                id = sc.nextInt();
                if (id >= 1 && id <= 4) {
                    return id;
                } else {
                    System.err.println("Please enter the integer number between[1-4]!");
                    check = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Task type should be a integer number!");
                check = false;
                sc.next();
            }
        } while (!check);
        return -1;
    }

    public boolean validTime(double fromT, double toT) {
//        if (fromT < 8.0 || fromT > 17.5 && (fromT % 1 != 0.0 || fromT % 1 != 0.5)) {
//            System.err.println("From time must be within 8.0->17.5!");
//            return false;
//        }
//        if (toT < 8.0 || toT > 17.5 && (toT % 1 != 0.0 || toT % 1 != 0.5)) {
//            System.err.println("To time must be within 8.0->17.5!");
//            return false;
//        }
        if (fromT > toT) {
            System.err.println("From time must be smaller than To time!");
            return false;
        }
        return true;
    }

    public boolean validFromTime(double fromT) {
        if (fromT < 8.0 || fromT > 17.5) {
            System.err.println("From time must be within 8.0->17.5!");
            return false;
        } else if (fromT % 0.5 != 0.0) {
            System.err.println("From time must be in format .0 or .5!");
            return false;
        }
        return true;
    }

    public boolean validToTime(double toT) {
        if (toT < 8.0 || toT > 17.5) {
            System.err.println("To time must be within 8.0->17.5!");
            return false;
        } else if (toT % 0.5 != 0.0) {
            System.err.println("To time must be in format .0 or .5!");
            return false;
        }
        return true;
    }

    public List<Task> getDataTasks(List<Task> tasks) {
        tasks.sort(Comparator.comparing(Task::getID));
        return tasks;
    }
}
