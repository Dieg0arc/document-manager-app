
package com.mycompany.portaldelsaber.igu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import com.mycompany.portaldelsaber.persistencia.ConexionBD;

public class ConsultaEstudiante extends javax.swing.JFrame {

public ConsultaEstudiante() {
        initComponents();
        btnConsultarE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarEstudiante();
            }
        });
    }

    private void consultarEstudiante() {
        String registroCivil = txtRCC.getText().trim();
        if (registroCivil.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un número de Registro Civil.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection con = ConexionBD.conectar()) {
            String sql = "SELECT * FROM estudiantes WHERE registro_civil = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, registroCivil);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                txtNombreC.setText(rs.getString("nombre"));
                txtApellidosC.setText(rs.getString("apellidos"));
                cmbGradoC.setSelectedItem("valor");
                cmbAnioC.setSelectedItem("valor");

                
                // Obtener ruta del archivo (Ejemplo: C:/2025/estudiante/Transicion/documento.pdf)
                String rutaArchivo = "C:/" + rs.getString("anio") + "/estudiante/" + rs.getString("grado") + "/" + registroCivil + ".pdf";
                txtRespuesta.setText(rutaArchivo);
            } else {
                JOptionPane.showMessageDialog(this, "Estudiante no encontrado.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al consultar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgCE = new javax.swing.JPanel();
        tituloConsultae = new javax.swing.JLabel();
        JLRC = new javax.swing.JLabel();
        txtRCC = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txtNombreC = new javax.swing.JTextField();
        JLNombreC = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtApellidosC = new javax.swing.JTextField();
        JLApellidosC = new javax.swing.JLabel();
        JLGradoC = new javax.swing.JLabel();
        JLAnioC = new javax.swing.JLabel();
        cmbAnioC = new javax.swing.JComboBox<>();
        cmbGradoC = new javax.swing.JComboBox<>();
        btnLimpiarE = new javax.swing.JButton();
        btnVolverCE = new javax.swing.JButton();
        btnConsultarE = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRespuesta = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        bgCE.setBackground(new java.awt.Color(255, 255, 255));
        bgCE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloConsultae.setBackground(new java.awt.Color(0, 0, 0));
        tituloConsultae.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        tituloConsultae.setForeground(new java.awt.Color(0, 0, 0));
        tituloConsultae.setText("Consulta Estudiante");
        bgCE.add(tituloConsultae, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, -1));

        JLRC.setBackground(new java.awt.Color(255, 255, 255));
        JLRC.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        JLRC.setForeground(new java.awt.Color(0, 0, 0));
        JLRC.setText("Resgitro civil");
        bgCE.add(JLRC, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 130, -1));

        txtRCC.setBackground(new java.awt.Color(255, 255, 255));
        txtRCC.setForeground(new java.awt.Color(204, 204, 204));
        txtRCC.setText("Ingrese el registro civil");
        txtRCC.setBorder(null);
        txtRCC.setCaretColor(new java.awt.Color(204, 204, 204));
        txtRCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtRCCMousePressed(evt);
            }
        });
        txtRCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRCCActionPerformed(evt);
            }
        });
        bgCE.add(txtRCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 190, -1));
        bgCE.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 190, -1));
        bgCE.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 190, -1));

        txtNombreC.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreC.setForeground(new java.awt.Color(204, 204, 204));
        txtNombreC.setText("Ingrese el nombre");
        txtNombreC.setBorder(null);
        txtNombreC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNombreCMousePressed(evt);
            }
        });
        txtNombreC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreCActionPerformed(evt);
            }
        });
        bgCE.add(txtNombreC, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 190, -1));

        JLNombreC.setBackground(new java.awt.Color(255, 255, 255));
        JLNombreC.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        JLNombreC.setForeground(new java.awt.Color(0, 0, 0));
        JLNombreC.setText("Nombre");
        bgCE.add(JLNombreC, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, -1));
        bgCE.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, 190, -1));

        txtApellidosC.setBackground(new java.awt.Color(255, 255, 255));
        txtApellidosC.setForeground(new java.awt.Color(204, 204, 204));
        txtApellidosC.setText("Ingrese los apellidos");
        txtApellidosC.setBorder(null);
        txtApellidosC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtApellidosCMousePressed(evt);
            }
        });
        bgCE.add(txtApellidosC, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 190, -1));

        JLApellidosC.setBackground(new java.awt.Color(255, 255, 255));
        JLApellidosC.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        JLApellidosC.setForeground(new java.awt.Color(0, 0, 0));
        JLApellidosC.setText("Apellidos");
        bgCE.add(JLApellidosC, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, -1, -1));

        JLGradoC.setBackground(new java.awt.Color(255, 255, 255));
        JLGradoC.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        JLGradoC.setForeground(new java.awt.Color(0, 0, 0));
        JLGradoC.setText("Grado");
        bgCE.add(JLGradoC, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 100, -1, -1));

        JLAnioC.setBackground(new java.awt.Color(255, 255, 255));
        JLAnioC.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        JLAnioC.setForeground(new java.awt.Color(0, 0, 0));
        JLAnioC.setText("Año");
        bgCE.add(JLAnioC, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 100, -1, -1));

        cmbAnioC.setBackground(new java.awt.Color(0, 0, 0));
        cmbAnioC.setForeground(new java.awt.Color(255, 255, 255));
        cmbAnioC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "2020", "2021", "2022", "2023", "2024", "2025", " " }));
        cmbAnioC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cmbAnioCMousePressed(evt);
            }
        });
        bgCE.add(cmbAnioC, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 120, 90, -1));

        cmbGradoC.setBackground(new java.awt.Color(0, 0, 0));
        cmbGradoC.setForeground(new java.awt.Color(255, 255, 255));
        cmbGradoC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "parvulos", "jardin", "pre-jardin", "preescolar", " " }));
        cmbGradoC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cmbGradoCMousePressed(evt);
            }
        });
        bgCE.add(cmbGradoC, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 120, -1, -1));

        btnLimpiarE.setText("Limpiar");
        btnLimpiarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarEActionPerformed(evt);
            }
        });
        bgCE.add(btnLimpiarE, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 100, 40));

        btnVolverCE.setText("Volver");
        btnVolverCE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverCEActionPerformed(evt);
            }
        });
        bgCE.add(btnVolverCE, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 270, 90, 30));

        btnConsultarE.setText("Consultar");
        btnConsultarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarEActionPerformed(evt);
            }
        });
        bgCE.add(btnConsultarE, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 100, 40));

        txtRespuesta.setBackground(new java.awt.Color(204, 204, 204));
        txtRespuesta.setColumns(20);
        txtRespuesta.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        txtRespuesta.setForeground(new java.awt.Color(0, 0, 0));
        txtRespuesta.setRows(5);
        txtRespuesta.setText("acá se deberia mostrar la URL");
        jScrollPane1.setViewportView(txtRespuesta);

        bgCE.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 940, 240));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgCE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgCE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreCActionPerformed

    private void btnLimpiarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarEActionPerformed
    txtRCC.setText("Ingrese el registro civil");
    txtNombreC.setText("Ingrese el nombre");
    txtApellidosC.setText("Ingrese los apellidos");
    cmbAnioC.setSelectedIndex(0);
    cmbGradoC.setSelectedIndex(0);
    
    }//GEN-LAST:event_btnLimpiarEActionPerformed

    private void btnConsultarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultarEActionPerformed

    private void btnVolverCEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverCEActionPerformed
        Estudiante pantalla = new Estudiante();
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnVolverCEActionPerformed

    private void txtRCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRCCActionPerformed

    private void txtRCCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRCCMousePressed
    if (txtRCC.getText().equals("Ingrese el registro civil")) {
        txtRCC.setText("");
        txtRCC.setForeground(Color.black);
    }
    if (txtNombreC.getText().isEmpty()) {
        txtNombreC.setText("Ingrese el nombre");
        txtNombreC.setForeground(Color.gray);
    }
    if (txtApellidosC.getText().isEmpty()) {
        txtApellidosC.setText("Ingrese los apellidos");
        txtApellidosC.setForeground(Color.gray);
    }
    }//GEN-LAST:event_txtRCCMousePressed

    private void txtNombreCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreCMousePressed
    if (txtRCC.getText().isEmpty()) {
        txtRCC.setText("Ingrese el registro civil");
        txtRCC.setForeground(Color.gray);
    }
    if (txtNombreC.getText().equals("Ingrese el nombre")) {
        txtNombreC.setText("");
        txtNombreC.setForeground(Color.black);
    }
    if (txtApellidosC.getText().isEmpty()) {
        txtApellidosC.setText("Ingrese los apellidos");
        txtApellidosC.setForeground(Color.gray);
    }
    }//GEN-LAST:event_txtNombreCMousePressed

    private void txtApellidosCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidosCMousePressed
    if (txtRCC.getText().isEmpty()) {
        txtRCC.setText("Ingrese el registro civil");
        txtRCC.setForeground(Color.gray);
    }
    if (txtNombreC.getText().isEmpty()) {
        txtNombreC.setText("Ingrese el nombre");
        txtNombreC.setForeground(Color.gray);
    }
    if (txtApellidosC.getText().equals("Ingrese los apellidos")) {
        txtApellidosC.setText("");
        txtApellidosC.setForeground(Color.black);
    }
    }//GEN-LAST:event_txtApellidosCMousePressed

    private void cmbGradoCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbGradoCMousePressed
    if (txtRCC.getText().isEmpty()) {
        txtRCC.setText("Ingrese el registro civil");
        txtRCC.setForeground(Color.gray);
    }
    if (txtNombreC.getText().isEmpty()) {
        txtNombreC.setText("Ingrese el nombre");
        txtNombreC.setForeground(Color.gray);
    }
    if (txtApellidosC.getText().isEmpty()) {
        txtApellidosC.setText("Ingrese los apellidos");
        txtApellidosC.setForeground(Color.gray);
    }
    }//GEN-LAST:event_cmbGradoCMousePressed

    private void cmbAnioCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbAnioCMousePressed
     if (txtRCC.getText().isEmpty()) {
        txtRCC.setText("Ingrese el registro civil");
        txtRCC.setForeground(Color.gray);
    }
    if (txtNombreC.getText().isEmpty()) {
        txtNombreC.setText("Ingrese el nombre");
        txtNombreC.setForeground(Color.gray);
    }
    if (txtApellidosC.getText().isEmpty()) {
        txtApellidosC.setText("Ingrese los apellidos");
        txtApellidosC.setForeground(Color.gray);
    }
    }//GEN-LAST:event_cmbAnioCMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLAnioC;
    private javax.swing.JLabel JLApellidosC;
    private javax.swing.JLabel JLGradoC;
    private javax.swing.JLabel JLNombreC;
    private javax.swing.JLabel JLRC;
    private javax.swing.JPanel bgCE;
    private javax.swing.JButton btnConsultarE;
    private javax.swing.JButton btnLimpiarE;
    private javax.swing.JButton btnVolverCE;
    private javax.swing.JComboBox<String> cmbAnioC;
    private javax.swing.JComboBox<String> cmbGradoC;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel tituloConsultae;
    private javax.swing.JTextField txtApellidosC;
    private javax.swing.JTextField txtNombreC;
    private javax.swing.JTextField txtRCC;
    private javax.swing.JTextArea txtRespuesta;
    // End of variables declaration//GEN-END:variables
}
