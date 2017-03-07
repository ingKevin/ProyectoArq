package arqSw.proyecto.DAO;

import arqSw.proyecto.Hibernate.Artista;
import arqSw.proyecto.Hibernate.Cliente;
import arqSw.proyecto.Hibernate.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class ArtistaDAO {
    
    Session session = null;

    public ArtistaDAO() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List<Artista> getArtista() {
        List<Artista> artistas = new ArrayList<Artista>();
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Artista");
            artistas = (List<Artista>) q.list();            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return artistas;
    }
    public boolean insertCliente(int id ,String user, String pass) {
        boolean b = false;
        try {            
            Transaction tx = session.beginTransaction();           
            
            Artista cli = new Artista();
            
            cli.setIdArtista(id);
            cli.setUsuario(user);
            cli.setPassword(pass);            
            session.save(cli);
            session.flush();            
            tx.commit();
            b = true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }
}
