package arqSw.proyecto.DAO;

import arqSw.proyecto.Hibernate.Cliente;
import arqSw.proyecto.Hibernate.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.spi.ServiceRegistry;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClienteDAO {

    Session session = null;
    private static ServiceRegistry serviceRegistry;

    public ClienteDAO() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List<Cliente> getCliente() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Cliente");
            clientes = (List<Cliente>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public boolean insertCliente(int id ,String user, String pass,
            String ubicacion, String formaPago) {
        boolean b = false;
        try {            
            Transaction tx = session.beginTransaction();           
            
            Cliente cli = new Cliente();
            
            cli.setFormaPago(formaPago);
            cli.setIdCliente(id);
            cli.setPassword(pass);
            cli.setUbicacion(ubicacion);
            cli.setUsuario(user);
            session.save(cli);
            session.flush();            
            tx.commit();
            b = true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }
    
    public boolean updatePassword(String pass1) {
        boolean b = false;
        try {            
            Transaction tx = session.beginTransaction();           
                        
            Cliente cli = (Cliente) session.get(Cliente.class,"usuario");
            cli.setPassword(pass1);
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
