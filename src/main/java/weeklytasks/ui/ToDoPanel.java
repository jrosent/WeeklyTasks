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
     * Adds a task to the task table held by this panel.
     * @param task task to be added
     */
    public void addTask(Task task){
        taskTable.addTask(task);
    }

    public ArrayList<Task> getCompleted(){
        ArrayList<Task> toMove = taskTable.getCompleted();
        return toMove;
    }

    public void addNewTask(String desc, String due) {
        Task t = new Task(taskNum, desc,due);
        taskTable.addTask(t);
        taskNum++;
    }

    public void editTask(String desc, String due){
        taskTable.editTask(desc,due);
    }

    public boolean setSelected(){
        return taskTable.setSelected();
    }

    public String taskText(String text){
        return taskTable.getInfo(text);
    }

    public void removeTask(){
        taskTable.removeTask();
    }
}
