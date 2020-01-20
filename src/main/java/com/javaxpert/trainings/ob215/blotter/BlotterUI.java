package com.javaxpert.trainings.ob215.blotter;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Main class for this demo
 * shows a frame with 2 Jlist instances
 * @author deadbrain
 */
public class BlotterUI extends JFrame {
    public static void main(String[] args) {
        new BlotterUI();
    }

    public BlotterUI(){
        super("Reuters Blotter");
        initComponents();
        initEvents();
    }

    private void initEvents(){
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
            }
        });
    }

    private void initComponents(){
        JPanel main_panel = (JPanel)getContentPane();
        JList list1 = new JList();
        list1.setModel(new DefaultListModel());

        JList list2 = new JList();
        list2.setModel(new DefaultListModel());

        main_panel.add(list1);
        main_panel.add(list2);
        pack();
        setVisible(true);
    }


}
