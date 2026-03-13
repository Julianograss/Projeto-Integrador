package Projeto;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class TelaCadastro extends JFrame{
    public Graphics g;
    public TelaCadastro(){
        setSize(1400, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

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
        pnlBase.setPreferredSize(new Dimension(1000,550));

        //Inicio dos componentes de cadastro
        JPanel pnlCompnentsCadas = new JPanel();
        pnlCompnentsCadas.setPreferredSize(new Dimension(500,550));
        pnlCompnentsCadas.setBackground(Color.LIGHT_GRAY);
        pnlCompnentsCadas.setLayout(null);

        JLabel lblMsgCadas = new JLabel("Cadastre-se Aqui");
        lblMsgCadas.setFont(new Font("Arial", Font.BOLD, 20));
        lblMsgCadas.setBounds(150,20,200,40);

        JLabel lblNomeComp = new JLabel("Nome Completo");
        lblNomeComp.setFont(fontLabels);
        lblNomeComp.setBounds(50, 100, 120, 20);
        JTextField txtNomeComp = new JTextField();
        txtNomeComp.setFont(fontTxtFields);
        txtNomeComp.setBounds(50, 130, 220, 25);

        JLabel lblCllrEmail = new JLabel("Celular ou Email");
        lblCllrEmail.setFont(fontLabels);
        lblCllrEmail.setBounds(50, 170, 150, 20);
        JTextField txtCllrEmail = new JTextField();
        txtCllrEmail.setFont(fontTxtFields);
        txtCllrEmail.setBounds(50, 200, 220, 25);

        JLabel lblSenhaCadas = new JLabel("Senha");
        lblSenhaCadas.setFont(fontLabels);
        lblSenhaCadas.setBounds(50, 240, 120, 20);
        JTextField txtSenhaCadas = new JTextField();
        txtSenhaCadas.setFont(fontTxtFields);
        txtSenhaCadas.setBounds(50, 270, 220, 25);

        JLabel lblDataNasc = new JLabel("Data de Nascimento");
        lblDataNasc.setFont(fontLabels);
        lblDataNasc.setBounds(50, 310, 150, 20);
        String msgDia = "Dia";
        JTextField txtDia = new JTextField();
        txtDia.setText(msgDia);
        txtDia.setFont(new Font("Arial", Font.BOLD, 12));
        txtDia.setBounds(50, 340, 40, 25);
        txtDia.setForeground(Color.GRAY);
        txtDia.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e){
                if (txtDia.getText().equals(msgDia)) {
                    txtDia.setText("");
                    txtDia.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e){
                if (txtDia.getText().isEmpty()) {
                    txtDia.setText(msgDia);
                    txtDia.setForeground(Color.GRAY);
                }
            }
        });
        String msgMes = "Mês";
        JTextField txtMes = new JTextField("Mês");
        txtMes.setFont(new Font("Arial", Font.BOLD, 12));
        txtMes.setBounds(140, 340, 40, 25);
        txtMes.setForeground(Color.GRAY);
        txtMes.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e){
                if (txtMes.getText().equals(msgMes)) {
                    txtMes.setText("");
                    txtMes.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e){
                if (txtMes.getText().isEmpty()) {
                    txtMes.setText(msgMes);
                    txtMes.setForeground(Color.GRAY);
                }
            }
        });
        String msgAno = "Ano";
        JTextField txtAno = new JTextField("Ano");
        txtAno.setFont(new Font("Arial", Font.BOLD, 12));
        txtAno.setBounds(230, 340, 40, 25);
        txtAno.setForeground(Color.GRAY);
        txtAno.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e){
                if (txtAno.getText().equals(msgAno)) {
                    txtAno.setText("");
                    txtAno.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e){
                if (txtAno.getText().isEmpty()) {
                    txtAno.setText(msgAno);
                    txtAno.setForeground(Color.GRAY);
                }
            }
        });

        JLabel lblGenero = new JLabel("Gênero");
        lblGenero.setFont(fontLabels);
        lblGenero.setBounds(50, 380, 120, 25);
        JLabel lblFeminino = new JLabel("F");
        lblFeminino.setFont(fontLabels);
        lblFeminino.setBounds(50, 410, 20, 25);
        JCheckBox chkFeminino = new JCheckBox();
        chkFeminino.setBounds(60, 410, 20, 25);
        chkFeminino.setBackground(null);
        JLabel lblMasculino = new JLabel("M");
        lblMasculino.setFont(fontLabels);
        lblMasculino.setBounds(140, 410, 20, 25);
        JCheckBox chkMasculino = new JCheckBox();
        chkMasculino.setBounds(155, 410, 20, 25);
        chkMasculino.setBackground(null);
        JLabel lblOutro = new JLabel("Outro");
        lblOutro.setFont(fontLabels);
        lblOutro.setBounds(210, 410, 60, 25);
        JCheckBox chkOutro = new JCheckBox();
        chkOutro.setBounds(250, 410, 20, 25);
        chkOutro.setBackground(null);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setFont(new Font("Arial", Font.BOLD, 18));
        btnCadastrar.setBounds(150, 475, 250, 25);
        
        pnlCompnentsCadas.add(lblMsgCadas);
        pnlCompnentsCadas.add(lblNomeComp);
        pnlCompnentsCadas.add(txtNomeComp);
        pnlCompnentsCadas.add(lblCllrEmail);
        pnlCompnentsCadas.add(txtCllrEmail);
        pnlCompnentsCadas.add(lblSenhaCadas);
        pnlCompnentsCadas.add(txtSenhaCadas);
        pnlCompnentsCadas.add(lblDataNasc);
        pnlCompnentsCadas.add(txtDia);
        pnlCompnentsCadas.add(txtMes);
        pnlCompnentsCadas.add(txtAno);
        pnlCompnentsCadas.add(lblGenero);
        pnlCompnentsCadas.add(lblFeminino);
        pnlCompnentsCadas.add(lblMasculino);
        pnlCompnentsCadas.add(lblOutro);
        pnlCompnentsCadas.add(chkFeminino);
        pnlCompnentsCadas.add(chkMasculino);
        pnlCompnentsCadas.add(chkOutro);
        pnlCompnentsCadas.add(btnCadastrar);
        //Fim dos componentes de cadastro

        JSeparator separador = new JSeparator(JSeparator.VERTICAL);
        separador.setMaximumSize(new Dimension(2, 400));
        separador.setForeground(Color.BLACK);
        separador.setAlignmentY(CENTER_ALIGNMENT);

        //Inicio dos componentes de Login
        JPanel pnlCompnentsLog = new JPanel();
        pnlCompnentsLog.setPreferredSize(new Dimension(500,550));
        pnlCompnentsLog.setBackground(Color.LIGHT_GRAY);
        pnlCompnentsLog.setLayout(null);

        JLabel lblMsgLog = new JLabel("Já Possui uma Conta?");
        lblMsgLog.setFont(new Font("Arial", Font.BOLD, 20));
        lblMsgLog.setBounds(150,20,300,40);

        JLabel lblNomEmail = new JLabel("Nome ou Email");
        lblNomEmail.setFont(fontLabels);
        lblNomEmail.setBounds(50, 100, 120, 25);
        JTextField txtNomEmail = new JTextField();
        txtNomEmail.setFont(fontTxtFields);
        txtNomEmail.setBounds(50, 130, 220, 25);

        JLabel lblSenhaLog = new JLabel("Senha");
        lblSenhaLog.setFont(fontLabels);
        lblSenhaLog.setBounds(50, 170, 120, 25);
        JTextField txtSenhaLog = new JTextField();
        txtSenhaLog.setFont(fontTxtFields);
        txtSenhaLog.setBounds(50, 200, 220, 25);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setFont(new Font("Arial", Font.BOLD, 16));
        btnEntrar.setBounds(180, 275, 150, 25);
        btnEntrar.addActionListener(e ->{
            new TelaLogin();
        });

        JLabel lblMsgOu = new JLabel("Ou");
        lblMsgOu.setFont(fontLabels);
        lblMsgOu.setBounds(245, 337, 50, 25);
        JButton btnGoogle = new JButton("Fazer Login com Google");
        btnGoogle.setFont(new Font("Arial", Font.BOLD, 16));
        btnGoogle.setBounds(130, 400, 250, 25);
        JButton btnInstagram = new JButton("Fazer Login com Instagram");
        btnInstagram.setFont(new Font("Arial", Font.BOLD, 16));
        btnInstagram.setBounds(130, 475, 250, 25);

        pnlCompnentsLog.add(lblMsgLog);
        pnlCompnentsLog.add(lblNomEmail);
        pnlCompnentsLog.add(txtNomEmail);
        pnlCompnentsLog.add(lblSenhaLog);
        pnlCompnentsLog.add(txtSenhaLog);
        pnlCompnentsLog.add(btnEntrar);
        pnlCompnentsLog.add(lblMsgOu);
        pnlCompnentsLog.add(btnGoogle);
        pnlCompnentsLog.add(btnInstagram);
        //Fim dos componentes de Login


        pnlBase.add(pnlCompnentsCadas);
        pnlBase.add(Box.createVerticalStrut(50));
        pnlBase.add(separador);
        pnlBase.add(pnlCompnentsLog);

        pnlCentralizar.add(pnlBase, BorderLayout.CENTER);
        add(pnlCentralizar, BorderLayout.CENTER);
        add(lblMsg, BorderLayout.NORTH);

        setVisible(true);
    }
    public static void main(String agrs[]){
        new TelaCadastro();
    }
}
