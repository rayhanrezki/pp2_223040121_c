/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class MainFrame {
    public static void main(String[] args){
        
        //frame utama
        SwingUtilities.invokeLater(()->{
            JFrame frame = new JFrame("contoh konkurensi di swing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400,200);
            frame.setLayout(new BorderLayout());
            
            //status label
            JLabel statusLabel = new JLabel("tekan tombol untuk mulai tugas berat", JLabel.CENTER);
            
            //start process btn
            JButton startButton = new JButton("Mulai");
            
            //Progress bar
           JProgressBar progressBar = new JProgressBar(0,60);
           progressBar.setValue(0);
           progressBar.setStringPainted(true);
           
           //add component to frame
           frame.add(statusLabel, BorderLayout.NORTH);
           frame.add(progressBar, BorderLayout.CENTER);
           frame.add(startButton, BorderLayout.SOUTH);
           
           //action btn
           startButton.addActionListener(e->{
               startButton.setEnabled(false); //btn nonaktif saat proses
               statusLabel.setText("Proses berjalan");
              
               //swingworker utk tugas berat
               SwingWorker<Void, Integer> worker = new SwingWorker<>(){
                   @Override
                   protected Void doInBackground() throws Exception{
                       
                       //simulasi Tugas Berat
                       for(int i = 0; i <= 100; i++){
                            Thread.sleep(50); //simulasi delay
                            publish(i); //perbarui progress
                        }
                       return null;
                   }
                   
                   @Override
                   protected void process(List<Integer> chunks){
                       //perbarui progress bar
                       int LatestProgress = chunks.get(chunks.size()-1);
                       progressBar.setValue(LatestProgress);
                   }
                   
                   @Override
                   protected void done(){
                       //aksi setelah tugas selesai
                       startButton.setEnabled(true);
                       statusLabel.setText("Proses selesai");
                   }
               };
               
               //jalanin SwingWorker
               worker.execute();
           });
           
           //nampilin frame
           frame.setLocationRelativeTo(null);
           frame.setVisible(true);
        });
    }
}