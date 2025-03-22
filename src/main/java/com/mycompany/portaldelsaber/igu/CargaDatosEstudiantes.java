
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

    private String cedulaAcudiente;

    public CargaDatosEstudiantes(String cedulaAcudiente) {
    initComponents();
    this.cedulaAcudiente = cedulaAcudiente;
}

    private void configurarValidaciones() {
    // Restricción para cédula (solo números)
    txtCCAcu.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            char c = evt.getKeyChar();
            if (!Character.isDigit(c)) {
                evt.consume(); // Ignorar cualquier carácter que no sea un dígito
            }
            if (txtCCAcu.getText().length() >= 11) {
                evt.consume(); // No permite más de 11 dígitos
            }
        }
    });
    
    // Restricción para teléfono (solo números)
    txtPhoneAcu.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            char c = evt.getKeyChar();
            if (!Character.isDigit(c)) {
                evt.consume(); // Ignorar cualquier carácter que no sea un dígito
            }
            if (txtPhoneAcu.getText().length() >= 10) {
                evt.consume(); 
            }
        }
    });
    txtPhoneAcu.addFocusListener(new java.awt.event.FocusAdapter() {
    public void focusLost(java.awt.event.FocusEvent evt) {
        String phone = txtPhoneAcu.getText().trim();
        if (phone.length() > 0 && phone.length() < 10) {
            JOptionPane.showMessageDialog(null, 
                "El número de teléfono debe tener exactamente 10 dígitos.",
                "Formato incorrecto", 
                JOptionPane.WARNING_MESSAGE);
            txtPhoneAcu.requestFocus();
        }
    }
});
    
    // Restricción para nombre (solo letras y convertir a mayúscula)
    txtNombreAcu.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            char c = evt.getKeyChar();
            if (!(Character.isLetter(c) || c == ' ')) {
                evt.consume(); // Ignorar cualquier carácter que no sea una letra o espacio
            } else {
                // Convertir a mayúscula
                evt.setKeyChar(Character.toUpperCase(c));
            }
        }
    });
    
    // Restricción para apellido (solo letras y convertir a mayúscula)
    txtApellidoAcu.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            char c = evt.getKeyChar();
            if (!(Character.isLetter(c) || c == ' ')) {
                evt.consume(); // Ignorar cualquier carácter que no sea una letra o espacio
            } else {
                // Convertir a mayúscula
                evt.setKeyChar(Character.toUpperCase(c));
            }
        }
    });
    
    // Restricción para parentesco (solo letras y convertir a mayúscula)
    txtParentescoAcu.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            char c = evt.getKeyChar();
            if (!(Character.isLetter(c) || c == ' ')) {
                evt.consume(); // Ignorar cualquier carácter que no sea una letra o espacio
            } else {
                // Convertir a mayúscula
                evt.setKeyChar(Character.toUpperCase(c));
            }
        }
    });
    
    // Validar que solo ingresen letras y espacios en Nombre
    txtNombreEstudiante.addKeyListener(new java.awt.event.KeyAdapter() {
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
    txtApellidosEstudiante.addKeyListener(new java.awt.event.KeyAdapter() {
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
    
    //Validar que el año solo sean numeros, mínimo y máximo 4 digitos
    txtAnioE.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            char c = evt.getKeyChar();
            if (!Character.isDigit(c)) {
                evt.consume(); // Solo permite números
            }
            if (txtAnioE.getText().length() >= 4) {
                evt.consume(); // No permite más de 11 dígitos
            }
        }
    });
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
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
        txtApellidosEstudiante = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtAnioE = new javax.swing.JTextField();
        btnGuardarEstudiante = new javax.swing.JButton();
        btnLimpiarEstudiante = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtNombreAcu = new javax.swing.JTextField();
        txtCCAcu = new javax.swing.JTextField();
        txtApellidoAcu = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPhoneAcu = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtParentescoAcu = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 0, 102));
        jPanel1.setMinimumSize(new java.awt.Dimension(1012, 578));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(102, 0, 204));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Datos Acudiente");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 260, 40));

        jPanel2.setBackground(new java.awt.Color(51, 0, 102));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre Estudiante");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Registro civil");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Grado");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
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

        txtApellidosEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosEstudianteActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Apellidos Estudiante");

        txtAnioE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnioEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(txtNombreEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                        .addComponent(txtRC)
                        .addComponent(txtApellidosEstudiante)
                        .addComponent(txtAnioE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtAnioE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(cmbGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, 380, 400));

        btnGuardarEstudiante.setBackground(new java.awt.Color(255, 255, 0));
        btnGuardarEstudiante.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnGuardarEstudiante.setText("Guardar");
        btnGuardarEstudiante.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardarEstudiante.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEstudianteActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardarEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 180, 54));

        btnLimpiarEstudiante.setBackground(new java.awt.Color(255, 255, 0));
        btnLimpiarEstudiante.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnLimpiarEstudiante.setText("Limpiar");
        btnLimpiarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarEstudianteActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiarEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 570, 180, 54));

        jButton3.setBackground(new java.awt.Color(255, 255, 0));
        jButton3.setText("Volver");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 590, 100, 40));

        jPanel6.setBackground(new java.awt.Color(51, 0, 102));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nombre Acudiente");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Cedula Acudiente");

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Telefono");

        txtNombreAcu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreAcuActionPerformed(evt);
            }
        });

        txtCCAcu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCCAcuActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Apellidos Acudiente");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Parentesco");

        txtParentescoAcu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtParentescoAcuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPhoneAcu)
                    .addComponent(jLabel9)
                    .addComponent(txtNombreAcu)
                    .addComponent(txtCCAcu)
                    .addComponent(txtApellidoAcu, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                    .addComponent(jLabel15)
                    .addComponent(txtParentescoAcu)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(txtParentescoAcu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(txtCCAcu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(txtNombreAcu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(txtApellidoAcu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(txtPhoneAcu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 380, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Carga Datos");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 397, -1));

        jLabel12.setBackground(new java.awt.Color(102, 0, 204));
        jLabel12.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 0));
        jLabel12.setText("Datos Estudiante");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 260, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEstudianteActionPerformed
        // Obtener datos del acudiente
    String parentesco = txtParentescoAcu.getText();
    String cedulaAcudiente = txtCCAcu.getText();
    String nombreAcudiente = txtNombreAcu.getText();
    String apellidoAcudiente = txtApellidoAcu.getText();
    String telefonoAcudiente = txtPhoneAcu.getText();
    
    // Obtener datos del estudiante
    String registro_civil = txtRC.getText();
    String nombre = txtNombreEstudiante.getText();
    String apellidos = txtApellidosEstudiante.getText();
    String grado = cmbGrado.getSelectedItem().toString();
    String anio = txtAnioE.getText();
    
    // Validar que todos los campos estén completos
    if (registro_civil.isEmpty() || nombre.isEmpty() || apellidos.isEmpty() || 
        grado.equals("-") || anio.isEmpty() ||
        cedulaAcudiente.isEmpty() || nombreAcudiente.isEmpty() || 
        apellidoAcudiente.isEmpty() || telefonoAcudiente.isEmpty() || parentesco.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Importante", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Validar el formato del teléfono
    if (telefonoAcudiente.length() != 10) {
        JOptionPane.showMessageDialog(this, "El número de teléfono debe tener exactamente 10 dígitos.",
            "Formato incorrecto", JOptionPane.WARNING_MESSAGE);
        txtPhoneAcu.requestFocus();
        return;
    }
    
    Connection conn = null;
    try {
        // Establecer conexión con la base de datos
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/portalsaberdb", "root", "");
        
        // Iniciar transacción
        conn.setAutoCommit(false);
        
        // 1. Guardar o actualizar datos del acudiente
        String sqlAcudiente = "INSERT INTO acudientes (cedula, nombre, apellidos, telefono, parentesco, estudiante_registro_civil ) " +
                              "VALUES (?, ?, ?, ?, ?, ?) " +
                              "ON DUPLICATE KEY UPDATE nombre = ?, apellidos = ?, telefono = ?, parentesco = ?";
        
        PreparedStatement stmtAcudiente = conn.prepareStatement(sqlAcudiente);
        stmtAcudiente.setString(1, cedulaAcudiente);
        stmtAcudiente.setString(2, nombreAcudiente);
        stmtAcudiente.setString(3, apellidoAcudiente);
        stmtAcudiente.setString(4, telefonoAcudiente);
        stmtAcudiente.setString(5, parentesco);
        stmtAcudiente.setString(6, registro_civil);
        stmtAcudiente.setString(7, nombreAcudiente);
        stmtAcudiente.setString(8, apellidoAcudiente);
        stmtAcudiente.setString(9, telefonoAcudiente);
        stmtAcudiente.setString(10, parentesco);
        
        stmtAcudiente.executeUpdate();
        
        // 2. Guardar datos del estudiante con referencia al acudiente
        String sqlEstudiante = "INSERT INTO estudiantes (registro_civil, nombre, apellidos, grado, anio, cedula_acudiente) " +
                              "VALUES (?, ?, ?, ?, ?, ?)";
        
        PreparedStatement stmtEstudiante = conn.prepareStatement(sqlEstudiante);
        stmtEstudiante.setString(1, registro_civil);
        stmtEstudiante.setString(2, nombre);
        stmtEstudiante.setString(3, apellidos);
        stmtEstudiante.setString(4, grado);
        stmtEstudiante.setInt(5, Integer.parseInt(anio));
        stmtEstudiante.setString(6, cedulaAcudiente);
        
        int filasInsertadas = stmtEstudiante.executeUpdate();
        
        // Confirmar la transacción
        conn.commit();
        
        if (filasInsertadas > 0) {
            JOptionPane.showMessageDialog(this, "Los datos del estudiante y acudiente se han guardado exitosamente", 
                                         "Datos Guardados", JOptionPane.INFORMATION_MESSAGE);
            // Limpiar los campos después de guardar
            btnLimpiarEstudianteActionPerformed(evt);
        }
        
        stmtAcudiente.close();
        stmtEstudiante.close();
        
    } catch (SQLException e) {
        // Revertir la transacción en caso de error
        try {
            if (conn != null) {
                conn.rollback();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al revertir transacción: " + ex.getMessage(), 
                                         "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        JOptionPane.showMessageDialog(this, "Error al guardar datos: " + e.getMessage(), 
                                     "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        // Restaurar el modo de autocommit y cerrar la conexión
        try {
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cerrar la conexión: " + ex.getMessage(), 
                                         "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_btnGuardarEstudianteActionPerformed

    private void btnLimpiarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarEstudianteActionPerformed
     //estudiante
        txtNombreEstudiante.setText("");  
        txtApellidosEstudiante.setText("");  
        txtRC.setText("");  
        txtAnioE.setText("");
        cmbGrado.setSelectedIndex(0);
     //acudiente
        txtNombreAcu.setText("");
        txtApellidoAcu.setText("");
        txtCCAcu.setText("");
        txtPhoneAcu.setText("");
        txtParentescoAcu.setText("");
     
    }//GEN-LAST:event_btnLimpiarEstudianteActionPerformed

    private void txtRCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRCActionPerformed

    private void cmbGradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGradoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        MenuEstudiante acu = new MenuEstudiante();
        acu.setVisible(true);
        acu.setLocationRelativeTo(null);
        this.dispose(); // Cierra la ventana actual

    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtApellidosEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosEstudianteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosEstudianteActionPerformed

    private void txtAnioEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnioEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnioEActionPerformed

    private void txtNombreAcuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreAcuActionPerformed
        validarSoloLetras(txtNombreAcu);
    }//GEN-LAST:event_txtNombreAcuActionPerformed

    private void txtCCAcuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCCAcuActionPerformed
        //boton cedula primer acudiente
    }//GEN-LAST:event_txtCCAcuActionPerformed

    private void txtParentescoAcuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtParentescoAcuActionPerformed
        validarSoloLetras(txtParentescoAcu);
    }//GEN-LAST:event_txtParentescoAcuActionPerformed

    private void validarSoloLetras(javax.swing.JTextField campo) {
    String text = campo.getText();
    if (!text.matches("[a-zA-Z ]+")) {
        JOptionPane.showMessageDialog(this, "Ingrese solo letras", "Error", JOptionPane.ERROR_MESSAGE);
        campo.setText("");
    }
}
    
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
        java.util.logging.Logger.getLogger(CargaDatosAcudiente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(CargaDatosAcudiente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(CargaDatosAcudiente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(CargaDatosAcudiente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new CargaDatosEstudiantes().setVisible(true);
        }
    });
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarEstudiante;
    private javax.swing.JButton btnLimpiarEstudiante;
    private javax.swing.JComboBox<String> cmbGrado;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtAnioE;
    private javax.swing.JTextField txtApellidoAcu;
    private javax.swing.JTextField txtApellidosEstudiante;
    private javax.swing.JTextField txtCCAcu;
    private javax.swing.JTextField txtNombreAcu;
    private javax.swing.JTextField txtNombreEstudiante;
    private javax.swing.JTextField txtParentescoAcu;
    private javax.swing.JTextField txtPhoneAcu;
    private javax.swing.JTextField txtRC;
    // End of variables declaration//GEN-END:variables
}
