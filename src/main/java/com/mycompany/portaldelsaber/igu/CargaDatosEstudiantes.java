
package com.mycompany.portaldelsaber.igu;

import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CargaDatosEstudiantes extends javax.swing.JFrame {


public CargaDatosEstudiantes() {
    initComponents();
    configurarValidaciones();
}

private void configurarValidaciones() {
    // Validar que solo ingresen letras y espacios en Nombre
    txtNombreEstudiante.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            char c = evt.getKeyChar();
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                evt.consume(); // No permite el carácter
            } else {
                txtNombreEstudiante.setText(txtNombreEstudiante.getText().toUpperCase());
            }
        }
    });

    // Validar que solo ingresen letras y espacios en Apellidos
    txtApellidosEstudiante.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            char c = evt.getKeyChar();
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                evt.consume(); // No permite el carácter
            } else {
                txtApellidosEstudiante.setText(txtApellidosEstudiante.getText().toUpperCase());
            }
        }
    });

    // Validar Registro Civil (solo números, mínimo 10 y máximo 11 dígitos)
    txtRC.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            char c = evt.getKeyChar();
            if (!Character.isDigit(c)) {
                evt.consume(); // Solo permite números
            }
            if (txtRC.getText().length() >= 11) {
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombreEstudiante = new javax.swing.JTextField();
        txtRC = new javax.swing.JTextField();
        cmbGrado = new javax.swing.JComboBox<>();
        cmbAnioEstudiante = new javax.swing.JComboBox<>();
        txtApellidosEstudiante = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnGuardarEstudiante = new javax.swing.JButton();
        btnLimpiarEstudiante = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1.setText("Datos estudiante");

        jLabel2.setText("Nombre");

        jLabel3.setText("Registro civil");

        jLabel4.setText("Grado");

        jLabel5.setText("Año");

        txtRC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRCActionPerformed(evt);
            }
        });

        cmbGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Parvulos", "Pre-jardin", "Jardin", "Transicion" }));
        cmbGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGradoActionPerformed(evt);
            }
        });

        cmbAnioEstudiante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "2020", "2021", "2022", "2023", "2024", "2025" }));
        cmbAnioEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAnioEstudianteActionPerformed(evt);
            }
        });

        jLabel8.setText("Apellidos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombreEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                        .addComponent(txtRC)
                        .addComponent(txtApellidosEstudiante))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cmbAnioEstudiante, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbGrado, javax.swing.GroupLayout.Alignment.LEADING, 0, 100, Short.MAX_VALUE)))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtRC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtNombreEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(txtApellidosEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(cmbGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(cmbAnioEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\Desktop\\Preescolar\\Portal_Saber.jpg")); // NOI18N

        btnGuardarEstudiante.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnGuardarEstudiante.setText("Guardar");
        btnGuardarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEstudianteActionPerformed(evt);
            }
        });

        btnLimpiarEstudiante.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnLimpiarEstudiante.setText("Limpiar");
        btnLimpiarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarEstudianteActionPerformed(evt);
            }
        });

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
                .addGap(62, 62, 62)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnGuardarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel6)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
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

    private void btnGuardarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEstudianteActionPerformed
        String registro_civil = txtRC.getText();
        String nombre = txtNombreEstudiante.getText();
        String apellidos = txtApellidosEstudiante.getText();
        String grado = cmbGrado.getSelectedItem().toString();
        String anio = cmbAnioEstudiante.getSelectedItem().toString();
        
        if (registro_civil.isEmpty() || nombre.isEmpty() || apellidos.isEmpty() || grado.equals("-") || anio.equals("-")) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Importante", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/portalsaberdb", "root", "");
            String sql = "INSERT INTO estudiantes (registro_civil, nombre, apellidos, grado, anio) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, registro_civil);
            stmt.setString(2, nombre);
            stmt.setString(3, apellidos);
            stmt.setString(4, grado);
            stmt.setInt(5, Integer.parseInt(anio));
            
            int filasInsertadas = stmt.executeUpdate();
            if (filasInsertadas > 0) {
                JOptionPane.showMessageDialog(this, "Los datos del estudiante se han guardado exitosamente", "Datos Guardados", JOptionPane.INFORMATION_MESSAGE);
            }
            
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar estudiante: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarEstudianteActionPerformed

    private void btnLimpiarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarEstudianteActionPerformed
     txtNombreEstudiante.setText("");  
     txtApellidosEstudiante.setText("");  
     txtRC.setText("");  
     cmbAnioEstudiante.setSelectedIndex(0);
     cmbGrado.setSelectedIndex(0);
     
    }//GEN-LAST:event_btnLimpiarEstudianteActionPerformed

    private void txtRCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRCActionPerformed

    private void cmbAnioEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAnioEstudianteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAnioEstudianteActionPerformed

    private void cmbGradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGradoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        MenuEstudiante acu = new MenuEstudiante();
        acu.setVisible(true);
        acu.setLocationRelativeTo(null);
        this.dispose(); // Cierra la ventana actual

    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarEstudiante;
    private javax.swing.JButton btnLimpiarEstudiante;
    private javax.swing.JComboBox<String> cmbAnioEstudiante;
    private javax.swing.JComboBox<String> cmbGrado;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtApellidosEstudiante;
    private javax.swing.JTextField txtNombreEstudiante;
    private javax.swing.JTextField txtRC;
    // End of variables declaration//GEN-END:variables
}
