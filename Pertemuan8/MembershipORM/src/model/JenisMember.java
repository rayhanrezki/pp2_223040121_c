package model;

public class JenisMember {
    private String id;
    private String nama;

    // Constructor default
    public JenisMember() {
    }

    // Constructor dengan parameter
    public JenisMember(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    // Getter dan Setter untuk 'id'
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter dan Setter untuk 'nama'
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
