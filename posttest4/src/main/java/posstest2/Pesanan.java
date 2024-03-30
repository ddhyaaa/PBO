package posstest2;

public class Pesanan {
    private static int nextId = 1;
    private int id;
    private String Username;
    private Bunga bunga;
    private int jumlahPesanan;
    private String status;

    public Pesanan(String Username, Bunga bunga, int jumlahPesanan, String status) {
        this.id = nextId++;
        this.Username = Username; 
        this.bunga = bunga;
        this.jumlahPesanan = jumlahPesanan;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return Username;
    }

    public Bunga getBunga() {
        return bunga;
    }

    public int getJumlahPesanan() {
        return jumlahPesanan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getJumlah() {
        return jumlahPesanan;
    }
    public void display() {
        System.out.println("ID Pesanan: " + id);
        System.out.println("Username: " + Username); 
        System.out.println("Nama Bunga: " + bunga.getNama());
        System.out.println("Jumlah Pesanan: " + jumlahPesanan);
        System.out.println("Status: " + status);
        System.out.println("============================================");
    }
}
