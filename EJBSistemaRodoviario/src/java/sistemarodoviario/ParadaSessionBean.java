/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.naming.InitialContext;
import javax.persistence.*;
import sistemarodoviario.jpa.Cidade;
import sistemarodoviario.jpa.Parada;

/**
 *
 * @author Bruno
 */
@Stateful(mappedName = "ejb/Parada")
@TransactionManagement(TransactionManagementType.CONTAINER)

public class ParadaSessionBean implements ParadaSessionBeanRemote {
    
    @PersistenceUnit (unitName = "EJBSistemaRodoviarioPU")
    
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction;
    private Parada parada;
    private List <Object[]> resultado;
    Cidade cidadeO;
    Cidade cidadeD;
    
    @PostConstruct
    @Override
    public void init() {
        parada = new Parada();
        em = emf.createEntityManager();        
    }
    
    @Override
    public List retornaParadas() {
        em = null;
        em = emf.createEntityManager();
        Query query = em.createNativeQuery("SELECT * FROM PARADA");
        resultado = query.getResultList();
        return resultado;
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar (Parada p) {        
        em = emf.createEntityManager();
        em.getTransaction().begin();
        parada = p;
        em.persist(parada);
        em.getTransaction().commit();
        em.close();
    }
    
    @Override
    public List retornaParadas (String cidadeOrigem, String cidadeDestino) {        
        try {
            InitialContext context = new InitialContext();
            CidadeSessionBeanRemote beanCidade = (CidadeSessionBeanRemote) context.lookup("ejb/Cidade");
            cidadeO = beanCidade.cidadePeloNome(cidadeOrigem);
            cidadeD = beanCidade.cidadePeloNome(cidadeDestino);
        } catch (Exception e) {}
        em = null;
        em = emf.createEntityManager();
        Query query = em.createNativeQuery("SELECT * FROM PARADA WHERE CIDADE_FK <> "+cidadeO.getIdCidade().toString()+" AND CIDADE_FK <> " +cidadeD.getIdCidade().toString());
        resultado = query.getResultList();
        return resultado;
    }
    
    
}
