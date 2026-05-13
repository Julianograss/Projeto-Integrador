package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaCadastro extends JFrame {

    public TelaCadastro() {
        setSize(1400, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Tela de Cadastro e Login");

        Font fontLabels = new Font("Arial", Font.BOLD, 14);
        Font fontTxtFields = new Font("Monospaced", Font.PLAIN, 13);

        JLabel lblMsg = new JLabel("Bem-Vindo");
        lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
        lblMsg.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));
        lblMsg.setFont(new Font("Arial", Font.PLAIN, 25));

        JPanel pnlCentralizar = new JPanel(new BorderLayout());
        pnlCentralizar.setBorder(BorderFactory.createEmptyBorder(0, 150, 100, 150));
        
        JPanel pnlBase = new JPanel();
        pnlBase.setLayout(new BoxLayout(pnlBase, BoxLayout.X_AXIS));
        pnlBase.setBackground(Color.LIGHT_GRAY);

        JPanel pnlCompnentsCadas = new JPanel(new GridBagLayout());
        pnlCompnentsCadas.setBackground(Color.LIGHT_GRAY);
        pnlCompnentsCadas.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        GridBagConstraints gbcCadas = new GridBagConstraints();
        gbcCadas.fill = GridBagConstraints.HORIZONTAL;
        gbcCadas.insets = new Insets(5, 0, 5, 0); 
        gbcCadas.weightx = 1.0;

        JLabel lblMsgCadas = new JLabel("Cadastre-se Aqui", SwingConstants.CENTER);
        lblMsgCadas.setFont(new Font("Arial", Font.BOLD, 20));
        gbcCadas.gridx = 0; gbcCadas.gridy = 0;
        gbcCadas.insets = new Insets(0, 0, 20, 0); 
        pnlCompnentsCadas.add(lblMsgCadas, gbcCadas);

        gbcCadas.insets = new Insets(5, 0, 0, 0);

        JLabel lblNomeComp = new JLabel("Nome Completo");
        lblNomeComp.setFont(fontLabels);
        gbcCadas.gridy = 1; pnlCompnentsCadas.add(lblNomeComp, gbcCadas);

        JTextField txtNomeComp = new JTextField();
        txtNomeComp.setFont(fontTxtFields);
        gbcCadas.gridy = 2; pnlCompnentsCadas.add(txtNomeComp, gbcCadas);

        JLabel lblCllrEmail = new JLabel("Celular ou Email");
        lblCllrEmail.setFont(fontLabels);
        gbcCadas.gridy = 3; pnlCompnentsCadas.add(lblCllrEmail, gbcCadas);

        JTextField txtCllrEmail = new JTextField();
        txtCllrEmail.setFont(fontTxtFields);
        gbcCadas.gridy = 4; pnlCompnentsCadas.add(txtCllrEmail, gbcCadas);

        JLabel lblSenhaCadas = new JLabel("Senha");
        lblSenhaCadas.setFont(fontLabels);
        gbcCadas.gridy = 5; pnlCompnentsCadas.add(lblSenhaCadas, gbcCadas);

        JTextField txtSenhaCadas = new JTextField();
        txtSenhaCadas.setFont(fontTxtFields);
        gbcCadas.gridy = 6; pnlCompnentsCadas.add(txtSenhaCadas, gbcCadas);

        JLabel lblDataNasc = new JLabel("Data de Nascimento");
        lblDataNasc.setFont(fontLabels);
        gbcCadas.gridy = 7; pnlCompnentsCadas.add(lblDataNasc, gbcCadas);

        JPanel pnlData = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        pnlData.setBackground(Color.LIGHT_GRAY);
        
        JTextField txtDia = criarCampoPlaceholder("Dia");
        JTextField txtMes = criarCampoPlaceholder("Mês");
        JTextField txtAno = criarCampoPlaceholder("Ano");
        
        pnlData.add(txtDia);
        pnlData.add(txtMes);
        pnlData.add(txtAno);
        gbcCadas.gridy = 8; pnlCompnentsCadas.add(pnlData, gbcCadas);

        JLabel lblGenero = new JLabel("Gênero");
        lblGenero.setFont(fontLabels);
        gbcCadas.gridy = 9; pnlCompnentsCadas.add(lblGenero, gbcCadas);

        JPanel pnlGenero = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        pnlGenero.setBackground(Color.LIGHT_GRAY);
        
        JCheckBox chkFeminino = new JCheckBox("F");
        chkFeminino.setBackground(Color.LIGHT_GRAY);
        chkFeminino.setFont(fontLabels);
        
        JCheckBox chkMasculino = new JCheckBox("M");
        chkMasculino.setBackground(Color.LIGHT_GRAY);
        chkMasculino.setFont(fontLabels);
        
        JCheckBox chkOutro = new JCheckBox("Outro");
        chkOutro.setBackground(Color.LIGHT_GRAY);
        chkOutro.setFont(fontLabels);

        pnlGenero.add(chkFeminino);
        pnlGenero.add(chkMasculino);
        pnlGenero.add(chkOutro);
        gbcCadas.gridy = 10; pnlCompnentsCadas.add(pnlGenero, gbcCadas);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setFont(new Font("Arial", Font.BOLD, 18));
        gbcCadas.gridy = 11; 
        gbcCadas.insets = new Insets(20, 0, 0, 0); 
        gbcCadas.fill = GridBagConstraints.NONE; 
        pnlCompnentsCadas.add(btnCadastrar, gbcCadas);

        JSeparator separador = new JSeparator(JSeparator.VERTICAL);
        separador.setMaximumSize(new Dimension(2, 450));
        separador.setForeground(Color.DARK_GRAY);

        JPanel pnlCompnentsLog = new JPanel(new GridBagLayout());
        pnlCompnentsLog.setBackground(Color.LIGHT_GRAY);
        pnlCompnentsLog.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        GridBagConstraints gbcLog = new GridBagConstraints();
        gbcLog.fill = GridBagConstraints.HORIZONTAL;
        gbcLog.insets = new Insets(5, 0, 5, 0);
        gbcLog.weightx = 1.0;

        JLabel lblMsgLog = new JLabel("Já Possui uma Conta?", SwingConstants.CENTER);
        lblMsgLog.setFont(new Font("Arial", Font.BOLD, 20));
        gbcLog.gridx = 0; gbcLog.gridy = 0;
        gbcLog.insets = new Insets(0, 0, 20, 0);
        pnlCompnentsLog.add(lblMsgLog, gbcLog);

        gbcLog.insets = new Insets(5, 0, 0, 0);

        JLabel lblNomEmail = new JLabel("Nome ou Email");
        lblNomEmail.setFont(fontLabels);
        gbcLog.gridy = 1; pnlCompnentsLog.add(lblNomEmail, gbcLog);

        JTextField txtNomEmail = new JTextField();
        txtNomEmail.setFont(fontTxtFields);
        gbcLog.gridy = 2; pnlCompnentsLog.add(txtNomEmail, gbcLog);

        JLabel lblSenhaLog = new JLabel("Senha");
        lblSenhaLog.setFont(fontLabels);
        gbcLog.gridy = 3; pnlCompnentsLog.add(lblSenhaLog, gbcLog);

        JTextField txtSenhaLog = new JTextField();
        txtSenhaLog.setFont(fontTxtFields);
        gbcLog.gridy = 4; pnlCompnentsLog.add(txtSenhaLog, gbcLog);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setFont(new Font("Arial", Font.BOLD, 16));
        gbcLog.gridy = 5; 
        gbcLog.insets = new Insets(20, 0, 20, 0);
        gbcLog.fill = GridBagConstraints.NONE;
        btnEntrar.addActionListener(e -> {
            new TelaLogin(); 
            JOptionPane.showMessageDialog(this, "Redirecionando para Login...");
        });
        pnlCompnentsLog.add(btnEntrar, gbcLog);

        gbcLog.fill = GridBagConstraints.HORIZONTAL;
        gbcLog.insets = new Insets(5, 0, 5, 0);

        JLabel lblMsgOu = new JLabel("Ou", SwingConstants.CENTER);
        lblMsgOu.setFont(fontLabels);
        gbcLog.gridy = 6; pnlCompnentsLog.add(lblMsgOu, gbcLog);

        JButton btnGoogle = new JButton("Fazer Login com Google");
        btnGoogle.setFont(new Font("Arial", Font.BOLD, 16));
        gbcLog.gridy = 7; pnlCompnentsLog.add(btnGoogle, gbcLog);

        JButton btnInstagram = new JButton("Fazer Login com Instagram");
        btnInstagram.setFont(new Font("Arial", Font.BOLD, 16));
        gbcLog.gridy = 8; pnlCompnentsLog.add(btnInstagram, gbcLog);

        pnlBase.add(Box.createHorizontalStrut(20)); 
        pnlBase.add(pnlCompnentsCadas);
        pnlBase.add(Box.createHorizontalStrut(20)); 
        pnlBase.add(separador);
        pnlBase.add(Box.createHorizontalStrut(20)); 
        pnlBase.add(pnlCompnentsLog);
        pnlBase.add(Box.createHorizontalStrut(20)); 

        pnlCentralizar.add(pnlBase, BorderLayout.CENTER);
        add(pnlCentralizar, BorderLayout.CENTER);
        add(lblMsg, BorderLayout.NORTH);

        setVisible(true);
    }

    private JTextField criarCampoPlaceholder(String placeholder) {
        JTextField txtField = new JTextField(placeholder);
        txtField.setPreferredSize(new Dimension(50, 25));
        txtField.setFont(new Font("Arial", Font.BOLD, 12));
        txtField.setForeground(Color.GRAY);
        
        txtField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtField.getText().equals(placeholder)) {
                    txtField.setText("");
                    txtField.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (txtField.getText().isEmpty()) {
                    txtField.setText(placeholder);
                    txtField.setForeground(Color.GRAY);
                }
            }
        });
        return txtField;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TelaCadastro::new);
    }
}
