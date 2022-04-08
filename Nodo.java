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


    public Nodo<E> findPredecessor() {
        if (this.getDerecha() == null) {
            return this;
        } else {
            return this.getDerecha().findPredecessor();
        }
    }
 
    public Nodo<E> findSuccessor() {
        if (this.getIzquierda() == null) {
            return this;
        } else {
            return this.getIzquierda().findSuccessor();
        }
    }
 
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
