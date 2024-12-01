package view.member;

import dao.MemberDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;
import model.JenisMember;
import model.Member;

public class MemberButtonSimpanActionListener implements ActionListener {
    private MemberFrame memberFrame;  // Reference to the MemberFrame
    private MemberDao memberDao;  // Data access object for Member

    public MemberButtonSimpanActionListener(MemberFrame memberFrame, MemberDao memberDao) {
        this.memberFrame = memberFrame;  // Initialize with MemberFrame
        this.memberDao = memberDao;  // Initialize with MemberDao
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nama = this.memberFrame.getNama();  // Get the name from the form
        if (nama.isEmpty()) {
            this.memberFrame.showAlert("Nama tidak boleh kosong");  // Show alert if name is empty
        } else {
            JenisMember jenisMember = this.memberFrame.getJenisMember();  // Get the selected jenis member
            if (jenisMember == null) {
                this.memberFrame.showAlert("Jenis Member harus dipilih");  // Alert if jenis member is not selected
            } else {
                // Create new Member object
                Member member = new Member();
                member.setId(UUID.randomUUID().toString());  // Generate unique ID
                member.setNama(nama);
                member.setJenisMember(jenisMember);  // Set the jenis member
                member.setJenisMemberId(jenisMember.getId());

                this.memberFrame.addMember(member);  // Add the member to the table or list
                this.memberDao.insert(member);  // Save the new member to the database

                this.memberFrame.clearForm();  // Clear the form after saving
            }
        }
    }

    // Getters and setters (optional)
    public MemberFrame getMemberFrame() {
        return memberFrame;
    }

    public void setMemberFrame(MemberFrame memberFrame) {
        this.memberFrame = memberFrame;
    }

    public MemberDao getMemberDao() {
        return memberDao;
    }

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
}
