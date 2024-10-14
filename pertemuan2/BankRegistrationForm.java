package pertemuan2;

import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.text.SimpleDateFormat;

public class BankRegistrationForm extends JFrame {

  public BankRegistrationForm() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Bank Registration Form");

    // Labels and text fields for name and phone number
    JLabel labelInputNama = new JLabel("Nama: ");
    labelInputNama.setBounds(15, 30, 350, 10);

    JLabel labelInputHP = new JLabel("No HP: ");
    labelInputHP.setBounds(15, 90, 350, 10);

    JTextField textFieldNama = new JTextField();
    textFieldNama.setBounds(15, 50, 350, 30);

    JTextField textFieldHP = new JTextField();
    textFieldHP.setBounds(15, 110, 350, 30);

    // Radio buttons for gender
    JLabel labelRadio = new JLabel("Jenis Kelamin : ");
    labelRadio.setBounds(15, 150, 350, 10);

    JRadioButton radioButton1 = new JRadioButton("Laki-Laki", true);
    radioButton1.setBounds(15, 165, 350, 30);

    JRadioButton radioButton2 = new JRadioButton("Perempuan");
    radioButton2.setBounds(15, 195, 350, 30);

    ButtonGroup bg = new ButtonGroup();
    bg.add(radioButton1);
    bg.add(radioButton2);

    // JList for selecting type of savings account
    JLabel labelSavings = new JLabel("Jenis Tabungan: ");
    labelSavings.setBounds(15, 230, 350, 10);

    String[] savingsTypes = { "Tabungan Biasa", "Tabungan Pendidikan", "Tabungan Investasi", "Tabungan Bisnis" };
    JList<String> listSavings = new JList<>(savingsTypes);
    listSavings.setBounds(15, 250, 350, 70);
    listSavings.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    // JSpinner for transaction frequency
    JLabel labelTransactionFreq = new JLabel("Frekuensi Transaksi / Bulan: ");
    labelTransactionFreq.setBounds(15, 330, 350, 10);

    JSpinner spinnerFreq = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
    spinnerFreq.setBounds(15, 350, 100, 30);

    // Password and confirm password fields
    JLabel labelPassword = new JLabel("Password: ");
    labelPassword.setBounds(15, 390, 350, 10);

    JPasswordField passwordField = new JPasswordField();
    passwordField.setBounds(15, 410, 350, 30);

    JLabel labelConfirmPassword = new JLabel("Confirm Password: ");
    labelConfirmPassword.setBounds(15, 450, 350, 10);

    JPasswordField confirmPasswordField = new JPasswordField();
    confirmPasswordField.setBounds(15, 470, 350, 30);

    // Date of birth spinner
    JLabel labelDOB = new JLabel("Tanggal Lahir: ");
    labelDOB.setBounds(15, 510, 350, 10);

    SpinnerDateModel dateModel = new SpinnerDateModel(new Date(), null, null, java.util.Calendar.YEAR);
    JSpinner spinnerDOB = new JSpinner(dateModel);
    JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinnerDOB, "dd/MM/yyyy");
    spinnerDOB.setEditor(dateEditor);
    spinnerDOB.setBounds(15, 530, 150, 30);

    // Output area
    JTextArea txtOutput = new JTextArea("");
    txtOutput.setBounds(15, 580, 350, 150);

    // Button for submitting data
    JButton button = new JButton("Simpan");
    button.setBounds(15, 740, 100, 40);

    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Get selected gender
        String jenisKelamin = "";
        if (radioButton1.isSelected()) {
          jenisKelamin = radioButton1.getText();
        } else if (radioButton2.isSelected()) {
          jenisKelamin = radioButton2.getText();
        }

        // Get name and phone number
        String name = textFieldNama.getText();
        String hp = textFieldHP.getText();

        // Get selected savings type
        String savingsType = listSavings.getSelectedValue();

        // Get transaction frequency
        int freq = (int) spinnerFreq.getValue();

        // Get date of birth
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dob = sdf.format(spinnerDOB.getValue());

        // Check if passwords match
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());
        String passwordMatch = password.equals(confirmPassword) ? "Passwords match" : "Passwords do not match";

        // Output to the text area
        txtOutput.setText("Nama: " + name + "\nNo HP: " + hp + "\nJenis Kelamin: " + jenisKelamin +
            "\nJenis Tabungan: " + savingsType + "\nFrekuensi Transaksi: " + freq +
            "\nTanggal Lahir: " + dob + "\n" + passwordMatch);

        // Clear fields after submission
        textFieldNama.setText("");
        textFieldHP.setText("");
        bg.clearSelection();
        passwordField.setText("");
        confirmPasswordField.setText("");
        listSavings.clearSelection();
        spinnerFreq.setValue(1);
      }
    });

    // Menu bar with Reset and Exit
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Menu");
    JMenuItem resetItem = new JMenuItem("Reset");
    JMenuItem exitItem = new JMenuItem("Exit");

    resetItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Clear all inputs and output
        textFieldNama.setText("");
        textFieldHP.setText("");
        bg.clearSelection();
        passwordField.setText("");
        confirmPasswordField.setText("");
        txtOutput.setText("");
        listSavings.clearSelection();
        spinnerFreq.setValue(1);
      }
    });

    exitItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    menu.add(resetItem);
    menu.add(exitItem);
    menuBar.add(menu);
    this.setJMenuBar(menuBar);

    // Add components to the frame
    this.add(button);
    this.add(textFieldNama);
    this.add(textFieldHP);
    this.add(labelRadio);
    this.add(radioButton1);
    this.add(radioButton2);
    this.add(labelInputNama);
    this.add(labelInputHP);
    this.add(labelSavings);
    this.add(listSavings);
    this.add(labelTransactionFreq);
    this.add(spinnerFreq);
    this.add(labelPassword);
    this.add(passwordField);
    this.add(labelConfirmPassword);
    this.add(confirmPasswordField);
    this.add(labelDOB);
    this.add(spinnerDOB);
    this.add(txtOutput);

    // Set frame properties
    this.setSize(400, 850);
    this.setLayout(null);
  }

  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        BankRegistrationForm form = new BankRegistrationForm();
        form.setVisible(true);
      }
    });
  }
}