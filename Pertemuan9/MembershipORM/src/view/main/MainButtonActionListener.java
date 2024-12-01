package view.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainButtonActionListener implements ActionListener {

    private MainFrame mainFrame;

    public MainButtonActionListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public MainButtonActionListener() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Check which button was clicked and show the corresponding frame
        if (e.getSource() == mainFrame.getButtonJenisMember()) {
            mainFrame.showJenisMemberFrame();  // Show the JenisMember frame
        } else if (e.getSource() == mainFrame.getButtonMember()) {
            mainFrame.showMemberFrame();  // Show the Member frame
        } else {
            // Optionally, handle other buttons in the future or log unexpected actions
            System.out.println("Unhandled button click: " + e.getSource());
        }
    }

    // Getter and Setter for MainFrame
    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
}
