package posstest2;
import java.io.IOException;

public interface Metode {
    void clear();
    void pause() throws IOException;
    void sleep(int milliseconds);
}
