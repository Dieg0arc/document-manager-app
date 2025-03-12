
package com.mycompany.portaldelsaber.igu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class CargaDatosDocentes extends javax.swing.JFrame {

    public CargaDatosDocentes() {
initComponents();
    configurarValidaciones();
}

private void configurarValidaciones() {
    // Validar que solo ingresen letras y espacios en Nombre
    txtNombreDocente.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            char c = evt.getKeyChar();
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                evt.consume(); // No permite el carácter
            } else {
                txtNombreDocente.setText(txtNombreDocente.getText().toUpperCase());
            }
        }
    });

    // Validar que solo ingresen letras y espacios en Apellidos
    txtApellidoDocente.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            char c = evt.getKeyChar();
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                evt.consume(); // No permite el carácter
            } else {
                txtApellidoDocente.setText(txtApellidoDocente.getText().toUpperCase());
            }
        }
    });

    // Validar Registro Civil (solo números, mínimo 10 y máximo 11 dígitos)
    txtCC.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            char c = evt.getKeyChar();
            if (!Character.isDigit(c)) {
                evt.consume(); // Solo permite números
            }
            if (txtCC.getText().length() >= 11) {
                evt.consume(); // No permite más de 11 dígitos
            }
        }
    });
}

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnGuardarDocente = new javax.swing.JButton();
        btnLimpiarDocente = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtNombreDocente = new javax.swing.JTextField();
        txtCC = new javax.swing.JTextField();
        cmbEstado = new javax.swing.JComboBox<>();
        cmbAnioDocente = new javax.swing.JComboBox<>();
        txtApellidoDocente = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1.setText("Datos docentes");

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\Desktop\\Preescolar\\Portal_Saber.jpg")); // NOI18N

        btnGuardarDocente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnGuardarDocente.setText("Guardar");
        btnGuardarDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarDocenteActionPerformed(evt);
            }
        });

        btnLimpiarDocente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnLimpiarDocente.setText("Limpiar");
        btnLimpiarDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarDocenteActionPerformed(evt);
            }
        });

        jLabel18.setText("Nombre");

        jLabel19.setText("Cedula de Ciudadania");

        jLabel20.setText("Estado");

        jLabel21.setText("Año");

        txtCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCCActionPerformed(evt);
            }
        });

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Activo", "Inactivo" }));
        cmbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoActionPerformed(evt);
            }
        });

        cmbAnioDocente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "2020", "2021", "2022", "2023", "2024", "2025" }));
        cmbAnioDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAnioDocenteActionPerformed(evt);
            }
        });

        jLabel22.setText("Apellidos");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAnioDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombreDocente, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                        .addComponent(txtCC)
                        .addComponent(txtApellidoDocente))
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(txtCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(txtNombreDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(txtApellidoDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(cmbAnioDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jButton3.setText("Volver");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(319, 319, 319)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardarDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiarDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel6)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardarDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiarDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDocenteActionPerformed
        String cedula = txtCC.getText();
        String nombre = txtNombreDocente.getText();
        String apellidos = txtApellidoDocente.getText();
        String anio = cmbAnioDocente.getSelectedItem().toString();
        String estado = cmbEstado.getSelectedItem().toString();
        
        if (cedula.isEmpty() || nombre.isEmpty() || apellidos.isEmpty() || anio.equals("-") || estado.equals("-")) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Importante", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/portalsaberdb", "root", "");
            String sql = "INSERT INTO docentes (cedula, nombre, apellidos, estado, anio) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cedula);
            stmt.setString(2, nombre);
            stmt.setString(3, apellidos);
            stmt.setString(4, estado);
            stmt.setInt(5, Integer.parseInt(anio));
            
            int filasInsertadas = stmt.executeUpdate();
            if (filasInsertadas > 0) {
                JOptionPane.showMessageDialog(this, "Los datos del docente se han guardado exitosamente", "Datos Guardados", JOptionPane.INFORMATION_MESSAGE);
            }
            
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar docente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    

    }//GEN-LAST:event_btnGuardarDocenteActionPerformed

    private void btnLimpiarDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarDocenteActionPerformed
        txtApellidoDocente.setText("");
        txtNombreDocente.setText("");
        txtCC.setText("");
        cmbAnioDocente.setSelectedIndex(0);
        cmbEstado.setSelectedIndex(0);
        
    }//GEN-LAST:event_btnLimpiarDocenteActionPerformed
                                         

    private void txtCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCCActionPerformed

    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEstadoActionPerformed

    private void cmbAnioDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAnioDocenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAnioDocenteActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        Formulario form = new Formulario();
        form.setVisible(true);
        form.setLocationRelativeTo(null);
        this.dispose(); // Cierra la ventana actual
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarDocente;
    private javax.swing.JButton btnLimpiarDocente;
    private javax.swing.JComboBox<String> cmbAnioDocente;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField txtApellidoDocente;
    private javax.swing.JTextField txtCC;
    private javax.swing.JTextField txtNombreDocente;
    // End of variables declaration//GEN-END:variables
}
