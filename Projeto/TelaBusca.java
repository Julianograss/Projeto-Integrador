package view;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TelaBusca extends JFrame {

    private static final Color BG_WHITE  = Color.WHITE;
    private static final Color BG_GRAY   = new Color(220, 220, 220);
    private static final Color BG_DESC   = new Color(210, 210, 210);
    private static final Color BORDER_C  = new Color(180, 180, 180);
    private static final Color FG_DEF    = new Color(30, 30, 30);
    private static final Color FG_GRAY   = new Color(140, 140, 140);

    private boolean painelFiltroVisivel = true;
    private JPanel  pnlFiltro;
    private JButton btnToggle;

    public TelaBusca() {
        setTitle("Busca Avançada");
        setSize(1050, 680);
        setMinimumSize(new Dimension(800, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(BG_WHITE);
        setLayout(new BorderLayout());

        add(criarPnlTop(),     BorderLayout.NORTH);
        add(criarPnlCorpo(),   BorderLayout.CENTER);
    }

    private JPanel criarPnlTop() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(BG_WHITE);
        p.setBorder(BorderFactory.createEmptyBorder(10, 16, 8, 16));

        JButton btnVoltar = criarBtnVoltar();

        JTextField txtBusca = new JTextField("Buscar profissional");
        txtBusca.setFont(new Font("SansSerif", Font.PLAIN, 13));
        txtBusca.setForeground(FG_GRAY);
        txtBusca.setHorizontalAlignment(SwingConstants.CENTER);
        txtBusca.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER_C, 1),
                BorderFactory.createEmptyBorder(6, 12, 6, 12)));
        txtBusca.setPreferredSize(new Dimension(240, 30));
        txtBusca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e) {
                if (txtBusca.getText().contains("Buscar")) {
                    txtBusca.setText("");
                    txtBusca.setForeground(FG_DEF);
                    txtBusca.setHorizontalAlignment(SwingConstants.LEFT);
                }
            }
            public void focusLost(java.awt.event.FocusEvent e) {
                if (txtBusca.getText().isEmpty()) {
                    txtBusca.setText("Buscar profissional");
                    txtBusca.setForeground(FG_GRAY);
                    txtBusca.setHorizontalAlignment(SwingConstants.CENTER);
                }
            }
        });

        JPanel pnlBusca = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlBusca.setBackground(BG_WHITE);
        pnlBusca.add(txtBusca);

        p.add(btnVoltar, BorderLayout.WEST);
        p.add(pnlBusca,  BorderLayout.CENTER);
        return p;
    }

    private JPanel criarPnlCorpo() {
        JPanel p = new JPanel(new BorderLayout(0, 0));
        p.setBackground(BG_WHITE);

        JPanel pnlLista = new JPanel();
        pnlLista.setLayout(new BoxLayout(pnlLista, BoxLayout.Y_AXIS));
        pnlLista.setBackground(BG_WHITE);
        pnlLista.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 12));

        pnlLista.add(criarCardProfissional());
        pnlLista.add(Box.createVerticalStrut(0));
        pnlLista.add(separadorH());
        pnlLista.add(Box.createVerticalStrut(0));
        pnlLista.add(criarCardProfissional());
        pnlLista.add(Box.createVerticalGlue());

        JScrollPane scroll = new JScrollPane(pnlLista);
        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        pnlFiltro = criarPnlFiltros();

        btnToggle = new JButton("›");
        btnToggle.setFont(new Font("SansSerif", Font.BOLD, 22));
        btnToggle.setForeground(FG_DEF);
        btnToggle.setBorderPainted(false);
        btnToggle.setContentAreaFilled(false);
        btnToggle.setFocusPainted(false);
        btnToggle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnToggle.setToolTipText("Mostrar/ocultar filtros");

        JPanel pnlDireita = new JPanel(new BorderLayout());
        pnlDireita.setBackground(BG_WHITE);
        pnlDireita.add(btnToggle,  BorderLayout.NORTH);
        pnlDireita.add(pnlFiltro,  BorderLayout.CENTER);

        btnToggle.addActionListener(e -> {
            painelFiltroVisivel = !painelFiltroVisivel;
            pnlFiltro.setVisible(painelFiltroVisivel);
            btnToggle.setText(painelFiltroVisivel ? "›" : "‹");
            revalidate();
        });

        p.add(scroll,     BorderLayout.CENTER);
        p.add(pnlDireita, BorderLayout.EAST);
        return p;
    }

    private JPanel criarCardProfissional() {
        JPanel card = new JPanel(new GridBagLayout());
        card.setBackground(BG_WHITE);
        card.setBorder(BorderFactory.createEmptyBorder(16, 0, 16, 0));
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 200));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 8, 0, 8);
        gbc.weighty = 1.0;

        JPanel pnlInfo = new JPanel();
        pnlInfo.setLayout(new BoxLayout(pnlInfo, BoxLayout.Y_AXIS));
        pnlInfo.setBackground(BG_WHITE);

        JLabel ic = new JLabel(iconePerfilQuadrado(44));
        ic.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlInfo.add(ic);
        pnlInfo.add(Box.createVerticalStrut(4));
        for (String txt : new String[]{"Nome", "Profissão", "Nota", "Contratos concluídos"}) {
            JLabel l = new JLabel(txt);
            l.setFont(new Font("SansSerif", Font.PLAIN, 13));
            l.setForeground(FG_DEF);
            l.setAlignmentX(Component.LEFT_ALIGNMENT);
            pnlInfo.add(l);
        }
        pnlInfo.add(Box.createVerticalStrut(6));

        JTextField tfAval = new JTextField("Avaliações");
        tfAval.setFont(new Font("SansSerif", Font.PLAIN, 12));
        tfAval.setEditable(false);
        tfAval.setBackground(BG_WHITE);
        tfAval.setBorder(BorderFactory.createLineBorder(BORDER_C, 1));
        tfAval.setMaximumSize(new Dimension(110, 26));
        tfAval.setAlignmentX(Component.LEFT_ALIGNMENT);
        pnlInfo.add(tfAval);

        gbc.gridx = 0; gbc.weightx = 0.30;
        card.add(pnlInfo, gbc);

        gbc.gridx = 1; gbc.weightx = 0.0;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(0, 4, 0, 4);
        card.add(new JSeparator(JSeparator.VERTICAL), gbc);

        gbc.gridx = 2; gbc.weightx = 0.55;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 8, 0, 8);
        JPanel pnlDesc = new JPanel(new BorderLayout());
        pnlDesc.setBackground(BG_DESC);
        pnlDesc.setBorder(BorderFactory.createLineBorder(BORDER_C, 1));
        JLabel lblDesc = new JLabel("Descrição profissional", SwingConstants.CENTER);
        lblDesc.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblDesc.setForeground(FG_GRAY);
        pnlDesc.add(lblDesc, BorderLayout.CENTER);
        card.add(pnlDesc, gbc);

        return card;
    }

    private JPanel criarPnlFiltros() {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(BG_GRAY);
        p.setPreferredSize(new Dimension(200, 0));
        p.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

        for (String filtro : new String[]{"Profissão", "Preço", "Nota", "Distância"}) {
            p.add(criarComboFiltro(filtro));
            p.add(Box.createVerticalStrut(14));
        }
        p.add(Box.createVerticalGlue());
        return p;
    }

    private JPanel criarComboFiltro(String label) {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(BG_GRAY);
        p.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));

        JComboBox<String> cb = new JComboBox<>(new String[]{label});
        cb.setFont(new Font("SansSerif", Font.PLAIN, 13));
        cb.setBackground(BG_WHITE);
        p.add(cb, BorderLayout.CENTER);
        return p;
    }

    private JSeparator separadorH() {
        JSeparator sep = new JSeparator(JSeparator.HORIZONTAL);
        sep.setMaximumSize(new Dimension(Integer.MAX_VALUE, 2));
        sep.setForeground(BORDER_C);
        return sep;
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
        g2.setColor(new Color(200, 200, 200));
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
        SwingUtilities.invokeLater(() -> new TelaBusca().setVisible(true));
    }
}
