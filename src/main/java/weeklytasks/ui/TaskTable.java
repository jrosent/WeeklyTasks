package weeklytasks.ui;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TaskTable extends JTable {

    final Object[] HEADER = {"Task Number", "Task Description", "Due Date","Completed"};
    private ArrayList<Task> tasks;
    DefaultTableModel model;
    int inProgressIndex = 3;

    public TaskTable() {
        tasks = new ArrayList<>();
        model = new DefaultTableModel(HEADER,0) {

            @Override
            public Class<?> getColumnClass(int columnIndex){
                if(columnIndex == inProgressIndex) {
                    return Boolean.class;
                }
                else{
                    return Object.class;
                }

            }

            @Override
            public boolean isCellEditable(int row, int column){
                if(column == inProgressIndex){
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
        this.addTask(new Task(1, "New Task 3", "12/25/21"));


    }

    /**
     * Adds a task to this task table.
     * @param task task to be added
     */
    public void addTask(Task task){
        tasks.add(task);
        model.addRow(task.getTaskInfo());
    }

    /**
     * Removed the selected task
     */
    public void removeTask(int index){
        tasks.remove(index);
        model.removeRow(index);
    }

    /**
     * Gets the in progress tasks
     * @return and ArrayList of the tasks
     */
    public ArrayList<Task> getCompleted(){
        ArrayList<Task> selected = new ArrayList<Task>();
        for(int i = tasks.size()-1; i >= 0; i--){
            if((boolean) model.getValueAt(i,inProgressIndex) == true){
                selected.add(tasks.get(i));
                removeTask(i);
            }
        }
        return selected;
    }

    public Task getSelected(){
        int row = getSelectedRow();
        return tasks.get(row);
    }


}
