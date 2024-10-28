package pertemuan6;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AplikasiDemo extends JFrame {
    private JTextField textField;
    private JTextArea textArea;
    private JRadioButton radioButton1, radioButton2;
    private JCheckBox checkBox1, checkBox2;
    private JComboBox<String> comboBox;
    private JList<String> list;
    private JSlider slider;
    private JSpinner spinner;
    private JTable table;
    private DefaultTableModel tableModel;

    public AplikasiDemo() {
        // Set title and default close operation
        setTitle("Aplikasi Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Set up menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem menuItem1 = new JMenuItem("Form Input");
        JMenuItem menuItem2 = new JMenuItem("Keluar");
        menuItem2.addActionListener(e -> System.exit(0));

        menu.add(menuItem1);
        menu.add(menuItem2);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Main panel
        JPanel panel = new JPanel(new GridLayout(3, 1));

        // Form panel
        JPanel formPanel = new JPanel(new GridLayout(8, 2));

        // JTextField
        formPanel.add(new JLabel("Nama:"));
        textField = new JTextField();
        formPanel.add(textField);

        // JTextArea
        formPanel.add(new JLabel("Alamat:"));
        textArea = new JTextArea(3, 20);
        formPanel.add(new JScrollPane(textArea));

        // JRadioButton
        formPanel.add(new JLabel("Gender:"));
        radioButton1 = new JRadioButton("Laki-laki");
        radioButton2 = new JRadioButton("Perempuan");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(radioButton1);
        genderGroup.add(radioButton2);
        JPanel radioPanel = new JPanel();
        radioPanel.add(radioButton1);
        radioPanel.add(radioButton2);
        formPanel.add(radioPanel);

        // JCheckBox
        formPanel.add(new JLabel("Hobi:"));
        checkBox1 = new JCheckBox("Membaca");
        checkBox2 = new JCheckBox("Bersepeda");
        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.add(checkBox1);
        checkBoxPanel.add(checkBox2);
        formPanel.add(checkBoxPanel);

        // JComboBox
        formPanel.add(new JLabel("Pendidikan:"));
        comboBox = new JComboBox<>(new String[] { "SMA", "D3", "S1", "S2" });
        formPanel.add(comboBox);

        // JList
        formPanel.add(new JLabel("Jurusan:"));
        list = new JList<>(new String[] { "Informatika", "Sistem Informasi", "Teknik Elektro" });
        formPanel.add(new JScrollPane(list));

        // JSlider
        formPanel.add(new JLabel("Pengalaman (tahun):"));
        slider = new JSlider(0, 10, 0);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        formPanel.add(slider);

        // JSpinner
        formPanel.add(new JLabel("Usia:"));
        spinner = new JSpinner(new SpinnerNumberModel(18, 18, 60, 1));
        formPanel.add(spinner);

        panel.add(formPanel);

        // JTable
        String[] columnNames = { "Nama", "Alamat", "Gender", "Hobi", "Pendidikan", "Jurusan", "Pengalaman", "Usia" };
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        panel.add(new JScrollPane(table));

        // Button to add data to table
        JButton addButton = new JButton("Tambah Data");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = textField.getText();
                String alamat = textArea.getText();
                String gender = radioButton1.isSelected() ? "Laki-laki" : "Perempuan";
                String hobi = "";
                if (checkBox1.isSelected())
                    hobi += "Membaca ";
                if (checkBox2.isSelected())
                    hobi += "Bersepeda";
                String pendidikan = (String) comboBox.getSelectedItem();
                String jurusan = list.getSelectedValue();
                int pengalaman = slider.getValue();
                int usia = (int) spinner.getValue();

                tableModel.addRow(new Object[] { nama, alamat, gender, hobi, pendidikan, jurusan, pengalaman, usia });
            }
        });

        panel.add(addButton);

        // Add panel to frame
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AplikasiDemo::new);
    }
}
