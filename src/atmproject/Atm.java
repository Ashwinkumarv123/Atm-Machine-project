package atmproject; //test command

import java.io.IOException; // Test command 2

public class Atm extends OptionMenu {
    public static void main(String[] args) throws IOException {
        OptionMenu optionMenu = new OptionMenu();
        
        optionMenu.getLogin();
    }
}
