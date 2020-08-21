
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

// CLASE QUE EXTIENDE A GESTIONARCHIVOS (PARA OCUAR SUS METODOS Y PROPIEDADES) E IMPLEMENTA LA CLASE RUNNABLE PARA LOS HILOS
public class HiloCopiarArchivoOrigen extends GestionArchivos implements Runnable {

    // instancio la clase GestionArchivos para acceder a sus metodos y propiedades
    GestionArchivos archivosMetodos = new GestionArchivos(); 
    
    // constante cola de tipo string, albergara el tamaño de la cola. BlockingQueue es una estructura
    // de datos de tipo cola protegida, esto quiere decir que si la cola esta vacia espera a
    // que la cola tenga un elemento para sacarlo de la cola, o si esta llena, espera a tener espacio
    // para ingresar un nuevo elemento 
    protected BlockingQueue<String> cola = null; 

    // El constructor de la clase
    public HiloCopiarArchivoOrigen(BlockingQueue<String> cola) {
        this.cola = cola;
    }    
    
    @Override
    public void run() { // el metodo que ejecutara el hilo al ser llamado
        copiar();
    }
   
    // ESTE METODO ME PERMITIRA LEER EL ARCHIVO Y GUARDAR EN UNA PILA DE BLOQUEO EL CONTENIDO DEL ARCHIVO
    public void copiar(){
        String archivoUbicado = archivosMetodos.rutaArchivo(); // instancia de la clase para acceder a sus metodos y propiedades
        if (archivoUbicado == null) { // si al buscar el archivo no me devuelve nada (se cancelo la busqueda)
            ProgramaDeArchivos.grpbtn.clearSelection(); // reseteo los botones de radio
        } else { // si no
            desactivarBotonesRadio(); // desactivo los botones de radios
            mostrarLeerArchivo(); // llaMo al metodo mostrarLeerArchivo
            ProgramaDeArchivos.jLabel3.setText(""); // la etiqueta le quito su texto , si lo tiene
            BufferedReader br = null; // inicializo el buffer de lectura
            try { // en un try catch leo el archivo
                br = new BufferedReader(new FileReader(new File(archivoUbicado))); // inicializo la lectura con el archivo a leer
                String bufer = null; // aqui guardare lo que se vaya leyendo
                while ((bufer = br.readLine()) != null) { // mientras el bufer  de lectura sea diferente de nulo
                    Thread.sleep(2000); // cada dos segundos leera
                    cola.put(bufer); // pongo lo leido en la cola
                }
                cola.put("EOF");  // cuando el fin del archivo ya se haya alcanzado
            // errores los capturo si los hay
            } catch (FileNotFoundException e) {
            } catch (IOException | InterruptedException e) {
            } finally {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }
    }
    
    
}
