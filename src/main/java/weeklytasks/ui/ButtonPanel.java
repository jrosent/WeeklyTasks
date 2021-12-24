package weeklytasks.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel{
    private TaskAreaPanel taskArea;
    private JButton addCourse;
    private JButton addTask;
    private JButton editCourse;
    private JButton editTask;
    private JButton removeCourse;
    private JButton removeTask;
    private JButton taskComplete;

    public ButtonPanel(TaskAreaPanel taskArea){
        this.taskArea = taskArea;
        this.setLayout(new GridLayout(2,1));
        addTask = new JButton("Add Task");
        editTask = new JButton("Edit Task");
        removeTask = new JButton("Remove Task");
        addCourse = new JButton("Add Course");
        editCourse = new JButton("Edit Course");
        removeCourse = new JButton("Remove Course");
        taskComplete = new JButton("TASK COMPLETE!");

        this.add(addTask);
        //this.add(editTask);
        //this.add(removeTask);
        this.add(addCourse);
        //this.add(editCourse);
        //this.add(removeCourse);
    }


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
                else if(e.getSource() == addCourse){
                    System.out.println("Add course clicked");
                    CategoryDialog cat = new CategoryDialog(taskArea,false);
                    cat.buttonClick();
                }
                else if(e.getSource() == editCourse){
                    System.out.println("Edit course clicked");
                }
                else if(e.getSource() == removeCourse){
                    System.out.println("Remove course clicked");
                }
            }

        };

        addTask.addActionListener(buttonClick);
        editTask.addActionListener(buttonClick);
        removeTask.addActionListener(buttonClick);
        addCourse.addActionListener(buttonClick);
        editCourse.addActionListener(buttonClick);
        removeCourse.addActionListener(buttonClick);
    }


}
