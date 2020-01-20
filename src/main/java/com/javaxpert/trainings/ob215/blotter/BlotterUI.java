package com.javaxpert.trainings.ob215.blotter;

import com.google.common.eventbus.EventBus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Main class for this demo
 * shows a frame with 2 Jlist instances
 * @author deadbrain
 */
public class BlotterUI extends JFrame {
    private EventBus bus;
    public static void main(String[] args) {
        new BlotterUI();
    }

    public BlotterUI(){
        super("Reuters Blotter");
        bus = new EventBus();
        bus.register(new MessageHandler());
        startMessageProducer();
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
        main_panel.setLayout(new FlowLayout());
        JList list1 = new JList();
        list1.setModel(new DefaultListModel());

        JList list2 = new JList();
        list2.setModel(new DefaultListModel());

        main_panel.add(list1);
        main_panel.add(list2);
        JButton button = new JButton("ok?");
        button.addActionListener(evt -> handleButtonPressed());
        pack();
        setVisible(true);
    }

    private void handleButtonPressed(){
        System.out.println("did someone clicked me ?");
    }
    private void startMessageProducer(){
        Runnable task= () -> {
            System.out.println("Producer is running");
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bus.post(new ReutersMessage("Another message", (short) 1, System.nanoTime()));
            }
        };
//        try {
//            SwingUtilities.invokeAndWait(task);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }

        // All code inside SwingWorker runs on a seperate thread
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            public Void  doInBackground() {
                task.run();
                return null;
            }
            @Override
            public void done() {
                // should be never here
                System.out.println("ok done....");
            }
        };

        // Call the SwingWorker from within the Swing thread
        worker.execute();
    }

}
