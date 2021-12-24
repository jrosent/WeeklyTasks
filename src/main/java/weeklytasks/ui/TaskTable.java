package weeklytasks.ui;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

public class TaskTable extends JTable {

    final Object[] HEADER = {"Task Number", "Task Description", "Due Date","In Progress"};
    private ArrayList<Task> tasks;
    DefaultTableModel model;

    public TaskTable() {
        tasks = new ArrayList<>();
        model = new DefaultTableModel(HEADER,0) {

            @Override
            public Class<?> getColumnClass(int columnIndex){
                if(columnIndex == 3) {
                    return Boolean.class;
                }
                else{
                    return Object.class;
                }

            }

            @Override
            public boolean isCellEditable(int row, int column){
                if(column == 3){
                    return true;
                }
                else {
                    return false;
                }
            }
        };

        this.setModel(model);

        this.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.getColumnModel().getColumn(2).setPreferredWidth(100);

        this.addTask(new Task(1, "New Task", "12/25/21"));
        this.addTask(new Task(1, "New Task 2", "12/25/21"));

    }

    public void addTask(Task task){
        tasks.add(task);
        model.addRow(task.getTaskInfo());
    }
}
