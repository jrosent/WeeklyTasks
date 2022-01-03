package weeklytasks.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskInfoDialog extends JFrame {

    private ToDoPanel todo;

    private final JPanel dialog;

    private final JLabel descLabel;
    private final JLabel dueLabel;

    private final JTextArea descText;
    private final JTextArea dueText;

    private final JButton submitButton;
    private final JButton cancelButton;

    private final JCheckBox inProgress;

    private boolean edit;

    public TaskInfoDialog(ToDoPanel todo, boolean edit) {
        this.todo = todo;
        this.edit = edit;

        dialog = new JPanel(new GridBagLayout());
        descLabel = new JLabel("Task Description: ");
        dueLabel = new JLabel("Due Date:");
        submitButton = new JButton("Submit");
        cancelButton = new JButton("Cancel");
        inProgress = new JCheckBox("In Progress");

        if(edit) {
            descText = new JTextArea(todo.taskText("desc"));
            dueText = new JTextArea(todo.taskText("date"));
        }
        else {
            descText = new JTextArea("Enter a description of the task.");
            dueText = new JTextArea("Enter the due date.");
        }


        setUp();
        buttonListener();
    }

    public void setUp() {
        //Grid bag coordinates
        int leftStrutX = 0;
        int labelsX = 1;
        int middleStrutX = 2;
        int textAreasX = 3;
        int rightStrutX = 4;
        int topStrutY = 0;
        int descY = 1;
        int dueY = 2;
        int buttonsY = 3;

        //Weights
        double strutWeight;
        int labelWeightX = 1;
        int labelWeightY = 1;
        int textAreaWeightX = 1;
        int textAreaWeightY = 1;
        int buttonWeightY = 5;


        //Grid spans
        int verticalStrutWidth = 5;
        int horizontalStrutHeight = 4;

        GridBagConstraints gc = new GridBagConstraints();

        gc.gridx = leftStrutX;
        gc.gridy = topStrutY;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.gridwidth = verticalStrutWidth;

        dialog.add(Box.createVerticalStrut(30), gc);

        gc.weightx = 0.0001;
        gc.gridwidth = 1;
        gc.gridheight = horizontalStrutHeight;
        dialog.add(Box.createHorizontalStrut(30), gc);

        gc.gridx = labelsX;
        gc.gridy = descY;
        gc.weightx = labelWeightX;
        gc.weighty = labelWeightY;
        gc.anchor = GridBagConstraints.EAST;
        gc.gridheight = 1;
        dialog.add(descLabel, gc);

        gc.gridy = dueY;
        dialog.add(dueLabel, gc);

        gc.gridy = buttonsY;
        gc.weighty = buttonWeightY;
        dialog.add(submitButton, gc);

        gc.gridx = middleStrutX;
        gc.gridy = 0;
        gc.weightx = .0001;
        gc.gridheight = horizontalStrutHeight;
        dialog.add(Box.createHorizontalStrut(10), gc);

        gc.gridx = textAreasX;
        gc.gridy = descY;
        gc.weightx = textAreaWeightX;
        gc.weighty = labelWeightY;
        gc.gridheight = 1;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.WEST;
        dialog.add(descText, gc);

        gc.gridy = dueY;
        dialog.add(dueText, gc);

        gc.gridy = buttonsY;
        gc.weighty = buttonWeightY;
        gc.fill = GridBagConstraints.NONE;
        dialog.add(cancelButton, gc);

        gc.gridx = rightStrutX;
        gc.gridy = topStrutY;
        gc.weightx = 1;
        gc.gridwidth = 1;
        gc.gridheight = horizontalStrutHeight;
        dialog.add(Box.createHorizontalStrut(30), gc);

        TextAreaFocusListener dt = new TextAreaFocusListener(descText);
        TextAreaFocusListener du = new TextAreaFocusListener(dueText);

        this.add(dialog);
        this.setSize(600, 400);
        this.setVisible(true);
        submitButton.requestFocusInWindow();
    }

    public void buttonListener() {
        ActionListener click = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submitButton) {
                    String desc = descText.getText();
                    String due = dueText.getText();
                    if(!edit) {
                        todo.addNewTask(desc,due);
                        dispose();
                    }
                    else if(edit){
                        todo.editTask(desc,due);
                        todo.revalidate();
                        System.out.println("Editing task");
                    }
                }
                else if (e.getSource() == cancelButton){
                    dispose();
                }
                dispose();
            }
        };

        submitButton.addActionListener(click);
        cancelButton.addActionListener(click);
    }


}
