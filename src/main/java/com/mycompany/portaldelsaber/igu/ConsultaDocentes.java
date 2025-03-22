package com.mycompany.portaldelsaber.igu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import com.mycompany.portaldelsaber.persistencia.ConexionBD;

public class ConsultaDocentes extends javax.swing.JFrame {
    
public ConsultaDocentes() {
    initComponents();
    configurarValidaciones();
    btnConsultarD.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            consultarDocente();
        }
    });
}

private void configurarValidaciones() {
    // Validar que solo ingresen letras y espacios en Nombre
    txtNombreC.addKeyListener(new java.awt.event.KeyAdapter() {
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
    txtApellidosC.addKeyListener(new java.awt.event.KeyAdapter() {
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
    txtCCD.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            char c = evt.getKeyChar();
            if (!Character.isDigit(c)) {
                evt.consume(); // Solo permite números
            }
            if (txtCCD.getText().length() >= 11) {
                evt.consume(); // No permite más de 11 dígitos
            }
        }
    });
    
    //Validar que el año solo sean numeros, mínimo y máximo 4 digitos
    txtAnioC.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            char c = evt.getKeyChar();
            if (!Character.isDigit(c)) {
                evt.consume(); // Solo permite números
            }
            if (txtAnioC.getText().length() >= 4) {
                evt.consume(); // No permite más de 11 dígitos
            }
        }
    });
}

