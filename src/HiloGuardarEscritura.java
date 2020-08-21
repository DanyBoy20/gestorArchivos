
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

// clase para los hilos de guardado
public class HiloGuardarEscritura extends GestionArchivos implements Runnable {

    @Override
    public void run() {
        GuardarEscritura();
    }
    
    // METODO QUE SE EJECUTARA CUANDO SE CREE E INICIA EL HILO
    public void GuardarEscritura(){
    if ("Ok".equals(ProgramaDeArchivos.btnGuardar.getText())) { // si el boton que se presiono tiene la etiqueta de "ok"
            ProgramaDeArchivos.grpbtn.clearSelection(); // reseteo los botones de radio
            activarBotonesRadio(); // y los activo
            ocultar(); // oculoto los controles del formulario
        // si el boton que se presiono tiene la etiqueta de "Guardar archivo"
        } else if ("Guardar archivo".equals(ProgramaDeArchivos.btnGuardar.getText())) {
            String ubicacion = ProgramaDeArchivos.txtNombreArchivo.getText(); // instancia de la clase para acceso a sus metodos
            try {
                File nuevoArchivo = new File(ubicacion); // asigno el valor devuelto
                FileWriter escribir = new FileWriter(nuevoArchivo); // el archivo que recogio el valor se lo asigno al stream de escritura
                // en un try catch, escribo el contenido
                try (BufferedWriter contenido = new BufferedWriter(escribir)) { 
                    contenido.write(ProgramaDeArchivos.txtareaContenido.getText());
                }
                // reseteo valores despues de la escritura
                ProgramaDeArchivos.txtNombreArchivo.setText("");
                ProgramaDeArchivos.txtareaContenido.setText("");
                ProgramaDeArchivos.grpbtn.clearSelection();
                activarBotonesRadio();// reseteo los botones de radio
                ocultar();// oculoto los controles del formulario
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        // si el boton que se presiono tiene la etiqueta de "Guardar archivo"
        } else if ("Guardar".equals(ProgramaDeArchivos.btnGuardar.getText())) {
            GestionArchivos ubicacionArchivo = new GestionArchivos(); // instancia de la clase para acceso a sus metodos
            String directorio = ubicacionArchivo.carpetaArchivo(); // ejecuto el metodo que me devuelve el directorio
            if (directorio == null) { // si lo que devuelve es nulo
                // reseteo el control
                ProgramaDeArchivos.txtareaContenido.setText(""); 
                ProgramaDeArchivos.grpbtn.clearSelection();
                ocultar();// oculoto los controles del formulario
            } else { // en caso contrario de que no se cumplan las anteriores
                // a variable ubicacion asigno la ruta completa del archivo
                String ubicacion = directorio + "/" + ProgramaDeArchivos.txtNombreArchivo.getText() + ".txt";
                try {
                    File nuevoArchivo = new File(ubicacion); // la ruta se la asigno a variable tipo archivo (File) 
                    if (nuevoArchivo.exists()) { // si el archivo ya existe
                        // mensaje de error
                        JOptionPane.showMessageDialog(null, "Ya existe el archivo en esa ubicación", "Error", JOptionPane.ERROR_MESSAGE);
                    } else { // si no existe
                        nuevoArchivo.createNewFile(); // creo el archivo
                        FileWriter escribir = new FileWriter(nuevoArchivo); // stream para escribir en el
                        try (BufferedWriter contenido = new BufferedWriter(escribir)) { // creo un bufer de escritura
                            contenido.write(ProgramaDeArchivos.txtareaContenido.getText()); // y escribo lo que contiene el control
                            // cierro streams y reseteo controles
                            contenido.close();
                            ProgramaDeArchivos.txtNombreArchivo.setText("");
                            ProgramaDeArchivos.txtareaContenido.setText("");
                            ProgramaDeArchivos.grpbtn.clearSelection();
                            activarBotonesRadio(); // activo los controles de radio
                            ocultar(); // oculto los elementos del formulario
                            // mando mensaje de ejecucion satisfactoria
                            JOptionPane.showMessageDialog(null, "Archivo guardado correctamente");
                        } catch (IOException e) {
                            // mensaje de error
                            JOptionPane.showMessageDialog(null, "Ocurrio un error al guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (IOException e) { // si hay error (no encuentra el archivo, no existe u otro
                    JOptionPane.showMessageDialog(null, "Error al intentar crear archivo" + e, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }else{
            ProgramaDeArchivos.grpbtn.clearSelection(); // reseteo los botones de radio
            activarBotonesRadio(); // activo los botones de radio
            ocultar();   // oculto los controles
        }
    }    
    
}
