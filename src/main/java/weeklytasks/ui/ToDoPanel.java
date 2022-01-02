package weeklytasks.ui;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Holds all the information about task that need to be completed.
 */
public class ToDoPanel extends JPanel{

    private ArrayList<Task> tasks;
    private JScrollPane taskScrollPane;
    private TaskTable taskTable;

    public ToDoPanel(){
        tasks = new ArrayList<>();
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
        tasks.add(task);
        taskTable.addTask(task);
    }

    public ArrayList<Task> getCompleted(){
        ArrayList<Task> toMove = taskTable.getCompleted();
        return toMove;
    }

    public Task getSelected(){
        return taskTable.getSelected();
    }

}
