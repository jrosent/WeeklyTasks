package weeklytasks.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;

public class Layout {

    //Frame
    private JFrame frame;

    //Panels
    private JPanel taskButtons;
    private JPanel center;
    private JPanel taskArea;
    private JPanel completedArea;
    private JPanel inProgress;

    //Labels and Text
    private JLabel label;
    private JTextField input;
    private JTextArea ta;

    //Buttons
    private JButton addCourse;
    private JButton addTask;
    private JButton editCourse;
    private JButton editTask;
    private JButton removeCourse;
    private JButton removeTask;
    private JButton taskComplete;

    //Other
    private int width;
    private int height;

    /**
     * Builds a JFrame with the specified width and height
     *
     * @param w width of the JFrame
     * @param h height of the JFrame
     */
    public Layout(int w, int h) {
        //Frame
        frame = new JFrame();

        //Panels
        taskButtons = new JPanel(new GridLayout(6,1));
        center = new JPanel();
        taskArea = new JPanel();
        completedArea = new JPanel();
        inProgress = new JPanel();

        //Labels and Text
        label = new JLabel("Hello");
        input = new JTextField(10);

        //Buttons
        addTask = new JButton("Add Task");
        editTask = new JButton("Edit Task");
        removeTask = new JButton("Remove Task");
        addCourse = new JButton("Add Course");
        editCourse = new JButton("Edit Course");
        removeCourse = new JButton("Remove Course");
        taskComplete = new JButton("TASK COMPLETE!");
        width = w;
        height = h;
    }

    /**
     * Sets up a mew JFrame window
     */
    public void setUp() {
        //Set layout for content Pane
        Container cp = frame.getContentPane();
        BorderLayout brdr = new BorderLayout();
        cp.setLayout(brdr);

        //Frame Properties
        frame.setSize(width, height);
        frame.setTitle("Tasker");


        //Add buttons to Task Buttons panel and add panel to frame
        taskButtons.add(addTask);
        taskButtons.add(editTask);
        taskButtons.add(removeTask);
        taskButtons.add(addCourse);
        taskButtons.add(editCourse);
        taskButtons.add(removeCourse);
        cp.add(taskButtons,BorderLayout.WEST);

        //Format and add task Complete button
        taskComplete.setBackground(Color.GREEN);
        taskComplete.setForeground(Color.BLACK);
        taskComplete.setRolloverEnabled(true);
        taskComplete.setFont(new Font("Cambria", Font.BOLD,20));
        cp.add(taskComplete,BorderLayout.SOUTH);

        //Set up center of the frame
        taskArea.setBorder(BorderFactory.createBevelBorder(1));
        taskArea.setBackground(Color.CYAN);
        completedArea.setBorder(BorderFactory.createLineBorder(Color.red));
        completedArea.setBackground(Color.gray);
        inProgress.setBorder(BorderFactory.createLineBorder(Color.yellow));
        inProgress.setBackground(Color.BLACK);

        //---------------GRIDBAG LAYOUT-------------------
        center.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        //Set Constraints and add panels

        //TaskArea Panel
        gc = setGridBagConstraints(10,1,0,0);
        gc.fill = GridBagConstraints.BOTH;
        gc.anchor = GridBagConstraints.WEST;
        center.add(taskArea, gc);

        //In Progress Panel
        gc = setGridBagConstraints(10,1,1,0);
        gc.fill = GridBagConstraints.BOTH;
        gc.anchor = GridBagConstraints.CENTER;
        center.add(inProgress, gc);

        //Completed Panel
        gc = setGridBagConstraints(10,1,2,0);
        gc.fill = GridBagConstraints.BOTH;
        gc.anchor = GridBagConstraints.EAST;
        center.add(completedArea,gc);

        cp.add(center,BorderLayout.CENTER);

        //Frame defaults
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public GridBagConstraints setGridBagConstraints(double wx, double wy, int gx, int gy){
        GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = wx;
        gc.weighty = wy;
        gc.gridx = gx;
        gc.gridy = gy;

        return gc;
    }


    /**
     * Create an action listener object for button clicks
     */
    public void setUpButtonListener() {
        //Button 1 action listener prints "Button 1 Clicked" to console
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }

        };
    }
}
