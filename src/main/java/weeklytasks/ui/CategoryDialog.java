package weeklytasks.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoryDialog extends JFrame{

    private boolean edit;
    private TaskAreaPanel taskArea;
    private JPanel dialog;

    private JLabel category;
    private JLabel startDate;
    private JLabel endDate;

    private JTextArea catName;
    private JTextArea start;
    private JTextArea end;

    private JButton submit;
    private JButton cancel;
    private JButton remove;

    private JPanel buttonPanel;

    public CategoryDialog(TaskAreaPanel taskArea, boolean edit){
        this.edit = edit;
        this.taskArea = taskArea;
        dialog = new JPanel(new GridBagLayout());
        category = new JLabel("Name of Task Category: ");
        catName = new JTextArea("Enter the name of the new task category.");
        startDate = new JLabel("Start Date: ");
        start = new JTextArea("Enter the start date.");
        endDate = new JLabel("End Date:");
        end = new JTextArea("Enter the end date.");
        submit = new JButton("Submit");
        cancel = new JButton("Cancel");
        remove = new JButton("Remove Category");

        setUpDialog();
    }

    public void setUpDialog(){

        GridBagConstraints gc = new GridBagConstraints();

        //GC SETTINGS
        //Weights
        int labelWeightX = 1;
        int textWeightX = 2;
        int lTWeightX = 1;
        int lTWeightY = 1;
        int buttonWeightY = 10;
        double separatorWeight = .0001;
        int bufferSize = 30;
        int separatorSize = 10;
        //Row and Columns
        int leftBufferX = 0;
        int labelX = 1;
        int seperatorX = 2;
        int textX = 3;
        int rightBufferX = 4;
        int topBufferY = 0;
        int categoryY = 1;
        int startY = 2;
        int endY = 3;
        int buttonY = 4;

        gc.gridx = leftBufferX;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = labelWeightX;

        dialog.add(Box.createHorizontalStrut(bufferSize),gc);

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.weighty = lTWeightY;
        gc.gridx = labelX;

        dialog.add(Box.createVerticalStrut(bufferSize),gc);

        //Set Up for labels
        gc.weighty = lTWeightY;
        gc.gridx = labelX;
        gc.anchor = GridBagConstraints.EAST;
        gc.fill = GridBagConstraints.NONE;
        gc.gridy = categoryY;
        dialog.add(category,gc);

        gc.gridy = startY;
        dialog.add(startDate,gc);

        gc.gridy = endY;
        dialog.add(endDate,gc);

        gc.gridx = seperatorX;
        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = separatorWeight;

        dialog.add(Box.createHorizontalStrut(separatorSize),gc);

        //Set up for text areas
        gc.weightx = textWeightX;
        gc.weighty = lTWeightY;
        gc.gridx = textX;
        gc.gridy = categoryY;
        gc.anchor = GridBagConstraints.WEST;
        gc.fill = GridBagConstraints.HORIZONTAL;
        dialog.add(catName,gc);

        gc.gridy = startY;
        dialog.add(start,gc);

        gc.gridy = endY;
        dialog.add(end,gc);

        gc.gridx = rightBufferX;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = 2;

        dialog.add(Box.createHorizontalStrut(bufferSize),gc);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.insets = new Insets(0,0,0,5);
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.EAST;
        buttonPanel.add(submit,gc);
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.WEST;
        gc.insets = new Insets(0,5,0,0);
        buttonPanel.add(cancel,gc);
        if(edit == true) {
            gc.gridx = 0;
            gc.gridy = 1;
            gc.gridwidth = 2;
            gc.insets = new Insets(0, 0, 0, 0);
            gc.anchor = GridBagConstraints.NORTH;
            buttonPanel.add(remove, gc);
        }

        gc.gridy = buttonY;
        gc.gridx = 0;
        gc.weighty = buttonWeightY;
        gc.gridwidth = 10;
        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.BOTH;
        dialog.add(buttonPanel,gc);

        TextAreaFocusListener cn = new TextAreaFocusListener(catName);
        TextAreaFocusListener st = new TextAreaFocusListener(start);
        TextAreaFocusListener en = new TextAreaFocusListener(end);


        this.add(dialog);
        this.setSize(600,400);
        this.setVisible(true);
        submit.requestFocusInWindow();
    }

    public void buttonClick(){
        ActionListener click = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == submit) {
                    String title = catName.getText();
                    taskArea.addTaskCategory(title);
                    taskArea.revalidate();
                    dispose();
                }
                else if(e.getSource() == remove){

                }
                else{
                    dispose();
                }
            }
        };

        submit.addActionListener(click);
        cancel.addActionListener(click);
    }

    public void addCategory(String title){

    }

}
