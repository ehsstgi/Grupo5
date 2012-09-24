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
import sistemarodoviario.jpa.Cidade;
import javax.persistence.*;

/**
 *
 * @author Bruno
 */
@Stateful(mappedName = "ejb/Cidade")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CidadeSessionBean implements CidadeSessionBeanRemote {

    @PersistenceUnit (unitName = "EJBSistemaRodoviarioPU")
    EntityManagerFactory emf;
    private EntityManager em;
    private Cidade cidade;
    List <Object[]> resultados;
    List <Cidade[]> cidades;

    @PostConstruct
    @Override
    public void init() {
        cidade = new Cidade();
        em = emf.createEntityManager();
    }

    @Override
    public Cidade getCidade() {
        return cidade;
    }

    @Override
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public Cidade findCidade(Long id) {
        em = null;
        em = emf.createEntityManager();
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        Cidade c = em.find(Cidade.class, id);

        return c;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar() {
        em = null;
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(cidade);
        em.getTransaction().commit();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar(Cidade c) {        
        em = emf.createEntityManager();
        em.getTransaction().begin();
        cidade = c;
        em.persist(cidade);
        em.getTransaction().commit();        
    }

    @Override
    public List retornaCidade() {
        em = null;
        em = emf.createEntityManager();
        Query query = em.createNativeQuery("SELECT * FROM CIDADE");
        resultados = query.getResultList();
        return resultados;
    }
    
    @Override
    public List retornaCidades(String cidadeOrigem, String cidadeDestino) {
        em = null;
        em = emf.createEntityManager();
        Query query = em.createNativeQuery("SELECT * FROM CIDADE WHERE CIDADE_NOME <> " + "'" + cidadeOrigem + "'" + "AND CIDADE_NOME <> " + "'" + cidadeDestino + "'");
        resultados = query.getResultList();
        return resultados;
    }
    
    @Override
    public Cidade cidadePeloNome (String nomeCidade) {
        Query query = em.createQuery("SELECT c FROM Cidade c WHERE c.cidadeNome = " + "'" + nomeCidade +"'");
        cidade = (Cidade)query.getSingleResult();
        return cidade;
        //"SELECT e FROM Estado e WHERE e.nomeEstado = :nomeEstado"
    }


    @Override
    public String toString() {
        return cidade.toString();
    }
}
