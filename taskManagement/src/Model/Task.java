/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

public class Task {

    private int ID;
    private String taskTypeID;
    private String requirementName;
    private Date date;
    private Double planFrom;
    private Double planTo;
    private String assignee;
    private String reviewer;

    public Task() {
    }

    public Task(int ID, String taskTypeID, String requirementName, Date date, Double planFrom, Double planTo, String assignee, String reviewer) {
        this.ID = ID;
        this.taskTypeID = taskTypeID;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTaskTypeID() {
        return taskTypeID;
    }

    public void setTaskTypeID(String taskTypeID) {
        this.taskTypeID = taskTypeID;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public String getDate(Date date) {
        return String.format("%s", date.getDate());
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(Double planFrom) {
        this.planFrom = planFrom;
    }

    public Double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(Double planTo) {
        this.planTo = planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    @Override
    public String toString() {
        return String.format("%-8s%-15s%-15s%-15s%-15s%-15s%s", ID, requirementName, date,taskTypeID,planTo -  planFrom, assignee, reviewer);
    }

}
