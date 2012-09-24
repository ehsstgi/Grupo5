/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.persistence.*;
import sistemarodoviario.jpa.Assento;
import sistemarodoviario.jpa.Onibus;

/**
 *
 * @author Bruno
 */
@Stateful(mappedName = "ejb/Onibus")
@TransactionManagement(TransactionManagementType.CONTAINER)

public class OnibusSessionBean implements OnibusSessionBeanRemote {  
    
    @PersistenceUnit (unitName = "EJBSistemaRodoviarioPU")
    
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction;
    private List <Object[]> resultados;
    private Onibus onibus;
    
    @PostConstruct
    @Override
    public void init() {
        onibus = new Onibus();
        em = emf.createEntityManager();
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar (Onibus o) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        this.onibus = o;
        em.persist(onibus);
        em.getTransaction().commit(); 
    }
    
    @Override
    public List retornaOnibus() {
        em = null;
        em = emf.createEntityManager();
        Query query = em.createNativeQuery("SELECT * FROM ONIBUS");
        resultados = query.getResultList();
        return resultados;
    }
    
    @Override
    public Onibus retornaUltimoSalvo() {
        em = null;
        em = emf.createEntityManager();
        Query query = em.createNativeQuery("SELECT MAX (ID_ONIBUS) FROM ONIBUS");
        String id = query.getSingleResult().toString();
        query = em.createQuery("SELECT o FROM Onibus o WHERE o.idOnibus = "+id);
        onibus = (Onibus)query.getSingleResult();
        return onibus;
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvarAssento (Assento a) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Assento assento = a;
        em.persist(assento);
        em.getTransaction().commit(); 
    }
}
