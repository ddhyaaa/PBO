import java.io.*;
import java.util.*;

// Nama : Raudhya Azzahra'
// NIM  : 2209106034

public class Main {
    static int batas;
    static int nextID = 1;
    static double Harga = 0;
    static int Stok = 0; 
    static boolean cekHarga = false;
    static boolean cekStok = false;

    private static InputStreamReader p = new InputStreamReader(System.in);
    private static BufferedReader input = new BufferedReader(p);
    private static ArrayList<Bunga> DataBunga = new ArrayList<>();
    private static ArrayList<Akun> DataAkun = new ArrayList<>();

    public static void header_display(){
        System.out.println("=================================");
        System.out.println("       >>  Data Bunga  <<     ");
        System.out.println("=================================");
    }
    
    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void pause() throws IOException {
        System.out.print("\nPress Enter to continue...");
        input.readLine(); 
    }
    
    public static void main(String[] args) throws IOException {
        while(true){
            clear();
            System.out.println("================================");
            System.out.println("||         H e l l o !        ||");
            System.out.println("================================");
            System.out.println("|| 1. Sign In                 ||");
            System.out.println("|| 2. Login                   ||");
            System.out.println("|| 3. Exit                    ||");
            System.out.println("================================");
            System.out.print("Masukkan pilihan Anda >> ");
            try {
                int pilih = Integer.parseInt(input.readLine());
                switch (pilih) {
                    case 1:
                        clear();
                        tambah_akun();
                        pause();
                        break;
                    case 2:
                        clear();
                        masuk_akun();
                        break;
                    case 3:
                        System.out.print("Anda yakin ingin keluar? (Y/N): ");
                        String konfirmasi = input.readLine();
                        if (konfirmasi.equalsIgnoreCase("Y") || konfirmasi.equalsIgnoreCase("y")){
                            System.out.println("See u dear!");
                            System.exit(0);
                        }
                        break;
                    default:
                        System.out.println("Maaf pilihan tidak tersedia");
                        sleep(1500);
                        break;
                }
              } catch (NumberFormatException e) {
                System.out.println("Maaf inputan harus berupa angka");
                sleep(1500);
            }
        }
    }

// Void Menu Utama
    static void main_menu() throws IOException{
        boolean exit = true;
        while (exit) {
            clear();
            System.out.println("      OO=============================OO         ");
            System.out.println("      ||           Hi Dear!          ||         ");
            System.out.println("      || Welcome to Gardenia Florist ||         ");
            System.out.println("  _U_ ||           -(O.O)-           || _U_     ");
            System.out.println("_U_|< 00=============================00 >|_U_   ");
            System.out.println(">| |  ||    1. Add data bunga        ||  | |<   ");
            System.out.println(" =====||    2. Display data bunga    ||=====    ");
            System.out.println(" | __ ||    3. Update data bunga     || __ |    ");
            System.out.println(" | __ ||    4. Delete data bunga     || __ |    ");
            System.out.println(" | __ ||    5. Exit                  || __ |    ");
            System.out.println(" ===========================================    ");
            System.out.print("        >> Masukkan pilihan anda : ");
            try {
                int pilih = Integer.parseInt(input.readLine());
                switch (pilih) {
                    case 1:
                        clear();
                        tambah_data();
                        pause();
                        break;
                    case 2:
                        clear();
                        header_display();
                        Display();
                        pause();
                        break;
                    case 3:
                        clear();
                        update_bunga();
                        pause();
                        break;
                    case 4:
                        clear();
                        hapus_bunga();
                        pause();
                        break;
                    case 5:
                        System.out.print("Anda yakin ingin keluar? (Y/N): ");
                        String konfirmasi = input.readLine();
                        if (konfirmasi.equalsIgnoreCase("Y") || konfirmasi.equalsIgnoreCase("y")){
                            exit = false;
                        }
                        break;
                    default:
                        System.out.println("Maaf pilihan tidak tersedia");
                        sleep(1500);
                        break;
                }
              } catch (NumberFormatException e) {
                System.out.println("Maaf inputan harus berupa angka");
                sleep(1500);
            }
        }
    }

// Void Menu Daftar Akun
    static void tambah_akun() throws IOException{
        System.out.println("=================================");
        System.out.println("       >>  Tambah Akun  <<       ");
        System.out.println("=================================");
        System.out.print("Masukkan Username   : ");
        String Username = input.readLine();
        System.out.print("Masukkan Password   : ");
        String Password = input.readLine();
        Akun akn = new Akun(Username, Password);
        DataAkun.add(akn);
    }

// Void Menu Login Akun
    static void masuk_akun() throws IOException{
        System.out.println("=================================");
        System.out.println("     >>  Masuk ke Akun  <<       ");
        System.out.println("=================================");
        System.out.print("Masukkan Username   : ");
        String Username = input.readLine();
        System.out.print("Masukkan Password   : ");
        String Password = input.readLine();

        boolean loginSuccess = false;
        for (Akun akun : DataAkun) {
            if (akun.getUsername().equals(Username) && akun.getPassword().equals(Password)) {
                loginSuccess = true;
                break;
            }
        }
        if (loginSuccess) {
            System.out.println("Login berhasil!");
            sleep(2000);
            main_menu();
        } else {
            System.out.println("Login gagal. Username atau password salah.");
            pause();
        }
    }
    
// Void Menu Tambah Data
    static void tambah_data() throws NumberFormatException, IOException{
        System.out.println("=================================");
        System.out.println("    >>  Tambah Data Bunga  <<    ");
        System.out.println("=================================");
        System.out.print("Mau nambah berapa bunga : ");
        batas = Integer.parseInt(input.readLine());
        for (int i=1; i <= batas; i++){
            System.out.println("=================================");
            System.out.print("Nama Bunga      : ");
            String Nama = input.readLine();
            System.out.print("Warna Bunga     : ");
            String Warna = input.readLine();
            System.out.print("Asal Bunga      : ");
            String Asal = input.readLine();
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
        }
        System.out.println("Data berhasil disimpan!");
    }

// Void Menu Display Data
    static void Display(){
        if (DataBunga.isEmpty()) {
            System.out.println("Tidak ada data yang tersedia.");
            return;
        }
        for (int i=0; i<DataBunga.size(); i++){
            DataBunga.get(i).display();
        }
    }

// Void Menu Update Data
    static void update_bunga() throws IOException {
        if (DataBunga.isEmpty()) {
            System.out.println("Tidak ada data yang tersedia.");
            return;
        }
        System.out.println("============================================");
        System.out.println("          >>  Update Data Bunga <<          ");
        System.out.println("============================================");
        System.out.print("Masukkan ID bunga yang ingin diupdate: ");
        int idToUpdate = Integer.parseInt(input.readLine());
    
        boolean found = false;
        for (Bunga bunga : DataBunga) {
            if (bunga.getId() == idToUpdate) {
                System.out.println("Bunga ID " + idToUpdate + " ditemukan.");
                System.out.println("Masukkan informasi baru untuk bunga:");
                System.out.println("============================================");
                System.out.print("Nama Bunga baru      : ");
                String Nama = input.readLine();
                System.out.print("Warna Bunga baru     : ");
                String Warna = input.readLine();
                System.out.print("Asal Bunga baru      : ");
                String Asal = input.readLine();
                cekHarga = false; 
                cekStok = false;
                while (!cekHarga) {
                    System.out.print("Harga Bunga baru     : Rp ");
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
                    System.out.print("Jumlah Bunga baru    : ");
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
    
                // Update informasi bunga
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

// Void Menu Delete Data
    static void hapus_bunga() throws IOException {
        if (DataBunga.isEmpty()) {
            System.out.println("Tidak ada data yang tersedia.");
            return;
        }

        System.out.println("============================================");
        System.out.println("          >>  Hapus Data Bunga <<           ");
        System.out.println("============================================");
        System.out.print("Masukkan ID bunga yang ingin dihapus: ");
        int idToDelete = Integer.parseInt(input.readLine());
    
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
}
