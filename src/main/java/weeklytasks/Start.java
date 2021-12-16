package weeklytasks;

import weeklytasks.ui.Layout;

import javax.swing.JFrame;

public class Start {

    public static void main(String[] args){
        Layout layout = new Layout(640,480);
        layout.setUp();
        layout.setUpButtonListener();
    }
}
