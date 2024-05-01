package posstest2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utilitas implements Metode {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void header_display() {
        System.out.println("============================================");
        System.out.println("           >>  List Data Bunga <<          ");
        System.out.println("============================================");
    }

    public static void header_pesanan() {
        System.out.println("============================================");
        System.out.println("            >>  List Pesanan <<             ");
        System.out.println("============================================");
    }

    @Override
    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void pause() throws IOException {
        System.out.print("\nPress Enter to continue...");
        input.readLine();
    }
}
