package Projeto;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class TelaLogin extends JFrame{
    public TelaLogin(){
        setSize(1400, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel pnlCentralizar = new JPanel();
        pnlCentralizar.setBorder(BorderFactory.createEmptyBorder(50,150,50,150));
        JPanel pnlLogin = new JPanel();
        pnlLogin.setLayout(null);
        pnlLogin.setPreferredSize(new Dimension(600, 600));
        pnlLogin.setBackground(Color.GRAY);


        pnlCentralizar.add(pnlLogin);
        add(pnlCentralizar, BorderLayout.CENTER);
        setVisible(true);
    }
}
