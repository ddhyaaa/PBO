public class Bunga{
    int Id;
    String Nama;
    String Warna;
    String Asal;
    double Harga;
    int Stok;

    public Bunga (int Ids, String Namas, String Warnas, String Asals, double Hargas, int Stoks){
        this.Id = Ids;
        this.Nama = Namas;
        this.Warna = Warnas;
        this.Asal = Asals;
        this.Harga = Hargas;
        this.Stok = Stoks;
    }

    public int getId() {
        return Id;
    }

    public void setNama(String Namas){
        this.Nama = Namas;
    }
    
    public void setWarna(String Warnas ){
        this.Warna = Warnas;
    }
    
    public void setAsal(String Asals){
        this.Asal = Asals;
    }
    
    public void setHarga(double Hargas){
        this.Harga = Hargas;
    }
    
    public void setStok(int Stoks){
        this.Stok = Stoks;
    }

    void display(){
        System.out.println("ID Bunga    : " + this.Id);
        System.out.println("Nama Bunga  : " + this.Nama);
        System.out.println("Warna Bunga : " + this.Warna);
        System.out.println("Asal Bunga  : " + this.Asal);
        System.out.println("Harga Bunga : Rp " + this.Harga);
        System.out.println("Stok Bunga  : " + this.Stok);
        System.out.println("=================================");
    }
}