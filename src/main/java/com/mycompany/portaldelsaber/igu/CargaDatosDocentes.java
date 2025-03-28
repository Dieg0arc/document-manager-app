
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
                                // Convertir a mayúscula
                evt.setKeyChar(Character.toUpperCase(c));
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
                                // Convertir a mayúscula
                evt.setKeyChar(Character.toUpperCase(c));
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
    //Validar que el año solo sean numeros, mínimo y máximo 4 digitos
    txtAnio.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            char c = evt.getKeyChar();
            if (!Character.isDigit(c)) {
                evt.consume(); // Solo permite números
            }
            if (txtAnio.getText().length() >= 4) {
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
        txtApellidoDocente = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 0, 102));
        jPanel1.setMinimumSize(new java.awt.Dimension(1012, 578));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Datos docentes");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 6, 397, -1));

        btnGuardarDocente.setBackground(new java.awt.Color(255, 255, 0));
        btnGuardarDocente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnGuardarDocente.setForeground(new java.awt.Color(102, 0, 204));
        btnGuardarDocente.setText("Guardar");
        btnGuardarDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarDocenteActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardarDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 420, 180, 54));

        btnLimpiarDocente.setBackground(new java.awt.Color(255, 255, 0));
        btnLimpiarDocente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnLimpiarDocente.setForeground(new java.awt.Color(102, 0, 204));
        btnLimpiarDocente.setText("Limpiar");
        btnLimpiarDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarDocenteActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiarDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 420, 180, 54));

        jPanel5.setBackground(new java.awt.Color(51, 0, 102));

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Nombre");

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Cedula de Ciudadania");

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Estado");

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
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

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Apellidos");

        txtAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombreDocente, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                        .addComponent(txtCC)
                        .addComponent(txtApellidoDocente)
                        .addComponent(txtAnio))
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
                .addGap(20, 20, 20)
                .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 74, -1, -1));

        jButton3.setBackground(new java.awt.Color(255, 255, 0));
        jButton3.setForeground(new java.awt.Color(102, 0, 204));
        jButton3.setText("Volver");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 520, 100, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoPs3.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, -1, -1));

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

    private void btnGuardarDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDocenteActionPerformed
        String cedula = txtCC.getText();
        String nombre = txtNombreDocente.getText();
        String apellidos = txtApellidoDocente.getText();
        String anio = txtAnio.getText();
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
        txtAnio.setText("");
        cmbEstado.setSelectedIndex(0);
        
    }//GEN-LAST:event_btnLimpiarDocenteActionPerformed
                                         

    private void txtCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCCActionPerformed

    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEstadoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        MenuDocente form = new MenuDocente();
        form.setVisible(true);
        form.setLocationRelativeTo(null);
        this.dispose(); // Cierra la ventana actual
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarDocente;
    private javax.swing.JButton btnLimpiarDocente;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtApellidoDocente;
    private javax.swing.JTextField txtCC;
    private javax.swing.JTextField txtNombreDocente;
    // End of variables declaration//GEN-END:variables
}
