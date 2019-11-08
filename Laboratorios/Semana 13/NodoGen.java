/**
 * Clase NodoGen, representacion de lista enlazadas con nodos genericos
 * @author	Programacion I
 * @version	2019/Nov/05
 * 
 */


class NodoGen<T> {
   private T valor;		// Valor contenido en cada nodo
   private NodoGen siguiente;	// Siguiente elemento de la lista


/**
 * Constructor de un nodo de la lista
 * @param	int valor del nodo a crear
 */
   public NodoGen( T valor ) {
     this.valor = valor;
     this.siguiente = null;

   }


/**
 * Metodo para obtener el valor del nodo
 */
   public T getValor() {
      return this.valor;
   }



/**
 * Metodo para obtener el siguiente elemento de la lista
 */
   public NodoGen<T> getSiguiente() {
      return this.siguiente;
   }


/**
 * Metodo para cambiar el valor de nodo
 * @param	int nuevo valor del nodo
 */
   public void setValor( T valor ) {
      this.valor = valor;
   }


/**
 * Metodo para cambiar el valor del siguiente nodo de la lista
 * @param	Nodo	valor del nuevo siguiente nodo en la lista
 */
   public void setSiguiente( NodoGen siguiente ) {
      this.siguiente = siguiente;
   }

}
