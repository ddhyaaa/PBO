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
    }
    public static void tambahPesanan(Pesanan pesanan, boolean notifikasi) {
        dataPesanan.add(pesanan);
        if (notifikasi) {
            System.out.println("Notifikasi: Pesanan berhasil ditambahkan.");
        }
    }

    public static void konfirmasiPesanan(int idPesanan, String status) {
        if (status.equalsIgnoreCase("y") || status.equalsIgnoreCase("n")) {
            for (Pesanan pesanan : dataPesanan) {
                if (pesanan.getId() == idPesanan) {
                    if (status.equalsIgnoreCase("y")) {
                        pesanan.setStatus("Diterima");
                        System.out.println("Status pesanan berhasil diupdate menjadi: " + pesanan.getStatus());
                    } else if (status.equalsIgnoreCase("n")) {
                        pesanan.setStatus("Ditolak");
                        Bunga bunga = pesanan.getBunga();
                        int jumlah = pesanan.getJumlah();
                        bunga.tambahStok(jumlah);
                        System.out.println("Pesanan ditolak. Stok bunga berhasil dikembalikan: " + jumlah);
                    }
                    return;
                }
            }
            System.out.println("Pesanan dengan ID tersebut tidak ditemukan.");
        } else {
            System.out.println("Input tidak valid");
            System.out.println(" Hanya menerima 'y' untuk diterima dan 'n' untuk ditolak.");
        }
    }    
    
    

}
