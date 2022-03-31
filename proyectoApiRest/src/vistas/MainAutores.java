
package vistas;

import controlador.ConexionControl;
import controlador.ControlAutores;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Autor;

/**
 *
 * @author Eva
 */
public class MainAutores extends javax.swing.JFrame {
    DefaultTableModel modelo;
    ConexionControl controller = new ConexionControl();
    ControlAutores controlAutores = new ControlAutores();
    
    
    
    public MainAutores() {
        initComponents();
        modelo = (DefaultTableModel) tablaAutor.getModel();
        btnConf.setVisible(false);
        this.setLocationRelativeTo(null);
        conectarBasedeDtos();
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
        tablaAutor = new javax.swing.JTable();
        txtNombre = new javax.swing.JFormattedTextField();
        txtFecha = new javax.swing.JFormattedTextField();
        txtSinopsis = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnInsert = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnConf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jToolBar1.setBackground(new java.awt.Color(204, 204, 204));
        jToolBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setRollover(true);
        jToolBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnAutor.setBackground(new java.awt.Color(51, 51, 51));
        btnAutor.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAutor.setForeground(new java.awt.Color(255, 255, 255));
        btnAutor.setText("Autores");
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
        btnExp.setText("Exposicoines");
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

        tablaAutor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "FechaNacimiento", "Nombre", "Sinopsis"
            }
        ));
        jScrollPane1.setViewportView(tablaAutor);

        jLabel1.setText("Nombre");

        jLabel2.setText("Fecha Nacimiento");

        jLabel3.setText("Sinopsis");

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
        jLabel4.setText("AUTORES");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel4.setOpaque(true);

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(118, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSinopsis, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnConf)))
                .addGap(102, 102, 102))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnInsert))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrar))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSinopsis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar)
                    .addComponent(btnConf))
                .addGap(58, 58, 58))
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

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        
        if(tablaAutor.getSelectedRow()!= -1){
            btnConf.setVisible(true);
            txtFecha.setText(tablaAutor.getValueAt(tablaAutor.getSelectedRow(), 1).toString());
            txtNombre.setText(tablaAutor.getValueAt(tablaAutor.getSelectedRow(), 2).toString());
            txtSinopsis.setText(tablaAutor.getValueAt(tablaAutor.getSelectedRow(), 3).toString());
           
            
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un registro de la tabla","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        btnConf.setVisible(false);
        if(tablaAutor.getSelectedRow() != -1){
            int id  = Integer.parseInt( tablaAutor.getValueAt(tablaAutor.getSelectedRow(), 0).toString());
            if(controlAutores.deleteAutor(id)){
                JOptionPane.showMessageDialog(this, "Borrado correctamente");
                mostrarTabla();
            }else{
                JOptionPane.showMessageDialog(this, "Error al borrar el registro");
            }
          

        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un registro de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        btnConf.setVisible(false);
        if(txtNombre.getText().isEmpty() || txtFecha.getText().isEmpty() || txtSinopsis.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Rellene todos los campos");
        }else{

            String fecha = txtFecha.getText();
            String nombre = txtNombre.getText();
            String sinopsis = txtSinopsis.getText();
            Autor autor = new Autor(fecha, nombre, sinopsis);

            if(controlAutores.saveAutor(autor)){
                JOptionPane.showMessageDialog(this, "Insertado conrrectamente");
                mostrarTabla();
                limpiarCampos();
            }else{
                JOptionPane.showMessageDialog(this, "Error de insertado");
            }
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnExpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpActionPerformed
        FrameExposiciones frameExposicion = new FrameExposiciones();
        this.setVisible(false);
        frameExposicion.setVisible(true);
    }//GEN-LAST:event_btnExpActionPerformed

    private void btnLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibroActionPerformed
        FrameLibros frameLibro = new FrameLibros();
        this.setVisible(false);
        frameLibro.setVisible(true);
    }//GEN-LAST:event_btnLibroActionPerformed

    private void btnAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutorActionPerformed

    }//GEN-LAST:event_btnAutorActionPerformed

    private void btnConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfActionPerformed
        
        Autor a = new Autor(txtFecha.getText(), txtNombre.getText(), txtSinopsis.getText());
             if(controlAutores.updateAutor(a)){
                JOptionPane.showMessageDialog(this, "Actualizado correctamente");
                mostrarTabla();
                limpiarCampos();
                btnConf.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(this,"Error al actualizar el registro");
            }
           
    }//GEN-LAST:event_btnConfActionPerformed

    private void btnOrganizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrganizacionActionPerformed
        FrameOrganizarExposicion fOrg = new FrameOrganizarExposicion();
        this.setVisible(false);
        fOrg.setVisible(true);
    }//GEN-LAST:event_btnOrganizacionActionPerformed
    private void conectarBasedeDtos() {
        if(!controller.probarConexion()){
            JOptionPane.showMessageDialog(this, "Error en la conexion");
        }
    }
    
     public void mostrarTabla() {
        Object[] datos = new Object[4];
        modelo.setRowCount(0);

        ArrayList<Autor> listaAutores = controlAutores.listaAutores();
        for (Autor a : listaAutores) {
            datos[0] = a.getId();
            datos[1] = a.getFechaNac();
            datos[2] = a.getNombre();
            datos[3] = a.getSinopsis();
            modelo.addRow(datos);
        }
    }
     
     public void limpiarCampos(){
         txtFecha.setText("");
         txtNombre.setText("");
         txtSinopsis.setText("");
     }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainAutores().setVisible(true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tablaAutor;
    private javax.swing.JFormattedTextField txtFecha;
    private javax.swing.JFormattedTextField txtNombre;
    private javax.swing.JFormattedTextField txtSinopsis;
    // End of variables declaration//GEN-END:variables

   
}
