package weeklytasks.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskCategory extends JPanel {

    private ToDoPanel todo;
    private CompletedPanel completed;
    private JPanel container;
    private JButton titleButton;

    private String title;
    private String startDate;
    private String endDate;

    public TaskCategory(String title, String start, String end){
        todo = new ToDoPanel();
        completed = new CompletedPanel();
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
     * a completed and to-do list
     */
    public void setUpTaskCategory() {

        //Button Constraints
        int buttonX = 0;
        int buttonY = 0;
        double buttonWeightX = 1;
        int buttonWeightY = 1;
        int buttonWidth = 3;

        //Panel Constraints
        int todoX = 0;
        int panelSeparatorX = 1;
        int completedX = 2;
        int panelsY = 1;
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
        gc.weightx = buttonWeightX;
        gc.weighty = buttonWeightY;
        gc.gridwidth = buttonWidth;
        gc.fill = GridBagConstraints.BOTH;
        gc.anchor = GridBagConstraints.CENTER;

        this.add(titleButton, gc);

        //TodoPanel formatting
        gc.gridy = panelsY;
        gc.weighty = panelWeightY;
        gc.gridwidth = panelWidth;

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
     * Edits the course information if the input is new values
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
        //titleButton.revalidate();
    }

    /**
     * Sets the title variable to a new string.
     * @param title new name of the task category
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     * Sets a new start date for the Task Category.
     * @param start new start date for the task category
     */
    public void setStart(String start){
        this.startDate = start;
    }

    /**
     * Sets a new end date for the Task Category
     * @param end new end date for the task category
     */
    public void setEnd(String end){
        this.endDate = end;
    }

    /**
     * Returns the title of the category
     */
    public String getTitle(){
        return title;
    }
    /**
     * Returns the start date of the category
     */
    public String getStartDate(){
        return startDate;
    }

    /**
     * Returns the end date of the category
     */
    public String getEndDate(){
        return endDate;
    }

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
}
