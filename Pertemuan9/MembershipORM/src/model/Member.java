package model;

public class Member {
    private String id;
    private String nama;
    private String jenisMemberId;
    private JenisMember jenisMember;

    // Constructor
    public Member() {
    }

    public Member(String id, String nama, String jenisMemberId, JenisMember jenisMember) {
        this.id = id;
        this.nama = nama;
        this.jenisMemberId = jenisMemberId;
        this.jenisMember = jenisMember;
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

    // Getter dan Setter untuk 'jenisMemberId'
    public String getJenisMemberId() {
        return jenisMemberId;
    }

    public void setJenisMemberId(String jenisMemberId) {
        this.jenisMemberId = jenisMemberId;
    }

    // Getter dan Setter untuk 'jenisMember'
    public JenisMember getJenisMember() {
        return jenisMember;
    }

    public void setJenisMember(JenisMember jenisMember) {
        this.jenisMember = jenisMember;
    }
}
