
package posstest2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Admin extends Akun {
    private int nextID = 1;
    private double Harga = 0;
    private int Stok = 0;
    private boolean cekHarga = false;
    private boolean cekStok = false;

    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private String priv = "Admin";
    private ArrayList<Bunga> DataBunga;

    public Admin(String username, String password, String priv) {
        super(username, password);
        this.priv = priv;
        DataBunga = new ArrayList<>();
    }

    public String getPriv() {
        return priv;
    }

    public ArrayList<Bunga> getDataBunga() {
        return DataBunga;
    }

    public void tambah_data() throws NumberFormatException, IOException{
        System.out.println("============================================");
        System.out.println("          >>  Tambah Data Bunga <<          ");
        System.out.println("============================================");
        String Nama = "";
        String Warna = "";
        String Asal = "";
        System.out.println("(ketik '00' untuk kembali)");
        while (true) {
            System.out.print("Nama Bunga      : ");
            Nama = input.readLine().trim();
            if (Nama.equals("00")) {
                System.out.println("Keluar dari menu tambah data");
                return;
            } else if (Nama.isEmpty()) {
                System.out.println(">> Nama tidak boleh kosong.");
            } else {
                break;
            }
        }
        while (Warna.isEmpty()) {
        System.out.print("Warna Bunga     : ");
        Warna = input.readLine().trim();
            if (Warna.isEmpty()) {
                System.out.println(">> Warna tidak boleh kosong.");
                }
            }
        while (Asal.isEmpty()) {
        System.out.print("Asal Bunga      : ");
        Asal = input.readLine().trim();
            if (Asal.isEmpty()) {
                System.out.println("Asal tidak boleh kosong.");
                }
            }
        cekHarga = false; 
        cekStok = false;
        while (!cekHarga) {
            System.out.print("Harga Bunga     : Rp ");
            try {
                Harga = Double.parseDouble(input.readLine());
                if (Harga > 0) {
                        cekHarga = true; 
                } else {
                        System.out.println(">> Harga harus lebih besar dari 0.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println(">> Masukan tidak valid!");
                }
            }
            while (!cekStok) {
                System.out.print("Jumlah Bunga    : ");
                try {
                    Stok = Integer.parseInt(input.readLine());
                    if (Stok > 0) {
                        cekStok = true; 
                    } else {
                        System.out.println(">> Stok harus lebih besar dari 0.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println(">> Masukan tidak valid!");
                }
            }
        Bunga bga = new Bunga(nextID++, Nama, Warna, Asal, Harga, Stok);
        DataBunga.add(bga);
        System.out.println("Data berhasil disimpan!");
    }
    
    public void Display(){
        if (DataBunga.isEmpty()) {
            System.out.println("Tidak ada data yang tersedia.");
            return;
        }
        for (int i=0; i<DataBunga.size(); i++){
            DataBunga.get(i).Display();
        }
    }

    public void update_bunga() throws IOException {
        System.out.println("============================================");
        System.out.println("          >>  Update Data Bunga <<          ");
        System.out.println("============================================");
        System.out.println("(ketik '00' untuk kembali)");
        System.out.print("Masukkan ID bunga yang ingin diupdate : ");
        String userInput = input.readLine().trim();
        
        if(userInput.equals("00")) {
            System.out.println("Keluar dari menu update data bunga.");
            return;
        }
        
        int idToUpdate;
        try {
            idToUpdate = Integer.parseInt(userInput);
        } catch(NumberFormatException e) {
            System.out.println("Masukan tidak valid!");
            return; 
        }
        
        boolean found = false;
        for (Bunga bunga : DataBunga) {
            if (bunga.getId() == idToUpdate) {
                System.out.println("Bunga ID " + idToUpdate + " ditemukan.");
                System.out.println("Masukkan informasi baru untuk bunga:");
                System.out.println("============================================");
                String Nama = "";
                String Warna = "";
                String Asal = "";
                while (Nama.isEmpty()) {
                    System.out.print("Nama Bunga      : ");
                    Nama = input.readLine().trim();
                    if (Nama.isEmpty()) {
                        System.out.println(">> Nama tidak boleh kosong.");
                    }
                }
                while (Warna.isEmpty()) {
                    System.out.print("Warna Bunga     : ");
                    Warna = input.readLine().trim();
                    if (Warna.isEmpty()) {
                        System.out.println(">> Warna tidak boleh kosong.");
                    }
                }
                while (Asal.isEmpty()) {
                    System.out.print("Asal Bunga      : ");
                    Asal = input.readLine().trim();
                    if (Asal.isEmpty()) {
                        System.out.println("Asal tidak boleh kosong.");
                    }
                }
                cekHarga = false; 
                cekStok = false;
                while (!cekHarga) {
                    System.out.print("Harga Bunga     :  Rp ");
                    try {
                        Harga = Double.parseDouble(input.readLine());
                        if (Harga > 0) {
                            cekHarga = true; 
                        } else {
                            System.out.println(">> Harga harus lebih besar dari 0.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(">> Masukan tidak valid!");
                    }
                }
                while (!cekStok) {
                    System.out.print("Jumlah Bunga    : ");
                    try {
                        Stok = Integer.parseInt(input.readLine());
                        if (Stok > 0) {
                            cekStok = true; 
                        } else {
                            System.out.println(">> Stok harus lebih besar dari 0.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(">> Masukan tidak valid!");
                    }
                }
    
                bunga.setNama(Nama);
                bunga.setWarna(Warna);
                bunga.setAsal(Asal);
                bunga.setHarga(Harga);
                bunga.setStok(Stok);
    
                found = true;
                break;
            }
        }
    
        if (!found) {
            System.out.println("Bunga ID " + idToUpdate + " tidak ditemukan.");
        } else {
            System.out.println("Data bunga berhasil diupdate!");
        }
    }

    public void hapus_bunga() throws IOException {
        if (DataBunga.isEmpty()) {
            System.out.println("Tidak ada data yang tersedia.");
            return;
        }
    
        System.out.println("============================================");
        System.out.println("          >>  Hapus Data Bunga  <<          ");
        System.out.println("============================================");
        System.out.println("(ketik '00' untuk kembali)");
        System.out.print("Masukkan ID bunga yang ingin dihapus: ");
        String inputId = input.readLine().trim();
        if (inputId.equals("00")) {
            System.out.println("Keluar dari penghapusan data.");
            return;
        }
    
        int idToDelete = 0;
        try {
            idToDelete = Integer.parseInt(inputId);
        } catch(NumberFormatException e) {
            System.out.println("Masukan tidak valid! Harap masukkan angka.");
            return;
        }
    
        boolean found = false;
        for (Iterator<Bunga> iterator = DataBunga.iterator(); iterator.hasNext();) {
            Bunga bunga = iterator.next();
            if (bunga.getId() == idToDelete) {
                System.out.println("Bunga ID " + idToDelete + " berhasil dihapus.");
                iterator.remove();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Bunga ID " + idToDelete + " tidak ditemukan.");
        }
    }    
        public void main_menu() throws IOException {
            boolean exit = true;
            while (exit) {
                Utilitas.clear();
                System.out.println("      OO=============================OO         ");
                System.out.println("      ||           Hi Dear!          ||         ");
                System.out.println("      || Welcome to Gardenia Florist ||         ");
                System.out.println("  _U_ ||           -(O.O)-           || _U_     ");
                System.out.println("_U_|< 00=============================00 >|_U_   ");
                System.out.println(">| |  ||    1. Add data bunga        ||  | |<   ");
                System.out.println(" =====||    2. Display data bunga    ||=====    ");
                System.out.println(" | __ ||    3. Update data bunga     || __ |    ");
                System.out.println(" | __ ||    4. Delete data bunga     || __ |    ");
                System.out.println(" | __ ||    5. Konfirmasi Pesanan    || __ |    ");
                System.out.println(" | __ ||    6. Exit                  || __ |    ");
                System.out.println(" ===========================================    ");
                System.out.print("        >> Masukkan pilihan anda : ");
                try {
                    int pilih = Integer.parseInt(input.readLine());
                    switch (pilih) {
                        case 1:
                            Utilitas.clear();
                            tambah_data();
                            Utilitas.pause();
                            break;
                        case 2:
                            Utilitas.clear();
                            Utilitas.header_display();
                            Display();
                            Utilitas.pause();
                            break;
                        case 3:
                            Utilitas.clear();
                            Utilitas.header_display();
                            Display();
                            update_bunga();
                            Utilitas.pause();
                            break;
                        case 4:
                            Utilitas.clear();
                            Utilitas.header_display();
                            Display();
                            hapus_bunga();
                            Utilitas.pause();
                            break;
                        case 5:
                            Utilitas.clear();
                            Utilitas.header_pesanan();
                            KelolaPesanan.lihatPesanan();
                            System.out.println("============================================");
                            System.out.println("ketik '00' untuk kembali");
                            System.out.print("Masukkan ID pesanan : ");
                            String inputId = input.readLine().trim();
                            if (inputId.equals("00")) {
                                System.out.println("Keluar dari menu konfirmasi pesanan.");
                                Utilitas.pause();
                                break;
                            }
                            
                            int idPesanan = Integer.parseInt(inputId);
                            System.out.print("Masukkan status pesanan (y/n): ");
                            String status = input.readLine();
                            KelolaPesanan.konfirmasiPesanan(idPesanan, status);
                            Utilitas.pause();
                            break;
                        case 6:
                            System.out.print("Anda yakin ingin keluar? (Y/N): ");
                            String konfirmasi = input.readLine();
                            if (konfirmasi.equalsIgnoreCase("Y") || konfirmasi.equalsIgnoreCase("y")) {
                                exit = false;
                            }
                            break;
                        default:
                            System.out.println("Maaf pilihan tidak tersedia");
                            Utilitas.sleep(1500);
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Maaf inputan harus berupa angka");
                    Utilitas.sleep(1500);
                }
            }
        }
        
}
