
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;


// clase para los hilos de lectura
public class HiloLectura extends GestionArchivos implements Runnable {

    //SeleccionArchivo metodos = new GestionArchivos();
    GestionArchivos archivosMetodos = new GestionArchivos();
    
    @Override
    public void run() {
        lectura();
    }
    
    // METODO QUE SE EJECUTARA CUANDO SE CREE E INICIA EL HILO
    public void lectura(){
        //SeleccionArchivo ubicacionArchivo = new GestionArchivos();
        String archivoUbicado = archivosMetodos.rutaArchivo();
        if (archivoUbicado == null) { // si es nulo, es decir, se cancelo la seleccion
            ProgramaDeArchivos.grpbtn.clearSelection();// reseteo los botones de radio
        } else {
            if (ProgramaDeArchivos.rdobtnLeer.isSelected()) {
                try { // todo el siguiente codigo dentro de un try catch para capturar errores de apertura                
                    // asigno a la variable la ruta del archivo    
                    botonesRadio(); // dejo activado el boton de radio que se presiono
                    // asigno valores
                    ProgramaDeArchivos.lblEscribirContenido.setText("Contenido del archivo:");
                    ProgramaDeArchivos.txtNombreArchivo.setText(archivoUbicado);
                    mostrarLeerArchivo(); // mostrar controles al leer
                    FileInputStream archivo = new FileInputStream(archivoUbicado); // creo el stream de entrada (parametro el archivo origen)
                    DataInputStream contenido = new DataInputStream(archivo); // acceso al contenido
                    BufferedReader leer = new BufferedReader(new InputStreamReader(contenido)); // creo el buffer de lectura 
                    String texto = ""; // variable que guardara todo lo que contiene el archivo
                    String letralinea; // variable que guardara linea a linea mientras se cumpla la condicion del bucle
                    while ((letralinea = leer.readLine()) != null) { // mientras haya algo que leer
                        texto += letralinea + "\n"; // lo voy asignando / guardando en la variable
                    }
                    // reseteo controles y cierro 
                    ProgramaDeArchivos.txtareaContenido.setText(texto);
                    ProgramaDeArchivos.txtareaContenido.setEditable(false);
                    ProgramaDeArchivos.btnGuardar.setVisible(true);
                    ProgramaDeArchivos.btnGuardar.setText("Ok");
                    leer.close();
                    archivo.close();
                    contenido.close();
                } catch (IOException e) { // si hay error (no encuentra el archivo, no existe u otro
                    // mensaje indicando el error
                    JOptionPane.showMessageDialog(null, "Error al intentar acceder en el archivo" + e, "Error", JOptionPane.ERROR_MESSAGE);
                    ocultar();
                }
            } else {
                try { // todo el siguiente codigo dentro de un try catch para capturar errores de apertura                
                    // asigno a la variable la ruta del archivo
                    botonesRadio();
                    mostrarLeerArchivo();
                    ProgramaDeArchivos.btnCancelar.setVisible(true);
                    ProgramaDeArchivos.btnGuardar.setVisible(true);
                    ProgramaDeArchivos.txtareaContenido.setEditable(true);
                    ProgramaDeArchivos.txtareaContenido.requestFocus();
                    ProgramaDeArchivos.jScrollPane1.setVisible(true);
                    ProgramaDeArchivos.lblEscribirContenido.setText("Escriba el contenido de su archivo:");
                    ProgramaDeArchivos.txtNombreArchivo.setText(archivoUbicado);
                    FileInputStream archivo = new FileInputStream(archivoUbicado); // creo el stream de entrada (parametro el archivo origen)
                    DataInputStream contenido = new DataInputStream(archivo); // acceso al contenido
                    BufferedReader leer = new BufferedReader(new InputStreamReader(contenido)); // creo el buffer de lectura 
                    String texto = ""; // variable que guardara todo lo que contiene el archivo
                    String letralinea; // variable que guardara linea a linea mientras se cumpla la condicion del bucle
                    while ((letralinea = leer.readLine()) != null) { // mientras haya algo que leer
                        texto += letralinea + "\n"; // lo voy asignando / guardando en la variable
                    }
                    leer.close();
                    archivo.close();
                    contenido.close();
                    ProgramaDeArchivos.txtareaContenido.setText(texto); // cuando ya acabo de leer, lo asigno al area de texto
                    ProgramaDeArchivos.btnGuardar.setText("Guardar archivo");
                } catch (IOException e) { // si hay error (no encuentra el archivo, no existe u otro
                    // mensaje indicando el error
                    JOptionPane.showMessageDialog(null, "Error al intentar acceder en el archivo" + e, "Error", JOptionPane.ERROR_MESSAGE);
                    ProgramaDeArchivos.grpbtn.clearSelection();// reseteo los botones de radio
                    ocultar(); // oculto los controles del formulario
                }
            }
        }
    }
    
}
