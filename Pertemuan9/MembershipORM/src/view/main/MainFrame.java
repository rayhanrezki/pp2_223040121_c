package view.main;

import dao.JenisMemberDao;
import dao.MemberDao;
import java.awt.FlowLayout;  // Corrected typo
import javax.swing.JButton;
import javax.swing.JFrame;
import view.jenismember.JenisMemberFrame;


public class MainFrame extends JFrame {

    public MainFrame(JenisMemberDao jenisMemberDao1, MemberDao memberDao1) {
    }
    private JenisMemberFrame jenisMemberFrame;
    private MemberFrame memberFrame;
    private JButton buttonJenisMember;
    private JButton buttonMember;
    private JenisMemberDao jenisMemberDao;
    private MemberDao memberDao;

    public void MemberFrame(JenisMemberDao jenisMemberDao, MemberDao memberDao) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(400, 500);

        this.jenisMemberDao = jenisMemberDao;
        this.memberDao = memberDao;

        this.jenisMemberFrame = new JenisMemberFrame(jenisMemberDao);
        this.memberFrame = new MemberFrame(memberDao, jenisMemberDao);

        this.setLayout(new FlowLayout());
        MainButtonActionListener actionListener = new MainButtonActionListener(this);

        this.buttonJenisMember = new JButton("Jenis Member");
        this.buttonMember = new JButton("Member");

        this.buttonJenisMember.addActionListener(actionListener);
        this.buttonMember.addActionListener(actionListener);

        this.add(buttonJenisMember);  // Corrected 'This' to 'this'
        this.add(buttonMember);
    }

    public JButton getButtonJenisMember() {
        return buttonJenisMember;
    }

    public JButton getButtonMember() {
        return buttonMember;
    }

    public void showJenisMemberFrame() {
        if (jenisMemberFrame == null) {
            jenisMemberFrame = new JenisMemberFrame(jenisMemberDao);
        }
        jenisMemberFrame.setVisible(true);
    }

    public void showMemberFrame() {
        if (memberFrame == null) {
            memberFrame = new MemberFrame(memberDao, jenisMemberDao);
        }
        memberFrame.populateComboJenis();  // Ensure populateComboJenis method exists
        memberFrame.setVisible(true);
    }

    public MemberFrame getMemberFrame() {
        return memberFrame;
    }

    public void setMemberFrame(MemberFrame memberFrame) {
        this.memberFrame = memberFrame;
    }

    private static class MemberFrame {

        public MemberFrame() {
        }
    }
}
