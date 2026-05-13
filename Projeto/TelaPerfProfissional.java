package view;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TelaPerfProfissional extends JFrame {

    private static final Color BG_WHITE  = Color.WHITE;
    private static final Color BORDER_C  = new Color(180, 180, 180);
    private static final Color BG_AREA   = new Color(245, 245, 245);
    private static final Color FG_DEF    = new Color(30, 30, 30);
    private static final Color FG_GRAY   = new Color(130, 130, 130);

    public TelaPerfProfissional() {
        setTitle("Perfil do Profissional");
        setSize(1000, 700);
        setMinimumSize(new Dimension(800, 560));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(BG_WHITE);
        setLayout(new BorderLayout());

        add(criarPnlTop(),    BorderLayout.NORTH);
        add(criarPnlCorpo(),  BorderLayout.CENTER);
    }

    private JPanel criarPnlTop() {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 16, 10));
        p.setBackground(BG_WHITE);
        p.add(criarBtnVoltar());
        return p;
    }

    private JPanel criarPnlCorpo() {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(BG_WHITE);
        p.setBorder(BorderFactory.createEmptyBorder(10, 60, 20, 60));

        p.add(criarSecaoTopo());
        p.add(Box.createVerticalStrut(28));
        p.add(criarSecaoAvaliacoes());
        p.add(Box.createVerticalStrut(16));
        p.add(criarBtnVerMais());
        p.add(Box.createVerticalGlue());

        JScrollPane scroll = new JScrollPane(p);
        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.getVerticalScrollBar().setUnitIncrement(16);

        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBackground(BG_WHITE);
        wrapper.add(scroll, BorderLayout.CENTER);
        return wrapper;
    }

    private JPanel criarSecaoTopo() {
        JPanel p = new JPanel(new GridBagLayout());
        p.setBackground(BG_WHITE);
        p.setMaximumSize(new Dimension(Integer.MAX_VALUE, 220));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 0, 32);
        gbc.weighty = 1.0;

        gbc.gridx = 0; gbc.weightx = 0.62;
        JTextArea txtDesc = new JTextArea("Descrição");
        txtDesc.setFont(new Font("SansSerif", Font.PLAIN, 13));
        txtDesc.setForeground(FG_DEF);
        txtDesc.setLineWrap(true);
        txtDesc.setWrapStyleWord(true);
        txtDesc.setEditable(false);
        txtDesc.setBackground(BG_WHITE);
        txtDesc.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER_C, 1),
                BorderFactory.createEmptyBorder(12, 12, 12, 12)));
        p.add(txtDesc, gbc);

        gbc.gridx = 1; gbc.weightx = 0.28; gbc.insets = new Insets(0, 0, 0, 0);
        JPanel pnlInfo = new JPanel();
        pnlInfo.setLayout(new BoxLayout(pnlInfo, BoxLayout.Y_AXIS));
        pnlInfo.setBackground(BG_WHITE);

        JLabel lblFoto = new JLabel(iconePerfilQuadrado(90));
        lblFoto.setBorder(BorderFactory.createLineBorder(BORDER_C, 1));
        lblFoto.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlInfo.add(lblFoto);
        pnlInfo.add(Box.createVerticalStrut(8));

        for (String txt : new String[]{"Nome", "Profissão", "CNPJ", "Nota:"}) {
            JLabel l = new JLabel(txt, SwingConstants.CENTER);
            l.setFont(new Font("SansSerif", Font.PLAIN, 13));
            l.setForeground(FG_DEF);
            l.setAlignmentX(Component.CENTER_ALIGNMENT);
            pnlInfo.add(l);
        }

        p.add(pnlInfo, gbc);
        return p;
    }

    private JPanel criarSecaoAvaliacoes() {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(BG_WHITE);

        JLabel titulo = new JLabel("Avaliações", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.PLAIN, 20));
        titulo.setForeground(FG_DEF);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        p.add(titulo);
        p.add(Box.createVerticalStrut(14));

        // Grid 2 colunas de cards de avaliação
        JPanel grid = new JPanel(new GridLayout(1, 2, 20, 0));
        grid.setBackground(BG_WHITE);
        grid.setMaximumSize(new Dimension(Integer.MAX_VALUE, 160));
        grid.add(criarCardComentario());
        grid.add(criarCardComentario());

        p.add(grid);
        return p;
    }

    private JPanel criarCardComentario() {
        JPanel card = new JPanel(new BorderLayout(10, 0));
        card.setBackground(BG_WHITE);

        JPanel pnlEsq = new JPanel();
        pnlEsq.setLayout(new BoxLayout(pnlEsq, BoxLayout.Y_AXIS));
        pnlEsq.setBackground(BG_WHITE);
        pnlEsq.setPreferredSize(new Dimension(72, 0));

        JLabel ic = new JLabel(iconePerfilQuadrado(44));
        ic.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlEsq.add(ic);

        for (String txt : new String[]{"Nome", "Nota:"}) {
            JLabel l = new JLabel(txt);
            l.setFont(new Font("SansSerif", Font.PLAIN, 12));
            l.setForeground(FG_DEF);
            l.setAlignmentX(Component.LEFT_ALIGNMENT);
            pnlEsq.add(l);
        }

        JTextArea txtComentario = new JTextArea("Comentário");
        txtComentario.setFont(new Font("SansSerif", Font.PLAIN, 13));
        txtComentario.setForeground(FG_GRAY);
        txtComentario.setLineWrap(true);
        txtComentario.setWrapStyleWord(true);
        txtComentario.setEditable(false);
        txtComentario.setBackground(BG_WHITE);
        txtComentario.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER_C, 1),
                BorderFactory.createEmptyBorder(8, 8, 8, 8)));

        card.add(pnlEsq,        BorderLayout.WEST);
        card.add(txtComentario, BorderLayout.CENTER);
        return card;
    }

    private JPanel criarBtnVerMais() {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p.setBackground(BG_WHITE);
        JComboBox<String> cb = new JComboBox<>(new String[]{"Ver mais"});
        cb.setFont(new Font("SansSerif", Font.PLAIN, 13));
        cb.setBackground(BG_WHITE);
        cb.setPreferredSize(new Dimension(130, 30));
        p.add(cb);
        return p;
    }

    private JButton criarBtnVoltar() {
        JButton btn = new JButton("← Voltar");
        btn.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btn.setForeground(new Color(30, 30, 30));
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setFocusPainted(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return btn;
    }

    private ImageIcon iconePerfilQuadrado(int size) {
        BufferedImage img = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(BG_WHITE);
        g2.fillRect(0, 0, size, size);
        g2.setColor(BORDER_C);
        g2.setStroke(new BasicStroke(1.5f));
        g2.drawRect(0, 0, size - 1, size - 1);
        int headR = size / 5;
        g2.setColor(new Color(120, 120, 120));
        g2.fillOval(size / 2 - headR, size / 6, headR * 2, headR * 2);
        int bW = (int)(size * 0.55), bH = (int)(size * 0.30);
        g2.fillArc(size / 2 - bW / 2, size / 6 + headR * 2 + size / 12, bW, bH, 0, 180);
        g2.dispose();
        return new ImageIcon(img);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaPerfProfissional().setVisible(true));
    }
}
