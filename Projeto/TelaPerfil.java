package view;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TelaPerfil extends JFrame {

    private static final Color BG_WHITE  = Color.WHITE;
    private static final Color BG_GRAY   = new Color(220, 220, 220);
    private static final Color BORDER_C  = new Color(190, 190, 190);
    private static final Color FG_DEF    = new Color(30, 30, 30);
    private static final Color FG_GRAY   = new Color(130, 130, 130);

    public TelaPerfil() {
        setTitle("Perfil");
        setSize(1000, 620);
        setMinimumSize(new Dimension(900, 540));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(BG_WHITE);
        setLayout(new BorderLayout());

        JPanel pnlTop = new JPanel(new FlowLayout(FlowLayout.LEFT, 16, 10));
        pnlTop.setBackground(BG_WHITE);
        JButton btnVoltar = criarBtnVoltar();
        pnlTop.add(btnVoltar);

        JPanel pnlCorpo = new JPanel(new GridLayout(1, 3, 12, 0));
        pnlCorpo.setBackground(BG_WHITE);
        pnlCorpo.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));

        pnlCorpo.add(criarColunaDados());
        pnlCorpo.add(criarColunaHistorico());
        pnlCorpo.add(criarColunaAvaliacoes());

        add(pnlTop,   BorderLayout.NORTH);
        add(pnlCorpo, BorderLayout.CENTER);
    }

    private JPanel criarColunaDados() {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(BG_GRAY);
        p.setBorder(BorderFactory.createEmptyBorder(24, 24, 24, 24));

        JLabel icPerfil = new JLabel(iconePerfilCirculo(64));
        icPerfil.setAlignmentX(Component.LEFT_ALIGNMENT);
        p.add(icPerfil);
        p.add(Box.createVerticalStrut(20));

        for (String campo : new String[]{"Nome", "E-mail", "Telefone", "Senha"}) {
            p.add(criarLinhaEditavel(campo));
            p.add(Box.createVerticalStrut(10));
        }
        p.add(Box.createVerticalGlue());
        return p;
    }

    private JPanel criarLinhaEditavel(String label) {
        JPanel linha = new JPanel(new BorderLayout(8, 0));
        linha.setBackground(BG_GRAY);
        linha.setMaximumSize(new Dimension(Integer.MAX_VALUE, 28));

        JLabel lbl = new JLabel(label);
        lbl.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lbl.setForeground(FG_DEF);

        JLabel lapsis = new JLabel(iconeLapis(14));
        lapsis.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        linha.add(lbl,    BorderLayout.CENTER);
        linha.add(lapsis, BorderLayout.EAST);
        return linha;
    }

    private JPanel criarColunaHistorico() {
        JPanel outer = new JPanel(new BorderLayout());
        outer.setBackground(BG_GRAY);
        outer.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(BG_GRAY);
        p.setBorder(BorderFactory.createEmptyBorder(16, 20, 16, 20));

        JLabel titulo = new JLabel("Histórico de contratos", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.PLAIN, 16));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        p.add(titulo);
        p.add(Box.createVerticalStrut(4));
        p.add(separadorH());
        p.add(Box.createVerticalStrut(12));

        p.add(criarItemContrato());
        p.add(Box.createVerticalStrut(4));
        p.add(separadorH());
        p.add(Box.createVerticalStrut(12));
        p.add(criarItemContrato());
        p.add(Box.createVerticalStrut(4));
        p.add(separadorH());
        p.add(Box.createVerticalGlue());

        JScrollPane scroll = new JScrollPane(p);
        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        outer.add(scroll, BorderLayout.CENTER);
        return outer;
    }

    private JPanel criarItemContrato() {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(BG_GRAY);
        p.setAlignmentX(Component.LEFT_ALIGNMENT);

        p.add(labelTexto("Nome:"));
        p.add(Box.createVerticalStrut(4));
        p.add(labelTexto("Profissão:"));
        p.add(Box.createVerticalStrut(6));

        // Linha "Contrato   [Ver detalhes]"
        JPanel linhaContrato = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 0));
        linhaContrato.setBackground(BG_GRAY);
        linhaContrato.setAlignmentX(Component.LEFT_ALIGNMENT);
        linhaContrato.add(labelTexto("Contrato"));
        JButton btnDet = new JButton("Ver detalhes");
        btnDet.setFont(new Font("SansSerif", Font.PLAIN, 11));
        btnDet.setBackground(BG_GRAY);
        btnDet.setBorder(BorderFactory.createLineBorder(BORDER_C, 1));
        btnDet.setFocusPainted(false);
        linhaContrato.add(btnDet);
        p.add(linhaContrato);
        p.add(Box.createVerticalStrut(6));

        // Linha "Valor:    Nota:"
        JPanel linhaVN = new JPanel(new FlowLayout(FlowLayout.LEFT, 24, 0));
        linhaVN.setBackground(BG_GRAY);
        linhaVN.setAlignmentX(Component.LEFT_ALIGNMENT);
        linhaVN.add(labelTexto("Valor:"));
        linhaVN.add(labelTexto("Nota:"));
        p.add(linhaVN);

        return p;
    }

    private JPanel criarColunaAvaliacoes() {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(BG_GRAY);
        p.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

        JLabel titulo = new JLabel("Minhas avaliações", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.PLAIN, 16));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        p.add(titulo);
        p.add(Box.createVerticalStrut(12));

        p.add(criarCardAvaliacao());
        p.add(Box.createVerticalStrut(8));
        p.add(criarCardAvaliacao());
        p.add(Box.createVerticalGlue());
        return p;
    }

    private JPanel criarCardAvaliacao() {
        JPanel card = new JPanel(new BorderLayout(8, 0));
        card.setBackground(BG_GRAY);
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 110));
        card.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel pnlEsq = new JPanel();
        pnlEsq.setLayout(new BoxLayout(pnlEsq, BoxLayout.Y_AXIS));
        pnlEsq.setBackground(BG_GRAY);
        pnlEsq.add(new JLabel(iconePerfilCirculo(36)));
        pnlEsq.add(labelTexto("Nome"));
        pnlEsq.add(labelTexto("Nota:"));
        JButton btnEditar = new JButton("Editar");
        btnEditar.setFont(new Font("SansSerif", Font.PLAIN, 11));
        btnEditar.setBackground(new Color(180, 180, 180));
        btnEditar.setBorder(BorderFactory.createLineBorder(BORDER_C, 1));
        btnEditar.setFocusPainted(false);
        pnlEsq.add(btnEditar);

        JTextArea txtComentario = new JTextArea();
        txtComentario.setBackground(Color.WHITE);
        txtComentario.setBorder(BorderFactory.createLineBorder(BORDER_C, 1));
        txtComentario.setLineWrap(true);
        txtComentario.setWrapStyleWord(true);

        card.add(pnlEsq,          BorderLayout.WEST);
        card.add(txtComentario,   BorderLayout.CENTER);
        return card;
    }


    private JLabel labelTexto(String txt) {
        JLabel l = new JLabel(txt);
        l.setFont(new Font("SansSerif", Font.PLAIN, 13));
        l.setForeground(FG_DEF);
        l.setAlignmentX(Component.LEFT_ALIGNMENT);
        return l;
    }

    private JSeparator separadorH() {
        JSeparator sep = new JSeparator(JSeparator.HORIZONTAL);
        sep.setMaximumSize(new Dimension(Integer.MAX_VALUE, 2));
        sep.setForeground(BORDER_C);
        sep.setAlignmentX(Component.LEFT_ALIGNMENT);
        return sep;
    }

    private JButton criarBtnVoltar() {
        JButton btn = new JButton("← Voltar");
        btn.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btn.setForeground(FG_DEF);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setFocusPainted(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return btn;
    }

    private ImageIcon iconePerfilCirculo(int size) {
        BufferedImage img = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(200, 200, 200));
        g2.fillOval(0, 0, size - 1, size - 1);
        g2.setColor(new Color(140, 140, 140));
        g2.setStroke(new BasicStroke(1.5f));
        g2.drawOval(0, 0, size - 1, size - 1);
        int headR = size / 5;
        g2.setColor(new Color(120, 120, 120));
        g2.fillOval(size / 2 - headR, size / 5, headR * 2, headR * 2);
        int bW = (int)(size * 0.55), bH = (int)(size * 0.30);
        g2.fillArc(size / 2 - bW / 2, size / 5 + headR * 2 + size / 12, bW, bH, 0, 180);
        g2.dispose();
        return new ImageIcon(img);
    }

    private ImageIcon iconeLapis(int size) {
        BufferedImage img = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(80, 80, 80));
        g2.setStroke(new BasicStroke(1.5f));

        int[] xp = {2, size - 4, size - 2, 0};
        int[] yp = {size - 4, 2, 4, size - 2};
        g2.drawPolygon(xp, yp, 4);

        g2.drawLine(0, size - 2, 2, size - 4);
        g2.dispose();
        return new ImageIcon(img);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaPerfil().setVisible(true));
    }
}
