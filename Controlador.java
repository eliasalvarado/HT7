
import java.util.ArrayList;


public class Controlador
{
    private Arbol ingles = new Arbol();
    private Arbol frances = new Arbol();
    private Archivo archivo = new Archivo();
    private ArrayList<String> listaCompleta = new ArrayList<String>();
    
    public Arbol getIngles()
    {
        return this.ingles;
    }

    public Arbol getFrances()
    {
        return this.frances;
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
            ingles = split[0].trim();
            espaniol = split[1].trim();
            frances = split[2].trim();
            this.ingles.insertar(ingles, espaniol);
            this.frances.insertar(frances, espaniol);
        }
    }

    public void recorrer(Nodo<String> n){
        if (n != null) {
            recorrer(n.getIzquierda());
            System.out.println("Palabra: " + n.getPalabra() + ". Traduccion: " + n.getTraduccion());
            recorrer(n.getDerecha());
        }
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
