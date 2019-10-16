/**
 * Juego Arqueria, Interfaz
 * @author  Programacion I
 * @version 2019/Set/27
 *
 */

import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.Box;

public class Interfaz {

   private Scanner leer;    // Console reader
   private int m0;      // First menu level choice
   private int jugadores;   // Player's number
   private boolean console; // If interface will go through a console
   private int sets;        // Tournament set quantity
   private int lanzamientos;    // Lanzamientos por set

/**
 * Class constructor
 */
   public Interfaz( boolean console ) {

      this.leer = new Scanner( System.in );
      this.m0 = 0;
      this.jugadores = 2;
      this.console = console;
      this.sets = 3;
      this.lanzamientos = 4;

   }

/**
 * Get jugadores
 */
   public int getJugadores() {

      return this.jugadores;

   }

/**
 * Get sets
 */
   public int getSets() {

      return this.sets;

   }

/**
 * Get lanzamientos
 */
   public int getLanzamientos() {

      return this.lanzamientos;

   }

/**
 * Try to read an integer from System.in
 * Work for positive integers only
 *
 * @return  int next scanned interger
 */
   public int leeInt( String tit, int min, int max ) {
      int opcion = 0;
      do {
         System.out.println( tit );
         if ( this.leer.hasNextInt() ) {
            opcion = this.leer.nextInt();
         } else {
            this.leer.next();   // Skips characters from System.In
            System.out.println( "Intente de nuevo ... [ " + min + ", " + max + " ]" );
         }
      } while ( opcion < min || opcion > max );

      return opcion;

   }


/**
 * Try to read a double from System.in
 *
 * @return  int next scanned interger
 */
   public double leeDouble( String tit, double min, double max ) {
      double opcion;

      opcion = min - 1;
      do {
         System.out.println( tit );
         if ( this.leer.hasNextFloat() ) {
            opcion = this.leer.nextDouble();
         } else {
            this.leer.next();   // Skips characters from System.In
            System.out.println( "Intente de nuevo ... [ "  + min + ", " + max + " ]" );
         }
      } while ( opcion < min || opcion > max );

      return opcion;

   }


/**
 * Determina la opcion en el menu principal
 *
 * @return  int opcion   seleccionada del primer menu
 *
 * Menu principal
 *   Iniciar nueva partida
 *   Ver puntaja mas alto
 *   Configurar cantidad de sets
 *   Configurar cantidad de lanzamientos
 *   Configurar cantidad de jugadores
 *   Finalizar
 */
   public int menuInicialConsola() {
      this.m0 = leeInt( "\nArqueria:\n\t1) Iniciar nueva partida\n\t2) Ver puntaje mas alto\n\t3) Configurar cantidad de sets\n\t4) Configurar cantidad de lanzamientos\n\t5) Configurar cantidad de jugadores\n\t6) Salir.", 1, 6 );

      switch ( this.m0 ) {
         case 1:    // Nueva partida
            break;
         case 2:    // Ver puntaje mas alto
            break;
         case 3:    // Configurar cantidad de sets
            break;
         case 4:    // Configurar cantidad de lanzamientos
            break;
         case 5:    // Configurar cantidad de jugadores
            break;
         case 6:    // Final del programa
            System.exit( 0 );
            break;
      }

      return this.m0;
   }


/**
 *
 */
   public int menuInicialGrafico() {
      String [] choices = { "Iniciar nueva partida", "Ver puntaje más alto", "Configurar cantidad de sets", "Configurar cantidad de lanzamientos","Configurar cantidad de jugadores", "Finalizar" };
      String result;
      int item;

      result = (String) JOptionPane.showInputDialog(null, "Escoja una opción", "Arquería", JOptionPane.QUESTION_MESSAGE, null, choices, "Finalizar" );

      item = -1;
      do {
         item++;
      } while ( ! result.equals( choices[ item ] ) );

      this.m0 = item + 1;

      return this.m0;
   }


/**
 *  Menu inicial
 */
   public int menuInicial() {
      int result;

      if ( this.console ) {
         result = this.menuInicialConsola();
      } else {
         result = this.menuInicialGrafico();
      }

      switch ( result ) {
         case 1:
            this.nuevaPartida();
            break;
         case 2:
            break;
         case 3:
            this.cantidadSets();
            break;
         case 4:
            this.cantidadLanzamientos();
            break;
         case 5:
            this.cantidadJugadores();
            break;
      }

      return result;

   }


/**
 *
 */
   public int nuevaPartida() {
      boolean listo;
      int resultado;
      int sets = 3;
      int lanzamientos = 4;
      int jugadores = 2;

      JTextField setsField = new JTextField( 5 );
      JTextField lanzamientosField = new JTextField( 5 );
      JTextField jugadoresField = new JTextField( 5 );

      JPanel torneo = new JPanel();
      torneo.add( new JLabel("Sets: ") );
      torneo.add( setsField );
      torneo.add( Box.createHorizontalStrut( 15 ) );
      torneo.add( new JLabel("Tiros: ") );
      torneo.add( lanzamientosField );
      torneo.add( new JLabel("Jugadores: ") );
      torneo.add( jugadoresField );

      do {
         listo = true;
         StringBuffer setsText = new StringBuffer( "" );
         StringBuffer lanzaText = new StringBuffer( "" );
         StringBuffer jugaText = new StringBuffer( "" );
         setsText.append( this.sets );
         lanzaText.append( this.lanzamientos );
         jugaText.append( this.jugadores );
         setsField.setText( setsText.toString() );
         lanzamientosField.setText( lanzaText.toString() );
         jugadoresField.setText( jugaText.toString() );
         try {
            resultado = JOptionPane.showConfirmDialog( null, torneo, "Indique los valores", JOptionPane.OK_CANCEL_OPTION );
            if ( resultado == JOptionPane.OK_OPTION ) {
               this.sets = Integer.parseInt( setsField.getText() );
               this.lanzamientos = Integer.parseInt( lanzamientosField.getText() );
               this.jugadores = Integer.parseInt( jugadoresField.getText() );
            }
         }
         catch ( NumberFormatException e ) {
            listo = false;
         }

      } while ( ! listo );

      return 0;
   }

/**
 * Escogencia de la cantidad de sets
 *
 * @return  int cantidad de sets en el torneo
 */
   public int cantidadSets() {
      boolean listo;
      int resultado;

      if ( this.console ) {
          this.sets = leeInt( "Cantidad de sets (2-10)", 2, 10 );
      } else {
         StringBuffer text = new StringBuffer( "" );
         text.append( this.sets );
         JPanel torneo = new JPanel();
         torneo.add( new JLabel("Sets: ") );
         JTextField setsField = new JTextField( text.toString(), 5 );
         torneo.add( setsField );
         do {
            listo = true;
            setsField.setText( text.toString() );
            resultado = JOptionPane.showConfirmDialog( null, torneo, "Indique la cantidad de sets", JOptionPane.OK_CANCEL_OPTION );
            if ( resultado == JOptionPane.OK_OPTION ) {
               try {
                  this.sets = Integer.parseInt( setsField.getText() );
               }
               catch ( NumberFormatException e ) {
                  listo = false;
               }
            }
         } while ( ! listo );

      }

      return this.sets;

   }

/**
 * Escogencia de la cantidad de tiros
 *
 * @return  int cantidad de lanzamientos por set
 */
   public int cantidadLanzamientos() {
      boolean listo;
      int resultado;

      if ( this.console ) {
          this.sets = leeInt( "Cantidad de lanzamientos por set (1-10)", 1, 10 );
      } else {
         StringBuffer text = new StringBuffer( "" );
         text.append( this.lanzamientos );
         JTextField lanzamientosField = new JTextField( text.toString(), 5 );
         JPanel torneo = new JPanel();
         torneo.add( new JLabel("Lanzamientos por set: ") );
         torneo.add( lanzamientosField );
         do {
            listo = true;
            lanzamientosField.setText( text.toString() );
            resultado = JOptionPane.showConfirmDialog( null, torneo, "Indique la cantidad de lanzamientos", JOptionPane.OK_CANCEL_OPTION );
            if ( resultado == JOptionPane.OK_OPTION ) {
               try {
                  this.lanzamientos = Integer.parseInt( lanzamientosField.getText() );
               }
               catch ( NumberFormatException e ) {
                  listo = false;
               }
            }
         } while ( ! listo );
      }

      return this.lanzamientos;

   }

