package main;

import dao.JenisMemberDao;
import dao.MemberDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import view.main.MainFrame;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml"; // Nama file konfigurasi MyBatis
        SqlSessionFactory sqlSessionFactory = null;

        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            System.err.println("Gagal memuat konfigurasi MyBatis: " + e.getMessage());
            e.printStackTrace();
            return;  // Hentikan eksekusi jika konfigurasi gagal dimuat
        }

        // Inisialisasi DAOs
        JenisMemberDao jenisMemberDao = new JenisMemberDao(sqlSessionFactory);
        MemberDao memberDao = new MemberDao(sqlSessionFactory);

        // Membuat dan menampilkan GUI
        MainFrame f = new MainFrame(jenisMemberDao, memberDao);

        javax.swing.SwingUtilities.invokeLater(() -> {
            f.setVisible(true);  // Menampilkan jendela utama aplikasi
        });
    }
}
