/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.persistence.*;
import sistemarodoviario.jpa.DataHora;

/**
 *
 * @author Bruno
 */
@Stateful(mappedName = "ejb/DataHora")
@TransactionManagement(TransactionManagementType.CONTAINER)

public class DataHoraSessionBean implements DataHoraSessionBeanRemote {
    
    @PersistenceUnit (unitName = "EJBSistemaRodoviarioPU")
    
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction;
    private List <Object[]> resultados;
    private DataHora dataHora;
    
    @PostConstruct
    @Override
    public void init() {
        dataHora = new DataHora();
        em = emf.createEntityManager();        
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar (DataHora dh) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        this.dataHora = dh;
        em.persist(dataHora);
        em.getTransaction().commit(); 
    }
    
    @Override
    public List retornaDataHoras() {
        em = null;
        em = emf.createEntityManager();
        Query query = em.createNativeQuery("SELECT * FROM DATA_HORA");
        resultados = query.getResultList();
        return resultados;
    }
    
    @Override
    public DataHora retornaUltimoSalvo() {
        em = null;
        em = emf.createEntityManager();
        Query query = em.createNativeQuery("SELECT MAX (ID_DATA_HORA) FROM DATA_HORA");
        String id = query.getSingleResult().toString();
        query = em.createQuery("SELECT dh FROM DataHora dh WHERE dh.idDataHora = "+id);
        dataHora = (DataHora)query.getSingleResult();
        return dataHora;
    }
    
    
}