   /**
 * Escogencia de la cantidad de jugadores
 *
 * @return	int	cantidad de jugadores en enfrentamiento
 */
   public int cantidadJugadores() {
       
       boolean listo;
      int resultado;

      if ( this.console ) {
          this.sets = leeInt( "Cantidad de jugadores (2-4)", 2, 4 );
      } else {
         StringBuffer text = new StringBuffer( "" );
         text.append( this.jugadores );
         JTextField jugadoresField = new JTextField( text.toString(), 5 );
         JPanel torneo = new JPanel();
         torneo.add( new JLabel("jugadores: ") );
         torneo.add( jugadoresField );
         do {
            listo = true;
            jugadoresField.setText( text.toString() );
            resultado = JOptionPane.showConfirmDialog( null, torneo, "Indique la cantidad de jugadores", JOptionPane.OK_CANCEL_OPTION );
            if ( resultado == JOptionPane.OK_OPTION ) {
               try {
                  this.jugadores = Integer.parseInt( jugadoresField.getText() );
               }
               catch ( NumberFormatException e ) {
                  listo = false;
               }
            }
         } while ( ! listo );
      }

      return this.jugadores;

   }


/**
 *
 */
   public double[] leeCoordenadas() {
      boolean listo = false;
      double [] coords = new double [ 2 ];
      int resultado;

      coords[ 0 ] = 1.0;
      coords[ 1 ] = 1.0;
      if ( this.console ) {
         coords[ 0 ] = leeDouble( "Coordenada x: ", 0.0, 2.0);
         coords[ 1 ] = leeDouble( "Coordenada y: ", 0.0, 2.0);
      } else {
         StringBuffer text = new StringBuffer( "" );
         text.append( coords[ 0 ] );
         JTextField x = new JTextField( text.toString(), 5 );
         JTextField y = new JTextField( text.toString(), 5 );

         JPanel torneo = new JPanel();
         torneo.add( new JLabel("Coordenada X: ") );
         torneo.add( x );
         torneo.add( Box.createHorizontalStrut( 15 ) );
         torneo.add( new JLabel("Coordenada Y: ") );
         torneo.add( y );

         do {
            listo = true;
            text  = new StringBuffer( "" );
            text.append( coords[ 0 ] );
            x.setText( text.toString() );
            text  = new StringBuffer( "" );
            text.append( coords[ 1 ] );
            y.setText( text.toString() );
            resultado = JOptionPane.showConfirmDialog( null, torneo, "Indique las coordenadas", JOptionPane.OK_CANCEL_OPTION );
            if ( resultado == JOptionPane.OK_OPTION ) {
               try {
                  coords[ 0 ] = Double.parseDouble( x.getText() );
                  coords[ 1 ] = Double.parseDouble( y.getText() );
               }
               catch ( NumberFormatException e ) {
                  listo = false;
               }
            }
         } while ( ! listo );
     }

     return coords;

   }


/*
 * Main method, for testing this class
 */
   public static void main( String args[] ) {
      int r;
      double [] c = new double[ 2 ];

      Interfaz i = new Interfaz( args.length > 0 );
      r = i.menuInicial();
      if ( 1 == r ) {
System.out.println("Inicia partida" );
      }
      c = i.leeCoordenadas();
      System.out.println( " Double = " + c[0] + " " + c[1] );
   }

}
