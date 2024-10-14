package pertemuan4;

import javax.swing.*;
import java.awt.event.*;

public class buttonexample {

  public static void main(String[] args) {
    // Membuat frame baru
    JFrame frame = new JFrame("Button Example");

    // Membuat tombol baru
    JButton button = new JButton("pencet aku");

    // Menambahkan ActionListener ke JButton
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked!");
      }
    });

    // Menentukan posisi dan ukuran tombol
    button.setBounds(50, 50, 150, 30);

    // Menambahkan tombol ke frame
    frame.add(button);

    // Mengatur ukuran frame
    frame.setSize(300, 200);

    // Menonaktifkan layout manager
    frame.setLayout(null);

    // Menampilkan frame
    frame.setVisible(true);

    // Mengatur default close operation
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
