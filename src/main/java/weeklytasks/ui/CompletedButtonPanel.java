package weeklytasks.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompletedButtonPanel extends JPanel {
    private TaskAreaPanel taskAreaPanel;
    private JButton taskCompleteButton;
    private JLabel label = new JLabel("Version 1.0.");


    public CompletedButtonPanel(TaskAreaPanel taskAreaPanel){
        taskCompleteButton = new JButton("TASK COMPLETE");
        this.setLayout(new GridBagLayout());
        this.taskAreaPanel = taskAreaPanel;

        setUp();
        taskCompleteClicked();
    }

    /**
     * Sets up and formats the completed button panel
     */
    public void setUp(){
        GridBagConstraints gc = new GridBagConstraints();

        taskCompleteButton.setBackground(Color.GREEN);
        taskCompleteButton.setFont(new Font("Cambria", Font.BOLD, 20));
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 20;
        gc.fill = GridBagConstraints.BOTH;
        gc.anchor = GridBagConstraints.CENTER;

        this.add(taskCompleteButton,gc);

        gc.gridy = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.EAST;

        this.add(label,gc);
    }

    /**
     * ActionListener for the task completed button to move tasks from todo to completed.
     */
    public void taskCompleteClicked(){
        ActionListener click = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Task Complete Clicked.");
                taskAreaPanel.moveTasks();

            }
        };

        taskCompleteButton.addActionListener(click);
    }
}
