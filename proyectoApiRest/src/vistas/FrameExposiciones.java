
package vistas;

import controlador.ControlExposicion;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Exposicion;

/**
 *
 * @author Eva
 */
public class FrameExposiciones extends javax.swing.JFrame {

    DefaultTableModel modelo;
    ControlExposicion controlExposicion = new ControlExposicion();
    public FrameExposiciones() {
        initComponents();
        modelo = (DefaultTableModel) tablaExp.getModel();
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
        tablaExp = new javax.swing.JTable();
        txtId = new javax.swing.JFormattedTextField();
        txtFecha = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnInsert = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCp = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        txtMunicipio = new javax.swing.JFormattedTextField();
        btnConf = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDesc = new javax.swing.JTextArea();

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

        tablaExp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "idExposicion", "Descripcion", "Fecha", "Nombre", "Direccion", "CodigoPostal", "Municipio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaExp);
        if (tablaExp.getColumnModel().getColumnCount() > 0) {
            tablaExp.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel1.setText("idExposicion");

        jLabel2.setText("Fecha");

        jLabel3.setText("Descripcion");

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
        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("EXPOSICIONES");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel4.setOpaque(true);

        jLabel5.setText("Nombre");

        jLabel6.setText("Direccion");

        jLabel7.setText("CP");

        jLabel8.setText("Municipio");

        btnConf.setText("CONFIRMAR");
        btnConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfActionPerformed(evt);
            }
        });

        txtDesc.setColumns(20);
        txtDesc.setRows(5);
        jScrollPane2.setViewportView(txtDesc);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 323, Short.MAX_VALUE)
                                        .addComponent(jLabel8))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                                        .addComponent(jLabel7)))
                                .addGap(10, 10, 10))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCp, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(98, 98, 98))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnBorrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnInsert, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnConf, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(btnInsert)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBorrar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(51, 51, 51))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConf))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(56, 56, 56))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnEditar)
                                .addGap(168, 168, 168))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE))))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibroActionPerformed
        FrameLibros frameLibros = new FrameLibros();
        this.setVisible(false);
        frameLibros.setVisible(true);
    }//GEN-LAST:event_btnLibroActionPerformed

    private void btnAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutorActionPerformed
        MainAutores mainAutor = new MainAutores();
        this.setVisible(false);
        mainAutor.setVisible(true);
    }//GEN-LAST:event_btnAutorActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        btnConf.setVisible(false);
        if(txtId.getText().isEmpty() || txtDesc.getText().isEmpty() || txtFecha.getText().isEmpty() || txtDireccion.getText().isEmpty() || txtMunicipio.getText().isEmpty()
                || txtCp.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Rellene todos los campos");
        }else{
            String id = txtId.getText();
            String desc = txtDesc.getText();
            String fecha = txtFecha.getText();
            String nombre = txtNombre.getText();
            String direccion = txtDireccion.getText();
            String cp = txtCp.getText();
            String municipio = txtMunicipio.getText();
            Exposicion exp = new Exposicion(id, desc, fecha,nombre,  direccion, cp,  municipio);
            
            
            if(controlExposicion.saveExposicion(exp)){
                JOptionPane.showMessageDialog(this, "Insertado correctamente");
                mostrarTabla();
                limpiarCampos();
            }else{
                JOptionPane.showMessageDialog(this, "Error al insertar registro");
                limpiarCampos();
            }
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        btnConf.setVisible(false);
        if(tablaExp.getSelectedRow() != -1){
            String id = tablaExp.getValueAt(tablaExp.getSelectedRow(), 0).toString();
            if(controlExposicion.deleteExposicion(id)){
                JOptionPane.showMessageDialog(this, "Borrado correctamente");
                mostrarTabla();
            }else{
                JOptionPane.showMessageDialog(this, "Error al borrar registro");
            }
       }else{
        JOptionPane.showMessageDialog(this, "Seleccione un registro de la tabla");
    }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(tablaExp.getSelectedRow() != -1){
            txtId.setEditable(false);
            btnConf.setVisible(true);
           txtId.setText(tablaExp.getValueAt(tablaExp.getSelectedRow(), 0).toString());
           txtDesc.setText(tablaExp.getValueAt(tablaExp.getSelectedRow(), 1).toString());
           txtFecha.setText(tablaExp.getValueAt(tablaExp.getSelectedRow(), 2).toString());
           txtNombre.setText(tablaExp.getValueAt(tablaExp.getSelectedRow(), 3).toString());
           txtDireccion.setText(tablaExp.getValueAt(tablaExp.getSelectedRow(), 4).toString());
           txtCp.setText(tablaExp.getValueAt(tablaExp.getSelectedRow(), 5).toString());
           txtMunicipio.setText(tablaExp.getValueAt(tablaExp.getSelectedRow(), 6).toString());
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un registro de la tabla");
            btnConf.setVisible(false);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfActionPerformed
        Exposicion exp = new Exposicion(txtId.getText(), txtDesc.getText(), txtFecha.getText(), txtNombre.getText(), txtDireccion.getText(), txtCp.getText(), txtMunicipio.getText());
        if(controlExposicion.updateExposicion(exp)){
            JOptionPane.showMessageDialog(this, "Actualizado correctamente");
            btnConf.setVisible(false);
            txtId.setEditable(true);
            mostrarTabla();
            limpiarCampos();
        }else{
            JOptionPane.showMessageDialog(this, "Error al actualizar el registro");
            btnConf.setVisible(false);
            txtId.setEditable(true);
            limpiarCampos();
        }
    }//GEN-LAST:event_btnConfActionPerformed

    private void btnExpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpActionPerformed
        FrameExposiciones fExp= new FrameExposiciones();
        this.setVisible(false);
        fExp.setVisible(true);
    }//GEN-LAST:event_btnExpActionPerformed

    private void btnOrganizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrganizacionActionPerformed
        FrameOrganizarExposicion fOrganizar = new FrameOrganizarExposicion();
        this.setVisible(false);
        fOrganizar.setVisible(true);
    }//GEN-LAST:event_btnOrganizacionActionPerformed

    
      public void mostrarTabla(){
        ArrayList<Exposicion> listaExp = new ArrayList<>();
        listaExp = controlExposicion.listaExposiciones();
        Object[] datos = new Object[7];
        modelo.setRowCount(0);
        
        for (Exposicion e : listaExp) {
            datos[0] = e.getId();
            datos[1] = e.getDesc();
            datos[2] = e.getFecha();
            datos[3] = e.getNombre();
            datos[4] = e.getDireccion();
            datos[5] = e.getCp();
            datos[6] = e.getMunicipio();
            modelo.addRow(datos);
        }
    }
      
      public void limpiarCampos(){
          txtId.setText("");
          txtDesc.setText("");  
          txtNombre.setText("");
          txtFecha.setText("");
          txtDireccion.setText("");
          txtCp.setText(""); 
          txtMunicipio.setText("");
          
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
            java.util.logging.Logger.getLogger(FrameExposiciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameExposiciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameExposiciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameExposiciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameExposiciones().setVisible(true);
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tablaExp;
    private javax.swing.JFormattedTextField txtCp;
    private javax.swing.JTextArea txtDesc;
    private javax.swing.JFormattedTextField txtDireccion;
    private javax.swing.JFormattedTextField txtFecha;
    private javax.swing.JFormattedTextField txtId;
    private javax.swing.JFormattedTextField txtMunicipio;
    private javax.swing.JFormattedTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
