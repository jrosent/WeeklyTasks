package weeklytasks.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
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

    //Table
    JTable todoTable;
    JTable inProgressTable;
    JTable completedTable;

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

        //Add Tables to center panels
        String[] columns = {"Task Number","Task", "Due Date"};
        Object[][] tasks = {{"1","Do homework", "1/24/22"},{"2","Don't homework","12/25/22"},
                {"3","Tell Justin he's dumb", "12/16/22"}};
        todoTable = new JTable(tasks,columns);
        completedTable = new JTable(tasks,columns);
        TableColumn taskColumn0 = todoTable.getColumnModel().getColumn(0);
        TableColumn taskColumn = todoTable.getColumnModel().getColumn(1);
        TableColumn taskColumn2 = todoTable.getColumnModel().getColumn(2);
        TableColumn completeColumn0 = completedTable.getColumnModel().getColumn(0);
        TableColumn completeColumn = completedTable.getColumnModel().getColumn(1);
        TableColumn completeColumn2 = completedTable.getColumnModel().getColumn(2);
        taskColumn0.setPreferredWidth(5);
        taskColumn.setPreferredWidth(200);
        taskColumn2.setPreferredWidth(25);
        completeColumn0.setPreferredWidth(5);
        completeColumn.setPreferredWidth(200);
        completeColumn2.setPreferredWidth(25);
        JScrollPane toDoPane = new JScrollPane(todoTable);
        JScrollPane completedPane = new JScrollPane(completedTable);
        todoTable.setFillsViewportHeight(true);
        completedTable.setFillsViewportHeight(true);
        taskArea.setLayout(new GridBagLayout());
        completedArea.setLayout(new GridBagLayout());
        JLabel label1 = new JLabel("First Task List");
        JLabel label2 = new JLabel("First Task List");
        label1.setFont(new Font("Veranda", Font.BOLD,20));
        label2.setFont(new Font("Veranda", Font.BOLD,20));
        GridBagConstraints ta = new GridBagConstraints();
        ta = setGridBagConstraints(1,1,0,0,GridBagConstraints.NONE,
                GridBagConstraints.SOUTHWEST);
        taskArea.add(label1,ta);
        completedArea.add(label2,ta);
        ta = setGridBagConstraints(10,10,0,1,GridBagConstraints.BOTH,
                GridBagConstraints.NORTH);
        taskArea.add(toDoPane,ta);
        completedArea.add(completedPane,ta);


        //Set up center of the frame
        taskArea.setBorder(BorderFactory.createLineBorder(Color.BLUE,3));
        completedArea.setBorder(BorderFactory.createLineBorder(Color.red,3));
        inProgress.setBorder(BorderFactory.createLineBorder(Color.GREEN,3));


        //---------------GRIDBAG LAYOUT-------------------
        center.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        //Set Constraints and add panels to center

        //TaskArea Panel
        gc = setGridBagConstraints(1,1,0,0,GridBagConstraints.BOTH, GridBagConstraints.WEST);
        center.add(taskArea, gc);

        gc = setGridBagConstraints(.01,1,1,0,GridBagConstraints.BOTH, GridBagConstraints.CENTER);
        center.add(Box.createHorizontalStrut(10),gc);

        //Completed Panel
        gc = setGridBagConstraints(1,1,2,0,GridBagConstraints.BOTH,GridBagConstraints.EAST);
        center.add(completedArea,gc);

        //Add center to center of content pane
        cp.add(center,BorderLayout.CENTER);

        //Frame defaults
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public GridBagConstraints setGridBagConstraints(double wx, double wy, int gx, int gy,
                                                    int fill, int anchor){
        GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = wx;
        gc.weighty = wy;
        gc.gridx = gx;
        gc.gridy = gy;
        gc.fill = fill;
        gc.anchor = anchor;

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
