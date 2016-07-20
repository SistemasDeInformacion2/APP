package XP.Control;

import XP.Modelo.*;

public class ControlHU
{
    private boolean visitas_completas;
    private HistoriaUsuario historia_usuario;
    private PuenteDBHU puenteHU;
    private int id_hu;
    
    public ControlHU( int id_hu )
    {
        initConexion();
        
        this.id_hu = id_hu;
        historia_usuario=initHistoria();
    }
    
    public ControlHU( HistoriaUsuario historia_usuario )
    {
        initConexion();
        
        this.historia_usuario = historia_usuario;
    }
    
    private void initConexion()
    {
        try
        {
            puenteHU = ConexionDB.pedirPuenteHistorias();
        }
        catch( Exception e )
        {
            System.out.println(e);
        }
    }
    
    public void addHistoria()
    {
        puenteHU.addHistoria( historia_usuario.getNombre(), 
                              historia_usuario.getDescripcion(),
                              historia_usuario.getImportancia());
    }
    
    public HistoriaUsuario getHistoria()
    {
        return historia_usuario;
    }
    
    public HistoriaUsuario initHistoria()
    {
        String descripcion = puenteHU.getDescripcion( id_hu );
        String nombre = puenteHU.getNombre( id_hu );
        int importancia = puenteHU.getImportancia( id_hu );
        int estado = puenteHU.getEstado( id_hu );
        
        HistoriaUsuario hu = new HistoriaUsuario( nombre, descripcion, importancia, id_hu );
        
        if( estado == 2 )
            hu.rechazarHistoria();
        else if ( estado== 1 )
            hu.aprobar();
        
        return hu;
    }
    
    public boolean estaAprobada()
    {
        boolean aprobada=false;
        
        if( puenteHU.cantidadUsuariosAprobaron( id_hu ) == puenteHU.cantidadUsuariosTotales() )
            aprobada=true;
        
        return aprobada;
    }
    
    public void rechazar( String descripcion )
    {
        puenteHU.rechazar( id_hu, descripcion );
    }
    
    public void aprobar( int user )
    {
        puenteHU.aprobar( user, id_hu );
    }
    
    public void visitar( int user )
    {
        puenteHU.visitar( user, id_hu );
    }
    
    public int progreso()
    {
        return 0;
    }
    
    public int expectedVisited()
    {
        return 0;
    }
}
