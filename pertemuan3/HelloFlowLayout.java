package pertemuan3;

import java.awt.*;
import javax.swing.*;

public class HelloFlowLayout extends JFrame {

  public HelloFlowLayout() {
    // Set the default close operation
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create buttons
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4"); // Fixed missing equals sign
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");
    JButton button10 = new JButton("10");

    // Set the layout manager to FlowLayout
    this.setLayout(new FlowLayout());

    // Add buttons to the frame
    this.add(button1);
    this.add(button2);
    this.add(button3);
    this.add(button4); // Corrected button4 instantiation
    this.add(button5);
    this.add(button6);
    this.add(button7);
    this.add(button8);
    this.add(button9);
    this.add(button10);

    // Set the frame size
    this.setSize(400, 400);
  }

  public static void main(String[] args) {
    // Run the application in the event-dispatching thread
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        HelloFlowLayout h = new HelloFlowLayout();
        h.setVisible(true);
      }
    });
  }
}
