package weeklytasks.ui;

import javax.swing.*;
import java.awt.*;

public class CompletedButtonPanel extends JPanel {
    JButton taskCompleteButton;

    public CompletedButtonPanel(){
        taskCompleteButton = new JButton("TASK COMPLETE");
        this.setLayout(new GridBagLayout());
        JLabel label = new JLabel("Most recent function.");

        GridBagConstraints gc = new GridBagConstraints();

        taskCompleteButton.setBackground(Color.GREEN);
        taskCompleteButton.setOpaque(true);
        //taskCompleteButton.setBorderPainted(true);
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
}
