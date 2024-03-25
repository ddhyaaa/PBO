package posstest2;
import java.io.*;

// Nama : Raudhya Azzahra'
// NIM  : 2209106034

public class Main {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Admin MyAdmin = new Admin("Raudhya", "1234", "Admin");
        User currentUser = new User(MyAdmin.getUsername(), MyAdmin.getPassword(), MyAdmin.getDataBunga());
        while(true){
            Utilitas.clear();
            System.out.println("================================");
            System.out.println("||         H e l l o !        ||");
            System.out.println("================================");
            System.out.println("|| 1. Admin                   ||");
            System.out.println("|| 2. User                    ||");
            System.out.println("|| 3. Exit                    ||");
            System.out.println("================================");
            System.out.print("Masukkan pilihan Anda >> ");
            try {
                int pilih = Integer.parseInt(input.readLine());
                switch (pilih) {
                    case 1:
                        Utilitas.clear();
                        System.out.print("Masukkan Username Anda >>> "); String username = input.readLine();
                        System.out.print("Masukkan Password Anda >>> "); String password = input.readLine();
                        if(username.equalsIgnoreCase(MyAdmin.getUsername()) && password.equalsIgnoreCase(MyAdmin.getPassword())) {
                             MyAdmin.main_menu();
                        }else {
                        System.out.println("Username atau password salah!!!");input.readLine();
                        }
                        break;
                    case 2:
                    while (true) {
                        Utilitas.clear();
                        System.out.println("================================");
                        System.out.println("||     U s e r  M e n u       ||");
                        System.out.println("================================");
                        System.out.println("|| 1. Tambah Akun             ||");
                        System.out.println("|| 2. Masuk Akun              ||");
                        System.out.println("|| 3. Kembali ke Menu Utama   ||");
                        System.out.println("================================");
                        System.out.print("Masukkan pilihan Anda >> ");
                        try {
                            int userChoice = Integer.parseInt(input.readLine());
                            switch (userChoice) {
                                case 1:
                                    Utilitas.clear();
                                    currentUser.tambah_akun(); 
                                    Utilitas.pause();
                                    break;
                                case 2:
                                    Utilitas.clear();
                                    currentUser.masuk_akun(); 
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println("Maaf pilihan tidak tersedia");
                                    Utilitas.sleep(1500);
                                    break;
                            }
                            if (userChoice == 3) {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Maaf inputan harus berupa angka");
                            Utilitas.sleep(1500);
                        }
                    }
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