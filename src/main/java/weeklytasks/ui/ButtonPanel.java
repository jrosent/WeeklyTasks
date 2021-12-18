package weeklytasks.ui;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel{
    private JButton addCourse;
    private JButton addTask;
    private JButton editCourse;
    private JButton editTask;
    private JButton removeCourse;
    private JButton removeTask;
    private JButton taskComplete;

    public ButtonPanel(){
        this.setLayout(new GridLayout(6,1));
        addTask = new JButton("Add Task");
        editTask = new JButton("Edit Task");
        removeTask = new JButton("Remove Task");
        addCourse = new JButton("Add Course");
        editCourse = new JButton("Edit Course");
        removeCourse = new JButton("Remove Course");
        taskComplete = new JButton("TASK COMPLETE!");

        this.add(addTask);
        this.add(editTask);
        this.add(removeTask);
        this.add(addCourse);
        this.add(editCourse);
        this.add(removeCourse);
    }

}
