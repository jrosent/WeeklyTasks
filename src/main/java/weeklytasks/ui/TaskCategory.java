package weeklytasks.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TaskCategory extends JPanel {

    private ToDoPanel todo;
    private CompletedPanel completed;
    private ButtonPanel taskOps;
    private JPanel container;
    private JButton titleButton;

    private int numTasks = 0;

    private String title;
    private String startDate;
    private String endDate;

    public TaskCategory(String title, String start, String end){
        todo = new ToDoPanel();
        completed = new CompletedPanel();
        taskOps = new ButtonPanel(this);
        this.title = title;
        this.startDate = start;
        this.endDate = end;
        this.container = new JPanel(new GridLayout(1,2));
        this.titleButton = new JButton(this.title);
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.black,2));

        todo.setBorder(BorderFactory.createLineBorder(Color.blue,2));
        completed.setBorder(BorderFactory.createLineBorder(Color.red,2));

        setUpTaskCategory();
        setUpTitleButton();

    }

    /**
     * Sets up the layout for a new task category with
     * a completed and to-do list.
     */
    public void setUpTaskCategory() {

        //Button Constraints
        int buttonX = 0;
        int buttonY = 0;
        double buttonWeightX = 1;
        int buttonWeightY = 1;
        int buttonWidth = 4;

        //Panel Constraints
        int taskOpsX = 0;
        int todoX = 1;
        int panelSeparatorX = 2;
        int completedX = 3;
        int panelsY = 1;
        double taskOpsWeight = 0.15;
        int panelWeightX = 1;
        double separatorWeightX = 0.0001;
        int panelWeightY = 15;
        int panelWidth = 1;


        GridBagConstraints gc = new GridBagConstraints();

        //Title formatting
        //titleButton.setBackground(Color.GRAY);
        //titleButton.setBorder(BorderFactory.createLineBorder(Color.black));
        titleButton.setFont(new Font("Cambria", Font.BOLD, 20));
        //titleButton.setForeground(Color.BLACK);
        gc.gridx = buttonX;
        gc.gridy = buttonY;
        gc.weightx = taskOpsWeight;
        gc.weighty = buttonWeightY;
        gc.gridwidth = buttonWidth;
        gc.fill = GridBagConstraints.BOTH;
        gc.anchor = GridBagConstraints.CENTER;

        this.add(titleButton, gc);

        //TodoPanel formatting
        gc.gridy = panelsY;
        gc.gridx = taskOpsX;
        gc.weightx = taskOpsWeight;
        gc.weighty = panelWeightY;
        gc.gridwidth = panelWidth;

        this.add(taskOps,gc);

        gc.gridx = todoX;
        gc.weightx = panelWeightX;
        this.add(todo, gc);

        //Panel Separator formatting
        gc.gridx = panelSeparatorX;
        gc.weightx = separatorWeightX;
        gc.fill = GridBagConstraints.VERTICAL;
        this.add(Box.createHorizontalStrut(10), gc);

        //Completed panel formatting
        gc.gridx = completedX;
        gc.weightx = panelWeightX;
        gc.fill = GridBagConstraints.BOTH;
        this.add(completed, gc);
    }

    /**
     * Edits the course information if the input is new values.
     * @param title name of the task category
     * @param start start date of the task category
     * @param end end date of the task category
     */
    public void editCategory(String title, String start, String end){

            if (!this.title.equalsIgnoreCase(title) && title != null) {
                setTitle(title);
                titleButton.setText(title);
            }
            if (start != null && !this.startDate.equalsIgnoreCase(start)) {
                setStart(start);
            }
            if (!this.endDate.equalsIgnoreCase(end) && end != null) {
                setEnd(end);
            }
    }

    /**
     * Sets the title variable to a new string.
     * @param title new name of the task category
     */
    private void setTitle(String title){
        this.title = title;
    }

    /**
     * Sets a new start date for the Task Category.
     * @param start new start date for the task category
     */
    private void setStart(String start){
        this.startDate = start;
    }

    /**
     * Sets a new end date for the Task Category.
     * @param end new end date for the task category
     */
    private void setEnd(String end){
        this.endDate = end;
    }

    /**
     * Returns the title of the category.
     */
    private String getTitle(){
        return title;
    }
    /**
     * Returns the start date of the category.
     */
    private String getStartDate(){
        return startDate;
    }

    /**
     * Returns the end date of the category.
     */
    private String getEndDate(){
        return endDate;
    }

    /**
     * Creates new Action Listener to open an editor dialog for the title button.
     */
    public void setUpTitleButton(){
        TaskCategory tc = this;
        ActionListener click = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CategoryInfoDialog cd = new CategoryInfoDialog(tc,true);
                cd.buttonClick();
            }
        };

        titleButton.addActionListener(click);
    }

    /**
     * Check if the new title is the same as this title ignoring capitalization.
     * @param title new title for a task category
     * @return true if the same, false if different
     */
    public boolean compareTitle(String title){
        if(this.getTitle().equalsIgnoreCase(title)){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Creates a new String with the specified TaskCategory variable.
     * @param var string indicating the variable information to be added to the JTextArea
     * @return String containing the value of the specified variable
     */
    public String dialogJText(String var){
        String temp = "";
        switch(var){
            case("catName") :
                temp = getTitle();
                break;
            case("start") :
                temp = getStartDate();
                break;
            case("end") :
                temp = getEndDate();
                break;
            default :
                temp = "";
                break;
        }
        return temp;
    }

    /**
     * Move selected tasks from todo to completed
     */
    public void moveTasks(){
        ArrayList<Task> toMove = todo.getCompleted();
        for(Task t : toMove){
            completed.addTask(t);
        }
    }

    public void addTask(Task task){
        todo.addTask(task);
    }

    public void addNewTask(String desc, String dueDate){
        Task t = new Task(numTasks,desc,dueDate);
        todo.addTask(t);
        numTasks++;
    }

    public Task getSelected(){
        return todo.getSelected();
    }

    public int getTaskNum(){
        int i = this.numTasks;
        return i;
    }

}
