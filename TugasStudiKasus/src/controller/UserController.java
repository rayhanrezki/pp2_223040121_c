/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.*;
import view.UserView;

import javax.swing.*;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.util.List;

/**
 *
 * @author ASUS
 */
public class UserController {
    private UserView view;
    private UserMapper mapper;
    
    public UserController(UserView view, UserMapper mapper) {
        this.view = view;
        this.mapper = mapper;

        this.view.addAddUserListener(new AddUserListener()); 
        this.view.addRefreshListener(new RefreshListener());
        this.view.addUpdateUserListener(new UpdateUserListener());
        this.view.addDeleteUserListener(new DeleteUserListener());
    }
    
    class AddUserListener implements ActionListener {
         @Override
        public void actionPerformed(ActionEvent e) { 
            String name = view.getNameInput();
            String email = view.getEmailInput();
            int npm = view.getNPMInput();
            String alamat = view.getAlamatInput();

            if (!name.isEmpty() && !email.isEmpty() && npm != -1 && !alamat.isEmpty()) {
                User user = new User();
                user.setName(name);
                user.setEmail(email);
                user.setNpm(npm);
                user.setAlamat(alamat);
                mapper.insertUser(user);
                JOptionPane.showMessageDialog(view, "User added successfully!");
                refreshUserList();
            } else {
                JOptionPane.showMessageDialog(view, "Please fill in all fields.");
            }
        }
    }

    class RefreshListener implements ActionListener {
         @Override
        public void actionPerformed(ActionEvent e) {
            refreshUserList();
        }
    }
    
    private void refreshUserList() {
        List<User> users = mapper.getAllUsers();
        view.setTableData(users);
    }
    
     class UpdateUserListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = view.getSelectedRow();
        if (selectedRow >= 0) {
            User user = view.getSelectedUser();
            System.out.println("Updating user: " + user); // Log untuk melihat isi user
            mapper.updateUser(user);
            JOptionPane.showMessageDialog(view, "User updated successfully!");
            refreshUserList();
        } else {
            JOptionPane.showMessageDialog(view, "Please select a user to update.");
        }
    }
}
     
      class DeleteUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = view.getSelectedRow();
            if (selectedRow >= 0) {
                int userId = view.getSelectedUserId();
                mapper.deleteUser(userId);
                JOptionPane.showMessageDialog(view, "User deleted successfully!");
                refreshUserList();
            } else {
                JOptionPane.showMessageDialog(view, "Please select a user to delete.");
            }
        }
    }
}