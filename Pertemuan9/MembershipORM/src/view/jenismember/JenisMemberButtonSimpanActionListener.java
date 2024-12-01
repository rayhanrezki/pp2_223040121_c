package view.jenismember;

import dao.JenisMemberDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;
import model.JenisMember;

public class JenisMemberButtonSimpanActionListener implements ActionListener {

    private JenisMemberFrame jenisMemberFrame;
    private JenisMemberDao jenisMemberDao;

    public JenisMemberButtonSimpanActionListener(JenisMemberFrame jenisMemberFrame, JenisMemberDao jenisMemberDao) {
        this.jenisMemberFrame = jenisMemberFrame;
        this.jenisMemberDao = jenisMemberDao;
    }

    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public void actionPerformed(ActionEvent e) {
        // Retrieve the name input from the frame
        String nama = this.jenisMemberFrame.getNama();

        // Validate input
        if (nama == null || nama.trim().isEmpty()) {
            // Optionally, show an error message to the user
            this.jenisMemberFrame.showErrorMessage("Nama tidak boleh kosong.");
            return;
        }

        // Create a new JenisMember object
        JenisMember jenisMember = new JenisMember();
        jenisMember.setId(UUID.randomUUID().toString()); // Generate a unique ID
        jenisMember.setNama(nama);

        // Try inserting into the database and handling errors
        try {
            this.jenisMemberDao.insert(jenisMember);  // Insert into the database
            this.jenisMemberFrame.addJenisMember(jenisMember); // Update the frame/UI with new data
            // Optionally, show a success message
            this.jenisMemberFrame.showSuccessMessage("Jenis Member berhasil disimpan.");
        } catch (Exception ex) {
            // Handle the exception if the insertion fails
            this.jenisMemberFrame.showErrorMessage("Terjadi kesalahan saat menyimpan data.");
            ex.printStackTrace();
        }
    }

    public JenisMemberDao getJenisMemberDao() {
        return jenisMemberDao;
    }

    public void setJenisMemberDao(JenisMemberDao jenisMemberDao) {
        this.jenisMemberDao = jenisMemberDao;
    }

    public JenisMemberFrame getJenisMemberFrame() {
        return jenisMemberFrame;
    }

    public void setJenisMemberFrame(JenisMemberFrame jenisMemberFrame) {
        this.jenisMemberFrame = jenisMemberFrame;
    }
}
