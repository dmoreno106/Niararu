
package vistas;

import controlador.ControlLibros;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Libro;

/**
 *
 * @author Eva
 */
public class FrameLibros extends javax.swing.JFrame {
    ControlLibros controlLibro = new ControlLibros();
    DefaultTableModel modelo;
    public FrameLibros() {
        initComponents();
        modelo = (DefaultTableModel) tablaLibros.getModel();    
        this.setLocationRelativeTo(null);
     
        btnConf.setVisible(false);
        mostrarTabla();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnAutor = new javax.swing.JButton();
        btnLibro = new javax.swing.JButton();
        btnExp = new javax.swing.JButton();
        btnOrganizacion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLibros = new javax.swing.JTable();
        txtId = new javax.swing.JFormattedTextField();
        txtFecha = new javax.swing.JFormattedTextField();
        txtTitulo = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnInsert = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtLenguaje = new javax.swing.JFormattedTextField();
        btnConf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jToolBar1.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setRollover(true);

        btnAutor.setBackground(new java.awt.Color(51, 51, 51));
        btnAutor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAutor.setForeground(new java.awt.Color(255, 255, 255));
        btnAutor.setText("Autores");
        btnAutor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAutor.setFocusable(false);
        btnAutor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAutor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutorActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAutor);

        btnLibro.setBackground(new java.awt.Color(51, 51, 51));
        btnLibro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnLibro.setForeground(new java.awt.Color(255, 255, 255));
        btnLibro.setText("Libros");
        btnLibro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLibro.setFocusable(false);
        btnLibro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLibro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibroActionPerformed(evt);
            }
        });
        jToolBar1.add(btnLibro);

        btnExp.setBackground(new java.awt.Color(51, 51, 51));
        btnExp.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnExp.setForeground(new java.awt.Color(255, 255, 255));
        btnExp.setText("Exposiciones");
        btnExp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExp.setFocusable(false);
        btnExp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpActionPerformed(evt);
            }
        });
        jToolBar1.add(btnExp);

        btnOrganizacion.setBackground(new java.awt.Color(51, 51, 51));
        btnOrganizacion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnOrganizacion.setForeground(new java.awt.Color(255, 255, 255));
        btnOrganizacion.setText("Organizacion");
        btnOrganizacion.setFocusable(false);
        btnOrganizacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOrganizacion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOrganizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrganizacionActionPerformed(evt);
            }
        });
        jToolBar1.add(btnOrganizacion);

        tablaLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "idLibro", "Titulo", "FechaPublicacion", "Lenguaje"
            }
        ));
        jScrollPane1.setViewportView(tablaLibros);

        jLabel1.setText("idLibro");

        jLabel2.setText("Fecha Publicaion");

        jLabel3.setText("Titulo");

        btnInsert.setText("INSERTAR");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnBorrar.setText("BORRAR");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("LIBROS");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel4.setOpaque(true);

        jLabel5.setText("Lenguaje");

        btnConf.setText("CONFRIMAR");
        btnConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLenguaje, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnConf, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInsert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(100, 100, 100))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnInsert)
                        .addGap(18, 18, 18)))
                .addComponent(btnBorrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLenguaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConf)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutorActionPerformed
        MainAutores frameAutor = new MainAutores();
        this.setVisible(false);
        frameAutor.setVisible(true);
    }//GEN-LAST:event_btnAutorActionPerformed

    private void btnExpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpActionPerformed
        FrameExposiciones frameExp = new FrameExposiciones();
        this.setVisible(false);
        frameExp.setVisible(true);
    }//GEN-LAST:event_btnExpActionPerformed

    private void btnLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLibroActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
       txtId.setEditable(true);
        if (txtId.getText().isEmpty() || txtTitulo.getText().isEmpty() || txtFecha.getText().isEmpty() || txtLenguaje.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Rellene todos los campos");
        }else{
            String Id = txtId.getText();
            String titulo =txtTitulo.getText();
            String fecha = txtFecha.getText();
            String lenguaje = txtLenguaje.getText();
            Libro libro = new Libro(Id, titulo, fecha, lenguaje);
            
            if(controlLibro.saveLibro(libro)){
                JOptionPane.showMessageDialog(this, "Insertado correctamente");
                mostrarTabla();
                limpiarCampos();
            }else{
                JOptionPane.showMessageDialog(this, "Error al insertar registro");
            }
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if(tablaLibros.getSelectedRow() != -1){
            String id = tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 0).toString();
            if(controlLibro.deleteLibro(id)){
                JOptionPane.showMessageDialog(this, "Borrado correctamente");
                mostrarTabla();
            }else{
                JOptionPane.showMessageDialog(this, "Error al borrar el registro");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un registro de la tabla");
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
    
    if(tablaLibros.getSelectedRow() != -1){
        txtId.setEditable(false);
        btnConf.setVisible(true);
         txtId.setText(tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 0).toString());
        txtTitulo.setText(tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 1).toString());
        txtFecha.setText(tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 2).toString());
        txtLenguaje.setText(tablaLibros.getValueAt(tablaLibros.getSelectedRow(), 3).toString());
    }else{
        JOptionPane.showMessageDialog(this, "Seleccione un registro de la tabla");
    }
      
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfActionPerformed
        Libro libro = new Libro(txtId.getText(), txtTitulo.getText(), txtFecha.getText(), txtLenguaje.getText());
        if(controlLibro.updateLibro(libro)){
            JOptionPane.showMessageDialog(this, "Actualizado correctamente");
            mostrarTabla();
            limpiarCampos();
            txtId.setEditable(true);
            btnConf.setVisible(false);
        }else{
           JOptionPane.showMessageDialog(this, "Error al actualizar el registro");
        }
    }//GEN-LAST:event_btnConfActionPerformed

    private void btnOrganizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrganizacionActionPerformed
        FrameOrganizarExposicion fOrganizar = new FrameOrganizarExposicion();
        this.setVisible(false);
        fOrganizar.setVisible(true);
        
    }//GEN-LAST:event_btnOrganizacionActionPerformed
    
    public void mostrarTabla(){
        ArrayList<Libro> listaLibros = new ArrayList<>();
        listaLibros = controlLibro.listaLibros();
        Object[] datos = new Object[4];
        modelo.setRowCount(0);
        
        for (Libro li : listaLibros) {
            datos[0] = li.getId();
            datos[1] = li.getTitulo();
            datos[2] = li.getFechaPublicacion();
            datos[3] = li.getLenguaje();
            modelo.addRow(datos);
        }
    }
    public void limpiarCampos(){
        txtId.setText("");
        txtTitulo.setText("");
        txtFecha.setText("");
        txtLenguaje.setText("");
    }
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
            java.util.logging.Logger.getLogger(FrameLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameLibros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAutor;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnConf;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExp;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnLibro;
    private javax.swing.JButton btnOrganizacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tablaLibros;
    private javax.swing.JFormattedTextField txtFecha;
    private javax.swing.JFormattedTextField txtId;
    private javax.swing.JFormattedTextField txtLenguaje;
    private javax.swing.JFormattedTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
