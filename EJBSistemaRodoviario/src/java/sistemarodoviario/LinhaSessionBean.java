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
import sistemarodoviario.jpa.Linha;

/**
 *
 * @author Bruno
 */
@Stateful(mappedName = "ejb/Linha")
@TransactionManagement(TransactionManagementType.CONTAINER)

public class LinhaSessionBean implements LinhaSessionBeanRemote {
    
    @PersistenceUnit (unitName = "EJBSistemaRodoviarioPU")
    
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction;
    private Linha linha;
    private DataHora dataHora;
    private CidadeSessionBean beanCidade;
    private String resultado;
    private String idOrigem ;
    private String idDestino;
    private List<Object[]> resultados;
    
    @PostConstruct
    @Override
    public void init() {
        linha = new Linha();
        em = emf.createEntityManager();        
    }
    
    @Override
    public Linha retornaLinhaPorId (Long id) {
        Linha l = em.find(Linha.class, id);
        return l;
    }
    
    @Override
    public Linha retornaLinha(String cidadeOrigem, String cidadeDestino) {       
        em = null;
        em = emf.createEntityManager();
        idDestino = em.createQuery("SELECT c.idCidade FROM Cidade c WHERE c.cidadeNome = " + "'" + cidadeDestino + "'").getSingleResult().toString();
        idOrigem = em.createQuery("SELECT c.idCidade FROM Cidade c WHERE c.cidadeNome = " + "'" + cidadeOrigem + "'").getSingleResult().toString();
        Query query = em.createQuery("SELECT p.linhaFk FROM Parada p WHERE p.cidadeFk = " +idDestino+ "AND p.linhaFk.cidadeOrigem.idCidade = "+idOrigem);
        linha = (Linha)query.getSingleResult();
        return linha;
    }
    
    @Override
    public List retornaLinhas (String cidadeOrigem, String cidadeDestino) {
        em = null;
        em = emf.createEntityManager();
        idDestino = em.createQuery("SELECT c.idCidade FROM Cidade c WHERE c.nomeCidade = " + "'" + cidadeDestino + "'").getSingleResult().toString();
        idOrigem = em.createQuery("SELECT c.idCidade FROM Cidade c WHERE c.nomeCidade = " + "'" + cidadeOrigem + "'").getSingleResult().toString();
        Query query = em.createQuery("SELECT p.trajetoFk FROM Parada p WHERE p.cidadeFk = " +idDestino+ "AND p.linhaFk.cidadeOrigem.idCidade = "+idOrigem);
        resultados = query.getResultList();
        return resultados;
    }
    
    @Override
    public List retornaPorLinha (Long idLinha) {
        em = null;
        em = emf.createEntityManager();
        Query query = em.createNativeQuery("SELECT * FROM DATA_HORA WHERE LINHA_FK = "+idLinha.toString());
        resultados = query.getResultList();
        return resultados;
    }    
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar (Linha l) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        this.linha = l;
        em.persist(linha);
        em.getTransaction().commit(); 
    }
    
    @Override
    public Linha retornaLinhaToda(String cidadeOrigem, String cidadeDestino) {       
        em = null;
        em = emf.createEntityManager();
        idDestino = em.createQuery("SELECT c.idCidade FROM Cidade c WHERE c.cidadeNome = " + "'" + cidadeDestino + "'").getSingleResult().toString();
        idOrigem = em.createQuery("SELECT c.idCidade FROM Cidade c WHERE c.cidadeNome = " + "'" + cidadeOrigem + "'").getSingleResult().toString();
        Query query = em.createQuery("SELECT l FROM Linha l WHERE l.cidadeDestino.idCidade = " +idDestino+ "AND l.cidadeOrigem.idCidade = "+idOrigem);
        linha = (Linha)query.getSingleResult();
        return linha;
    }
    
    @Override
    public List todasLinhas() {
        em = null;
        em = emf.createEntityManager();
        Query query = em.createNativeQuery("SELECT * FROM LINHA");
        resultados = query.getResultList();
        return resultados;
    }
    
    @Override
    public DataHora retornaDataHora (Linha linha, String data, String horaPartida) {
        em = null;
        em = emf.createEntityManager();
        Query query = em.createQuery("SELECT d FROM DataHora d WHERE d.linhaFk.idLinha = "+linha.getIdLinha().toString()+" AND d.data = "+"'"+ data +"'"+" AND d.horaPartida ="+"'"+ horaPartida +"'");
        dataHora = (DataHora)query.getSingleResult();
        //for (int i = 0; i<=resultados.size(); i++) {
            //Object[]aux = resultados.get(i);
            //dataHora = new DataHora((Long)aux[0],(String)aux[1],(String)aux[2],(String)aux[3]);
        //}
        return dataHora;
    }   
        
}
