package posstest2;

public class Bunga {
    int Id;
    String Nama;
    String Warna;
    String Asal;
    double Harga;
    int Stok;

    public Bunga(int Id, String Nama, String Warna, String Asal, double Harga, int Stok) {
        this.Id = Id;
        this.Nama = Nama;
        this.Warna = Warna;
        this.Asal = Asal;
        this.Harga = Harga;
        this.Stok = Stok;
    }

    public int getId() {
        return Id;
    }

    public String getNama() {
        return Nama;
    }

    public String getWarna() {
        return Warna;
    }

    public String getAsal() {
        return Asal;
    }

    public double getHarga() {
        return Harga;
    }

    public int getStok() {
        return Stok;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public void setWarna(String Warna) {
        this.Warna = Warna;
    }

    public void setAsal(String Asal) {
        this.Asal = Asal;
    }

    public void setHarga(double Harga) {
        this.Harga = Harga;
    }

    public void setStok(int Stok) {
        this.Stok = Stok;
    }

    public void kurangiStok(int jumlah) {
        this.Stok -= jumlah;
    }

    public void tambahStok(int jumlah) {
        this.Stok += jumlah;
    }
    

    void display() {
        System.out.println("=================================");
        System.out.println("ID Bunga    : " + this.Id);
        System.out.println("Nama Bunga  : " + this.Nama);
        System.out.println("Warna Bunga : " + this.Warna);
        System.out.println("Asal Bunga  : " + this.Asal);
        System.out.println("Harga Bunga : Rp " + this.Harga);
        System.out.println("Stok Bunga  : " + this.Stok);
    }
}
