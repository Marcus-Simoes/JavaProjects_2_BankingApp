import java.io.IOException;

public class MyFirstBankApp {

    public static void main(String[] args) throws IOException {

        MyAccount m_Simoes = new MyAccount("Marcus Simoes", "MS007");
        m_Simoes.showMenu();

        //MyAccount g_Simoes = new MyAccount("Geneza Simoes", "GS007");
        //g_Simoes.showMenu();

    }
}
