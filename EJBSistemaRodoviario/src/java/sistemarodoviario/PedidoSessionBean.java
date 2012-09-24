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
import javax.persistence.PersistenceUnit;
import sistemarodoviario.jpa.Parada;
import sistemarodoviario.jpa.Pedido;

/**
 *
 * @author Bruno
 */
@Stateful(mappedName = "ejb/Pedido")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PedidoSessionBean implements PedidoSessionBeanRemote {
    
    @PersistenceUnit (unitName = "EJBSistemaRodoviarioPU")
    EntityManagerFactory emf;
    private EntityManager em;
    private Pedido pedido;
    List <Object[]> resultados;
    
    @PostConstruct
    @Override
    public void init() {
        pedido = new Pedido();
        em = emf.createEntityManager();        
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar (Pedido p) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        pedido = p;
        em.persist(pedido);
        em.getTransaction().commit();
        em.close();
    }
    
}
