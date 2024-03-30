package posstest2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class User extends Akun {
    
    private String loggedInUsername;
    private ArrayList<Bunga> DataBunga; 
    private static ArrayList<Akun> DataAkun = new ArrayList<>();
    private KelolaPesanan kelolaPesanan; 
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public User(String username, String password) {
        super(username, password);
        this.DataBunga = new ArrayList<>();
        this.kelolaPesanan = new KelolaPesanan(); 
        super.setUsername(username);
    }

    public User(String username, String password, ArrayList<Bunga> dataBunga) {
        super(username, password);
        this.DataBunga = dataBunga;
        this.kelolaPesanan = new KelolaPesanan(); 
        super.setUsername(username); 
    }

    public String getUsername() {
        return Username;
    }

    public void Display() {
        if (DataBunga.isEmpty()) {
            System.out.println("Tidak ada data yang tersedia.");
            return;
        }
        for (Bunga bunga : DataBunga) {
            bunga.Display();
        }
    }

    public void tambah_akun() throws IOException {
        System.out.println("============================================");
        System.out.println("             >>  Tambah Akun  <<            ");
        System.out.println("============================================");
        String Username = "";
        String Password = "";
        while (Username.isEmpty()) {
            System.out.print("Masukkan Username   : ");
            Username = input.readLine().trim();
            if (Username.isEmpty()) {
                System.out.println("Username tidak boleh kosong.");
            }
        }
        while (Password.isEmpty()) {
            System.out.print("Masukkan Password   : ");
            Password = input.readLine().trim();
            if (Password.isEmpty()) {
                System.out.println("Password tidak boleh kosong.");
            }
        }
        Akun akn = new Akun(Username, Password);
        DataAkun.add(akn);
        System.out.println("Akun berhasil dibuat!");
        Utilitas.pause();
    }

    public void masuk_akun() throws IOException{
        System.out.println("============================================");
        System.out.println("            >>  Masuk ke Akun  <<           ");
        System.out.println("============================================");
        String Username = "";
        String Password = "";
        while (Username.isEmpty()) {
            System.out.print("Masukkan Username   : ");
            Username = input.readLine().trim();
            if (Username.isEmpty()) {
                System.out.println("Username tidak boleh kosong.");
            }
        }
        while (Password.isEmpty()) {
            System.out.print("Masukkan Password   : ");
            Password = input.readLine().trim();
            if (Password.isEmpty()) {
                System.out.println("Password tidak boleh kosong.");
            }
        }

        boolean loginSuccess = false;
        for (Akun akun : DataAkun) {
            if (akun.getUsername().equals(Username) && akun.getPassword().equals(Password)) {
                loginSuccess = true;
                this.loggedInUsername = Username;
                break;
            }
        }
        if (loginSuccess) {
            System.out.println("Login berhasil!");
            Utilitas.sleep(2000);
            menu_user();
        } else {
            System.out.println("Login gagal. Username atau password salah.");
            Utilitas.pause();
        }
    }

    public void pesanBunga() throws IOException {
        System.out.println("============================================");
        System.out.println("             >> Pesan Bunga <<              ");
        System.out.println("============================================");
        Display();
        System.out.print("Masukkan ID Bunga yang ingin dipesan: ");
        int idBunga = Integer.parseInt(input.readLine());
        Bunga bungaDipesan = null;
        for (Bunga bunga : DataBunga) {
            if (bunga.getId() == idBunga) {
                bungaDipesan = bunga;
                break;
            }
        }
        if (bungaDipesan != null) {
            System.out.print("Masukkan jumlah bunga yang ingin dipesan: ");
            int jumlahPesanan = Integer.parseInt(input.readLine());
            if (jumlahPesanan <= 0) {
                System.out.println("Jumlah pesanan harus lebih dari nol.");
            } else if (jumlahPesanan > bungaDipesan.getStok()) {
                System.out.println("Stok bunga tidak mencukupi untuk pesanan ini. Stok tersedia: " + bungaDipesan.getStok());
            } else {
                KelolaPesanan.tambahPesanan(new Pesanan(this.loggedInUsername, bungaDipesan, jumlahPesanan, "Belum dikonfirmasi"), true);
                bungaDipesan.kurangiStok(jumlahPesanan);
            }
        } else {
            System.out.println("Bunga dengan ID tersebut tidak ditemukan.");
        }
    }    
    
    public static void Display(KelolaPesanan kelolaPesanan, String loggedInUsername) {
        System.out.println("============================================");
        System.out.println("           >> Riwayat Pesanan <<            ");
        System.out.println("============================================");
    
        ArrayList<Pesanan> riwayatPesanan = new ArrayList<>();
        for (Pesanan pesanan : KelolaPesanan.getDataPesanan()) {
            if (pesanan.getUsername().equals(loggedInUsername)) {
                riwayatPesanan.add(pesanan);
            }
        }
    
        if (riwayatPesanan.isEmpty()) {
            System.out.println("Anda belum memiliki riwayat pesanan.");
            return;
        }
    
        for (Pesanan pesanan : riwayatPesanan) {
            pesanan.display();
        }
    }

    public void menu_user() throws IOException{
        boolean exit = true;
        while (exit) {
            Utilitas.clear();
            System.out.println("      OO=============================OO         ");
            System.out.println("      ||           Hi Dear!          ||         ");
            System.out.println("      || Welcome to Gardenia Florist ||         ");
            System.out.println("  _U_ ||           -(O.O)-           || _U_     ");
            System.out.println("_U_|< 00=============================00 >|_U_   ");
            System.out.println(">| |  ||    1. Display data bunga    ||  | |<   ");
            System.out.println(" =====||    2. Pesan Bunga           ||=====    ");
            System.out.println(" | __ ||    3. Riwayat Pesanan       || __ |    ");
            System.out.println(" | __ ||    4. Exit                  || __ |    ");
            System.out.println(" | __ ||                             || __ |    ");
            System.out.println(" ===========================================    ");
            System.out.print("        >> Masukkan pilihan anda : ");
            try {
                int pilih = Integer.parseInt(input.readLine());
                switch (pilih) {
                    case 1:
                        Utilitas.clear();
                        Utilitas.header_display();
                        Display(); 
                        Utilitas.pause();
                        break;
                    case 2:
                        Utilitas.clear();
                        pesanBunga();
                        Utilitas.pause();
                        break;
                    case 3:
                        Utilitas.clear();
                        Display(kelolaPesanan, loggedInUsername);
                        Utilitas.pause();
                        break;
                    case 4:
                        System.out.print("Anda yakin ingin keluar? (Y/N): ");
                        String konfirmasi = input.readLine();
                        if (konfirmasi.equalsIgnoreCase("Y") || konfirmasi.equalsIgnoreCase("y")){
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
