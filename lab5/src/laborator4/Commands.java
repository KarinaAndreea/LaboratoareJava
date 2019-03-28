package laborator4;
import java.io.IOException;

public interface Commands {
    void save(String path) throws IOException;
    void load(String nume) throws IOException;
}