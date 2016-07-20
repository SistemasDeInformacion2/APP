package XP.Modelo;

public class Sesion
{
    int id_user, rol;
    
    public Sesion( int id_user, int rol )
    {
        this.id_user = id_user;
        this.rol = rol;
    }
    
    public int getIdUser()
    {
        return id_user;
    }
    
    public int getRol()
    {
        return rol;
    }
}
