package arqSw.proyecto.DAO;

import arqSw.proyecto.Hibernate.Administrador;
import arqSw.proyecto.Hibernate.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdministradorDAO {

    Session session = null;

    public AdministradorDAO() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List<Administrador> getAdministrador() {
        List<Administrador> administradores = new ArrayList<Administrador>();
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Administrador");
            administradores = (List<Administrador>) q.list();            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return administradores;
    }

}
