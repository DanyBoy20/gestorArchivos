
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import javax.swing.JOptionPane;
public class ProgramaDeArchivos extends javax.swing.JFrame {

    public ProgramaDeArchivos() {
        initComponents();
        this.setLocationRelativeTo(null); // CENTRAR EL JFRAME
        ocultar(); // METODO QUE ME OCULTA CONTROLES
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpbtn = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rdobtnCrear = new javax.swing.JRadioButton();
        rdobtnRenombrar = new javax.swing.JRadioButton();
        rdobtnEliminar = new javax.swing.JRadioButton();
        rdobtnEscribir = new javax.swing.JRadioButton();
        rdobtnLeer = new javax.swing.JRadioButton();
        rdobtnCopiar = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        txtNombreArchivo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtareaContenido = new javax.swing.JTextArea();
        lblEscribirContenido = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        grpbtn.add(rdobtnCrear);
        grpbtn.add(rdobtnRenombrar);
        grpbtn.add(rdobtnEliminar);
        grpbtn.add(rdobtnLeer);
        grpbtn.add(rdobtnEscribir);
        grpbtn.add(rdobtnCopiar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel1.setText("DHP");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setText("OPERACIONES CON ARCHIVOS. ");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Elija una opción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 14))); // NOI18N

        rdobtnCrear.setText("Crear archivo");
        rdobtnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdobtnCrearActionPerformed(evt);
            }
        });

        rdobtnRenombrar.setText("Renombrar Archivo");
        rdobtnRenombrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdobtnRenombrarActionPerformed(evt);
            }
        });

        rdobtnEliminar.setText("Eliminar archivo");
        rdobtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdobtnEliminarActionPerformed(evt);
            }
        });

        rdobtnEscribir.setText("Escribir archivo");
        rdobtnEscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdobtnEscribirActionPerformed(evt);
            }
        });

        rdobtnLeer.setText("Leer archivo");
        rdobtnLeer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdobtnLeerActionPerformed(evt);
            }
        });

        rdobtnCopiar.setText("Copiar archivo");
        rdobtnCopiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdobtnCopiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdobtnCrear)
                    .addComponent(rdobtnLeer))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdobtnRenombrar)
                    .addComponent(rdobtnEscribir))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdobtnCopiar)
                    .addComponent(rdobtnEliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdobtnCrear)
                    .addComponent(rdobtnRenombrar)
                    .addComponent(rdobtnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdobtnEscribir)
                    .addComponent(rdobtnLeer)
                    .addComponent(rdobtnCopiar))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        txtNombreArchivo.setEditable(false);
        txtNombreArchivo.setBorder(null);
        txtNombreArchivo.setFocusable(false);

        txtareaContenido.setColumns(20);
        txtareaContenido.setRows(5);
        txtareaContenido.setBorder(null);
        txtareaContenido.setCaretColor(new java.awt.Color(240, 240, 240));
        jScrollPane1.setViewportView(txtareaContenido);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalir.setText("Cerrar Aplicación");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(23, 23, 23))
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(73, 73, 73)
                                    .addComponent(jLabel2))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(81, 81, 81)
                                    .addComponent(btnSalir))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(44, 44, 44))
                                        .addComponent(lblEscribirContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNombreArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelar)))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEscribirContenido, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // BOTON QUE EJECUTA LA CREACION DEL ARCHIVO
    private void rdobtnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdobtnCrearActionPerformed
        // desactivo botones de radio que no se esten ocupando
        rdobtnRenombrar.setEnabled(false);
        rdobtnEliminar.setEnabled(false);
        rdobtnLeer.setEnabled(false);
        rdobtnEscribir.setEnabled(false);
        btnGuardar.setText("Guardar"); // activo el boton para guardar
        String nombreArchivo = JOptionPane.showInputDialog("Asigne el nombre al archivo:"); // pido asignar nombre a archivo
        // si el nombre es nulo, muestro mensaje de error
        if(nombreArchivo == null){ 
            JOptionPane.showMessageDialog(null, "Ha cancelado la asignacion de nombre", "Error", JOptionPane.ERROR_MESSAGE);
            // dejo los botones deseleccionados y los habilito
            grpbtn.clearSelection();
            rdobtnCrear.setEnabled(true);
            rdobtnRenombrar.setEnabled(true);
            rdobtnEliminar.setEnabled(true);
            rdobtnLeer.setEnabled(true);
            rdobtnEscribir.setEnabled(true);
        // si el usuario puso espacios en blanco (con trim elimino esos espacios) mando mensaje de error
        }else if (nombreArchivo.trim().length() == 0){
            JOptionPane.showMessageDialog(null, "Debe escribir un nombre para el archivo", "Cancelado", JOptionPane.WARNING_MESSAGE);
            // dejo los botones deseleccionados y los habilito
            grpbtn.clearSelection();
            rdobtnCrear.setEnabled(true);
            rdobtnRenombrar.setEnabled(true);
            rdobtnEliminar.setEnabled(true);
            rdobtnLeer.setEnabled(true);
            rdobtnEscribir.setEnabled(true);
        // si no se cumplen las condiciones previas y descritas arriba
        }else{
            // muestro los controles correspondientes y asigno valores
            jLabel3.setVisible(true);
            jLabel3.setText("Nombre del archivo:");
            txtNombreArchivo.setVisible(true);
            txtNombreArchivo.setText(nombreArchivo);
            btnCancelar.setVisible(true);
            btnGuardar.setVisible(true);
            jScrollPane1.setVisible(true);
            txtareaContenido.setVisible(true);
            txtareaContenido.setEnabled(true);
            txtareaContenido.requestFocus();
            jLabel3.setVisible(true);
            txtNombreArchivo.setVisible(true);
            lblEscribirContenido.setVisible(true);
            lblEscribirContenido.setText("Escriba el contenido de su archivo:");
        }      
    }//GEN-LAST:event_rdobtnCrearActionPerformed

    // SALIR DEL SISTEMA
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0); // salir del sistema
    }//GEN-LAST:event_btnSalirActionPerformed

    // GUARDAR EL ARCHIVO - AQUI CREO UN HILO PARA EL BOTON DE GUARDADO
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Thread guardar = new Thread(new HiloGuardarEscritura());
        guardar.start(); 
    }//GEN-LAST:event_btnGuardarActionPerformed

    // CANCELAR EL GUARDADO/EDITADO
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // el boton cancelar solo me resetea los controles, es decir, los deshabilita.
        txtNombreArchivo.setText("");
        txtareaContenido.setText("");
        jLabel3.setVisible(false);
        txtNombreArchivo.setVisible(false);
        grpbtn.clearSelection();
        rdobtnCrear.setEnabled(true);
        rdobtnRenombrar.setEnabled(true);
        rdobtnEliminar.setEnabled(true);
        rdobtnLeer.setEnabled(true);
        rdobtnEscribir.setEnabled(true);
        ocultar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    // LECTURA DE ARCHIVOS - otro hilo para la lectura de archivos (aqui solo se lee)
    private void rdobtnLeerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdobtnLeerActionPerformed
        Thread leer = new Thread(new HiloLectura());
        leer.start();
    }//GEN-LAST:event_rdobtnLeerActionPerformed

    // ECRITURA DE ARCHIVOS - otro hilo para la escritura de archivos (aqui se lee y se escribe en el control textbox)
    private void rdobtnEscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdobtnEscribirActionPerformed
        Thread leerParaEscribir = new Thread(new HiloLectura());
        leerParaEscribir.start();     
    }//GEN-LAST:event_rdobtnEscribirActionPerformed

    // ELIMINACION DE ARCHIVOS
    private void rdobtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdobtnEliminarActionPerformed
        // mensaje de advertencia de que se eliminara un archivo
        int confirmar = JOptionPane.showConfirmDialog(null, "Va a eliminar un archivo, ¿deseas continuar?");
        // si elige eliminar (la opcion de si)
        if (confirmar == JOptionPane.YES_OPTION) {
            // creo una instancia de la clase GestionArchivos
            GestionArchivos archivoSeleccionado = new GestionArchivos();
            File archivo = archivoSeleccionado.archivos(); // llamo al metodo que me devuelve un valor de tipo archivo
            if (archivo == null) { // si no me devolvio nada, es decir, se cancelo
                grpbtn.clearSelection(); // el grupo de botones de radio les quito la seleccion - todos estan disponibles
            } else { // y si no
                if (archivo.delete()) { // si el archivo se elimino satisfactoriamente
                    JOptionPane.showMessageDialog(null, "Archivo borrado"); // mensaje de eliminacion satisfactoria
                    grpbtn.clearSelection(); // el grupo de botones de radio les quito la seleccion - todos estan disponibles
                } else {// si no
                    JOptionPane.showMessageDialog(null, "No se pudo borrar el archivo"); // mensaje de error
                    grpbtn.clearSelection(); // el grupo de botones de radio les quito la seleccion - todos estan disponibles
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se elimino ningun archivo", "Cancelado", JOptionPane.PLAIN_MESSAGE);
            grpbtn.clearSelection();  // el grupo de botones de radio les quito la seleccion - todos estan disponibles
        }
    }//GEN-LAST:event_rdobtnEliminarActionPerformed

    // RENOMBRAR NOMBRE DE ARCHIVOS
    private void rdobtnRenombrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdobtnRenombrarActionPerformed
         // creo una instancia de la clase GestionArchivos
        GestionArchivos archivoSeleccionado = new GestionArchivos();
        File archivo = archivoSeleccionado.archivos();// llamo al metodo que me devuelve un valor de tipo archivo
        if (archivo == null) {// si no me devolvio nada, es decir, se cancelo
            grpbtn.clearSelection();// el grupo de botones de radio les quito la seleccion - todos estan disponibles
        } else { // si no
            String nuevoNom = JOptionPane.showInputDialog("Ingresa nuevo nombre"); // pido el nuevo nombre
            String nvo = archivo.getParent() + "\\" + nuevoNom + ".txt"; // le asigno la ruta y el archivo a variable
            File f2 = new File(nvo); // retomo el archivo con los valores anteriores
            boolean correcto = archivo.renameTo(f2); // lo renombro
            if (correcto == true) { // si se pudo renombrar
                JOptionPane.showMessageDialog(null, "El renombrado ha sido correcto"); // mensaje satisfactorio
                grpbtn.clearSelection();// el grupo de botones de radio les quito la seleccion - todos estan disponibles
            } else { // si no
                JOptionPane.showMessageDialog(null, "El renombrado no se ha podido realizar"); // mensaje error
                grpbtn.clearSelection();// el grupo de botones de radio les quito la seleccion - todos estan disponibles
            }
        }       
    }//GEN-LAST:event_rdobtnRenombrarActionPerformed

    // BOTON PARA EL CONTENIDO DE UN ARCHIVO DE TEXTO A OTRO
    private void rdobtnCopiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdobtnCopiarActionPerformed
    // creamos la cola y le asignamos una capacidad (tamaño)
    BlockingQueue<String> cola = new ArrayBlockingQueue<>(7);
    // creams los objetos de las clases Mensaje enviado y mensaje recibido y le asignamos el tamaño de la cola
    HiloCopiarArchivoOrigen copiarTexto = new HiloCopiarArchivoOrigen(cola);
    HiloEscribirArchivoDestino pegarTexto = new HiloEscribirArchivoDestino(cola);
    // creamos los hilos y de parametro las instancias
    new Thread(copiarTexto).start();
    new Thread(pegarTexto).start();
        
    }//GEN-LAST:event_rdobtnCopiarActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProgramaDeArchivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ProgramaDeArchivos().setVisible(true);
        });
    }
    
    // METODO PARA OCULTAR LOS CONTROLES 
    public void ocultar(){
        ProgramaDeArchivos.btnCancelar.setVisible(false);
        ProgramaDeArchivos.btnGuardar.setVisible(false);
        ProgramaDeArchivos.txtareaContenido.setVisible(false);
        ProgramaDeArchivos.jLabel3.setText("");
        ProgramaDeArchivos.jLabel3.setVisible(false);
        ProgramaDeArchivos.txtNombreArchivo.setVisible(false);
        ProgramaDeArchivos.lblEscribirContenido.setVisible(false);
        ProgramaDeArchivos.lblEscribirContenido.setText("");
        ProgramaDeArchivos.jScrollPane1.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnCancelar;
    public static javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    public static javax.swing.ButtonGroup grpbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JLabel lblEscribirContenido;
    public static javax.swing.JRadioButton rdobtnCopiar;
    public static javax.swing.JRadioButton rdobtnCrear;
    public static javax.swing.JRadioButton rdobtnEliminar;
    public static javax.swing.JRadioButton rdobtnEscribir;
    public static javax.swing.JRadioButton rdobtnLeer;
    public static javax.swing.JRadioButton rdobtnRenombrar;
    public static javax.swing.JTextField txtNombreArchivo;
    public static javax.swing.JTextArea txtareaContenido;
    // End of variables declaration//GEN-END:variables
}
