/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.User;

/**
 *
 * @author ASUS
 */
public class UserView extends JFrame{
     private JTextField txtName = new JTextField(20); 
    private JTextField txtEmail = new JTextField(20); 
    private JTextField txtNPM = new JTextField(20);
    private JTextField txtAlamat = new JTextField(20);
    private JButton btnAdd = new JButton("Add User"); 
    private JButton btnRefresh = new JButton("Refresh"); 
    private JButton btnUpdate = new JButton("Update");
    private JButton btnDelete = new JButton("Delete");
    private JTable userTable = new JTable();
    private DefaultTableModel tableModel = new DefaultTableModel();
    
    public UserView() {
         setTitle("User Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(6, 1)); 
        panel.add(new JLabel("Name:"));
        panel.add(txtName);
        panel.add(new JLabel("Email:")); 
        panel.add(txtEmail);
        panel.add(new JLabel("NPM:"));
        panel.add(txtNPM);
        panel.add(new JLabel("Alamat:"));
        panel.add(txtAlamat);

        JPanel buttonPanel = new JPanel(); 
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnRefresh); 
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        panel.add(buttonPanel);

        tableModel.setColumnIdentifiers(new String[]{"ID", "Name", "Email", "NPM", "Alamat"});
        userTable.setModel(tableModel);
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(userTable), BorderLayout.CENTER);
    }

   public String getNameInput() { 
        return txtName.getText();
    }

    public String getEmailInput() {
        return txtEmail.getText();
    }

    public int getNPMInput() {
        try {
            return Integer.parseInt(txtNPM.getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String getAlamatInput() {
        return txtAlamat.getText();
    }

    public void setTableData(List<User> users) {
        tableModel.setRowCount(0);
        for (User user : users) {
            tableModel.addRow(new Object[]{user.getId(), user.getName(), user.getEmail(), user.getNpm(), user.getAlamat()});
        }
    }

    public int getSelectedRow() {
        return userTable.getSelectedRow();
    }

    public int getSelectedUserId() {
        int selectedRow = getSelectedRow();
        return (int) tableModel.getValueAt(selectedRow, 0);
    }

    public User getSelectedUser() {
        int selectedRow = getSelectedRow();
        User user = new User();
        user.setId((int) tableModel.getValueAt(selectedRow, 0));
        user.setName((String) tableModel.getValueAt(selectedRow, 1));
        user.setEmail((String) tableModel.getValueAt(selectedRow, 2));
        user.setNpm((int) tableModel.getValueAt(selectedRow, 3));
        user.setAlamat((String) tableModel.getValueAt(selectedRow, 4));
        return user;
    }

    public void addAddUserListener(ActionListener listener) { 
        btnAdd.addActionListener(listener);
    }

    public void addRefreshListener(ActionListener listener) { 
        btnRefresh.addActionListener(listener);
    }

    public void addUpdateUserListener(ActionListener listener) {
        btnUpdate.addActionListener(listener);
    }

    public void addDeleteUserListener(ActionListener listener) {
        btnDelete.addActionListener(listener);
    }
    
}