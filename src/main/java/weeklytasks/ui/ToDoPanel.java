package weeklytasks.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class ToDoPanel extends JPanel{

    private ArrayList<Task> tasks;
    private JScrollPane taskScrollPane;
    private TaskTable taskTable;
    int selected;

    public ToDoPanel(){
        tasks = new ArrayList<>();
        taskTable = new TaskTable();
        taskScrollPane = new JScrollPane(taskTable);
        this.setLayout(new BorderLayout());
        this.add(taskScrollPane,BorderLayout.CENTER);
    }

    public void addTask(Task task){
        tasks.add(task);
        taskTable.addTask(task);
    }


}
