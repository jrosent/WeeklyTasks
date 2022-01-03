package weeklytasks.ui;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Holds all the information about task that need to be completed.
 */
public class ToDoPanel extends JPanel{

    private JScrollPane taskScrollPane;
    private TaskTable taskTable;
    private int taskNum = 0;

    public ToDoPanel(){
        taskTable = new TaskTable();
        taskScrollPane = new JScrollPane(taskTable);
        this.setLayout(new BorderLayout());
        this.add(taskScrollPane,BorderLayout.CENTER);
    }

    /**
     * Adds all the tasks with the completed checkbox selected to
     * and ArrayList.
     * @return ArrayList of the completed tasks
     */
    public ArrayList<Task> getCompleted(){
        ArrayList<Task> toMove = taskTable.getCompleted();
        return toMove;
    }

    /**
     * Adds a new task to the TaskTable.
     * @param desc description of the new task
     * @param due due date of the new task
     */
    public void addNewTask(String desc, String due) {
        Task t = new Task(taskNum, desc,due);
        taskTable.addTask(t);
        taskNum++;
    }

    /**
     * Send new parameters for an existing task to the task table.
     * @param desc new description for an existing task
     * @param due ne wdue date for an existing task
     */
    public void editTask(String desc, String due){
        taskTable.editTask(desc,due);
    }

    /**
     * Tells the Task Table to store the selected task.
     * @return true if task is selected
     */
    public boolean setSelected(){
        return taskTable.setSelected();
    }

    /**
     * Gets information about a task in the task table.
     * @param text specifies the information about a task to return
     *             "desc" : description of the task
     *             "date" : due date of the task
     * @return String containing the desired information
     */
    public String taskText(String text){
        return taskTable.getInfo(text);
    }

    /**
     * Removes the selected task from the Task Table.
     */
    public void removeTask(){
        taskTable.removeTask();
    }
}
