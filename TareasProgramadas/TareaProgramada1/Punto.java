/**
 * Juego Arqueria, Puntos en el plano cartesiano
 * @author	Programacion I
 * @version	2019/Set/30
 *
 */

import java.lang.Math;
import java.util.Random;


    public class Punto {

       private double x;	// Coordenada X
       private double y;	// Coordenada Y


/**
 *  Class empty constructor
 */
    public Punto() {
       this.x = 0;
       this.y = 0;
    }


/**
 *  Class constructor
 * @param	double x	coordenada x del punto a crear
 * @param	double y	coordenada y del punto a crear
 */
    public Punto( double x, double y ) {
       this.x = x;
       this.y = y;
    }


/**
 * Copy constructor
 * @param	Punto	el punto a utilizar de copia
 */
    public Punto( Punto aCopiar ) {
       this.x = aCopiar.x;
       this.y = aCopiar.y;
    }


/**
 *  Genera un punto con coordenadas al azar entre [ -1.0, 1.0 ]
 */
    public Punto( Random  random ) {

       this.x = random.nextDouble() * 2.0;
       this.y = random.nextDouble() * 2.0;

    }


/**
 *
 */
   public double getX() {
      return this.x;
   }


/**
 *
 */
   public double getY() {
      return this.y;
   }


/**
 *
 */
   public void setX( double x ) {
      this.x = x;
   }


/**
 *
 */
   public void setY( double y) {
      this.y = y;
   }


/**
 * Calcula a distancia entre dos puntos
 * @param	Punto	el otro punto para determinar la distancia
 * @return	double	la distancia entre ambos puntos
 */
    public double distancia( Punto otro ) {
       double dx, dy, hyp;

       dx = this.x - otro.x;
       dy = this.y - otro.y;
       hyp = Math.sqrt( dx * dx + dy * dy );

       return hyp;
    }


/**
 * Calcula el punto medio entre dos puntos
 * @param	Punto	el otro punto para determinar la distancia
 * @return	double	la distancia entre ambos puntos
 */
    public Punto puntoMedio( Punto otro ) {
       double dx, dy;

       dx = (this.x + otro.x) / 2.0;
       dy = (this.y + otro.y) / 2.0;

       return new Punto( dx, dy );
    }


/**
 * Desplegar las instancias de esta clase
 */
   public String toString() {
      StringBuffer punto = new StringBuffer( "" );
 
      punto.append( "( " );
      punto.append( this.x );
      punto.append( ", " );
      punto.append( this.y );
      punto.append( " )" );
      return punto.toString();

   }


/*
 * Main method, for testing this class
 */
   public static void main( String args[] ) {
      double x, y, z;
      Punto p;

      p = new Punto( 1.0, 1.0 );
      System.out.println( p.distancia( new Punto( 0.5, 0.5 ) ) );

   }  

}
