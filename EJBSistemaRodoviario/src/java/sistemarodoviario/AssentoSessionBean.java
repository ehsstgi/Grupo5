/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.*;
import sistemarodoviario.jpa.*;

/**
 *
 * @author Bruno
 */
@Stateful(mappedName = "ejb/Assento")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AssentoSessionBean implements AssentoSessionBeanRemote {
    
    @PersistenceUnit (unitName = "EJBSistemaRodoviarioPU")
    EntityManagerFactory emf;
    private EntityManager em;
    private Assento assento;
    List <Object[]> resultados;
    
    @PostConstruct
    @Override
    public void init() {
        em = emf.createEntityManager();
    }
    
    @Override
    public List retornaAssentos (Linha linha, DataHora dataHora) {
        em = null;
        em = emf.createEntityManager();
        Query query = em.createQuery ("SELECT o.idOnibus FROM Onibus o WHERE o.linhaFk.idLinha = "+linha.getIdLinha().toString()+" AND o.dataHoraFk.idDataHora = "+dataHora.getIdDataHora().toString());
        String s = query.getSingleResult().toString();
        query = em.createNativeQuery ("SELECT * FROM ASSENTO WHERE DISPONIBILIDADE = "+1+" AND ONIBUS_FK = "+s);
        resultados = query.getResultList();
        return resultados;
    }
    
    @Override
    public void mudaAssento (Linha linha, DataHora dataHora, String numeroAssento) {
        em = null;
        em = emf.createEntityManager();
        Query query = em.createQuery ("SELECT o.idOnibus FROM Onibus o WHERE o.linhaFk.idLinha = "+linha.getIdLinha().toString()+" AND o.dataHoraFk.idDataHora = "+dataHora.getIdDataHora().toString());
        String s = query.getSingleResult().toString();
        query = em.createQuery ("SELECT a.idAssento FROM Assento a WHERE a.onibusFk.idOnibus = "+s+" AND a.numeroAssento = "+"'"+numeroAssento+"'");
        s = query.getSingleResult().toString();
        em.getTransaction().begin();
        assento = em.find(Assento.class, Long.parseLong(s));
        assento.setDisponibilidade((short)0);
        em.merge(assento);
        em.getTransaction().commit();
        //"SELECT a.idAssento FROM Assento a WHERE a.onibusFk.idOnibus = "+s+" AND a.numeroAssento = "+numeroAssento
    }
    
}
