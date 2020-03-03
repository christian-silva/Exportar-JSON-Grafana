/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import conexao.ConexaoPermanente;
import conexao.DAO;
import dados.dashboard;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Christian
 */
public class JanelaDoGrafico extends javax.swing.JFrame {

    /**
     * Creates new form JanelaDoGrafico
     */
    private ArrayList<String[]> listaDaTabela;
    private List<dashboard> listaDashboards;
    private DefaultTableModel valoresTabela;
    private JFrame jframeGeral;
    private JFrame frameLoading;
    private JLabel imagemCarregando;

    public JanelaDoGrafico() {
        initComponents();

        Image fundo = null;

        try {
            URL url = this.getClass().getResource("/icones/systemtray.png");
            Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
            fundo = imagemTitulo;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.err.println("Erro ao carregar icone da aplica��o");;
        }

        this.setIconImage(fundo);

        valoresTabela = (DefaultTableModel) tabelaDados.getModel();
        listaDaTabela = new ArrayList<>();
        listaDashboards = new ArrayList<>();
        jframeGeral = this;

        tabelaDados.getColumnModel().getColumn(2).setMinWidth(0);
        tabelaDados.getColumnModel().getColumn(2).setMaxWidth(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDados = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        botaoSelecionarPastaBD = new javax.swing.JButton();
        numRegistros = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nomeBanco = new javax.swing.JTextField();
        botaoExportarCSV = new javax.swing.JButton();
        botaoExportarJSON = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Exportar JSON do Grafana");

        tabelaDados.setAutoCreateRowSorter(true);
        tabelaDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data da Cria��o", "Data da Modifica��o", "Slug", "T�tulo", "Dados", "Id da Organiza��o", "Nome da Organiza��o"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaDados.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tabelaDados);
        tabelaDados.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        botaoSelecionarPastaBD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icons8-database-24.png"))); // NOI18N
        botaoSelecionarPastaBD.setText("Selecione Banco de Dados");
        botaoSelecionarPastaBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSelecionarPastaBDActionPerformed(evt);
            }
        });

        numRegistros.setEditable(false);
        numRegistros.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numRegistros.setText(" ");

        jLabel6.setText("N�mero de Registros");

        jLabel1.setText("Nome do Banco de Dados");

        nomeBanco.setEditable(false);
        nomeBanco.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        nomeBanco.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(botaoSelecionarPastaBD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeBanco)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 513, Short.MAX_VALUE)))
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(numRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(numRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(botaoSelecionarPastaBD, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botaoExportarCSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/ic_save_black_24dp_1x.png"))); // NOI18N
        botaoExportarCSV.setText("Exportar para CSV");
        botaoExportarCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExportarCSVActionPerformed(evt);
            }
        });

        botaoExportarJSON.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/ic_save_black_24dp_1x.png"))); // NOI18N
        botaoExportarJSON.setText("Exportar para JSON");
        botaoExportarJSON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExportarJSONActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1)
                .addGap(11, 11, 11))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoExportarCSV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoExportarJSON)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoExportarCSV)
                    .addComponent(botaoExportarJSON))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoSelecionarPastaBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSelecionarPastaBDActionPerformed

        jframeGeral = this;
        ConexaoPermanente.fecharConexao();
        String nomeUsuarioSistema = System.getProperty("user.name");
        File caminhoAbsolutoJAR = new File(".");
        String caminho = null;
        try {
            caminho = caminhoAbsolutoJAR.getCanonicalPath();
        } catch (IOException ex) {
            Logger.getLogger(JanelaDoGrafico.class.getName()).log(Level.SEVERE, null, ex);
        }
        /**
         * Respons�vel por abrir uma janela
         */
        JFileChooser abrir = new JFileChooser();
        File novoDiretorio = new File("C:/Users/" + nomeUsuarioSistema + "/Desktop/");
        if (!novoDiretorio.exists()) {
            novoDiretorio = new File("E:/Desktop/");
        }

        abrir.setCurrentDirectory(novoDiretorio);
        abrir.setFileSelectionMode(JFileChooser.FILES_ONLY);

        FileFilter filefilter = new FileNameExtensionFilter("Arquivo do Grafana", "db");
        abrir.setFileFilter(filefilter);

        int verificacao = abrir.showOpenDialog(jframeGeral);
        if (verificacao == JFileChooser.APPROVE_OPTION) {
            String caminhoBD = abrir.getSelectedFile().toString();
            ConexaoPermanente.fecharConexao();
            RealizarConexaoComBancoDados(caminhoBD);

            /**
             * Verifica se conseguiu conectar
             */
            if (ConexaoPermanente.getConexao() != null) {

                nomeBanco.setText(abrir.getSelectedFile().getAbsolutePath());

                Thread propertie = new Thread() {
                    @Override
                    public void run() {
                        inicializaProcessoCarregando(jframeGeral);
                        /**
                         * Apaga o que tinha antes na tabela
                         */
                        try {
                            listaDaTabela.clear();
                            listaDashboards.clear();
                            while (tabelaDados.getModel().getRowCount() > 0) {
                                ((DefaultTableModel) tabelaDados.getModel()).removeRow(0);
                            }

                            DAO dashboards = new DAO(jframeGeral);
                            listaDashboards = dashboards.selecionarDashboards();

                            numRegistros.setText(String.valueOf(listaDashboards.size()));

                            for (dashboard dado : listaDashboards) {
                                //String dataCriacao = formatarData(dado.getData_criacao());
                                // String dataModificacao = formatarData(dado.getData_modificacao());

                                String[] inserir = {
                                    String.valueOf(dado.getData_criacao()),
                                    String.valueOf(dado.getData_modificacao()),
                                    dado.getSlug(),
                                    dado.getTitulo(),
                                    dado.getDados(),
                                    String.valueOf(dado.getId_organizacao()),
                                    String.valueOf(dado.getNome_organizacao()),};
                                valoresTabela.addRow(inserir);
                                listaDaTabela.add(inserir);
                            }
                        } catch (Exception ex) {
                            System.err.println(" Erro: " + ex);
                        }
                        finalizarProcessoCarregando();
                    }
                };
                propertie.start();
            }
        }

    }//GEN-LAST:event_botaoSelecionarPastaBDActionPerformed

    private void botaoExportarCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExportarCSVActionPerformed
        int existeLinha = tabelaDados.getRowCount();
        if (existeLinha > 0) {
            JFileChooser abrir = new JFileChooser();
            /**
             * Obtem o nome do usu�rio do sistema
             */
            String nomeUsuarioSistema = System.getProperty("user.name");
            File novoDiretorio = new File("C:/Users/" + nomeUsuarioSistema + "/Desktop/");
            if (!novoDiretorio.exists()) {
                novoDiretorio = new File("E:/Desktop/");
            }
            abrir.setCurrentDirectory(novoDiretorio);
            /**
             * Abre diret�rios e arquivos
             */
            //abrir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            abrir.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            /**
             * Mostrar apenas os arquivos .csv
             */
            FileFilter filefilter = new FileNameExtensionFilter("Dados CSV", "csv");
            abrir.setFileFilter(filefilter);
            /**
             * Abre com o nome do arquivo CSV
             */
            abrir.setSelectedFile(new File("Dados grafana.csv"));
            int verificacao = abrir.showOpenDialog(this);
            if (verificacao == JFileChooser.APPROVE_OPTION) {
                novoDiretorio = abrir.getSelectedFile();
                String dir = null;
                //Charset utf8 = null;
                try {
                    dir = novoDiretorio.getCanonicalPath();
                    //utf8 = StandardCharsets.ISO_8859_1;
                } catch (IOException ex) {
                    Logger.getLogger(JanelaDoGrafico.class.getName()).log(Level.SEVERE, null, ex);
                }
                Path path;
                if (!dir.contains(".csv")) {
                    path = Paths.get(dir + ".csv");
                } else {
                    path = Paths.get(dir);
                }

                try (BufferedWriter w = Files.newBufferedWriter(path)) {
                    w.write(getCabecalho() + "\n");
                    //System.out.println("Size: " + linhasInseridasNFe.size());
                    //linhasInseridasCTE
                    for (String[] linha : listaDaTabela) {
                        w.write(linha[0] + ";" + linha[1] + ";" + linha[2] + ";" + linha[3] + ";" + linha[4] + ";" + linha[5] + "\n");
                    }
                    Icon icon1 = icon1 = new ImageIcon(getClass().getResource("/icones/ic_save_black_24dp_1x.png"));
                    JOptionPane.showMessageDialog(this, "       CSV do Grafana salvo com sucesso", "CSV", JOptionPane.PLAIN_MESSAGE, icon1);

                } catch (IOException ex) {
                    System.out.println("Erro ao gerar o arquivo CSV");
                    JOptionPane.showMessageDialog(this, "N�o foi poss�vel gerar o arquivo CSV", "Erro na gera��o do arquivo .csv", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_botaoExportarCSVActionPerformed

    private void botaoExportarJSONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExportarJSONActionPerformed
        /**
         * Respons�vel por abrir uma janela
         */
        String nomeUsuarioSistema = System.getProperty("user.name");
        JFileChooser abrir = new JFileChooser();
        File novoDiretorio = new File("C:/Users/" + nomeUsuarioSistema + "/Desktop/");
        if (novoDiretorio.exists()) {
            abrir.setCurrentDirectory(novoDiretorio);
        } else {
            novoDiretorio = new File("E:/Desktop/");
            abrir.setCurrentDirectory(novoDiretorio);
        }

        abrir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int verificacao = abrir.showOpenDialog(this);
        if (verificacao == JFileChooser.APPROVE_OPTION) {
            // Mostra os labels
            //System.out.println("Caminho: " + abrir.getSelectedFile());
            Charset utf8 = StandardCharsets.UTF_8;

            for (String[] linha : listaDaTabela) {

                Path destino = Paths.get(abrir.getSelectedFile() + "\\" + linha[2] + "-" + linha[6] + ".json");
                System.out.println("Destino do ArquivoJSON: " + destino);

                if (destino.toFile().exists()) {
                    // System.err.println("Arquivo existe ");
                } else {
                    //System.err.println("Arquivo n�o existe ");
                    try (BufferedWriter w = Files.newBufferedWriter(destino, utf8)) {

                        w.write(linha[4]);

                    } catch (IOException ex) {
                        System.err.println("Erro ao gerar o arquivo TXT: " + ex);
                    }
                }
            }
            try {
                Runtime.getRuntime().exec("explorer " + abrir.getSelectedFile());
            } catch (IOException ex) {
                Logger.getLogger(ex.getMessage());
            }
        }
    }//GEN-LAST:event_botaoExportarJSONActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaDoGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaDoGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaDoGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaDoGrafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaDoGrafico().setVisible(true);
            }
        });
    }

    public static double truncate(double value) {
        return Math.round(value * 100) / 100d;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoExportarCSV;
    private javax.swing.JButton botaoExportarJSON;
    private javax.swing.JButton botaoSelecionarPastaBD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeBanco;
    private javax.swing.JTextField numRegistros;
    private javax.swing.JTable tabelaDados;
    // End of variables declaration//GEN-END:variables

    private void RealizarConexaoComBancoDados(String path) {
        try {
            ConexaoPermanente.CriaConexao(path);
        } catch (Exception ex) {
            System.err.println("Erro na conex�o com o Banco de Dados.\n" + ex.getMessage());
        }
    }

    private String formatarData(String data) {
        if (data != null) {
            SimpleDateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date dateManipulada = null;

            try {
                dateManipulada = formato2.parse(data);
            } catch (ParseException ex1) {
                Logger.getLogger(JanelaDoGrafico.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return formatter.format(dateManipulada);
        } else {
            return "2001-01-01 00:00:01";
        }
    }

    private void inicializaProcessoCarregando(JFrame jframe) {
        frameLoading = new JFrame("Verificando...");
        imagemCarregando = new JLabel();
        Container content = frameLoading.getContentPane();
        frameLoading.setTitle("Verificando...");
        imagemCarregando.setIcon(new ImageIcon(getClass().getResource("/icones/loading.gif")));
        frameLoading.toFront();
        content.add(imagemCarregando, BorderLayout.CENTER);

        //Fundo fundoLogin = new Fundo();
        //fundoLogin.setAtivarImagemInteira(true);
        //frame.setIconImage(fundoLogin.carregaIconeAplicacao(true));
        frameLoading.setSize(40, 45);
        frameLoading.setUndecorated(true);
        frameLoading.setLocationRelativeTo(jframe);
        frameLoading.setVisible(true);
        this.setEnabled(false);
    }

    private void finalizarProcessoCarregando() {
        this.setEnabled(true);
        frameLoading.dispose();
        this.toFront();

    }

    private String getCabecalho() {
        return "Data da Cria��o;Data da Modifica��o;T�tulo;Dados;Id da Organiza��o;Nome da Organiza��o";
    }
}
