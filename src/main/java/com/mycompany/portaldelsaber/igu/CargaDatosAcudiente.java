package com.mycompany.portaldelsaber.igu;

import javax.swing.JOptionPane;
import com.mycompany.portaldelsaber.logica.Acudiente;
import com.mycompany.portaldelsaber.logica.Controladora;
import com.mycompany.portaldelsaber.persistencia.ConexionBD;
import static java.awt.SystemColor.control;

public class CargaDatosAcudiente extends javax.swing.JFrame {


private Controladora control;
private String registroCivilEstudiante;

public CargaDatosAcudiente() {
    this(null); // Constructor sin registro civil
}

    public CargaDatosAcudiente(String registroCivilEstudiante) {
    initComponents();
    control = new Controladora();
    
    this.registroCivilEstudiante = registroCivilEstudiante;
    
    // Deshabilitar el botón Siguiente hasta que se guarde un acudiente
    btnSiguienteA.setEnabled(false);
    
    // Aplicar restricciones a los campos
    aplicarRestriccionesCampos();
}

// Método para aplicar las restricciones a los campos
    private void aplicarRestriccionesCampos() {
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
    
    // También podemos agregar un Document Listener para verificar si todos los campos están llenos
    // y habilitar el botón Guardar solo cuando todos tengan contenido
    
    javax.swing.event.DocumentListener documentListener = new javax.swing.event.DocumentListener() {
        public void changedUpdate(javax.swing.event.DocumentEvent e) {
            verificarCamposCompletos();
        }
        public void removeUpdate(javax.swing.event.DocumentEvent e) {
            verificarCamposCompletos();
        }
        public void insertUpdate(javax.swing.event.DocumentEvent e) {
            verificarCamposCompletos();
        }
    };
    
    txtCCAcu.getDocument().addDocumentListener(documentListener);
    txtNombreAcu.getDocument().addDocumentListener(documentListener);
    txtApellidoAcu.getDocument().addDocumentListener(documentListener);
    txtPhoneAcu.getDocument().addDocumentListener(documentListener);
    txtNombreAcu.getDocument().addDocumentListener(documentListener);
}

// Método para verificar si todos los campos están completos
    private void verificarCamposCompletos() {
    boolean camposCompletos = !txtCCAcu.getText().trim().isEmpty() &&
                             !txtNombreAcu.getText().trim().isEmpty() &&
                             !txtApellidoAcu.getText().trim().isEmpty() &&
                             !txtPhoneAcu.getText().trim().isEmpty() &&
                             !txtNombreAcu.getText().trim().isEmpty();
    
    // Habilitar o deshabilitar el botón Guardar según si todos los campos están completos
    btnGuardarEstudiante.setEnabled(camposCompletos);
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNombreAcu2 = new javax.swing.JTextField();
        txtCCA2 = new javax.swing.JTextField();
        txtApellidoAcu2 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtPhoneAcu2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnGuardarEstudiante = new javax.swing.JButton();
        btnLimpiarEstudiante = new javax.swing.JButton();
        btnSiguienteA = new javax.swing.JButton();
        btnBackA = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtNombreAcu = new javax.swing.JTextField();
        txtCCAcu = new javax.swing.JTextField();
        txtApellidoAcu = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPhoneAcu = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtParentescoAcu = new javax.swing.JTextField();

        jLabel11.setText("Nombre");

        jLabel12.setText("Cedula Acudiente");

        jLabel13.setText("Telefono");

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

        jLabel14.setText("Apellidos");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPhoneAcu2)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNombreAcu2, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                                .addComponent(txtCCA2)
                                .addComponent(txtApellidoAcu2))
                            .addComponent(jLabel13))
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(txtCCA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(txtNombreAcu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(txtApellidoAcu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPhoneAcu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 0, 102));
        jPanel2.setMinimumSize(new java.awt.Dimension(1012, 578));
        jPanel2.setPreferredSize(new java.awt.Dimension(1012, 578));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Datos Acudiente");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 6, 397, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\Desktop\\Mis codigos\\logot3.jpg")); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, -1, -1));

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
        jPanel2.add(btnGuardarEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(604, 424, 180, 54));

        btnLimpiarEstudiante.setBackground(new java.awt.Color(255, 255, 0));
        btnLimpiarEstudiante.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnLimpiarEstudiante.setText("Limpiar");
        btnLimpiarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarEstudianteActionPerformed(evt);
            }
        });
        jPanel2.add(btnLimpiarEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 424, 180, 54));

        btnSiguienteA.setBackground(new java.awt.Color(255, 255, 0));
        btnSiguienteA.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnSiguienteA.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguienteA.setText("Siguiente");
        btnSiguienteA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteAActionPerformed(evt);
            }
        });
        jPanel2.add(btnSiguienteA, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 530, 100, 40));

        btnBackA.setBackground(new java.awt.Color(255, 255, 0));
        btnBackA.setText("Volver");
        btnBackA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackAActionPerformed(evt);
            }
        });
        jPanel2.add(btnBackA, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 530, 100, 40));

        jPanel6.setBackground(new java.awt.Color(51, 0, 102));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cedula Acudiente");

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

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Apellidos");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Parentesco");

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
                    .addComponent(jLabel3)
                    .addComponent(txtNombreAcu)
                    .addComponent(txtCCAcu)
                    .addComponent(txtApellidoAcu, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                    .addComponent(jLabel15)
                    .addComponent(txtParentescoAcu)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtParentescoAcu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtCCAcu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtNombreAcu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(txtApellidoAcu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(txtPhoneAcu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 440, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private void btnGuardarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEstudianteActionPerformed
        try {
        // Obtener datos del acudiente desde el formulario
        String parentesco = txtParentescoAcu.getText().trim();
        String cedulaAcu = txtCCAcu.getText().trim();
        String nombreAcu = txtNombreAcu.getText().trim();
        String apellidosAcu = txtApellidoAcu.getText().trim();
        String telefonoAcu = txtPhoneAcu.getText().trim();
        
        // Verificar campos
        if (cedulaAcu.isEmpty() || nombreAcu.isEmpty() || apellidosAcu.isEmpty() || 
            telefonoAcu.isEmpty() || parentesco.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                    "Por favor, complete todos los campos obligatorios.",
                    "Datos incompletos", 
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Verificar longitud del teléfono
        if (telefonoAcu.length() != 10) {
            JOptionPane.showMessageDialog(this, 
                    "El número de teléfono debe tener exactamente 10 dígitos.",
                    "Formato incorrecto", 
                    JOptionPane.WARNING_MESSAGE);
            txtPhoneAcu.requestFocus();
            return;
        }
        
        // Usar el registro civil si está disponible, o null si no lo está
        String registroCivil = (this.registroCivilEstudiante != null) ? this.registroCivilEstudiante : null;
        
        // Guardar el acudiente usando la conexión directa a la BD
        boolean guardadoExitoso = ConexionBD.insertarAcudiente(cedulaAcu, nombreAcu, apellidosAcu, telefonoAcu, parentesco, registroCivil);
        
        if (guardadoExitoso) {
            JOptionPane.showMessageDialog(this, 
                    "Acudiente guardado exitosamente! Ahora puede continuar al siguiente paso.",
                    "Información", 
                    JOptionPane.INFORMATION_MESSAGE);
            
            // Habilitar el botón Siguiente después de guardar exitosamente
            btnSiguienteA.setEnabled(true);
            
            // Opcionalmente, deshabilitar el botón Guardar para evitar duplicados
            btnGuardarEstudiante.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, 
                    "Error al guardar el acudiente. Intente nuevamente.",
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
                "Error al guardar el acudiente: " + e.getMessage(),
                "Error", 
                JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnGuardarEstudianteActionPerformed

    private void btnLimpiarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarEstudianteActionPerformed
        limpiarCampos();
    }
       
    private void limpiarCampos(){
        txtNombreAcu.setText("");
        txtApellidoAcu.setText("");
        txtCCAcu.setText("");
        txtPhoneAcu.setText("");
        txtParentescoAcu.setText("");
    }//GEN-LAST:event_btnLimpiarEstudianteActionPerformed

    private void btnSiguienteAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteAActionPerformed
        // Obtener la cédula del acudiente
String cedulaAcudiente = txtCCAcu.getText().trim();
String Nombre = txtNombreAcu.getText().trim();
String Apellido = txtApellidoAcu.getText().trim();
String Phone = txtPhoneAcu.getText().trim(); // Corregido
String Parentesco = txtParentescoAcu.getText().trim();

// Validar que ningún campo esté vacío
if (cedulaAcudiente.isEmpty() || Nombre.isEmpty() || Apellido.isEmpty() || 
    Phone.isEmpty() || Parentesco.isEmpty()) {
    JOptionPane.showMessageDialog(this, 
            "Por favor, ingrese toda la información del acudiente antes de continuar.",
            "Datos incompletos", 
            JOptionPane.WARNING_MESSAGE);
    return; // Importante: detener la ejecución si hay campos vacíos
}
        
        // Crear una instancia de CargaDatosEstudiantes pasándole la cédula del acudiente
        CargaDatosEstudiantes estu = new CargaDatosEstudiantes(); // Corregido el nombre de la variable
        estu.setVisible(true);
        estu.setLocationRelativeTo(null);
        this.dispose(); // Cierra la ventana actual
    }//GEN-LAST:event_btnSiguienteAActionPerformed

    private void btnBackAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackAActionPerformed
               // Volver a la pantalla anterior
        MenuEstudiante menu = new MenuEstudiante(); 
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
        this.dispose(); // Cierra la ventana actual
    }//GEN-LAST:event_btnBackAActionPerformed

    private void txtNombreAcu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreAcu2ActionPerformed
        String text = txtNombreAcu2.getText();
        if (!text.matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(this, "Ingrese solo letras", "Error", JOptionPane.ERROR_MESSAGE);
            txtNombreAcu2.setText("");
        }
    }//GEN-LAST:event_txtNombreAcu2ActionPerformed

    private void txtCCA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCCA2ActionPerformed
        //boton cedula primer acudiente
    }//GEN-LAST:event_txtCCA2ActionPerformed

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
        /**
 * @param args the command line arguments
 */
    
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
            new CargaDatosAcudiente().setVisible(true);
        }
    });
}

        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackA;
    private javax.swing.JButton btnGuardarEstudiante;
    private javax.swing.JButton btnLimpiarEstudiante;
    private javax.swing.JButton btnSiguienteA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField txtApellidoAcu;
    private javax.swing.JTextField txtApellidoAcu2;
    private javax.swing.JTextField txtCCA2;
    private javax.swing.JTextField txtCCAcu;
    private javax.swing.JTextField txtNombreAcu;
    private javax.swing.JTextField txtNombreAcu2;
    private javax.swing.JTextField txtParentescoAcu;
    private javax.swing.JTextField txtPhoneAcu;
    private javax.swing.JTextField txtPhoneAcu2;
    // End of variables declaration//GEN-END:variables
}
