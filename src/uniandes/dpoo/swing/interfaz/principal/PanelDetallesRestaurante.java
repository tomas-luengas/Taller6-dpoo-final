package uniandes.dpoo.swing.interfaz.principal;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelDetallesRestaurante extends JPanel
{
    /**
     * La etiqueta donde se muestra el nombre de un restaurante
     */
    private JLabel labNombre;

    /**
     * La etiqueta donde se muestra la calificacion de un restaurante, usando imagenes de estrellas
     */
    private JLabel labCalificacion;

    /**
     * Un checkbox en el que se muestra si un restaurante fue visitado o no
     */
    private JCheckBox chkVisitado;

    public PanelDetallesRestaurante( )
    {
        setLayout( new GridLayout( 3, 1 ) );

        // Configura la etiqueta para el nombre
        JPanel pNombre = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
        pNombre.add( new JLabel( "Nombre: " ) );
        labNombre = new JLabel( "" );
        pNombre.add( labNombre );
        add( pNombre );

        // Configura la etiqueta para la calificacion
        JPanel pCalificacion = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
        pCalificacion.add( new JLabel( "Calificacion: " ) );
        labCalificacion = new JLabel( "" );
        pCalificacion.add( labCalificacion );
        add( pCalificacion );

        // Configura el checkbox para indicar si ya se visito o no el restaurante
        JPanel pVisitado = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
        chkVisitado = new JCheckBox( "Visitado" );
        chkVisitado.setEnabled( false );
        pVisitado.add( chkVisitado );
        add( pVisitado );
    }

    /**
     * Actualiza los datos mostrados del restaurante, indicando los valores por separado.
     * @param nombre
     * @param calificacion
     * @param visitado
     */
    private void actualizarRestaurante( String nombre, int calificacion, boolean visitado )
    {
        labNombre.setText( nombre );
        labCalificacion.setIcon( buscarIconoCalificacion( calificacion ) );
        chkVisitado.setSelected( visitado );
    }

    /**
     * Actualiza los datos que se muestran de un restaurante
     * @param r El restaurante que se debe mostrar
     */
    public void actualizarRestaurante( Restaurante r )
    {
        if( r != null )
        {
            this.actualizarRestaurante( r.getNombre( ), r.getCalificacion( ), r.isVisitado( ) );
        }
        else
        {
            labNombre.setText( "" );
            labCalificacion.setIcon( null );
            chkVisitado.setSelected( false );
        }
    }

    /**
     * Dada una calificacion, retorna una imagen para utilizar en la etiqueta que muestra la calificacion
     * @param calificacion La calificacion del restaurante, que debe ser un numero entre 1 y 5.
     * @return Una imagen a la que corresponde la calificacion
     */
    private ImageIcon buscarIconoCalificacion( int calificacion )
    {
        String imagen = "./imagenes/stars" + calificacion + ".png";
        return new ImageIcon( imagen );
    }
}
