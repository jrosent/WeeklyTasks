package weeklytasks.ui;

import javax.swing.*;
import java.awt.*;

public class TaskDialog extends JPanel {

    private TaskCategory cat;

    private JPanel dialog;

    private JLabel taskDesc;
    private JLabel endDate;

    private JTextArea desc;
    private JTextArea end;

    private JButton submit;
    private JButton cancel;

    private JPanel buttonPanel;

    private JCheckBox inProgress;

    public TaskDialog(TaskCategory cat, boolean edit){
        this.cat = cat;

        dialog = new JPanel(new GridBagLayout());
        taskDesc = new JLabel("Task Description: ");
        desc = new JTextArea("Enter a description of the task.");
        endDate = new JLabel("Due Date:");
        end = new JTextArea("Enter the due date.");
        submit = new JButton("Submit");
        cancel = new JButton("Cancel");
        inProgress = new JCheckBox("In Progress");

    }

    public void setUpTaskDialog(){

    }

}
