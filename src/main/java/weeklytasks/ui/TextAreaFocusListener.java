package weeklytasks.ui;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TextAreaFocusListener implements FocusListener {
    private final JTextArea textArea;
    TextAreaFocusListener(JTextArea textArea){
        this.textArea = textArea;
        textArea.addFocusListener(this);
    }
    @Override
    public void focusGained(FocusEvent e) {
        textArea.setText("");
    }

    @Override
    public void focusLost(FocusEvent e) {
    }
}
