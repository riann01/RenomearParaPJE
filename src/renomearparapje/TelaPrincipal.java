package renomearparapje;

import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import com.itextpdf.text.pdf.PdfReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaPrincipal extends javax.swing.JFrame {
    
    private File arquivos[];
    private String salvarCaminho;
    
    public TelaPrincipal() {
        initComponents();
        java.net.URL imgURL = getClass().getResource("/imagem/img.png");
        labelImg.setIcon(new ImageIcon(imgURL));
        this.setLocationRelativeTo(null);
        barraProgresso.setVisible(false);
        radioJuntada.setSelected(true);
        checkAlterarSomenteNumeracao.setEnabled(false);
        arquivos = new File[0];
    }
    
    public void preencherLista(File arquivosAbertos[]) {
        listaArquivosAbertos.setModel(new javax.swing.AbstractListModel<String>() {
            @Override
            public int getSize() { return arquivosAbertos.length; }
            @Override
            public String getElementAt(int i) { return arquivosAbertos[i].getName(); }
        });
    }
    
    public String[] retornarExtensoes(File arquivos[]) {
        String[] nomes = new String[arquivos.length];
        for (int i = 0; i < arquivos.length; i++) {
            nomes[i] = "";
            for (int j = arquivos[i].getName().length() - 1; j > 0; j--) {
                if (arquivos[i].getName().charAt(j) == '.') {
                    break;
                }
                else {
                    nomes[i] = nomes[i] + arquivos[i].getName().charAt(j);
                }
            }
            nomes[i] = reverso(nomes[i]);
        }
        return nomes;
    }
    
    public String[] retornarNomes(File arquivos[]) {
        String[] nomes = new String[arquivos.length];
        for (int i = 0; i < arquivos.length; i++) {
            nomes[i] = "";
            for (int j = 0; j < arquivos[i].getName().length(); j++) {
                if (arquivos[i].getName().charAt(j) != '.') {
                    nomes[i] = nomes[i] + arquivos[i].getName().charAt(j);
                    System.out.println(arquivos[i].getName().charAt(j));
                }
                else {
                    break;
                }
            }
        }
        return nomes;
    }
    
    public void criarDiretorio(String caminho) {
        String nomeArquivo = "";
        for (int i = caminho.length() - 1; i > 0; i--) {
            if (caminho.charAt(i) == '\\') {
                break;
            }
            else {
                nomeArquivo = nomeArquivo + caminho.charAt(i);
            }
        }
        nomeArquivo = reverso(nomeArquivo);
        caminho = caminho.replaceFirst(nomeArquivo, "");
        caminho = caminho + "Arquivos Renomeados";
        salvarCaminho = caminho;
        try {
            File diretorio = new File(caminho);
            diretorio.mkdir();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro", "Erro ao criar o diretório", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
        }
    }
    
    public String reverso(String string) {
        String reverso = "";
        for (int i = string.length() - 1; i > -1; i--) {
            reverso = reverso + string.charAt(i);
        }
        return reverso;
    }
    
    public void limparLista() {
        listaArquivosAbertos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Nenhum arquivo" };
            @Override
            public int getSize() { return strings.length; }
            @Override
            public String getElementAt(int i) { return strings[i]; }
        });
    }
    
    public boolean verificarPdf(String extensoes[]) {
        for (int i = 0; i < extensoes.length; i++) {
            if (!extensoes[i].equalsIgnoreCase("pdf")) {
                return false;
            }
        }
        return true;
    }
    
    private int qtdPaginas(File arquivo) throws FileNotFoundException, IOException {
        byte[] bytesArray = new byte[(int) arquivo.length()]; 
        FileInputStream fis = new FileInputStream(arquivo);
        fis.read(bytesArray);
        fis.close();
        int qtPaginas = 0;
	PdfReader pdfReader;
	try {
            pdfReader = new PdfReader(bytesArray);
            qtPaginas = pdfReader.getNumberOfPages();
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao processar o arquivo PDF, tavez este esteja corrompido.", "Erro ao processar Arquivo", JOptionPane.ERROR_MESSAGE);
	}
	return qtPaginas;
    }
    
    public void setArquivos(File arquivos[]) {
        this.arquivos = arquivos;
    }
    
    public File[] getArquivos() {
        return this.arquivos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaArquivosAbertos = new javax.swing.JList<>();
        labelNumArqAbertos = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        radioJuntada = new javax.swing.JRadioButton();
        radioDigital = new javax.swing.JRadioButton();
        checkAlterarSomenteNumeracao = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        comboNome = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        textFieldNumeracao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnRenomear = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        labelImg = new javax.swing.JLabel();
        barraProgresso = new javax.swing.JProgressBar();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuAbrir = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Renomear para o PJE");
        setResizable(false);

        listaArquivosAbertos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Nenhum arquivo" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaArquivosAbertos);

        labelNumArqAbertos.setText("0 Arquivos atualmente abertos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "<html><body><center>Opções de Nomeação</center></body></html>", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        buttonGroup1.add(radioJuntada);
        radioJuntada.setText("Juntada");
        radioJuntada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioJuntadaActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioDigital);
        radioDigital.setText("Digitalização de Processo Físico");
        radioDigital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDigitalActionPerformed(evt);
            }
        });

        checkAlterarSomenteNumeracao.setText("Alterar Somente a Numeração");
        checkAlterarSomenteNumeracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAlterarSomenteNumeracaoActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("<html><body><center>Nota: Marque um \"x\" onde deseja que a numeração mude.<br/>\nObs.: Este utilitário funciona somente com um tópico por vez.</center></body></html>");

        comboNome.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usar nome diferente", "Certidao", "Fotografia", "Outros documentos" }));
        comboNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNomeActionPerformed(evt);
            }
        });

        jLabel4.setText("Nome");

        jLabel5.setText("Numeração");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(radioJuntada)
                        .addGap(10, 10, 10)
                        .addComponent(radioDigital))
                    .addComponent(jLabel4)
                    .addComponent(comboNome, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(textFieldNumeracao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(checkAlterarSomenteNumeracao)
                .addGap(72, 72, 72))
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioJuntada)
                    .addComponent(radioDigital))
                .addGap(18, 18, 18)
                .addComponent(checkAlterarSomenteNumeracao)
                .addGap(13, 13, 13)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textFieldNumeracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnRenomear.setText("Renomear Arquivos");
        btnRenomear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRenomearActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        labelImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImg.setText("jLabel2");

        jMenu1.setText("Arquivo");

        menuAbrir.setText("Abrir");
        menuAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAbrirActionPerformed(evt);
            }
        });
        jMenu1.add(menuAbrir);

        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        jMenu1.add(menuSair);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ajuda");

        jMenuItem1.setText("Sobre");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Como renomear arquivos");
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(labelNumArqAbertos))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(barraProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRenomear)
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(labelImg, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(labelImg, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelNumArqAbertos)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(barraProgresso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRenomear)
                        .addComponent(btnSair)))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new Sobre().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void radioJuntadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioJuntadaActionPerformed
        checkAlterarSomenteNumeracao.setSelected(false);
        checkAlterarSomenteNumeracao.setEnabled(false);
    }//GEN-LAST:event_radioJuntadaActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        int retorno = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Sair do utilitário", JOptionPane.YES_NO_OPTION);
        if (retorno == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnSairActionPerformed

    private void menuAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAbrirActionPerformed
        JFileChooser abrirArquivo = new JFileChooser();
        abrirArquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
        abrirArquivo.setMultiSelectionEnabled(true);
        abrirArquivo.showOpenDialog(null);
        File arquivosAbertos[] = abrirArquivo.getSelectedFiles();
        if (radioDigital.isSelected()) {
            Arrays.sort(arquivosAbertos, new Comparador());
        }
        preencherLista(arquivosAbertos);
        labelNumArqAbertos.setText(arquivosAbertos.length + " Arquivos atualmente abertos");
        setArquivos(arquivosAbertos);
    }//GEN-LAST:event_menuAbrirActionPerformed

    private void btnRenomearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRenomearActionPerformed
        int numArquivos = getArquivos().length;
        barraProgresso.setMaximum(numArquivos);
        barraProgresso.setVisible(true);
        if (radioJuntada.isSelected() && comboNome.getSelectedIndex() == 0) {
            int nomeSelecionado = comboNome.getSelectedIndex();
            if (nomeSelecionado == 0) {
                String nome = textFieldNumeracao.getText();
                if (getArquivos().length == 0) {
                    JOptionPane.showMessageDialog(null, "Nenhum arquivo foi carregado", "Erro ao renomear os arquivos", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    String caminho = getArquivos()[0].getPath();
                    if (nome.equals("")) {
                        JOptionPane.showMessageDialog(null, "O novo nome dos arquivos não pode ser nulo", "Erro ao renomear os arquivos", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        String extensoes[] = retornarExtensoes(getArquivos());
                        String nomes[] = new String[extensoes.length];
                        criarDiretorio(caminho);
                        System.out.println(getArquivos().length + "FORAM CARREGADOS!!!!!!!!!!");
                        for (int i = 0; i < getArquivos().length; i++) {
                            nomes[i] = nome.replaceFirst("x", (i+1) + "");
                            getArquivos()[i].renameTo(new File(salvarCaminho + "\\" + nomes[i] + "." + extensoes[i]));
                            barraProgresso.setValue(i + 1);
                            barraProgresso.updateUI();
                        }
                        JOptionPane.showMessageDialog(null, "Os seus arquivos foram renomeados conforme os parâmetros especificados", "Renomear arquivos", JOptionPane.INFORMATION_MESSAGE);
                        arquivos = new File[0];
                        limparLista();
                        labelNumArqAbertos.setText("0 Arquivos atualmente abertos");
                    }
                }
            }
        }
        if (radioDigital.isSelected() && checkAlterarSomenteNumeracao.isSelected()) {
            String extensoes[] = retornarExtensoes(getArquivos());
            String nomes[] = retornarNomes(getArquivos());
            String caminho = getArquivos()[0].getPath();
            int index = 0, numero = Integer.parseInt(textFieldNumeracao.getText());
            if (verificarPdf(extensoes)) {
                JOptionPane.showMessageDialog(null, "Todos os arquivos carregados são pdf.", "Informação", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Todos os arquivos são PDF.");
                criarDiretorio(caminho);
                for (int i = 0; i < nomes.length; i++) {
                    for (int j = 0; j < nomes[i].length(); j++) {
                        if (nomes[i].charAt(j) == '_') {
                            index = j+1;
                            break;
                        }
                    }
                    nomes[i] = numero + "_" + nomes[i].substring(index);
                    try {
                        numero = numero + qtdPaginas(getArquivos()[i]);
                    }
                    catch (IOException ex) {
                        Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("NOME DO ARQUIVO É: " + nomes[i]);
                    getArquivos()[i].renameTo(new File(salvarCaminho + "\\" + nomes[i] + "." + extensoes[i]));
                    System.out.println(salvarCaminho + "\\" + nomes[i] + "." + extensoes[i]);
                    barraProgresso.setValue(i + 1);
                   barraProgresso.updateUI();
                }
                JOptionPane.showMessageDialog(null, "Os seus arquivos foram renomeados conforme os parâmetros especificados", "Renomear arquivos", JOptionPane.INFORMATION_MESSAGE);
                arquivos = new File[0];
                limparLista();
                labelNumArqAbertos.setText("0 Arquivos atualmente abertos");
            }
        }
        barraProgresso.setVisible(false);
    }//GEN-LAST:event_btnRenomearActionPerformed

    private void comboNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNomeActionPerformed
        
    }//GEN-LAST:event_comboNomeActionPerformed

    private void radioDigitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDigitalActionPerformed
        checkAlterarSomenteNumeracao.setEnabled(true);
        if (radioDigital.isSelected() && checkAlterarSomenteNumeracao.isSelected()) {
            comboNome.setEnabled(false);
        }
        else {
            comboNome.setEnabled(true);
        }
    }//GEN-LAST:event_radioDigitalActionPerformed

    private void checkAlterarSomenteNumeracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAlterarSomenteNumeracaoActionPerformed
        if (radioDigital.isSelected() && checkAlterarSomenteNumeracao.isSelected()) {
            comboNome.setEnabled(false);
        }
        else {
            comboNome.setEnabled(true);
        }
    }//GEN-LAST:event_checkAlterarSomenteNumeracaoActionPerformed

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        int retorno = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Sair do utilitário", JOptionPane.YES_NO_OPTION);
        if (retorno == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_menuSairActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgresso;
    private javax.swing.JButton btnRenomear;
    private javax.swing.JButton btnSair;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox checkAlterarSomenteNumeracao;
    private javax.swing.JComboBox<String> comboNome;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelImg;
    private javax.swing.JLabel labelNumArqAbertos;
    private javax.swing.JList<String> listaArquivosAbertos;
    private javax.swing.JMenuItem menuAbrir;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JRadioButton radioDigital;
    private javax.swing.JRadioButton radioJuntada;
    private javax.swing.JTextField textFieldNumeracao;
    // End of variables declaration//GEN-END:variables
}
