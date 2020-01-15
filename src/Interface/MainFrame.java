package Interface;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame(){
        super("NetflixStatitics!");

        setLayout(new BorderLayout());

        setVisible(true);
        setSize(600,500);


//        JButton account = new JButton("Accoussnt");
        JPanel Account = new JPanel();
        JPanel Bekeken = new JPanel();
//        Account.add(account);
        JTabbedPane AAccoimt = new JTabbedPane();
        AAccoimt.addTab("Account", Account);
        AAccoimt.addTab("Bekeken", Bekeken);
        add(AAccoimt,BorderLayout.CENTER);


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
