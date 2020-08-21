
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

// CLASE QUE EXTIENDE A GESTIONARCHIVOS (PARA OCUAR SUS METODOS Y PROPIEDADES) E IMPLEMENTA LA CLASE RUNNABLE PARA LOS HILOS
public class HiloEscribirArchivoDestino extends GestionArchivos implements Runnable  {

    // instancio la clase GestionArchivos para acceder a sus metodos y propiedades
    GestionArchivos archivosMetodos = new GestionArchivos();
    
    // constante cola de tipo string, albergara el tamaño de la cola. BlockingQueue es una estructura
    // de datos de tipo cola protegida, esto quiere decir que si la cola esta vacia espera a
    // que la cola tenga un elemento para sacarlo de la cola, o si esta llena, espera a tener espacio
    // para ingresar un nuevo elemento 
    protected BlockingQueue<String> cola = null;

    // El constructor de la clase
    public HiloEscribirArchivoDestino(BlockingQueue<String> cola) { // el metodo que ejecutara el hilo al ser llamado
        this.cola = cola;
    }
    
    @Override
    public void run() {
        // en el trycatch asigno 10 segundos de espera antes de ejecutar el metodo, esto es 
        // para que le de tiempo al usuario de seleccionar el archivo desde donde va a copiar
        try {
            Thread.sleep(10000); // 10 segndos de espera
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloEscribirArchivoDestino.class.getName()).log(Level.SEVERE, null, ex);
        }
        pegar(); // ejecuto el metodo pegar desrito lineas abajo
    }
    
    // ESTE METODO ME PERMITIRA LEER EL ARCHIVO Y GUARDAR EN UNA PILA DE BLOQUEO EL CONTENIDO DEL ARCHIVO
    public void pegar(){
        ProgramaDeArchivos.jLabel3.setText("Copiando, espere ..."); // asigno un texto informativo al jlabel
        String archivoUbicado = archivosMetodos.rutaArchivo(); // ejecuto el metodo de la instancia y el valor lo asigno a variable
        if (archivoUbicado == null) { // si es nulo el valor de la variable
            ProgramaDeArchivos.grpbtn.clearSelection();// reseteo los botones de radio
        } else { // si no
            try (PrintWriter escribir = new PrintWriter(new File(archivoUbicado))) { // inicializo la escritura con el archivo destino
                while (true) { // condicion, mientras se cumpla
                    Thread.sleep(4000); // cada 4 segundos tomara lo que este en la cola
                    String bufer = cola.take(); // toma lo que esta en la cola y lo asigno al bufer
                    //verifico si ya se llego al fin del archivo (o del bufer en este caso)
                    if (bufer.equals("EOF")) { // si es asi
                        break; // salgo 
                    }
                    if (bufer.isEmpty()) { // si el bufer esta vacio,  continuo

                    }
                    escribir.println(bufer); // escribo en el bufer
                    ProgramaDeArchivos.txtareaContenido.setText(bufer + "\n"); // y lo asigno al control txtarea (solo para mostrarlo)
                }
                ProgramaDeArchivos.txtareaContenido.setText("\nFin del copiado"); // si ya salio del bucle, escribo en el txt area
            } catch (FileNotFoundException | InterruptedException e) {
            }
        }
        // mando mensaje de finalizacion
        JOptionPane.showMessageDialog(null, "Ha finalizado el copiado", "Cancelado", JOptionPane.WARNING_MESSAGE);
        ocultar(); // oculto los controles
        activarBotonesRadio(); // activo los botones de radio
        ProgramaDeArchivos.grpbtn.clearSelection(); // y los reseteo
    }
    
}
