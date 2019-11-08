/**
 * Clase para la representacion de listas enlazadas con nodos genericos
 * @author	Programacion I
 * @version	2019/Nov/05
 * 
 */


class ListaGen<T extends Comparable<T>> {

   private NodoGen<T> inicio;		// Inicio de la lista enlazada


/**
 *  Constructor de la clase
 *  Crea una lista vacia
 */
   public ListaGen() {
      this.inicio = null;
   }


/**
 *  Devuelve el inicio de la lista
 */
   public NodoGen<T> getInicio() {
      return this.inicio;
   }


/**
 *  Agrega un nuevo nodo en la lista
 *  No toma en cuenta el orden, ni si ya existe
 * @param	T valor del nuevo nodo a agregar
 */
   public void agregar( T valor ) {

      NodoGen<T> antes = this.inicio;

      this.inicio = new NodoGen<T>( valor );
      this.inicio.setSiguiente( antes );

   }

/**
 *  Agrega un nuevo nodo en la lista
 *  Toma en cuenta el orden de los elementos para agregarlo
 *  Permite la insercion de repetidos
 * @param 	int	valor a insertar
 */
   public void agregarOrdenado( T valor ) {
      NodoGen<T> antes, voy, nodo;

      if ( null == this.inicio ) {
         this.inicio = new NodoGen<T>( valor );
      } else {
         voy = this.inicio;
         antes = null;
         while ( (null != voy ) && ( valor.compareTo( voy.getValor() ) < 0 ) ) {
            antes = voy;
            voy = voy.getSiguiente();
         }

         nodo = new NodoGen<T>( valor );
         nodo.setSiguiente( voy );
         if ( voy == this.inicio ) {	// antes es null
            this.inicio = nodo;
         } else {
            antes.setSiguiente( nodo );
         }
      }

   }


/**
 *  Agrega un vector de valores en la lista
 *  Permite repetidos
 *  @param	T[] valores a insertar
 */
   public void agregarOrdenado( T [] valores ) {
      for ( T valor:valores ) {
         agregarOrdenado( valor );
      }
   }


/**
 *  Agregar un nodo a la lista de manera recursiva
 *  Permite repetidos
 * @param	int valor a agregar
 */
   public void agregarOrdenadoRecursivo( T valor ) {
      this.inicio = agregarOrdenadoRecursivo( this.inicio, valor );
   }


/**
 *  Agrega un nuevo nodo a la lista de manera recursiva
 * @param	Nodo donde queremos agregar el nodo
 * @param	int valor del nuevo nodo a agregar
 */
   public NodoGen<T> agregarOrdenadoRecursivo( NodoGen<T> donde, T valor ) {
      NodoGen<T> nodo;

      if ( null == donde ) {
         donde = new NodoGen<T>( valor );
      } else {
         if ( valor.compareTo( donde.getValor() ) < 0 ) {
            agregarOrdenadoRecursivo( donde.getSiguiente(), valor );
         } else {
            nodo = new NodoGen<T>( valor );
            nodo.setSiguiente( donde );
         }
      }
      return donde;
   }


/**
 *  Elimina un elemento de la lista de manera recursiva
 * @param	int elemento a eliminar
 */
   public void eliminarRecursivo( T valor ) {
      this.inicio = eliminarRecursivo( this.inicio, valor );
   }

/**
 *  Recorre la lista de manera recursiva para eliminar el elemento indicado
 * @param	int elemento a eliminar
 * @return	Nodo indicador del siguiente elemento de la lista
 */
   public NodoGen<T> eliminarRecursivo( NodoGen<T> voy, T valor ) {
      if ( null == voy ) {
         return voy;
      }
      if ( voy.getValor() == valor ) {
         return voy.getSiguiente();
      } else {
         voy.setSiguiente( eliminarRecursivo( voy.getSiguiente(), valor ) );
         return voy;
      }
   }



/**
 *  Convierte la lista en una tira de caracteres
 */
   public String toString() {
      StringBuffer lista = new StringBuffer( "" );
      NodoGen<T> voy = this.inicio;

      lista.append( "Elementos de la lista:\n" );
      while ( null != voy ) {
         lista.append( voy.getValor() + " " );
         voy = voy.getSiguiente();
      }
      lista.append( "\n" );

      return lista.toString();

   }


/**
 *
 */
   public String toStringRec() {
      return toStringRec( this.inicio ).toString();
   }


/**
 *
 */
   public StringBuffer toStringRec( NodoGen<T> voy ) {

      if ( null == voy ) {
         return new StringBuffer( "" );
      } else {
         StringBuffer valor = new StringBuffer( voy.getValor() + " " );	// Need to convert int to String
         return valor.append( toStringRec( voy.getSiguiente() ) );
      }
   }


/**
 *  Despliega la lista de manera recursiva
 * @param	Nodo por el que vamos desplegando
 */
   public void printRec( NodoGen<T> voy ) {

      if ( null == voy ) {
      } else {
         printRec( voy.getSiguiente() );
         System.out.println( voy.getValor() );
      }
   }


/**
 *  Metodo para realizar las pruebas de la clase
 */
   public static void main( String args[] ) {
      ListaGen<Integer> lista = new ListaGen<Integer>();
      ListaGen<Double> otra = new ListaGen<Double>();
      int valores [] = { 20, 4, 30, 11, 12, -10, 100, 1, 2, -1, 0, 200, 10 };
      double otros[] = { 0.90, 0.70, 1.12, 2.01, 0.0001, 4.5, 7, 3.4, 3.14, 12, 1000 };

      for ( Integer valor: valores ) {
         lista.agregarOrdenado( valor );
      }

      System.out.println( lista );		
      System.out.println( lista.toStringRec() );

      for ( Double valor:otros ) {
         otra.agregarOrdenado( valor );
      }
      System.out.println( otra.toStringRec() );
   }

}
