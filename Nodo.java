public class Nodo<E>
{
    private E palabra; //Llave
    private E traduccion; //Contenido
    private Nodo<E> padre,izquierda, derecha;

    public Nodo(E palabra, E traduccion)
    {
        this.palabra = palabra;
        this.traduccion = traduccion;
        this.izquierda = this.derecha = null;
    }

    public E getPalabra()
    {
        return this.palabra;
    }

    public E getTraduccion()
    {
        return this.traduccion;
    }

    public void setPalabra(E palabra)
    {
        this.palabra = palabra;
    }

    public void setTraduccion(E traduccion)
    {
        this.traduccion = traduccion;
    }

    public Nodo<E> getPadre()
    {
        return this.padre;
    }

    public Nodo<E> getDerecha()
    {
        return this.derecha;
    }

    public Nodo<E> getIzquierda()
    {
        return this.izquierda;
    }

    public void setPadre(Nodo<E> padre)
    {
        this.padre = padre;
    }

    public void setDerecha(Nodo<E> derecha)
    {
        this.derecha = derecha;
    }

    public void setIzquierda(Nodo<E> izquierda)
    {
        this.izquierda = izquierda;
    }
}
