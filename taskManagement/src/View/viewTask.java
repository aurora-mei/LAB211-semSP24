/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Task;
import common.libraryTask;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class viewTask {

    InputterTask in = new InputterTask();
    libraryTask lib = new libraryTask();

    public String validInputID() {
        displayTitle("Delete Task", '-');
        return String.format("%s", in.getIntFromInput("Enter ID: "));
    }

//còn thiếu enum để chuyển đổi số ttid thành chữ tt, và thông tin tt để ng dùng chọn
    public int createTask(List<Task> tasks) throws Exception {
        displayTitle("Add Task", '-');
        String taskName = in.getStringFromInput("Requirement Name: ");
        String taskTypeID = null;
        int idTT = lib.validTTID("Task Type: ");
        switch (idTT) {
            case 1 -> {
                taskTypeID = "Code";
            }
            case 2 -> {
                taskTypeID = "Test";
            }
            case 3 -> {
                taskTypeID = "Design";
            }
            case 4 -> {
                taskTypeID = "Review";
            }
        }
        Date date = in.getFormattedDateFromInput("Date: ");
        double planFrom, planTo;
        do {
            do {
                planFrom = in.getDoubleFromInput("From: ");
            } while (!lib.validFromTime(planFrom));
            do {
                planTo = in.getDoubleFromInput("To: ");
            } while (!lib.validToTime(planTo));
        } while (!lib.validTime(planFrom, planTo));
        String assignee = in.getStringFromInput("Assignee: ");
        String reviewer = in.getStringFromInput("Reviewer: ");
        return lib.add(tasks,taskTypeID,taskName, assignee, reviewer, date, planTo, planFrom);
    }

    //display
    public void displayTitle(String msg, char c) {
        Stream.generate(() -> c).limit(5).forEach(System.out::print);
        System.out.print(" " + msg + " ");
        Stream.generate(() -> c).limit(5).forEach(System.out::print);
        System.out.println();
    }

    public void displayResultFunction(int res, String functionName) {
        if (res > 0) {
            System.out.println(functionName + " task " + res + " successfull!");
        } else {
            System.out.println(functionName + " task " + res + " failed!");
        }
    }

    public void displayAll(List< Task> list) throws NullPointerException {
        if (list.isEmpty()) {
            System.out.println("List task is empty. There is nothing to display!");
            return;
        }
        displayTitle("Tasks", '-');
        System.out.println(String.format("%-8s%-15s%-15s%-15s%-15s%-15s%s", "ID", "Name", "Date", "Task Type","Time", "Asignee", "Reviewer"));
        for (Task con : list) {
            System.out.println(con.toString());
        }
    }
}
