import java.io.IOException;
import hsa.Console;

public class Main {
    static Console c;

    public static void main(String[] args) throws IOException {
        c = new Console();
    
        MenuPage intro = new MenuPage(c);
        intro.welcome();

        c.close();
    }
}

