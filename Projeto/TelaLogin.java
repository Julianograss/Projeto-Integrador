package view;
 
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
 
public class TelaLogin extends JFrame {
 
    private static final Color BG_OUTER   = Color.WHITE;
    private static final Color BG_PANEL   = new Color(220, 220, 220); // cinza claro
    private static final Color FG_DEFAULT = new Color(30, 30, 30);
    private static final Color FG_LINK    = new Color(50, 100, 200);
    private static final Color BTN_BG     = Color.WHITE;
    private static final Color BTN_BORDER = new Color(160, 160, 160);
    private static final Color FIELD_BG   = Color.WHITE;
    private static final Color FIELD_BORDER = new Color(180, 180, 180);
 
    public TelaLogin() {
        setTitle("Login");
        setSize(960, 720);
        setMinimumSize(new Dimension(700, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(BG_OUTER);
        setLayout(new GridBagLayout());
 
        JPanel painelPrincipal = new JPanel(new GridBagLayout());
        painelPrincipal.setBackground(BG_PANEL);
        painelPrincipal.setPreferredSize(new Dimension(460, 620));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(24, 44, 32, 44));
 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(4, 0, 4, 0);
 
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        JButton btnVoltar = criarBotaoVoltar();
        painelPrincipal.add(btnVoltar, gbc);
 
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(2, 0, 18, 0);
        JLabel lblLogin = new JLabel("Login", SwingConstants.CENTER);
        lblLogin.setFont(new Font("Georgia", Font.PLAIN, 28));
        lblLogin.setForeground(FG_DEFAULT);
        painelPrincipal.add(lblLogin, gbc);
 
        gbc.gridy = 2;
        gbc.insets = new Insets(4, 0, 2, 0);
        JLabel lblUsuario = new JLabel("Nome ou E-mail");
        lblUsuario.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblUsuario.setForeground(FG_DEFAULT);
        painelPrincipal.add(lblUsuario, gbc);
 
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 14, 0);
        JTextField txtUsuario = criarCampoTexto();
        painelPrincipal.add(txtUsuario, gbc);
 
        gbc.gridy = 4;
        gbc.insets = new Insets(4, 0, 2, 0);
        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblSenha.setForeground(FG_DEFAULT);
        painelPrincipal.add(lblSenha, gbc);
 
        gbc.gridy = 5;
        gbc.insets = new Insets(0, 0, 4, 0);
        JPasswordField txtSenha = new JPasswordField();
        txtSenha.setFont(new Font("SansSerif", Font.PLAIN, 13));
        txtSenha.setBackground(FIELD_BG);
        txtSenha.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(FIELD_BORDER, 1),
                BorderFactory.createEmptyBorder(6, 8, 6, 8)));
        txtSenha.setPreferredSize(new Dimension(0, 34));
        painelPrincipal.add(txtSenha, gbc);
 
        gbc.gridy = 6;
        gbc.insets = new Insets(0, 0, 18, 0);
        JLabel lblEsqueceu = new JLabel("Esqueceu sua senha?");
        lblEsqueceu.setFont(new Font("SansSerif", Font.PLAIN, 11));
        lblEsqueceu.setForeground(FG_LINK);
        lblEsqueceu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        painelPrincipal.add(lblEsqueceu, gbc);
 
        gbc.gridy = 7;
        gbc.insets = new Insets(4, 0, 18, 0);
        JButton btnEntrar = criarBotaoPadrao("Entrar");
        painelPrincipal.add(btnEntrar, gbc);
 
        gbc.gridy = 8;
        gbc.insets = new Insets(4, 0, 16, 0);
        JSeparator sep = new JSeparator();
        sep.setForeground(new Color(150, 150, 150));
        painelPrincipal.add(sep, gbc);

        gbc.gridy = 9;
        gbc.insets = new Insets(2, 0, 8, 0);
        JLabel lblNaoConta = new JLabel("Não possui uma conta?", SwingConstants.CENTER);
        lblNaoConta.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblNaoConta.setForeground(FG_DEFAULT);
        painelPrincipal.add(lblNaoConta, gbc);
 
        gbc.gridy = 10;
        gbc.insets = new Insets(0, 0, 28, 0);
        JButton btnCriarConta = criarBotaoPadrao("Criar minha conta");
        painelPrincipal.add(btnCriarConta, gbc);
 
        gbc.gridy = 11;
        gbc.insets = new Insets(0, 0, 2, 0);
        JLabel lblProblemas = new JLabel("Problemas em Logar? Entre em contato", SwingConstants.CENTER);
        lblProblemas.setFont(new Font("SansSerif", Font.PLAIN, 11));
        lblProblemas.setForeground(FG_DEFAULT);
        painelPrincipal.add(lblProblemas, gbc);
 
        gbc.gridy = 12;
        gbc.insets = new Insets(0, 0, 0, 0);
        JLabel lblZap = new JLabel("Whatsapp: xx x xxxx-xxxx", SwingConstants.CENTER);
        lblZap.setFont(new Font("SansSerif", Font.BOLD, 11));
        lblZap.setForeground(FG_DEFAULT);
        painelPrincipal.add(lblZap, gbc);

        add(painelPrincipal);

        btnEntrar.addActionListener(e -> {
            if (!txtUsuario.getText().isEmpty()) {
                dispose();
                new TelaInicio().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Usuário não cadastrado ou campos vazios.",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private JButton criarBotaoVoltar() {
        JButton btn = new JButton("← Voltar") {
            @Override protected void paintComponent(Graphics g) {
                setContentAreaFilled(false);
                super.paintComponent(g);
            }
        };
        btn.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btn.setForeground(FG_DEFAULT);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setFocusPainted(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return btn;
    }
 
    private JTextField criarCampoTexto() {
        JTextField tf = new JTextField();
        tf.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tf.setBackground(FIELD_BG);
        tf.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(FIELD_BORDER, 1),
                BorderFactory.createEmptyBorder(6, 8, 6, 8)));
        tf.setPreferredSize(new Dimension(0, 34));
        return tf;
    }
 
    private JButton criarBotaoPadrao(String texto) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("SansSerif", Font.PLAIN, 14));
        btn.setBackground(BTN_BG);
        btn.setForeground(FG_DEFAULT);
        btn.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BTN_BORDER, 1),
                BorderFactory.createEmptyBorder(8, 16, 8, 16)));
        btn.setFocusPainted(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setPreferredSize(new Dimension(0, 38));
        return btn;
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaLogin().setVisible(true));
    }
}
 
