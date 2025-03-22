
package com.mycompany.portaldelsaber.igu;

import com.mycompany.portaldelsaber.persistencia.ConexionBD;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextField;


public class OldAcudiente extends javax.swing.JFrame {

public OldAcudiente() {
    initComponents();

    // Deshabilitar el botón "Siguiente" al inicio
    btnSiguienteEstu.setEnabled(false);

    // Deshabilitar el segundo acudiente al inicio
    habilitarSegundoAcudiente(false);

    // Validaciones de entrada
    validarSoloNumeros(txtCCA1, 10);
    validarSoloNumeros(txtPhoneAcu1, 11);
    validarSoloNumeros(txtCCA2, 10);
    validarSoloNumeros(txtPhoneAcu2, 11);
    validarSoloLetras(txtNombreAcu1);
    validarSoloLetras(txtApellidoAcu1);
    validarSoloLetras(txtNombreAcu2);
    validarSoloLetras(txtApellidosAcu2);

    // Checkbox para habilitar el segundo acudiente
    chkSegundoAcudiente.addActionListener(e -> habilitarSegundoAcudiente(chkSegundoAcudiente.isSelected()));

    // Agregar validación al escribir en los campos del primer acudiente
    agregarValidacionTiempoReal();
}

// Método para validar y habilitar el botón "Siguiente"
private void validarFormulario() {
    boolean nombreOK = !txtNombreAcu1.getText().trim().isEmpty();
    boolean apellidoOK = !txtApellidoAcu1.getText().trim().isEmpty();
    boolean ccOK = txtCCA1.getText().trim().length() == 10;
    boolean phoneOK = txtPhoneAcu1.getText().trim().length() == 11;

    // Si todo está completo, habilitar el botón "Siguiente"
    btnSiguienteEstu.setEnabled(nombreOK && apellidoOK && ccOK && phoneOK);
}

// Método para agregar validación en tiempo real a los campos del primer acudiente
private void agregarValidacionTiempoReal() {
    txtNombreAcu1.addKeyListener(new KeyAdapter() { public void keyReleased(KeyEvent e) { validarFormulario(); }});
    txtApellidoAcu1.addKeyListener(new KeyAdapter() { public void keyReleased(KeyEvent e) { validarFormulario(); }});
    txtCCA1.addKeyListener(new KeyAdapter() { public void keyReleased(KeyEvent e) { validarFormulario(); }});
    txtPhoneAcu1.addKeyListener(new KeyAdapter() { public void keyReleased(KeyEvent e) { validarFormulario(); }});
}

// Método para validar solo números con un máximo de caracteres
private void validarSoloNumeros(JTextField campo, int maxLength) {
    campo.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent evt) {
            char c = evt.getKeyChar();
            if (!Character.isDigit(c) || campo.getText().length() >= maxLength) {
                evt.consume();
            }
        }
    });
}

// Método para validar solo letras y espacios
private void validarSoloLetras(JTextField campo) {
    campo.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent evt) {
            char c = evt.getKeyChar();
            if (!Character.isLetter(c) && c != ' ') { // Se permite el espacio
                evt.consume();
            }
        }
    });
}