private void consultarDocente() {
    String cedula = txtCCD.getText().trim();
    String nombre = txtNombreC.getText().trim();
    String apellidos = txtApellidosC.getText().trim();
    String estado = cmbEstadoCD.getSelectedItem().toString();
    String anio = txtAnioC.getText().trim();
    
    // Verificar si hay al menos un criterio de búsqueda válido
    if ((cedula.isEmpty() || cedula.equals("Ingrese la cédula") || cedula.equals("Ingrese la cedula")) &&
        (nombre.isEmpty() || nombre.equals("Ingrese el nombre")) &&
        (apellidos.isEmpty() || apellidos.equals("Ingrese los apellidos")) &&
        (estado.equals("-") || estado.equals(" ")) &&
        (anio.isEmpty() || anio.equals("Ingrese el año"))) {
        JOptionPane.showMessageDialog(this, "Ingrese al menos un criterio de búsqueda.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try (Connection con = ConexionBD.conectar()) {
        // Construir consulta SQL dinámica
        StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM docentes WHERE 1=1");
        
        // Preparar lista de parámetros
        java.util.List<Object> params = new java.util.ArrayList<>();
        
        // Añadir condiciones basadas en los campos proporcionados
        if (!cedula.isEmpty() && !cedula.equals("Ingrese la cédula") && !cedula.equals("Ingrese la cedula")) {
            sqlBuilder.append(" AND cedula = ?");
            params.add(cedula);
        }
        
        if (!nombre.isEmpty() && !nombre.equals("Ingrese el nombre")) {
            sqlBuilder.append(" AND nombre LIKE ?");
            params.add("%" + nombre + "%");
        }
        
        if (!apellidos.isEmpty() && !apellidos.equals("Ingrese los apellidos")) {
            sqlBuilder.append(" AND apellidos LIKE ?");
            params.add("%" + apellidos + "%");
        }
        
        if (!estado.equals("-") && !estado.equals(" ")) {
            sqlBuilder.append(" AND estado = ?");
            params.add(estado);
        }
        
        if (!anio.isEmpty() && !anio.equals("Ingrese el año")) {
            sqlBuilder.append(" AND anio = ?");
            params.add(anio);
        }
        
        // Para depuración
        System.out.println("Consulta SQL: " + sqlBuilder.toString());
        System.out.println("Parámetros: " + params);
        
        // Preparar statement con consulta dinámica
        PreparedStatement ps = con.prepareStatement(sqlBuilder.toString());
        
        // Establecer parámetros
        for (int i = 0; i < params.size(); i++) {
            ps.setObject(i + 1, params.get(i));
        }
        
        // Ejecutar consulta
        ResultSet rs = ps.executeQuery();
        
        int resultCount = 0;
        
        // Contar resultados antes de procesarlos
        while (rs.next()) {
            resultCount++;
        }
        
        // Resetear el resultset para volver al inicio
        rs = ps.executeQuery();
        
        if (resultCount == 0) {
            // Sin resultados
            JOptionPane.showMessageDialog(this, "No se encontraron docentes con los criterios proporcionados.", 
                "Información", JOptionPane.INFORMATION_MESSAGE);
            txtRespuesta.setText("");
            return;
        } else if (resultCount == 1) {
            // Si hay EXACTAMENTE UN RESULTADO, mostrar directamente
            if (rs.next()) {
                String foundCedula = rs.getString("cedula");
                String foundEstado = rs.getString("estado");
                String foundAnio = rs.getString("anio");
                String foundNombre = rs.getString("nombre");
                String foundApellidos = rs.getString("apellidos");
                
                // Actualizar los campos del formulario
                txtCCD.setText(foundCedula);
                txtNombreC.setText(foundNombre);
                txtApellidosC.setText(foundApellidos);
                
                // Establecer el estado en el combo box
                for (int i = 0; i < cmbEstadoCD.getItemCount(); i++) {
                    if (cmbEstadoCD.getItemAt(i).equals(foundEstado)) {
                        cmbEstadoCD.setSelectedIndex(i);
                        break;
                    }
                }
                
                txtAnioC.setText(foundAnio);
                
                // Generar y mostrar la ruta del archivo
                String rutaArchivo = "C:\\Users\\Asus\\Desktop\\PruebasPS\\" + foundAnio + 
                                     "\\docente\\" + foundCedula + ".pdf";
                txtRespuesta.setText(rutaArchivo);
                
                // Hacer que el área de texto se vea como un URL cliqueable
                txtRespuesta.setForeground(Color.BLUE);
                txtRespuesta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                
                // Agregar listener para manejar clics en el URL
                for (java.awt.event.MouseListener ml : txtRespuesta.getMouseListeners()) {
                    if (ml instanceof URLClickListener || ml instanceof MultipleURLClickListener) {
                        txtRespuesta.removeMouseListener(ml);
                    }
                }
                txtRespuesta.addMouseListener(new URLClickListener());
            }
        } else {
            // MÚLTIPLES RESULTADOS: mostrar tabla para todos los casos
            Object[][] data = new Object[resultCount][5];
            String[] columnNames = {"Cédula", "Nombre", "Apellidos", "Estado", "Año"};
            
            int index = 0;
            while (rs.next()) {
                data[index][0] = rs.getString("cedula");
                data[index][1] = rs.getString("nombre");
                data[index][2] = rs.getString("apellidos");
                data[index][3] = rs.getString("estado");
                data[index][4] = rs.getString("anio");
                index++;
            }
            
            // Crear modelo de tabla
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, columnNames) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // Hacer que las celdas no sean editables
                }
            };
            
            // Crear tabla y scrollpane
            javax.swing.JTable table = new javax.swing.JTable(model);
            javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(table);
            
            // Mostrar diálogo con tabla
            Object[] options = {"Seleccionar", "Cancelar"};
            int result = JOptionPane.showOptionDialog(
                this,
                scrollPane,
                "Seleccione un docente (" + resultCount + " resultados)",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
            );
            
            // Si el usuario seleccionó una entrada
            if (result == JOptionPane.YES_OPTION && table.getSelectedRow() != -1) {
                int selectedRow = table.getSelectedRow();
                
                // Establecer los campos del formulario
                txtCCD.setText((String) data[selectedRow][0]);
                txtNombreC.setText((String) data[selectedRow][1]);
                txtApellidosC.setText((String) data[selectedRow][2]);
                
                // Establecer el estado en el combo box
                String selectedEstado = (String) data[selectedRow][3];
                for (int i = 0; i < cmbEstadoCD.getItemCount(); i++) {
                    if (cmbEstadoCD.getItemAt(i).equals(selectedEstado)) {
                        cmbEstadoCD.setSelectedIndex(i);
                        break;
                    }
                }
                
                txtAnioC.setText((String) data[selectedRow][4]);
                
                // Generar y mostrar la ruta del archivo
                String cc = (String) data[selectedRow][0];
                String rutaArchivo = "C:\\Users\\Asus\\Desktop\\PruebasPS\\" + data[selectedRow][4] + 
                                     "\\docente\\" + cc + ".pdf";
                txtRespuesta.setText(rutaArchivo);
                
                // Hacer que el área de texto se vea como un URL cliqueable
                txtRespuesta.setForeground(Color.BLUE);
                txtRespuesta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                
                // Agregar listener para manejar clics en el URL
                for (java.awt.event.MouseListener ml : txtRespuesta.getMouseListeners()) {
                    if (ml instanceof URLClickListener || ml instanceof MultipleURLClickListener) {
                        txtRespuesta.removeMouseListener(ml);
                    }
                }
                txtRespuesta.addMouseListener(new URLClickListener());
            }
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al consultar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

// Listener para un solo URL
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

// Listener para manejar múltiples URLs en el texto
private class MultipleURLClickListener extends java.awt.event.MouseAdapter {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() > 0) {
            try {
                // Obtenemos el texto completo
                String text = txtRespuesta.getText();
                
                // Encontramos la línea donde se hizo clic
                int caretPosition = txtRespuesta.viewToModel2D(evt.getPoint());
                int lineStart = 0;
                int lineEnd = text.length();
                
                // Buscamos el inicio de la línea
                for (int i = caretPosition; i >= 0; i--) {
                    if (text.charAt(i) == '\n') {
                        lineStart = i + 1;
                        break;
                    }
                }
                
                // Buscamos el final de la línea
                for (int i = caretPosition; i < text.length(); i++) {
                    if (text.charAt(i) == '\n') {
                        lineEnd = i;
                        break;
                    }
                }
                
                // Obtenemos la línea donde se hizo clic
                String line = text.substring(lineStart, lineEnd).trim();
                
                // Extraemos la ruta del archivo
                if (line.contains("C:\\")) {
                    int index = line.indexOf("C:\\");
                    String filePath = line.substring(index).trim();
                    
                    // Abrimos el archivo
                    java.awt.Desktop.getDesktop().open(new java.io.File(filePath));
                }
            } catch (Exception ex) {
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
        cmbEstadoCD = new javax.swing.JComboBox<>();
        JLRC = new javax.swing.JLabel();
        txtCCD = new javax.swing.JTextField();
        txtNombreC = new javax.swing.JTextField();
        JLNombreC = new javax.swing.JLabel();
        txtAnioC = new javax.swing.JTextField();
        JLApellidosC = new javax.swing.JLabel();
        JLGradoC = new javax.swing.JLabel();
        JLAnioC = new javax.swing.JLabel();
        btnLimpiarD = new javax.swing.JButton();
        btnVolverCD = new javax.swing.JButton();
        btnConsultarD = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRespuesta = new javax.swing.JTextArea();
        txtApellidosC = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        bgCE.setBackground(new java.awt.Color(51, 0, 102));
        bgCE.setMinimumSize(new java.awt.Dimension(1012, 578));
        bgCE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloConsultae.setBackground(new java.awt.Color(0, 0, 0));
        tituloConsultae.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        tituloConsultae.setForeground(new java.awt.Color(255, 255, 255));
        tituloConsultae.setText("Consulta Docente");
        bgCE.add(tituloConsultae, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        cmbEstadoCD.setForeground(new java.awt.Color(0, 0, 0));
        cmbEstadoCD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Activo", "Inactivo" }));
        bgCE.add(cmbEstadoCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, 80, -1));

        JLRC.setBackground(new java.awt.Color(255, 255, 255));
        JLRC.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        JLRC.setForeground(new java.awt.Color(255, 255, 255));
        JLRC.setText("Cedula Ciudadania");
        bgCE.add(JLRC, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 150, -1));

        txtCCD.setBackground(new java.awt.Color(255, 255, 255));
        txtCCD.setForeground(new java.awt.Color(204, 204, 204));
        txtCCD.setText("Ingrese la cedula");
        txtCCD.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtCCD.setCaretColor(new java.awt.Color(204, 204, 204));
        txtCCD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCCDMousePressed(evt);
            }
        });
        txtCCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCCDActionPerformed(evt);
            }
        });
        bgCE.add(txtCCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 190, -1));

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
        JLGradoC.setText("Estado");
        bgCE.add(JLGradoC, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 100, 60, -1));

        JLAnioC.setBackground(new java.awt.Color(255, 255, 255));
        JLAnioC.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        JLAnioC.setForeground(new java.awt.Color(255, 255, 255));
        JLAnioC.setText("Año");
        bgCE.add(JLAnioC, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 100, -1, -1));

        btnLimpiarD.setBackground(new java.awt.Color(255, 255, 0));
        btnLimpiarD.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnLimpiarD.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiarD.setText("Limpiar");
        btnLimpiarD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarDActionPerformed(evt);
            }
        });
        bgCE.add(btnLimpiarD, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 140, 40));

        btnVolverCD.setBackground(new java.awt.Color(255, 255, 0));
        btnVolverCD.setText("Volver");
        btnVolverCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverCDActionPerformed(evt);
            }
        });
        bgCE.add(btnVolverCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 270, 100, 30));

        btnConsultarD.setBackground(new java.awt.Color(255, 255, 0));
        btnConsultarD.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnConsultarD.setForeground(new java.awt.Color(0, 0, 0));
        btnConsultarD.setText("Consultar");
        btnConsultarD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarDActionPerformed(evt);
            }
        });
        bgCE.add(btnConsultarD, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 140, 40));

        txtRespuesta.setBackground(new java.awt.Color(204, 204, 204));
        txtRespuesta.setColumns(20);
        txtRespuesta.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        txtRespuesta.setForeground(new java.awt.Color(153, 153, 153));
        txtRespuesta.setRows(5);
        txtRespuesta.setText("                                                 Ingrese los datos para poder filtrar");
        txtRespuesta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
            .addComponent(bgCE, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgCE, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCCDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCCDMousePressed
        if (txtCCD.getText().equals("Ingrese la cedula")) {
            txtCCD.setText("");
            txtCCD.setForeground(Color.black);
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
    }//GEN-LAST:event_txtCCDMousePressed

    private void txtCCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCCDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCCDActionPerformed

    private void txtNombreCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreCMousePressed
        if (txtCCD.getText().isEmpty()) {
            txtCCD.setText("Ingrese la cedula");
            txtCCD.setForeground(Color.gray);
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

    private void txtNombreCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreCActionPerformed

    private void txtAnioCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAnioCMousePressed
        if (txtCCD.getText().isEmpty()) {
            txtCCD.setText("Ingrese la cedula");
            txtCCD.setForeground(Color.gray);
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

    private void txtAnioCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnioCActionPerformed
        if (txtAnioC.getText().equals("Ingrese el año")) {
            txtAnioC.setText("");
            txtAnioC.setForeground(Color.black);
        }
        if (txtCCD.getText().isEmpty()) {
            txtCCD.setText("Ingrese la cedula");
            txtCCD.setForeground(Color.gray);
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

    private void btnLimpiarDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarDActionPerformed
        txtCCD.setText("Ingrese la cedula");
        txtCCD.setForeground(Color.gray);
        txtNombreC.setText("Ingrese el nombre");
        txtNombreC.setForeground(Color.gray);
        txtAnioC.setText("Ingrese el año");
        txtAnioC.setForeground(Color.gray);
        txtApellidosC.setText("Ingrese los apellidos");
        txtApellidosC.setForeground(Color.gray);
        cmbEstadoCD.setSelectedIndex(0);
        txtRespuesta.setText("                          agrega información en los campos para poder filtrar");
        txtRespuesta.setForeground(Color.gray);
    }//GEN-LAST:event_btnLimpiarDActionPerformed

    private void btnVolverCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverCDActionPerformed
        MenuDocente pantalla = new MenuDocente();
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnVolverCDActionPerformed

    private void btnConsultarDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarDActionPerformed
        consultarDocente();
    }//GEN-LAST:event_btnConsultarDActionPerformed

    private void txtApellidosCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidosCMousePressed
        if (txtApellidosC.getText().equals("Ingrese los apellidos")) {
            txtApellidosC.setText("");
            txtApellidosC.setForeground(Color.black);
        }
        if (txtCCD.getText().isEmpty()) {
            txtCCD.setText("Ingrese la cedula");
            txtCCD.setForeground(Color.gray);
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

    private void txtApellidosCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosCActionPerformed
        if (txtApellidosC.getText().equals("Ingrese los apellidos")) {
            txtApellidosC.setText("");
            txtApellidosC.setForeground(Color.black);
        }
        if (txtCCD.getText().isEmpty()) {
            txtCCD.setText("Ingrese la cedula");
            txtCCD.setForeground(Color.gray);
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
    private javax.swing.JButton btnConsultarD;
    private javax.swing.JButton btnLimpiarD;
    private javax.swing.JButton btnVolverCD;
    private javax.swing.JComboBox<String> cmbEstadoCD;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel tituloConsultae;
    private javax.swing.JTextField txtAnioC;
    private javax.swing.JTextField txtApellidosC;
    private javax.swing.JTextField txtCCD;
    private javax.swing.JTextField txtNombreC;
    private javax.swing.JTextArea txtRespuesta;
    // End of variables declaration//GEN-END:variables
}
