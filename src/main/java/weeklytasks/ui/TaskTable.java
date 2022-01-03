package weeklytasks.ui;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TaskTable extends JTable {

    final Object[] HEADER = {"Task Number", "Task Description", "Due Date","Completed"};
    private ArrayList<Task> tasks;
    private int selectedRow;
    DefaultTableModel model;
    final int DESCINDEX = 1;
    final int DATEINDEX = 2;
    final int COMPLETEDINDEX = 3;

    public TaskTable() {
        tasks = new ArrayList<>();
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        model = new DefaultTableModel(HEADER,0) {
            @Override
            public Class<?> getColumnClass(int columnIndex){
                if(columnIndex == COMPLETEDINDEX) {
                    return Boolean.class;
                }
                else{
                    return Object.class;
                }

            }

            @Override
            public boolean isCellEditable(int row, int column){
                if(column == COMPLETEDINDEX){
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
    public void removeTask(){
        tasks.remove(selectedRow);
        model.removeRow(selectedRow);
    }

    /**
     * Gets the in progress tasks
     * @return and ArrayList of the tasks
     */
    public ArrayList<Task> getCompleted(){
        ArrayList<Task> selected = new ArrayList<Task>();
        for(int i = tasks.size()-1; i >= 0; i--){
            if((boolean) model.getValueAt(i,COMPLETEDINDEX) == true){
                selected.add(tasks.get(i));
                tasks.remove(i);
                model.removeRow(i);            }
        }
        return selected;
    }

    public boolean setSelected(){
        selectedRow = getSelectedRow();
        if(selectedRow >= 0) {
            System.out.println("Selected Row: " + selectedRow);
            return true;
        }
        else{
            return false;
        }
    }

    public void editTask(String desc, String date){
        if(selectedRow >= 0) {
            model.setValueAt(desc, selectedRow, DESCINDEX);
            model.setValueAt(date, selectedRow, DATEINDEX);
            tasks.get(selectedRow).editTask(desc, date);
            selectedRow = -1;
        }
        else{
            System.out.println("No rows selected.");
        }
        revalidate();
    }

    public String getInfo(String text){
       String temp;
       switch(text){
           case("desc") :
               temp = (String) model.getValueAt(selectedRow,DESCINDEX);
               break;
           case("date") :
               temp = (String) model.getValueAt(selectedRow,DATEINDEX);
               break;
           default :
               temp  = "";
               break;
       }

       return temp;
    }

}
