/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizer;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author oscar
 */
public class Analizador extends javax.swing.JFrame {

    File tokens = new File("src/Files/tokens.txt");
    Text txtTokens = new Text(tokens);
    File datatypes = new File("src/Files/types.txt");
    Text txtDataTypes = new Text(datatypes);
    File file = null;
    Text txtFile = null;
    /**
     * Creates new form Analizador
     */
    public Analizador() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.DARK_GRAY);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnOpen = new javax.swing.JButton();
        btnFindToken = new javax.swing.JButton();
        btnClean = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnAddToken = new javax.swing.JButton();
        btnAddType = new javax.swing.JButton();
        btnSeekTokens = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnAnalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        terminal = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ANALIZADOR LÉXICO");

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Tokenizer");

        btnOpen.setBackground(new java.awt.Color(0, 153, 153));
        btnOpen.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnOpen.setText("Abrir archivo");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        btnFindToken.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnFindToken.setText("Token finder");
        btnFindToken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindTokenActionPerformed(evt);
            }
        });

        btnClean.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnClean.setText("Limpiar");
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(0, 153, 102));
        btnSave.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Ajustes");

        btnAddToken.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnAddToken.setText("Agregar token");
        btnAddToken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTokenActionPerformed(evt);
            }
        });

        btnAddType.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnAddType.setText("Agregar tipo de dato");
        btnAddType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTypeActionPerformed(evt);
            }
        });

        btnSeekTokens.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnSeekTokens.setText("Ver tokens");
        btnSeekTokens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeekTokensActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("- v3.0 estable");

        btnAnalizar.setBackground(new java.awt.Color(204, 204, 0));
        btnAnalizar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnAnalizar.setText("Analizar");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 92, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnSave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnClean, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFindToken, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnOpen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAnalizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnAddType, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddToken, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSeekTokens, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(12, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOpen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFindToken)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClean)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddToken)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddType)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSeekTokens)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        text.setBackground(new java.awt.Color(51, 51, 51));
        text.setColumns(20);
        text.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        text.setForeground(new java.awt.Color(204, 204, 204));
        text.setRows(5);
        text.setCaretColor(new java.awt.Color(204, 204, 255));
        text.setSelectedTextColor(new java.awt.Color(102, 102, 102));
        text.setSelectionColor(new java.awt.Color(153, 153, 255));
        jScrollPane1.setViewportView(text);

        terminal.setBackground(new java.awt.Color(51, 51, 51));
        terminal.setColumns(20);
        terminal.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        terminal.setForeground(new java.awt.Color(204, 204, 204));
        terminal.setRows(5);
        terminal.setCaretColor(new java.awt.Color(204, 204, 255));
        terminal.setSelectedTextColor(new java.awt.Color(102, 102, 102));
        terminal.setSelectionColor(new java.awt.Color(153, 153, 255));
        jScrollPane2.setViewportView(terminal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        JFileChooser open = new JFileChooser();
        open.setFileFilter(new FileNameExtensionFilter(".txt", "txt", "text"));
        open.showOpenDialog(this);
        text.setText("");
        File myFile = open.getSelectedFile();
        if(myFile != null){
            Text file = new Text(myFile);
            ArrayList<String> lines = file.getLines();
            lines.forEach((o) -> text.append(o + "\n"));
            this.file = myFile;
            this.txtFile = file;
        }
    }//GEN-LAST:event_btnOpenActionPerformed

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        text.setText("");
        terminal.setText("");
        this.file = null;
        this.txtFile = null;
    }//GEN-LAST:event_btnCleanActionPerformed

    private void btnFindTokenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindTokenActionPerformed
        if(this.file != null){
            ArrayList<String> t = txtTokens.getLines();
            String[] tokens = new String[t.size()];
            for (String s:t){
                tokens[t.indexOf(s)] = s;
            }
            Constant.DATATYPES.clear();
            for (String s: txtDataTypes.getLines()){
                Constant.DATATYPES.add(s);
            }
            terminal.setText("");
            Reporte reporte = new Reporte(this.file, this.txtFile);
            reporte.setTokens(tokens);
            ArrayList<String> rep = reporte.getReporteToken();
            rep.forEach((String e)->{
                terminal.append(e + "\n");
            });
        }else{
            JOptionPane.showMessageDialog(null, "No existe algún archivo para generar el reporte.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnFindTokenActionPerformed

    private void btnSeekTokensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeekTokensActionPerformed
        terminal.setText("");
        this.file = null;
        this.txtFile = null;
        ArrayList<String> lines = txtTokens.getLines();
        lines.forEach((String s) -> {
            terminal.append(s + "\n");
        });
    }//GEN-LAST:event_btnSeekTokensActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(this.file != null){
            JFileChooser save = new JFileChooser();
            save.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            save.showSaveDialog(this);
            File directory = save.getSelectedFile();
            if(directory != null){
                String path = directory.getPath();
                try{
                    File newFile = new File(path + ".txt");
                    Text txtNewFile = new Text(newFile);
                    if(newFile.createNewFile()){
                        String[] lines = terminal.getText().split("\n");
                        ArrayList<String> lin = new ArrayList();
                        for (String s : lines) {
                            lin.add(s);
                        }
                        txtNewFile.saveReport(lin);
                        JOptionPane.showMessageDialog(null, "El reporte se guardo correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se ha guardado el reporte");
                    }
                }catch (Exception e) {
                    System.err.println(e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay ningún reporte generado");
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnAddTokenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTokenActionPerformed
        String newToken = JOptionPane.showInputDialog(null, "Ingrese el nuevo token:");
        if(newToken.length()>0){
            txtTokens.newData(newToken);
            JOptionPane.showMessageDialog(null, "Se agregó correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Ingrese un token válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddTokenActionPerformed

    private void btnAddTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTypeActionPerformed
        String newType = JOptionPane.showInputDialog(null, "Ingrese el nuevo tipo de dato:");
        if(newType.length()>0){
            txtTokens.newData(newType);
            JOptionPane.showMessageDialog(null, "Se agregó correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Ingrese un tipo de dato válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddTypeActionPerformed

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        if (this.file != null) {
            ArrayList<String> t = txtTokens.getLines();
            String[] tokens = new String[t.size()];
            for (String s : t) {
                tokens[t.indexOf(s)] = s;
            }
            Constant.DATATYPES.clear();
            for (String s : txtDataTypes.getLines()) {
                Constant.DATATYPES.add(s);
            }
            terminal.setText("");
            Reporte report = new Reporte(this.file, this.txtFile);
            ArrayList<String> r = report.getReporte();
            r.forEach((String e) -> {
                terminal.append(e + "\n");
            });
        } else {
            JOptionPane.showMessageDialog(null, "No hay ningún archivo de texto para generar el reporte", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAnalizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try{
          JFrame.setDefaultLookAndFeelDecorated(true);
          JDialog.setDefaultLookAndFeelDecorated(true);
          UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        }catch (Exception e){
          e.printStackTrace();
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Analizador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToken;
    private javax.swing.JButton btnAddType;
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnFindToken;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSeekTokens;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea terminal;
    private javax.swing.JTextArea text;
    // End of variables declaration//GEN-END:variables
}