// Método para habilitar o deshabilitar el segundo acudiente
private void habilitarSegundoAcudiente(boolean habilitado) {
    txtNombreAcu2.setEnabled(habilitado);
    txtApellidosAcu2.setEnabled(habilitado);
    txtCCA2.setEnabled(habilitado);
    txtPhoneAcu2.setEnabled(habilitado);

    if (!habilitado) {
        txtNombreAcu2.setText("");
        txtApellidosAcu2.setText("");
        txtCCA2.setText("");
        txtPhoneAcu2.setText("");
    }
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
        txtNombreAcu1 = new javax.swing.JTextField();
        txtCCA1 = new javax.swing.JTextField();
        txtApellidoAcu1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPhoneAcu1 = new javax.swing.JTextField();
        btnGuardarAcudiente = new javax.swing.JButton();
        btnLimpiarAcudiente = new javax.swing.JButton();
        btnSiguienteEstu = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombreAcu2 = new javax.swing.JTextField();
        txtCCA2 = new javax.swing.JTextField();
        txtApellidosAcu2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPhoneAcu2 = new javax.swing.JTextField();
        btnBackAcu1 = new javax.swing.JButton();
        chkSegundoAcudiente = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1.setText("Datos acudiente");

        jLabel2.setText("Nombre");

        jLabel3.setText("Cedula Acudiente");

        jLabel4.setText("Telefono");

        txtNombreAcu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreAcu1ActionPerformed(evt);
            }
        });

        txtCCA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCCA1ActionPerformed(evt);
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
                    .addComponent(txtPhoneAcu1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNombreAcu1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                                .addComponent(txtCCA1)
                                .addComponent(txtApellidoAcu1))
                            .addComponent(jLabel4))
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtCCA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtNombreAcu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(txtApellidoAcu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPhoneAcu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );

        btnGuardarAcudiente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnGuardarAcudiente.setText("Guardar");
        btnGuardarAcudiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAcudienteActionPerformed(evt);
            }
        });

        btnLimpiarAcudiente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnLimpiarAcudiente.setText("Limpiar");
        btnLimpiarAcudiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarAcudienteActionPerformed(evt);
            }
        });

        btnSiguienteEstu.setText("siguiente");
        btnSiguienteEstu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteEstuActionPerformed(evt);
            }
        });

        jLabel5.setText("Nombre");

        jLabel6.setText("Cedula Acudiente2");

        jLabel7.setText("Telefono");

        txtNombreAcu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreAcu2ActionPerformed(evt);
            }
        });

        txtCCA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCCA2ActionPerformed(evt);
            }
        });

        jLabel9.setText("Apellidos");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPhoneAcu2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNombreAcu2, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                                .addComponent(txtCCA2)
                                .addComponent(txtApellidosAcu2))
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(txtCCA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtNombreAcu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(txtApellidosAcu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPhoneAcu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );

        btnBackAcu1.setText("Volver");
        btnBackAcu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackAcu1ActionPerformed(evt);
            }
        });

        chkSegundoAcudiente.setText("Segundo Acudiente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(319, 319, 319)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chkSegundoAcudiente)
                .addGap(306, 306, 306))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addComponent(btnGuardarAcudiente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLimpiarAcudiente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSiguienteEstu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBackAcu1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(93, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addComponent(chkSegundoAcudiente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGuardarAcudiente, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSiguienteEstu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBackAcu1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnLimpiarAcudiente, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
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

    private void txtCCA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCCA1ActionPerformed
        //boton cedula primer acudiente
    }//GEN-LAST:event_txtCCA1ActionPerformed

    private void btnGuardarAcudienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAcudienteActionPerformed

    String cedulaAcu1 = txtCCA1.getText().trim();
    String nombreAcu1 = txtNombreAcu1.getText().trim();
    String apellidosAcu1 = txtApellidoAcu1.getText().trim();
    String telefonoAcu1 = txtPhoneAcu1.getText().trim();
    
    String cedulaAcu2 = txtCCA2.getText().trim();
    String nombreAcu2 = txtNombreAcu2.getText().trim();
    String apellidosAcu2 = txtApellidosAcu2.getText().trim();
    String telefonoAcu2 = txtPhoneAcu2.getText().trim();
    
    if (cedulaAcu1.isEmpty() || nombreAcu1.isEmpty() || apellidosAcu1.isEmpty() || telefonoAcu1.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos del primer acudiente.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    if (!cedulaAcu1.matches("\\d{1,10}")) {
        JOptionPane.showMessageDialog(this, "La cédula del primer acudiente debe contener hasta 10 dígitos numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    if (!telefonoAcu1.matches("\\d{1,11}")) {
        JOptionPane.showMessageDialog(this, "El teléfono del primer acudiente debe contener hasta 11 dígitos numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    if (!cedulaAcu2.isEmpty() && (!cedulaAcu2.matches("\\d{1,10}") || !telefonoAcu2.matches("\\d{1,11}"))) {
        JOptionPane.showMessageDialog(this, "Verifique que la cédula (hasta 10 dígitos) y el teléfono (hasta 11 dígitos) del segundo acudiente sean correctos.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    try {
        Connection conn = ConexionBD.conectar();
        String sql = "INSERT INTO acudientes (cedula, nombre, apellidos, telefono) VALUES (?, ?, ?, ?);";
        PreparedStatement pst = conn.prepareStatement(sql);
        
        pst.setString(1, cedulaAcu1);
        pst.setString(2, nombreAcu1);
        pst.setString(3, apellidosAcu1);
        pst.setString(4, telefonoAcu1);
        pst.executeUpdate();
        
        if (!cedulaAcu2.isEmpty() && !nombreAcu2.isEmpty() && !apellidosAcu2.isEmpty() && !telefonoAcu2.isEmpty()) {
            pst.setString(1, cedulaAcu2);
            pst.setString(2, nombreAcu2);
            pst.setString(3, apellidosAcu2);
            pst.setString(4, telefonoAcu2);
            pst.executeUpdate();
        }
        
        JOptionPane.showMessageDialog(this, "Acudiente(s) guardado(s) correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        
        txtCCA1.setText("");
        txtNombreAcu1.setText("");
        txtApellidoAcu1.setText("");
        txtPhoneAcu1.setText("");
        txtCCA2.setText("");
        txtNombreAcu2.setText("");
        txtApellidosAcu2.setText("");
        txtPhoneAcu2.setText("");
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al guardar en la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }


    }//GEN-LAST:event_btnGuardarAcudienteActionPerformed

    private void btnLimpiarAcudienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarAcudienteActionPerformed
        txtNombreAcu1.setText("");
        txtApellidoAcu1.setText("");
        txtCCA1.setText("");
        txtPhoneAcu1.setText("");
        txtNombreAcu2.setText("");
        txtApellidosAcu2.setText("");
        txtCCA2.setText("");
        txtPhoneAcu2.setText("");


    }//GEN-LAST:event_btnLimpiarAcudienteActionPerformed

    private void btnSiguienteEstuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteEstuActionPerformed
                                    
    CargaDatosEstudiantes estu = new CargaDatosEstudiantes();
    estu.setVisible(true);
    estu.setLocationRelativeTo(null);
    this.dispose();  
    }//GEN-LAST:event_btnSiguienteEstuActionPerformed

    private void txtCCA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCCA2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCCA2ActionPerformed

    private void txtNombreAcu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreAcu1ActionPerformed
    String text = txtNombreAcu1.getText();
    if (!text.matches("[a-zA-Z ]+")) { 
        JOptionPane.showMessageDialog(this, "Ingrese solo letras", "Error", JOptionPane.ERROR_MESSAGE);
        txtNombreAcu1.setText("");
    }
    }//GEN-LAST:event_txtNombreAcu1ActionPerformed

    private void txtNombreAcu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreAcu2ActionPerformed
    String text = txtNombreAcu2.getText();
    if (!text.matches("[a-zA-Z ]+")) { 
        JOptionPane.showMessageDialog(this, "Ingrese solo letras", "Error", JOptionPane.ERROR_MESSAGE);
        txtNombreAcu2.setText("");
    }
    }//GEN-LAST:event_txtNombreAcu2ActionPerformed

    private void btnBackAcu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackAcu1ActionPerformed
        MenuEstudiante estu = new MenuEstudiante();
        estu.setVisible(true);
        estu.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnBackAcu1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OldAcudiente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackAcu1;
    private javax.swing.JButton btnGuardarAcudiente;
    private javax.swing.JButton btnLimpiarAcudiente;
    private javax.swing.JButton btnSiguienteEstu;
    private javax.swing.JCheckBox chkSegundoAcudiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtApellidoAcu1;
    private javax.swing.JTextField txtApellidosAcu2;
    private javax.swing.JTextField txtCCA1;
    private javax.swing.JTextField txtCCA2;
    private javax.swing.JTextField txtNombreAcu1;
    private javax.swing.JTextField txtNombreAcu2;
    private javax.swing.JTextField txtPhoneAcu1;
    private javax.swing.JTextField txtPhoneAcu2;
    // End of variables declaration//GEN-END:variables
}
