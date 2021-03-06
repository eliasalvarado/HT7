/**
 * Clase Controldaor. Sera la encargada de ejecutar las acciones requeridas por el usuario
 * Autor: Elias Alberto Alvarado Raxon - 21808
 * Fecha de creacion: 06/04/2022
 * @version 10
 */


import java.util.ArrayList;

public class Controlador
{
    private Arbol ingles = new Arbol();
    private Arbol frances = new Arbol();
    private Archivo archivo = new Archivo();
    private ArrayList<String> listaCompleta = new ArrayList<String>();
    
    /** 
     * @return Arbol
     */
    public Arbol getIngles()
    {
        return this.ingles;
    }
    
    /** 
     * @return Arbol
     */
    public Arbol getFrances()
    {
        return this.frances;
    }
    
    /** 
     * @param palabra
     * @param traduccion
     * @param ingles
     * @return String
     */
    public String insertar(String palabra, String traduccion, boolean ingles)
    {
        String info = "";
        if(ingles)
        {
            this.ingles.insertar(palabra.toLowerCase(), traduccion.toLowerCase());
            info += "\nSe ha agregado la palabra '" + palabra + "' con traduccion: " + traduccion + " al diccionario de Ingles-Espaniol";
        }
        else
        {
            this.frances.insertar(palabra.toLowerCase(), traduccion.toLowerCase());
            info += "\nSe ha agregado la palabra '" + palabra + "' con traduccion: " + traduccion + " al diccionario de Frances-Espaniol";
        }
        return info;
    }

    public void insertar()
    {
        String ingles = "";
        String espaniol = "";
        String frances = "";

        for(String linea: this.listaCompleta)
        {
            linea = linea.trim().replaceAll("\\s+", " ");
            String[] split = linea.split(",");
            ingles = split[0].trim().toLowerCase();
            espaniol = split[1].trim().toLowerCase();
            frances = split[2].trim().toLowerCase();
            this.ingles.insertar(ingles, espaniol);
            this.frances.insertar(frances, espaniol);
        }
    }
    
    /** 
     * @param n
     */
    public void recorrer(Nodo<String> n){
        if (n != null) {
            recorrer(n.getIzquierda());
            System.out.println("Palabra: " + n.getPalabra() + ". Traduccion: " + n.getTraduccion());
            recorrer(n.getDerecha());
        }
    }
    
    /** 
     * @param palabra
     * @param ingles
     * @return String
     */
    public String traducir(String palabra, boolean ingles)
    {
        if(ingles)
        {
            return this.ingles.traduccion(palabra.toLowerCase());
        }
        else
        {
            return this.frances.traduccion(palabra.toLowerCase());
        }
    }
    
    /** 
     * @param linea
     * @return boolean
     */
    public boolean determinarIdioma(String linea)
    {
        linea = linea.trim().replaceAll("\\s+", " ");
        String[] split = linea.split(" ");
        for(String palabra: split)
        {
            if(this.ingles.existe(palabra)) return true;
        }
        return false;
    }
    
    /** 
     * @param ruta
     * @return String
     */
    public String traducirTexto(String ruta)
    {
        Archivo archivo = new Archivo();
        archivo.crearArchivo(ruta);
        ArrayList<String> palabras = archivo.leerArchivo();
        String traduccion = "\n";
        String texto = "";
        for(String linea: palabras)
        {
            texto += linea + ".\n ";
            linea = linea.trim().replaceAll("\\s+", " ");
            String[] split = linea.split(" ");
            for(String palabra: split)
            {
                traduccion += this.traducir(palabra.toLowerCase(), this.determinarIdioma(palabra.toLowerCase())) + " ";
            }
            traduccion += "\n ";
        }
        return "\nTexto:\n'" + texto.trim() + "'" + "\nTraduccion:\n'" + traduccion.trim() + ".'";
    }
    
    /** 
     * @param palabra
     * @param ingles
     * @return String
     */
    public String eliminarPalabra(String palabra, boolean ingles)
    {
        String info = "";
        if(ingles)
        {
            this.ingles.getRaiz().delete(palabra);
            info += "\nSe ha eliminado la palabra '" + palabra + "' del diccionario de Ingles-Espaniol.";
        }
        else
        {
            this.frances.getRaiz().delete(palabra);
            info += "\nSe ha eliminado la palabra '" + palabra + "' del diccionario de Frances-Espaniol.";
        }

        return info;
    }
    
    /** 
     * @param palabra
     * @param traduccion
     * @param ingles
     * @return String
     */
    public String editar(String palabra, String traduccion, boolean ingles)
    {
        if(ingles) return this.ingles.editar(palabra, traduccion);
        else return this.frances.editar(palabra, traduccion);
    }

    
    //Archivo
    /** 
     * @param ruta
     * @return String
     */
    public String leerArchivo(String ruta)
    {
        try {
            return archivo.crearArchivo(ruta);
            
        } catch (Exception e) {
            //TODO: handle exception
            return "\nNo se pudo leer el documento. Por favor, asegurese que la ruta sea la correcta.";
        }
    }

    /** 
     * @return boolean
     */
    public boolean comprobarArchivo()
    {
        return archivo.getFile().canRead();
    }

    public void archivoArray()
    {
        this.listaCompleta = this.archivo.leerArchivo();
    }
    //Fin archivo
}
