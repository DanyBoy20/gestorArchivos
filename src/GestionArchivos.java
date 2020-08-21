
import java.io.File;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.DIRECTORIES_ONLY;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

// EN ESTA CLASE ESTAN LOS METODOS PARA LA GESTION DE ARCHIVOS:
// BUSCAR ARCHIVOS, BUSCAR CARPETAS (DONDE SE GUARDARAN LOS ARCHIVOS CREADOS)
public class GestionArchivos {
    
    // atributos
    private String ubicacion = null; // para la ruta/ubicacion (archivo y carpetas)se usara: al leer y escribir
    private File archivo = null; // para elegir el archivo (se usara: para renombrar, eliminar)
    private JFileChooser jfc = new JFileChooser(); // para crear ventana de seleccion de archivos/carpetas
    
    // METODO PARA LA UBICACION (SOLO MUESTRA ARCHIVOS TXT)
    public String rutaArchivo(){        
        jfc.setDialogTitle("Guardar archivo en ..."); // titulo a la ventana de buscar archivos
        jfc.setAcceptAllFileFilterUsed(false); // cambiamos la propiedad (filtro) de la ventana de busqueda de archivos
        FileNameExtensionFilter filtrar = new FileNameExtensionFilter("Archivos .txt", "txt"); // filtramos los tipos de archivos
        jfc.addChoosableFileFilter(filtrar);
        int valorElegido = jfc.showOpenDialog(jfc); // iniciamos la ventana
        if (valorElegido == JFileChooser.CANCEL_OPTION){ // si se eligio el boton cancelar
            // mandamos mensaje de error
            JOptionPane.showMessageDialog(null, "Ha cancelado la carga del archivo", "Cancelado", JOptionPane.WARNING_MESSAGE);
        }else{ // si no
            ubicacion = jfc.getSelectedFile().getAbsolutePath();// asignamos el valor a la variable
        }    
        return ubicacion; // retornamos esa variable
    }
    
    // METODO QUE DEVUELVE LA UBICACION (SOLO MUESTRA LAS CARPETAS)
    public String carpetaArchivo(){        
        jfc.setDialogTitle("Guardar archivo en ..."); // titulo a la ventana de buscar archivos
        jfc.setAcceptAllFileFilterUsed(false); // cambiamos la propiedad (filtro) de la ventana de busqueda de archivos
        jfc.setFileSelectionMode(DIRECTORIES_ONLY); // solo se mostraran los directorios  
        int valorElegido = jfc.showDialog(jfc, "Guardar"); // iniciamos la ventana ( y ponemos nombre a boton)
        if (valorElegido == JFileChooser.CANCEL_OPTION){// si se eligio el boton cancelar
            // mandamos mensaje de error
            JOptionPane.showMessageDialog(null, "Ha cancelado la carga del archivo", "Cancelado", JOptionPane.WARNING_MESSAGE);
        }else{ // si no
            ubicacion = jfc.getSelectedFile().getAbsolutePath();// asignamos el valor a la variable
        }    
        return ubicacion; // y la retornamos
    }
    
    // METODO QUE DEVUELVE EL ARCHIVO SELECCIONADO (SOLO TXT)
    public File archivos(){
        jfc.setDialogTitle("Seleccione un archivo de texto .TXT");// titulo a la ventana de buscar archivos
        jfc.setAcceptAllFileFilterUsed(false);// cambiamos la propiedad (filtro) de la ventana de busqueda de archivos
        FileNameExtensionFilter filtrar = new FileNameExtensionFilter("Archivos .txt", "txt"); // filtramos los tipos de archivos
        jfc.addChoosableFileFilter(filtrar);           
        int valorElegido = jfc.showOpenDialog(jfc); // iniciamos la ventana
        if (valorElegido == JFileChooser.CANCEL_OPTION) { // si se eligio el boton cancelar
            // mandamos mensaje de error
            JOptionPane.showMessageDialog(null, "Se cancelo la elección del archivo");
        } else { // si no
            archivo = jfc.getSelectedFile();// asignamos el valor a la variable
        }
        return archivo; // y la devolvemos 
    }
    
