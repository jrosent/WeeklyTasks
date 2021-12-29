package weeklytasks.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel{
    private TaskAreaPanel taskArea;
    private JButton addTask;
    private JButton editTask;
    private JButton removeTask;

    public ButtonPanel(){
        this.taskArea = taskArea;
        this.setLayout(new GridLayout(3,1));
        addTask = new JButton("Add Task");
        editTask = new JButton("Edit Task");
        removeTask = new JButton("Remove Task");

        this.add(addTask);
        this.add(editTask);
        this.add(removeTask);

    }


    /**
     * Sets up th ActionListener for the buttons in this panel.
     */
    public void setButtonClick(){
        ActionListener buttonClick = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == addTask){
                    System.out.println("Add task clicked");
                }
                else if(e.getSource() == editTask){
                    System.out.println("Edit task clicked");
                }
                else if(e.getSource() == removeTask){
                    System.out.println("Remove task clicked");
                }
            }

        };

        addTask.addActionListener(buttonClick);
        editTask.addActionListener(buttonClick);
        removeTask.addActionListener(buttonClick);
    }


}
