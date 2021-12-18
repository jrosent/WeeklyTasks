package weeklytasks.ui;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

public class TaskTable extends JTable {

    final Object[] HEADER = {"Task Number", "Task Description", "Due Date"};
    private ArrayList<Task> tasks;
    DefaultTableModel model = new DefaultTableModel(HEADER,0);

    public TaskTable() {
        tasks = new ArrayList<>();
        this.setModel(model);
        this.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.addTask(new Task(1,"Task 1", "12/24/2021"));
    }

    public void addTask(Task task){
        tasks.add(task);
        model.addRow(task.getTaskInfo());
    }
}
