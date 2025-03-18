
package com.mycompany.portaldelsaber.igu;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JOptionPane;

public class MenuPrincipal extends javax.swing.JFrame {

    public MenuPrincipal() {
        initComponents();
 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnEstudiante = new javax.swing.JButton();
        btnSalirApp = new javax.swing.JButton();
        btnDocente = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(51, 0, 102));
        jPanel1.setMinimumSize(new java.awt.Dimension(1012, 578));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Preescolar");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 260, -1));

        jPanel2.setBackground(new java.awt.Color(51, 0, 102));

        btnEstudiante.setBackground(new java.awt.Color(255, 255, 0));
        btnEstudiante.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnEstudiante.setForeground(new java.awt.Color(51, 0, 102));
        btnEstudiante.setText("Estudiante");
        btnEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstudianteActionPerformed(evt);
            }
        });

        btnSalirApp.setBackground(new java.awt.Color(255, 255, 0));
        btnSalirApp.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnSalirApp.setForeground(new java.awt.Color(51, 0, 102));
        btnSalirApp.setText("Salir");
        btnSalirApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirAppActionPerformed(evt);
            }
        });

        btnDocente.setBackground(new java.awt.Color(255, 255, 0));
        btnDocente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnDocente.setForeground(new java.awt.Color(51, 0, 102));
        btnDocente.setText("Docentes");
        btnDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalirApp, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(btnEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalirApp, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 146, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\Desktop\\Mis codigos\\logot3.jpg")); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, 192, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("El Portal del Saber");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, -1, -1));

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

    private void btnEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstudianteActionPerformed
MenuEstudiante estu = new MenuEstudiante();
estu.setVisible(true);
estu.setLocationRelativeTo(null);
this.dispose(); 
    }//GEN-LAST:event_btnEstudianteActionPerformed

    private void btnSalirAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirAppActionPerformed
                                       
        int confirm = JOptionPane.showConfirmDialog(this, 
                "¿Estás seguro de que quieres salir?", 
                "Confirmar salida", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.WARNING_MESSAGE);
    
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0); // Cierra la aplicación
        }
    }//GEN-LAST:event_btnSalirAppActionPerformed

    private void btnDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocenteActionPerformed
MenuDocente docente = new MenuDocente();
docente.setVisible(true);
docente.setLocationRelativeTo(null);
this.dispose();
    }//GEN-LAST:event_btnDocenteActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDocente;
    private javax.swing.JButton btnEstudiante;
    private javax.swing.JButton btnSalirApp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
