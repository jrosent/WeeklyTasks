package weeklytasks.ui;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class CompletedPanel extends JPanel{

    private ArrayList<TaskCategory> taskCatagories;
    private JLabel todo = new JLabel("COMPLETED");
    GridBagSetUp gc = new GridBagSetUp();

    public CompletedPanel(){
        taskCatagories = new ArrayList<>();
        todo.setFont(new Font("Times New Roman", Font.BOLD, 26));
        todo.setHorizontalAlignment(JLabel.CENTER);
        this.setLayout(new GridBagLayout());
        gc.setUpGridBag(1,.01,0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.NORTH);
        this.add(todo,gc);
        this.addTaskCatagory("Tasks");

    }

    /**
     * Add a category to the ArrayList of categories to hold tasks
     * @param title title of the task category
     */
    public void addTaskCatagory(String title){
        TaskCategory tc = new TaskCategory(title);
        taskCatagories.add(tc);
        gc.setUpGridBag(1,1,0,taskCatagories.size(),GridBagConstraints.BOTH);
        this.add(tc,gc);
    }

}

