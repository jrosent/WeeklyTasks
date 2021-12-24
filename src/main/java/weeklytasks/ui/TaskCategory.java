package weeklytasks.ui;

import javax.swing.*;
import java.awt.*;

public class TaskCategory extends JPanel {

    private ToDoPanel todo;
    private CompletedPanel completed;
    private JPanel container;
    private JButton title;

    public TaskCategory(String title){
        todo = new ToDoPanel();
        completed = new CompletedPanel();
        this.container = new JPanel(new GridLayout(1,2));
        this.title = new JButton(title);
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.black,2));

        todo.setBorder(BorderFactory.createLineBorder(Color.blue,2));
        completed.setBorder(BorderFactory.createLineBorder(Color.red,2));

        setUpTaskCategory();

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
        title.setBackground(Color.GRAY);
        title.setBorder(BorderFactory.createLineBorder(Color.black));
        title.setFont(new Font("Cambria", Font.BOLD, 20));
        title.setForeground(Color.BLACK);
        gc.gridx = buttonX;
        gc.gridy = buttonY;
        gc.weightx = buttonWeightX;
        gc.weighty = buttonWeightY;
        gc.gridwidth = buttonWidth;
        gc.fill = GridBagConstraints.BOTH;
        gc.anchor = GridBagConstraints.CENTER;

        this.add(title, gc);

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
}
