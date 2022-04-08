/**
 * Clase Nodo. Implementara la logica de un nodo de un BST siendo generico
 * Autor: Elias Alberto Alvarado Raxon - 21808
 * Fecha de creacion: 06/04/2022
 * @version 7
 */

public class Nodo<E>
{
    private E palabra; //Llave
    private E traduccion; //Contenido
    private Nodo<E> padre,izquierda, derecha; //nodos

    public Nodo(E palabra, E traduccion)
    {
        this.palabra = palabra;
        this.traduccion = traduccion;
        this.izquierda = this.derecha = null;
    }

    /** 
     * @return E
     */
    public E getPalabra()
    {
        return this.palabra;
    }
    
    /** 
     * @return E
     */
    public E getTraduccion()
    {
        return this.traduccion;
    }
    
    /** 
     * @param palabra
     */
    public void setPalabra(E palabra)
    {
        this.palabra = palabra;
    }
    
    /** 
     * @param traduccion
     */
    public void setTraduccion(E traduccion)
    {
        this.traduccion = traduccion;
    }
    
    /** 
     * @return Nodo<E>
     */
    public Nodo<E> getPadre()
    {
        return this.padre;
    }
    
    /** 
     * @return Nodo<E>
     */
    public Nodo<E> getDerecha()
    {
        return this.derecha;
    }
    
    /** 
     * @return Nodo<E>
     */
    public Nodo<E> getIzquierda()
    {
        return this.izquierda;
    }
    
    /** 
     * @param padre
     */
    public void setPadre(Nodo<E> padre)
    {
        this.padre = padre;
    }
    
    /** 
     * @param derecha
     */
    public void setDerecha(Nodo<E> derecha)
    {
        this.derecha = derecha;
    }
    
    /** 
     * @param izquierda
     */
    public void setIzquierda(Nodo<E> izquierda)
    {
        this.izquierda = izquierda;
    }
    
    /** 
     * @return Nodo<E>
     */
    public Nodo<E> findPredecessor() {
        if (this.getDerecha() == null) {
            return this;
        } else {
            return this.getDerecha().findPredecessor();
        }
    }
    
    /** 
     * @return Nodo<E>
     */
    public Nodo<E> findSuccessor() {
        if (this.getIzquierda() == null) {
            return this;
        } else {
            return this.getIzquierda().findSuccessor();
        }
    }
    
    /** 
     * @param palabra
     * @return Nodo<E>
     */
    public Nodo<E> delete(E palabra) {
        Nodo<E> response = this;
        if(palabra.toString().compareTo(this.palabra.toString()) < 0)
        {
            this.izquierda = this.izquierda.delete(palabra);
        }
        else if(palabra.toString().compareTo(this.palabra.toString()) > 0)
        {
            this.derecha = this.derecha.delete(palabra);
        } 
        else 
        {
            if (this.izquierda != null && this.derecha != null) 
            {
                Nodo<E> temp = this;
                Nodo<E> maxOfTheLeft = this.izquierda.findPredecessor();
                this.palabra = maxOfTheLeft.getPalabra();
                temp.izquierda = temp.izquierda.delete(maxOfTheLeft.getPalabra());
            } 
            else if (this.izquierda != null)
            {
                response = this.izquierda;
            }
            else if (this.derecha != null) 
            {
                response = this.derecha;
            }
            else 
            {
                response = null;
            }
        }
        return response;
    }
}