    // metodo para ocultar los controles
    public final void ocultar() {
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
    
    // metodo para mostrar los controles
    public final void mostrarControles(){
            ProgramaDeArchivos.jLabel3.setVisible(true);
            ProgramaDeArchivos.jLabel3.setText("Nombre del archivo:");
            ProgramaDeArchivos.txtNombreArchivo.setVisible(true);
            ProgramaDeArchivos.btnCancelar.setVisible(true);
            ProgramaDeArchivos.btnGuardar.setVisible(true);
            ProgramaDeArchivos.jScrollPane1.setVisible(true);
            ProgramaDeArchivos.txtareaContenido.setVisible(true);
            ProgramaDeArchivos.txtareaContenido.requestFocus();
            ProgramaDeArchivos.jLabel3.setVisible(true);
            ProgramaDeArchivos.txtNombreArchivo.setVisible(true);
            ProgramaDeArchivos.lblEscribirContenido.setVisible(true);
            ProgramaDeArchivos.lblEscribirContenido.setText("Escriba el contenido de su archivo:");
    }

    // metodo para mostrar los controles cuando se leera el archivo
    public final void mostrarLeerArchivo() {
        ProgramaDeArchivos.txtNombreArchivo.setVisible(true);
        ProgramaDeArchivos.jScrollPane1.setVisible(true);
        ProgramaDeArchivos.txtareaContenido.setVisible(true);
        ProgramaDeArchivos.jLabel3.setVisible(true);
        ProgramaDeArchivos.lblEscribirContenido.setVisible(true);
        ProgramaDeArchivos.jLabel3.setText("Ruta del archivo: ");
    }

    // metodo para deshabilitar los botones de radio que no esten en uso
    public final void botonesRadio() {
        if (ProgramaDeArchivos.rdobtnEscribir.isSelected()) {
            ProgramaDeArchivos.rdobtnCrear.setEnabled(false);
            ProgramaDeArchivos.rdobtnRenombrar.setEnabled(false);
            ProgramaDeArchivos.rdobtnEliminar.setEnabled(false);
            ProgramaDeArchivos.rdobtnLeer.setEnabled(false);
            ProgramaDeArchivos.rdobtnCopiar.setEnabled(false);
        } else if (ProgramaDeArchivos.rdobtnCrear.isSelected()) {
            ProgramaDeArchivos.rdobtnEscribir.setEnabled(false);
            ProgramaDeArchivos.rdobtnRenombrar.setEnabled(false);
            ProgramaDeArchivos.rdobtnEliminar.setEnabled(false);
            ProgramaDeArchivos.rdobtnLeer.setEnabled(false);
            ProgramaDeArchivos.rdobtnCopiar.setEnabled(false);
        } else if (ProgramaDeArchivos.rdobtnRenombrar.isSelected()) {
            ProgramaDeArchivos.rdobtnEscribir.setEnabled(false);
            ProgramaDeArchivos.rdobtnCrear.setEnabled(false);
            ProgramaDeArchivos.rdobtnEliminar.setEnabled(false);
            ProgramaDeArchivos.rdobtnLeer.setEnabled(false);
            ProgramaDeArchivos.rdobtnCopiar.setEnabled(false);
        } else if (ProgramaDeArchivos.rdobtnEliminar.isSelected()) {
            ProgramaDeArchivos.rdobtnEscribir.setEnabled(false);
            ProgramaDeArchivos.rdobtnCrear.setEnabled(false);
            ProgramaDeArchivos.rdobtnRenombrar.setEnabled(false);
            ProgramaDeArchivos.rdobtnLeer.setEnabled(false);
            ProgramaDeArchivos.rdobtnCopiar.setEnabled(false);
        } else if (ProgramaDeArchivos.rdobtnLeer.isSelected()) {
            ProgramaDeArchivos.rdobtnEscribir.setEnabled(false);
            ProgramaDeArchivos.rdobtnCrear.setEnabled(false);
            ProgramaDeArchivos.rdobtnRenombrar.setEnabled(false);
            ProgramaDeArchivos.rdobtnEliminar.setEnabled(false);
            ProgramaDeArchivos.rdobtnCopiar.setEnabled(false);
        } else {
            ProgramaDeArchivos.rdobtnEscribir.setEnabled(false);
            ProgramaDeArchivos.rdobtnCrear.setEnabled(false);
            ProgramaDeArchivos.rdobtnRenombrar.setEnabled(false);
            ProgramaDeArchivos.rdobtnEliminar.setEnabled(false);
            ProgramaDeArchivos.rdobtnLeer.setEnabled(false);  
        }   
    }

    // metodo para activar los botones de radio
    public final void activarBotonesRadio() {
        ProgramaDeArchivos.rdobtnCrear.setEnabled(true);
        ProgramaDeArchivos.rdobtnRenombrar.setEnabled(true);
        ProgramaDeArchivos.rdobtnEliminar.setEnabled(true);
        ProgramaDeArchivos.rdobtnLeer.setEnabled(true);
        ProgramaDeArchivos.rdobtnEscribir.setEnabled(true);
        ProgramaDeArchivos.rdobtnCopiar.setEnabled(true); 
    }
    
    // metodo para activar los botones de radio
    public final void desactivarBotonesRadio(){
        ProgramaDeArchivos.rdobtnEscribir.setEnabled(false);
        ProgramaDeArchivos.rdobtnCrear.setEnabled(false);
        ProgramaDeArchivos.rdobtnRenombrar.setEnabled(false);
        ProgramaDeArchivos.rdobtnEliminar.setEnabled(false);
        ProgramaDeArchivos.rdobtnLeer.setEnabled(false);
        ProgramaDeArchivos.rdobtnCopiar.setEnabled(false);
    }
    
}
