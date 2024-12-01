package view.jenismember;

import dao.JenisMemberDao;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.JenisMember;

public class JenisMemberFrame extends JFrame {

    private List<JenisMember> jenisMemberList;  // Corrected the type to JenisMember
    private JTextField textFieldNama;
    private JenisMemberTableModel tableModel;
    private JenisMemberDao jenisMemberDao;

    public JenisMemberFrame(JenisMemberDao jenisMemberDao) {
        this.jenisMemberDao = jenisMemberDao;
        this.jenisMemberList = jenisMemberDao.findAll();  // Assuming findAll() returns a List<JenisMember>
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create and configure components
        JLabel labelInput = new JLabel("Nama:");
        labelInput.setBounds(15, 40, 350, 20);

        textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);

        JButton button = new JButton("Simpan");
        button.setBounds(15, 100, 350, 30);  // Adjusted position to avoid overlap

        JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 150, 350, 200);

        // Initialize the table model and set it to the JTable
        tableModel = new JenisMemberTableModel(jenisMemberList);
        table.setModel(tableModel);

        // Register the button's action listener
        JenisMemberButtonSimpanActionListener actionListener = 
            new JenisMemberButtonSimpanActionListener(this, jenisMemberDao);
        button.addActionListener(actionListener);  // Fixed typo here

        // Add components to the frame
        this.add(button);
        this.add(textFieldNama);
        this.add(labelInput);
        this.add(scrollableTable);

        // Set frame properties
        this.setSize(400, 500);
        this.setLayout(null);  // For absolute positioning
    }

    public String getNama() {
        return textFieldNama.getText();
    }

    // Method to add a new JenisMember to the table model
    public void addJenisMember(JenisMember jenisMember) {
        tableModel.add(jenisMember);  // Assumed 'add' method exists in the table model
        textFieldNama.setText("");  // Clear the text field after adding
    }

    public List<JenisMember> getJenisMemberList() {
        return jenisMemberList;
    }

    public void setJenisMemberList(List<JenisMember> jenisMemberList) {
        this.jenisMemberList = jenisMemberList;
    }

    public JTextField getTextFieldNama() {
        return textFieldNama;
    }

    public void setTextFieldNama(JTextField textFieldNama) {
        this.textFieldNama = textFieldNama;
    }

    public JenisMemberTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(JenisMemberTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public JenisMemberDao getJenisMemberDao() {
        return jenisMemberDao;
    }

    public void setJenisMemberDao(JenisMemberDao jenisMemberDao) {
        this.jenisMemberDao = jenisMemberDao;
    }

    void showErrorMessage(String terjadi_kesalahan_saat_menyimpan_data) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void showSuccessMessage(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showSuccessMessage'");
    }
}
