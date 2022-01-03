package weeklytasks.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel{
    private ToDoPanel todo;
    private JButton addTask;
    private JButton editTask;
    private JButton removeTask;

    public ButtonPanel(ToDoPanel todo){
        this.todo = todo;
        this.setLayout(new GridLayout(3,1));
        addTask = new JButton("Add Task");
        editTask = new JButton("Edit Task");
        removeTask = new JButton("Remove Task");

        this.add(addTask);
        this.add(editTask);
        this.add(removeTask);

        setButtonClick();
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
                    TaskInfoDialog tid = new TaskInfoDialog(todo,false);
                }
                else if(e.getSource() == editTask) {
                    System.out.println("Edit task clicked");
                    if (todo.setSelected()){
                        TaskInfoDialog tid = new TaskInfoDialog(todo, true);
                    }
                }
                else if(e.getSource() == removeTask){
                    if(todo.setSelected()){
                        todo.removeTask();
                    }
                    System.out.println("Remove task clicked");
                }
            }

        };

        addTask.addActionListener(buttonClick);
        editTask.addActionListener(buttonClick);
        removeTask.addActionListener(buttonClick);
    }


}
