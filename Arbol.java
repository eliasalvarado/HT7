/**
 * Clase Arbol. Implementara la logica de un BST utilizando nodos de tipo String
 * Autor: Elias Alberto Alvarado Raxon - 21808
 * Fecha de creacion: 06/04/2022
 * @version 5
 */

public class Arbol
{
    private Nodo<String> raiz;

    /** 
     * @param busqueda
     * @return boolean
     */
    public boolean existe(String busqueda)
    {
        return existe(this.raiz, busqueda);
    }

    /** 
     * @param nodo
     * @param busqueda
     * @return boolean
     */
    private boolean existe(Nodo<String> nodo, String busqueda)
    {
        if (nodo == null) return false;
        if (nodo.getPalabra().equals(busqueda)) return true;
        else if (busqueda.compareTo(nodo.getPalabra()) < 0) return existe(nodo.getIzquierda(), busqueda);
        else return existe(nodo.getDerecha(), busqueda);
    }
    
    /** 
     * @param palabra
     * @return String
     */
    public String traduccion(String palabra)
    {
        return traduccion(this.raiz, palabra);
    }
    
    /** 
     * @param nodo
     * @param palabra
     * @return String
     */
    private String traduccion(Nodo<String> nodo, String palabra)
    {
        if (nodo == null) return "*"  + palabra + "*";
        if (nodo.getPalabra().equals(palabra)) return nodo.getTraduccion();
        else if (palabra.compareTo(nodo.getPalabra()) < 0) return traduccion(nodo.getIzquierda(), palabra);
        else return traduccion(nodo.getDerecha(), palabra);
    }
    
    /** 
     * @param palabra
     * @param traduccion
     * @return String
     */
    public String editar(String palabra, String traduccion)
    {
        return editar(this.raiz, palabra, traduccion);
    }
    
    /** 
     * @param nodo
     * @param palabra
     * @param traduccion
     * @return String
     */
    private String editar(Nodo<String> nodo, String palabra, String traduccion)
    {
        if (nodo == null) return "\nHa ocurrio un error inesperado, verifique haber ingresado correctamente la palabra clave.";
        if (nodo.getPalabra().equals(palabra))
        {
            nodo.setTraduccion(traduccion);
            return "\nSe ha editado con exito la palabra '" + palabra + "' por la nueva traduccion: " + traduccion;
        }
        else if (palabra.compareTo(nodo.getPalabra()) < 0) return editar(nodo.getIzquierda(), palabra, traduccion);
        else return editar(nodo.getDerecha(), palabra, traduccion);
    }
    
    /** 
     * @param palabra
     * @param traduccion
     */
    public void insertar(String palabra, String traduccion)
    {
        Nodo<String> n = new Nodo<String>(palabra, traduccion);
        n.setTraduccion(traduccion);
        
        //SI LA RAIZ ES NULA SIGNIFICA QUE NO HA EMPEZADO A CRECER EL ARBOL
        if (raiz==null) {
            raiz=n;
        }else{
            // DE LO CONTRARIO CREAMO UN NO AUXILIAR ARA BUSCAR EN DONDE COLOCARLO, SI A LA DER O IZQ
            Nodo<String> aux = raiz;
            //MIENTRAS EL AUXILIAR NO SEA NULO HAGAMOS QUE EL PADRE DEL NODO SEA EL AUXILIAR,
            //ASI VAMOS SUBIENDO EN EL ARBOL
            while(aux != null){
                
                n.setPadre(aux);
                //VALIDAMOS, SI EL INDICE ES MAYOR ENTONCES VA A LA DERECHA
                if (n.getPalabra().compareTo(aux.getPalabra()) > 0) {
                    aux = aux.getDerecha();
                }else{
                    //SI NO VA A LA IZQUIERDA
                    aux = aux.getIzquierda();
                }
            }
            //si la llave del nodo actual es menor al indice del nodo padre entonces enlazo la direccion
            //dentro del arbol
            if (n.getPalabra().compareTo(n.getPadre().getPalabra()) < 0)
            {
                n.getPadre().setIzquierda(n);
            }
            else
            {
                n.getPadre().setDerecha(n);
            }
        }
    }
    
    /** 
     * @return Nodo<String>
     */
    public Nodo<String> getRaiz()
    {
        return this.raiz;
    }
}
