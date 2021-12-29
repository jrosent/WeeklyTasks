package weeklytasks.ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TaskAreaPanel extends JPanel{

    private ArrayList<TaskCategory> taskCategories;
    private JLabel todoLabel;
    private JLabel completedLabel;
    private Font font;
    private GridBagConstraints gc;

    public TaskAreaPanel(){
        taskCategories = new ArrayList<>();
        font = new Font("Times New Roman", Font.BOLD, 26);
        todoLabel = new JLabel("TODO");
        todoLabel.setFont(font);
        todoLabel.setHorizontalAlignment(JLabel.CENTER);
        completedLabel = new JLabel("COMPLETE");
        completedLabel.setFont(font);
        completedLabel.setHorizontalAlignment(JLabel.CENTER);
        gc = new GridBagConstraints();

        setUpTaskAreaPanel();
    }

    /**
     * Sets up the layout for the TaskAreaPanel to be put in the
     * center of the main frame.
     */
    public void setUpTaskAreaPanel(){

        //Label layout constants
        int labelWeight = 1;
        int todoLabelX = 0;
        int completedLabelX = 1;
        int titleLabelY = 0;

        //Set layout and add components
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        //todolabel formatting
        gc.weightx = labelWeight;
        gc.weighty = labelWeight;
        gc.gridx = todoLabelX;
        gc.gridy = titleLabelY;
        gc.fill = GridBagConstraints.BOTH;

        this.add(todoLabel,gc);

        //Completed label formatting
        gc.gridx = completedLabelX;
        this.add(completedLabel,gc);

        addTaskCategory("Course 1", "Now", "Later");
        addTaskCategory("Course 2", "Now", "Later");


    }

    /**
     * Adds a new TaskCategory to the TaskAreaPanel.
     * @param title name of the new TaskCategory
     * @param start start date of the new TaskCategory
     * @param end end date of the new TaskCategory
     */
    public void addTaskCategory(String title, String start, String end){
        //Task Category layout constants
        int taskCategoryX = 0;
        int taskCategoryY = taskCategories.size() + 1;
        int taskCategoryWeight = 10;
        int taskCategoryWidth = 2;

        TaskCategory tc = new TaskCategory(title, start, end);
        taskCategories.add(tc);
        gc.gridx = taskCategoryX;
        gc.gridy = taskCategoryY;
        gc.gridwidth = taskCategoryWidth;
        gc.fill = GridBagConstraints.BOTH;
        gc.weighty = taskCategoryWeight;
        gc.insets = new Insets(5,0,5,0);
        this.add(tc,gc);
    }

    /**
     * Removes a TaskCategory from the TaskAreaPanel.
     * @param tc TaskCategory to be removed
     */
    public void removeTaskCategory(TaskCategory tc){
        taskCategories.remove(tc);
        this.remove(tc);
    }

    /**
     * Checks if the title for a new TaskCategory is unique.
     * @param title name of new TaskCategory
     * @return true if unique false if not
     */
    public boolean checkValidTitle(String title){

        for(TaskCategory tc: taskCategories){
            if(tc.compareTitle(title)){
                return false;
            }
        }
        return true;
    }

    /**
     * Move selected tasks to completed
     */
    public void moveTasks(){
        for(TaskCategory tc : taskCategories){
            tc.moveTasks();
        }
    }

}
