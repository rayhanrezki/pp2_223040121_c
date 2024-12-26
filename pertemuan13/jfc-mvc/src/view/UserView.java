/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.PropertyEditor;

/**
 *
 * @author ASUS
 */
public class UserView extends JFrame{
    private JTextField txtName = new JTextField(20); 
    private JTextField txtEmail = new JTextField(20); 
    private JButton btnAdd = new JButton("Add User"); 
    private JButton btnRefresh = new JButton("Refresh");
    private JButton btnExport = new JButton("Export"); 
    private JList<String> userList = new JList<>();
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private  JButton startButton = new JButton("Mulai");
    private  JProgressBar progressBar = new JProgressBar(0, 100);
    private JLabel statusLabel = new JLabel("Tekan tombol memulai", JLabel.CENTER);
    
    public UserView() {
        setTitle("User Management");
        setSize (400, 300);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel (new GridLayout (6, 1)); 
        panel.add(new JLabel ("Name:"));
        panel.add(txtName);
        panel.add(new JLabel("Email:")); 
        panel.add(txtEmail);

        JPanel buttonPanel = new JPanel(); 
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnRefresh);
        buttonPanel.add(btnExport); 
        buttonPanel.add(startButton);
        panel.add(buttonPanel);
        
        JPanel statusPanel = new JPanel();
        statusPanel.add(statusLabel, BorderLayout.NORTH);
        statusPanel.add(progressBar, BorderLayout.CENTER);

        userList.setModel(listModel);
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane (userList), BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);
    }

    public String getNameInput () { 
        return txtName.getText();
    }
    
    public String getEmailInput() {
        return txtEmail.getText();
    }

    public void setUserList (String[] users) {
        listModel.clear();
        for (String user : users) {
                listModel.addElement(user);
        }
    }
           
    public void addAddUserListener (ActionListener listener) { 
        btnAdd.addActionListener(listener);
    }

    public void addRefreshListener (ActionListener listener) { 
        btnRefresh.addActionListener(listener);
    }
    
    public void addExportListener (ActionListener listener) { 
        btnRefresh.addActionListener(listener);
    }
    
    public void addStartButtonListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }
    public JButton getStartButton() {
        return startButton;
    }
    public JProgressBar getProgressBar() {
        return progressBar;
    }
    public JLabel getStatusLabel() {
        return statusLabel;
    }
}