package view;
 
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
 
public class TelaInicio extends JFrame {
 
    private static final Color BG_FRAME    = Color.WHITE;
    private static final Color BG_CARD     = Color.WHITE;
    private static final Color BORDER_CLR  = new Color(210, 210, 210);
    private static final Color FG_DEFAULT  = new Color(30, 30, 30);
    private static final Color FG_GRAY     = new Color(140, 140, 140);
    private static final Color BTN_GREEN_BG = new Color(34, 139, 34);
    private static final Color BTN_BORDER  = new Color(180, 180, 180);
    private static final Color FIELD_BORDER = new Color(190, 190, 190);
 
    public TelaInicio() {
        setTitle("Início");
        setSize(1000, 760);
        setMinimumSize(new Dimension(800, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(BG_FRAME);
        setLayout(new BorderLayout(0, 0));
 
        add(criarPainelSuperior(), BorderLayout.NORTH);
        add(criarPainelCentral(),  BorderLayout.CENTER);
    }
 
    private JPanel criarPainelSuperior() {
        JPanel pnl = new JPanel(new BorderLayout(12, 0));
        pnl.setBackground(BG_FRAME);
        pnl.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, BORDER_CLR),
                BorderFactory.createEmptyBorder(14, 24, 14, 24)));
 
        JTextField txtBusca = new JTextField("busca avançada");
        txtBusca.setFont(new Font("SansSerif", Font.PLAIN, 14));
        txtBusca.setForeground(FG_GRAY);
        txtBusca.setHorizontalAlignment(SwingConstants.CENTER);
        txtBusca.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(FIELD_BORDER, 1),
                BorderFactory.createEmptyBorder(7, 12, 7, 12)));
        txtBusca.setMaximumSize(new Dimension(380, 36));
        txtBusca.setPreferredSize(new Dimension(300, 36));
        txtBusca.addFocusListener(new FocusAdapter() {
            @Override public void focusGained(FocusEvent e) {
                if (txtBusca.getText().contains("busca avançada")) {
                    txtBusca.setText("");
                    txtBusca.setForeground(FG_DEFAULT);
                    txtBusca.setHorizontalAlignment(SwingConstants.LEFT);
                }
            }
            @Override public void focusLost(FocusEvent e) {
                if (txtBusca.getText().isEmpty()) {
                    txtBusca.setForeground(FG_GRAY);
                    txtBusca.setHorizontalAlignment(SwingConstants.CENTER);
                    txtBusca.setText("busca avançada");
                }
            }
        });
 
        JPanel pnlBusca = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        pnlBusca.setBackground(BG_FRAME);
        pnlBusca.add(txtBusca);
 
        JPanel pnlIcones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 14, 0));
        pnlIcones.setBackground(BG_FRAME);
 
        JLabel lblAjuda = new JLabel("?");
        lblAjuda.setFont(new Font("SansSerif", Font.BOLD, 20));
        lblAjuda.setForeground(FG_DEFAULT);
        lblAjuda.setToolTipText("Guia de uso do site");
        lblAjuda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
 
        JLabel lblPerfil = new JLabel(criarIconePerfil(36));
        lblPerfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblPerfil.setToolTipText("Perfil do usuário");
 
        pnlIcones.add(lblAjuda);
        pnlIcones.add(lblPerfil);
 
        pnl.add(pnlBusca,  BorderLayout.CENTER);
        pnl.add(pnlIcones, BorderLayout.EAST);
        return pnl;
    }
 
    private JPanel criarPainelCentral() {
        JPanel pnl = new JPanel(new BorderLayout(0, 0));
        pnl.setBackground(BG_FRAME);
 
        JPanel pnlFiltro = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 10));
        pnlFiltro.setBackground(BG_FRAME);
        pnlFiltro.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, BORDER_CLR));
 
        String[] profissoes = {"Selecionar Profissão", "Encanador", "Pintor",
                               "Marceneiro", "Eletricista", "Faxineiro", "Jardineiro"};
        JComboBox<String> cbProfissoes = new JComboBox<>(profissoes);
        cbProfissoes.setFont(new Font("SansSerif", Font.PLAIN, 13));
        cbProfissoes.setPreferredSize(new Dimension(200, 32));
        pnlFiltro.add(cbProfissoes);
 
        JPanel pnlLista = new JPanel();
        pnlLista.setLayout(new BoxLayout(pnlLista, BoxLayout.Y_AXIS));
        pnlLista.setBackground(BG_FRAME);
        pnlLista.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
 
        pnlLista.add(criarCard("Nome", "Profissão", "Nota", "Contratos Concluídos",
                               "Descrição Profissional"));
        pnlLista.add(Box.createVerticalStrut(10));
        pnlLista.add(criarCard("Nome", "Profissão", "Nota", "Contratos Concluídos",
                               "Descrição Profissional"));
        pnlLista.add(Box.createVerticalStrut(10));
        pnlLista.add(criarCard("Nome", "Profissão", "Nota", "Contratos Concluídos",
                               "Descrição Profissional"));
 
        JScrollPane scroll = new JScrollPane(pnlLista);
        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
 
        pnl.add(pnlFiltro, BorderLayout.NORTH);
        pnl.add(scroll,    BorderLayout.CENTER);
        return pnl;
    }
 
    private JPanel criarCard(String nome, String profissao, String nota,
                             String contratos, String descricao) {
 
        JPanel card = new JPanel(new GridBagLayout());
        card.setBackground(BG_CARD);
        card.setBorder(BorderFactory.createLineBorder(BORDER_CLR, 1));
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 160));
 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 12, 8, 12);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
 
        JPanel pnlInfo = new JPanel();
        pnlInfo.setLayout(new BoxLayout(pnlInfo, BoxLayout.Y_AXIS));
        pnlInfo.setBackground(BG_CARD);
 
        JLabel icPerfil = new JLabel(criarIconePerfil(44));
        icPerfil.setAlignmentX(Component.LEFT_ALIGNMENT);
 
        JLabel lblNome       = criarInfoLabel(nome,       false);
        JLabel lblProfissao  = criarInfoLabel(profissao,  false);
        JLabel lblNota       = criarInfoLabel(nota,       false);
        JLabel lblContratos  = criarInfoLabel(contratos,  false);
 
        pnlInfo.add(icPerfil);
        pnlInfo.add(Box.createVerticalStrut(4));
        pnlInfo.add(lblNome);
        pnlInfo.add(lblProfissao);
        pnlInfo.add(lblNota);
        pnlInfo.add(lblContratos);
 
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.22; gbc.weighty = 1.0;
        card.add(pnlInfo, gbc);
 
        gbc.gridx = 1; gbc.weightx = 0.0; gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(10, 0, 10, 0);
        card.add(new JSeparator(JSeparator.VERTICAL), gbc);
 
        gbc.gridx = 2; gbc.weightx = 0.45; gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(8, 12, 8, 12);
        JTextArea txtDesc = new JTextArea(descricao);
        txtDesc.setFont(new Font("SansSerif", Font.PLAIN, 13));
        txtDesc.setForeground(FG_DEFAULT);
        txtDesc.setLineWrap(true);
        txtDesc.setWrapStyleWord(true);
        txtDesc.setEditable(false);
        txtDesc.setBackground(BG_CARD);
        txtDesc.setBorder(null);
        card.add(txtDesc, gbc);
 
        gbc.gridx = 3; gbc.weightx = 0.0; gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(10, 0, 10, 0);
        card.add(new JSeparator(JSeparator.VERTICAL), gbc);
 
        JPanel pnlBotoes = new JPanel();
        pnlBotoes.setLayout(new BoxLayout(pnlBotoes, BoxLayout.Y_AXIS));
        pnlBotoes.setBackground(BG_CARD);
 
        String[] avalOpcoes = {"Avaliações"};
        JComboBox<String> cbAvaliacoes = new JComboBox<>(avalOpcoes);
        cbAvaliacoes.setFont(new Font("SansSerif", Font.PLAIN, 13));
        cbAvaliacoes.setMaximumSize(new Dimension(Integer.MAX_VALUE, 32));
        cbAvaliacoes.setAlignmentX(Component.CENTER_ALIGNMENT);
 
        JButton btnContratar = new JButton("Contratar");
        btnContratar.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnContratar.setBackground(BG_CARD);
        btnContratar.setForeground(FG_DEFAULT);
        btnContratar.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BTN_BORDER, 1),
                BorderFactory.createEmptyBorder(6, 16, 6, 16)));
        btnContratar.setFocusPainted(false);
        btnContratar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnContratar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnContratar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 32));
 
        pnlBotoes.add(cbAvaliacoes);
        pnlBotoes.add(Box.createVerticalStrut(8));
        pnlBotoes.add(btnContratar);
 
        gbc.gridx = 4; gbc.weightx = 0.20; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(8, 8, 8, 16);
        card.add(pnlBotoes, gbc);
 
        return card;
    }
 
    private JLabel criarInfoLabel(String texto, boolean negrito) {
        JLabel lbl = new JLabel(texto);
        lbl.setFont(new Font("SansSerif", negrito ? Font.BOLD : Font.PLAIN, 13));
        lbl.setForeground(FG_DEFAULT);
        lbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        return lbl;
    }
 
    private ImageIcon criarIconePerfil(int size) {
        java.awt.image.BufferedImage img =
                new java.awt.image.BufferedImage(size, size,
                        java.awt.image.BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
 
        g2.setColor(new Color(200, 200, 200));
        g2.fillOval(0, 0, size - 1, size - 1);
        g2.setColor(new Color(150, 150, 150));
        g2.setStroke(new BasicStroke(1.5f));
        g2.drawOval(0, 0, size - 1, size - 1);
 
        int headR = size / 5;
        int headX = size / 2 - headR;
        int headY = size / 5;
        g2.setColor(new Color(130, 130, 130));
        g2.fillOval(headX, headY, headR * 2, headR * 2);
 
        int bodyW = (int)(size * 0.55);
        int bodyH = (int)(size * 0.30);
        int bodyX = size / 2 - bodyW / 2;
        int bodyY = headY + headR * 2 + size / 12;
        g2.fillArc(bodyX, bodyY, bodyW, bodyH, 0, 180);
 
        g2.dispose();
        return new ImageIcon(img);
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaInicio().setVisible(true));
    }
}
 
