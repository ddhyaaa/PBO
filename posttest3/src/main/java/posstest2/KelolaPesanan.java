package posstest2;

import java.util.ArrayList;

public class KelolaPesanan {
    private static ArrayList<Pesanan> dataPesanan = new ArrayList<>();

    public static ArrayList<Pesanan> getDataPesanan() {
        return dataPesanan;
    }

    static {
        dataPesanan = new ArrayList<>();
    }
    

    public static void tambahPesanan(Pesanan pesanan) {
        dataPesanan.add(pesanan);
        System.out.println("Pesanan berhasil ditambahkan.");
    }

    public void konfirmasiPesanan(int idPesanan, boolean diterima) {
        for (Pesanan pesanan : dataPesanan) {
            if (pesanan.getId() == idPesanan) {
                if (diterima) {
                    pesanan.setStatus("Diterima");
                } else {
                    pesanan.setStatus("Tidak Diterima");
                }
                System.out.println("Status pesanan berhasil diupdate.");
                return;
            }
        }
        System.out.println("Pesanan dengan ID tersebut tidak ditemukan.");
    }
    public void adminKonfirmasiPesanan(int idPesanan, String status) {
        for (Pesanan pesanan : dataPesanan) {
            if (pesanan.getId() == idPesanan) {
                if (status.equalsIgnoreCase("diterima") || status.equalsIgnoreCase("ditolak")) {
                    pesanan.setStatus(status);
                    System.out.println("Status pesanan berhasil diupdate menjadi: " + status);
                } else {
                    System.out.println("Status yang dimasukkan tidak valid.");
                }
                return;
            }
        }
        System.out.println("Pesanan dengan ID tersebut tidak ditemukan.");
    }
}
