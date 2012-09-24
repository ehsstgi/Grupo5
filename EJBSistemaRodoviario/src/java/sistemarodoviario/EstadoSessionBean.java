/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import sistemarodoviario.jpa.Estado;
import javax.persistence.*;

/**
 *
 * @author Bruno
 */
@Stateful(mappedName = "ejb/Estado")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class EstadoSessionBean implements EstadoSessionBeanRemote {

    @PersistenceUnit (unitName = "EJBSistemaRodoviarioPU")
    EntityManagerFactory emf;
    private EntityManager em;
    private Estado estado;
    private List<Estado> resultados;
    private List<Object[]> estados;

    @PostConstruct
    @Override
    public void init() {
        estado = new Estado();
        em = emf.createEntityManager();
    }

    @Override
    public Estado getEstado() {
        return estado;
    }
    
    @Override
    public List<Estado> listarCidades(){
        return resultados;
    }
    
    @Override
    public Estado findEstado(Long id) {
        Estado e = em.find(Estado.class, id);
        return e;
    }

    @Override
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar() {
        em = null;
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(estado);
        em.getTransaction().commit();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar(Estado e) {
        em = null;
        em = emf.createEntityManager();
        estado = e;
        em.getTransaction().begin();
        em.merge(estado);
        em.getTransaction().commit();
        em.close();

    }
    
    @Override
    public Estado estadoPeloNome (String nomeEstado) {
        Query query = em.createQuery("SELECT e FROM Estado e WHERE e.nomeEstado = " + "'" + nomeEstado +"'");
        estado = (Estado)query.getSingleResult();
        return estado;
        //"SELECT e FROM Estado e WHERE e.nomeEstado = :nomeEstado"
    }
    
    @Override
    public List retornaEstado() {
        em = null;
        em = emf.createEntityManager();
        Query query = em.createNativeQuery("SELECT * FROM ESTADO");
        estados = query.getResultList();
        return estados;
    }

    @Override
    public String toString() {
        return estado.toString();
    }
}
