package pertemuan1;

import javax.swing.*;

public class HelloWorldSwing {

    private static void createAndShowGUI() {
        // Create the frame (window)
        JFrame frame = new JFrame("HelloWorldSwing");
        // Set the default close operation to exit when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create a label with the text "Hello World"
        JLabel label = new JLabel("Hello World");
        // Add the label to the frame
        frame.getContentPane().add(label);
        // Adjust the frame size to fit the components
        frame.pack();
        // Make the frame visible
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Use the event dispatch thread to build the GUI
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
