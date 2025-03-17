
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
    String nombre = txtNombreC.getText().trim();
    String apellidos = txtApellidosC.getText().trim();
    String grado = cmbGradoC.getSelectedItem().toString();
    String anio = txtAnioC.getText().trim();
    
    // Verify if at least one field has valid search data
    if ((registroCivil.isEmpty() || registroCivil.equals("Ingrese el registro civil")) &&
        (nombre.isEmpty() || nombre.equals("Ingrese el nombre")) &&
        (apellidos.isEmpty() || apellidos.equals("Ingrese los apellidos")) &&
        (grado.equals("-") || grado.equals(" ")) &&
        (anio.isEmpty() || anio.equals("Ingrese el año"))) {
        JOptionPane.showMessageDialog(this, "Ingrese al menos un criterio de búsqueda.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try (Connection con = ConexionBD.conectar()) {
        // Build dynamic SQL query based on provided fields
        StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM estudiantes WHERE 1=1");
        
        // Prepare parameters list
        java.util.List<Object> params = new java.util.ArrayList<>();
        
        // Add conditions based on provided fields
        if (!registroCivil.isEmpty() && !registroCivil.equals("Ingrese el registro civil")) {
            sqlBuilder.append(" AND registro_civil = ?");
            params.add(registroCivil);
        }
        
        if (!nombre.isEmpty() && !nombre.equals("Ingrese el nombre")) {
            sqlBuilder.append(" AND nombre LIKE ?");
            params.add("%" + nombre + "%");
        }
        
        if (!apellidos.isEmpty() && !apellidos.equals("Ingrese los apellidos")) {
            sqlBuilder.append(" AND apellidos LIKE ?");
            params.add("%" + apellidos + "%");
        }
        
        if (!grado.equals("-") && !grado.equals(" ")) {
            sqlBuilder.append(" AND grado = ?");
            params.add(grado);
        }
        
        if (!anio.isEmpty() && !anio.equals("Ingrese el año")) {
            sqlBuilder.append(" AND anio = ?");
            params.add(anio);
        }
        
        // Prepare statement with dynamic query
        PreparedStatement ps = con.prepareStatement(sqlBuilder.toString());
        
        // Set parameters
        for (int i = 0; i < params.size(); i++) {
            ps.setObject(i + 1, params.get(i));
        }
        
        // Execute query
        ResultSet rs = ps.executeQuery();
        
        int resultCount = 0;
        
        // Count the results before processing
        while (rs.next()) {
            resultCount++;
        }
        
        // Reset the result set to start from the beginning
        rs = ps.executeQuery();
        
        if (resultCount == 1) {
            // If only one result, display it directly as in the second code
            if (rs.next()) {
                txtNombreC.setText(rs.getString("nombre"));
                txtApellidosC.setText(rs.getString("apellidos"));
                
                // Set the grade in the combo box
                String foundGrado = rs.getString("grado");
                for (int i = 0; i < cmbGradoC.getItemCount(); i++) {
                    if (cmbGradoC.getItemAt(i).equals(foundGrado)) {
                        cmbGradoC.setSelectedIndex(i);
                        break;
                    }
                }
                
                txtAnioC.setText(rs.getString("anio"));
                
                // Get the document path as a clickable URL
                String rc = rs.getString("registro_civil");
                String rutaArchivo = "C:\\Users\\Asus\\Desktop\\PruebasPS\\" + rs.getString("anio") + "\\estudiante\\" + foundGrado + "\\" + rc + ".pdf";
                txtRespuesta.setText(rutaArchivo);
                
                // Make the text area look like a clickable URL
                txtRespuesta.setForeground(Color.BLUE);
                txtRespuesta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                
                // Add mouse listener to handle clicks on the URL
                if (!txtRespuesta.getMouseListeners().getClass().getName().contains("URLClickListener")) {
                    txtRespuesta.addMouseListener(new URLClickListener());
                }
            }
        } else if (resultCount > 1) {
            // Multiple results found, show selection dialog
            Object[][] data = new Object[resultCount][5];
            String[] columnNames = {"Registro Civil", "Nombre", "Apellidos", "Grado", "Año"};
            
            int index = 0;
            while (rs.next()) {
                data[index][0] = rs.getString("registro_civil");
                data[index][1] = rs.getString("nombre");
                data[index][2] = rs.getString("apellidos");
                data[index][3] = rs.getString("grado");
                data[index][4] = rs.getString("anio");
                index++;
            }
            
            // Create table model
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, columnNames) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // Make cells non-editable
                }
            };
            
            // Create table and scrollpane
            javax.swing.JTable table = new javax.swing.JTable(model);
            javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(table);
            
            // Show dialog with table
            Object[] options = {"Seleccionar", "Cancelar"};
            int result = JOptionPane.showOptionDialog(
                this,
                scrollPane,
                "Seleccione un estudiante (" + resultCount + " resultados)",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
            );
            
            // If user selected an entry
            if (result == JOptionPane.YES_OPTION && table.getSelectedRow() != -1) {
                int selectedRow = table.getSelectedRow();
                
                // Set the form fields
                txtRCC.setText((String) data[selectedRow][0]);
                txtNombreC.setText((String) data[selectedRow][1]);
                txtApellidosC.setText((String) data[selectedRow][2]);
                
                // Set the grade in the combo box
                String selectedGrado = (String) data[selectedRow][3];
                for (int i = 0; i < cmbGradoC.getItemCount(); i++) {
                    if (cmbGradoC.getItemAt(i).equals(selectedGrado)) {
                        cmbGradoC.setSelectedIndex(i);
                        break;
                    }
                }
                
                txtAnioC.setText((String) data[selectedRow][4]);
                
                // Generate and display file path
                String rc = (String) data[selectedRow][0];
                String rutaArchivo = "C:\\Users\\Asus\\Desktop\\PruebasPS\\" + data[selectedRow][4] + "\\estudiante\\" + data[selectedRow][3] + "\\" + rc + ".pdf";
                txtRespuesta.setText(rutaArchivo);
                
                // Make the text area look like a clickable URL
                txtRespuesta.setForeground(Color.BLUE);
                txtRespuesta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                
                // Add mouse listener to handle clicks on the URL
                if (!txtRespuesta.getMouseListeners().getClass().getName().contains("URLClickListener")) {
                    txtRespuesta.addMouseListener(new URLClickListener());
                }
            }
        } else {
            // No results
            JOptionPane.showMessageDialog(this, "No se encontraron estudiantes con los criterios proporcionados.", 
                "Información", JOptionPane.INFORMATION_MESSAGE);
            txtRespuesta.setText("");
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al consultar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

// Custom MouseListener class to handle clicks on the URL in the text area
private class URLClickListener extends java.awt.event.MouseAdapter {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() > 0) {
            String url = txtRespuesta.getText().trim();
            try {
                java.awt.Desktop.getDesktop().open(new java.io.File(url));
            } catch (java.io.IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al abrir el archivo: " + ex.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}


    
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgCE = new javax.swing.JPanel();
        tituloConsultae = new javax.swing.JLabel();
        JLRC = new javax.swing.JLabel();
        txtRCC = new javax.swing.JTextField();
        txtNombreC = new javax.swing.JTextField();
        JLNombreC = new javax.swing.JLabel();
        txtAnioC = new javax.swing.JTextField();
        JLApellidosC = new javax.swing.JLabel();
        JLGradoC = new javax.swing.JLabel();
        JLAnioC = new javax.swing.JLabel();
        cmbGradoC = new javax.swing.JComboBox<>();
        btnLimpiarE = new javax.swing.JButton();
        btnVolverCE = new javax.swing.JButton();
        btnConsultarE = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRespuesta = new javax.swing.JTextArea();
        txtApellidosC = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        bgCE.setBackground(new java.awt.Color(51, 0, 102));
        bgCE.setMinimumSize(new java.awt.Dimension(1012, 578));
        bgCE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloConsultae.setBackground(new java.awt.Color(0, 0, 0));
        tituloConsultae.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        tituloConsultae.setForeground(new java.awt.Color(255, 255, 255));
        tituloConsultae.setText("Consulta Estudiante");
        bgCE.add(tituloConsultae, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        JLRC.setBackground(new java.awt.Color(255, 255, 255));
        JLRC.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        JLRC.setForeground(new java.awt.Color(255, 255, 255));
        JLRC.setText("Resgitro civil");
        bgCE.add(JLRC, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 130, -1));

        txtRCC.setBackground(new java.awt.Color(255, 255, 255));
        txtRCC.setForeground(new java.awt.Color(204, 204, 204));
        txtRCC.setText("Ingrese el registro civil");
        txtRCC.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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
        bgCE.add(txtRCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 190, -1));

        txtNombreC.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreC.setForeground(new java.awt.Color(204, 204, 204));
        txtNombreC.setText("Ingrese el nombre");
        txtNombreC.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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
        bgCE.add(txtNombreC, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 190, -1));

        JLNombreC.setBackground(new java.awt.Color(255, 255, 255));
        JLNombreC.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        JLNombreC.setForeground(new java.awt.Color(255, 255, 255));
        JLNombreC.setText("Nombre");
        bgCE.add(JLNombreC, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, -1, -1));

        txtAnioC.setBackground(new java.awt.Color(255, 255, 255));
        txtAnioC.setForeground(new java.awt.Color(204, 204, 204));
        txtAnioC.setText("Ingrese el año");
        txtAnioC.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtAnioC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtAnioCMousePressed(evt);
            }
        });
        txtAnioC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnioCActionPerformed(evt);
            }
        });
        bgCE.add(txtAnioC, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 130, 130, -1));

        JLApellidosC.setBackground(new java.awt.Color(255, 255, 255));
        JLApellidosC.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        JLApellidosC.setForeground(new java.awt.Color(255, 255, 255));
        JLApellidosC.setText("Apellidos");
        bgCE.add(JLApellidosC, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, -1, -1));

        JLGradoC.setBackground(new java.awt.Color(255, 255, 255));
        JLGradoC.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        JLGradoC.setForeground(new java.awt.Color(255, 255, 255));
        JLGradoC.setText("Grado");
        bgCE.add(JLGradoC, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 100, -1, -1));

        JLAnioC.setBackground(new java.awt.Color(255, 255, 255));
        JLAnioC.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        JLAnioC.setForeground(new java.awt.Color(255, 255, 255));
        JLAnioC.setText("Año");
        bgCE.add(JLAnioC, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 100, -1, -1));

        cmbGradoC.setForeground(new java.awt.Color(255, 255, 255));
        cmbGradoC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "parvulos", "jardin", "pre-jardin", "preescolar", " " }));
        cmbGradoC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cmbGradoCMousePressed(evt);
            }
        });
        bgCE.add(cmbGradoC, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, -1, -1));

        btnLimpiarE.setBackground(new java.awt.Color(255, 255, 0));
        btnLimpiarE.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiarE.setText("Limpiar");
        btnLimpiarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarEActionPerformed(evt);
            }
        });
        bgCE.add(btnLimpiarE, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 100, 40));

        btnVolverCE.setText("Volver");
        btnVolverCE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverCEActionPerformed(evt);
            }
        });
        bgCE.add(btnVolverCE, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 270, 90, 30));

        btnConsultarE.setBackground(new java.awt.Color(255, 255, 0));
        btnConsultarE.setForeground(new java.awt.Color(0, 0, 0));
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

        bgCE.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 990, 260));

        txtApellidosC.setBackground(new java.awt.Color(255, 255, 255));
        txtApellidosC.setForeground(new java.awt.Color(204, 204, 204));
        txtApellidosC.setText("Ingrese los apellidos");
        txtApellidosC.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtApellidosC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtApellidosCMousePressed(evt);
            }
        });
        txtApellidosC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosCActionPerformed(evt);
            }
        });
        bgCE.add(txtApellidosC, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 190, -1));

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

    private void btnVolverCEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverCEActionPerformed
        MenuEstudiante pantalla = new MenuEstudiante();
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnVolverCEActionPerformed

    private void btnLimpiarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarEActionPerformed
    txtRCC.setText("Ingrese el registro civil");
    txtRCC.setForeground(Color.gray);
    txtNombreC.setText("Ingrese el nombre");
    txtNombreC.setForeground(Color.gray);
    txtAnioC.setText("Ingrese el año");
    txtAnioC.setForeground(Color.gray);
    txtApellidosC.setText("Ingrese los apellidos");
    txtApellidosC.setForeground(Color.gray);
    cmbGradoC.setSelectedItem("Todos");

    }//GEN-LAST:event_btnLimpiarEActionPerformed

    private void cmbGradoCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbGradoCMousePressed
        if (txtRCC.getText().isEmpty()) {
            txtRCC.setText("Ingrese el registro civil");
            txtRCC.setForeground(Color.gray);
        }
        if (txtNombreC.getText().isEmpty()) {
            txtNombreC.setText("Ingrese el nombre");
            txtNombreC.setForeground(Color.gray);
        }
        if (txtAnioC.getText().isEmpty()) {
            txtAnioC.setText("Ingrese los apellidos");
            txtAnioC.setForeground(Color.gray);
        }
        if (txtApellidosC.getText().isEmpty()) {
            txtApellidosC.setText("Ingrese los apellidos");
            txtApellidosC.setForeground(Color.gray);
        }
    }//GEN-LAST:event_cmbGradoCMousePressed

    private void txtAnioCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAnioCMousePressed
        if (txtRCC.getText().isEmpty()) {
            txtRCC.setText("Ingrese el registro civil");
            txtRCC.setForeground(Color.gray);
        }
        if (txtNombreC.getText().isEmpty()) {
            txtNombreC.setText("Ingrese el nombre");
            txtNombreC.setForeground(Color.gray);
        }
        if (txtAnioC.getText().equals("Ingrese el año")) {
            txtAnioC.setText("");
            txtAnioC.setForeground(Color.black);
        }
        if (txtApellidosC.getText().isEmpty()) {
            txtApellidosC.setText("Ingrese los apellidos");
            txtApellidosC.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtAnioCMousePressed

    private void txtNombreCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreCActionPerformed

    private void txtNombreCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreCMousePressed
        if (txtRCC.getText().isEmpty()) {
            txtRCC.setText("Ingrese el registro civil");
            txtRCC.setForeground(Color.gray);
        }
        if (txtNombreC.getText().equals("Ingrese el nombre")) {
            txtNombreC.setText("");
            txtNombreC.setForeground(Color.black);
        }
        if (txtAnioC.getText().isEmpty()) {
            txtAnioC.setText("Ingrese el año");
            txtAnioC.setForeground(Color.gray);
        }
        if (txtApellidosC.getText().isEmpty()) {
            txtApellidosC.setText("Ingrese los apellidos");
            txtApellidosC.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtNombreCMousePressed

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
    if (txtAnioC.getText().isEmpty()) {
        txtAnioC.setText("Ingrese el año");
        txtAnioC.setForeground(Color.gray);
    }
    if (txtApellidosC.getText().isEmpty()) {
        txtApellidosC.setText("Ingrese los apellidos");
        txtApellidosC.setForeground(Color.gray);
    }
    }//GEN-LAST:event_txtRCCMousePressed

    private void btnConsultarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarEActionPerformed
        consultarEstudiante();
    }//GEN-LAST:event_btnConsultarEActionPerformed

    private void txtApellidosCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidosCMousePressed
            if (txtApellidosC.getText().equals("Ingrese los apellidos")) {
        txtApellidosC.setText("");
        txtApellidosC.setForeground(Color.black);
    }
    if (txtRCC.getText().isEmpty()) {
        txtRCC.setText("Ingrese el registro civil");
        txtRCC.setForeground(Color.gray);
    }
    if (txtNombreC.getText().isEmpty()) {
        txtNombreC.setText("Ingrese el nombre");
        txtNombreC.setForeground(Color.gray);
    }
    if (txtAnioC.getText().isEmpty()) {
        txtAnioC.setText("Ingrese el año");
        txtAnioC.setForeground(Color.gray);
    }
    }//GEN-LAST:event_txtApellidosCMousePressed

    private void txtAnioCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnioCActionPerformed
    if (txtAnioC.getText().equals("Ingrese el año")) {
        txtAnioC.setText("");
        txtAnioC.setForeground(Color.black);
    }
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
    }//GEN-LAST:event_txtAnioCActionPerformed

    private void txtApellidosCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosCActionPerformed
    if (txtApellidosC.getText().equals("Ingrese los apellidos")) {
        txtApellidosC.setText("");
        txtApellidosC.setForeground(Color.black);
    }
    if (txtRCC.getText().isEmpty()) {
        txtRCC.setText("Ingrese el registro civil");
        txtRCC.setForeground(Color.gray);
    }
    if (txtNombreC.getText().isEmpty()) {
        txtNombreC.setText("Ingrese el nombre");
        txtNombreC.setForeground(Color.gray);
    }
    if (txtAnioC.getText().isEmpty()) {
        txtAnioC.setText("Ingrese el año");
        txtAnioC.setForeground(Color.gray);
    }
    }//GEN-LAST:event_txtApellidosCActionPerformed


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
    private javax.swing.JComboBox<String> cmbGradoC;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel tituloConsultae;
    private javax.swing.JTextField txtAnioC;
    private javax.swing.JTextField txtApellidosC;
    private javax.swing.JTextField txtNombreC;
    private javax.swing.JTextField txtRCC;
    private javax.swing.JTextArea txtRespuesta;
    // End of variables declaration//GEN-END:variables
}
