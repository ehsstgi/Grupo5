/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;
import javax.enterprise.inject.Disposes;
import javax.persistence.*;
import sistemarodoviario.jpa.*;

/**
 *
 * @author Bruno
 */
@Stateful(mappedName = "ejb/Funcionario")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class FuncionarioSessionBean implements FuncionarioSessionBeanRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceUnit (unitName = "EJBSistemaRodoviarioPU")
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction;
    private Funcionario funcionario;

    @PostConstruct
    @Override
    public void init() {
        funcionario = new Funcionario();
        em = emf.createEntityManager();
        
    }

    @Override
    public Funcionario getFuncionario() {
        return funcionario;
    }

    @Override
    public Funcionario recebeFuncionarioPorID(Long id) {
        Funcionario f = em.find(Funcionario.class, id);
        return f;
    }

    @Override
    public int RetornaFuncionario() {
        em = null;
        em = emf.createEntityManager();
        return em.createQuery("SELECT * FROM CLIENTES").getResultList().size();
    }

    @Override
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public void trocarSenha(String s) {
        funcionario.setUsuarioFunc(s);
        this.salvar();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar() {
        em = null;
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(funcionario);
        em.getTransaction().commit();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar(Funcionario f) {

        em = emf.createEntityManager();
        transaction = em.getTransaction();
          if (transaction.isActive()) {
            funcionario = f;
            em.merge(funcionario);
            transaction.commit();
        } else {
            transaction.begin();
            funcionario = f;
            em.merge(funcionario);
            transaction.commit();
        }


    }

    @Override
    public String getNomeFuncionario(String usuario) {
        em = null;
        em = emf.createEntityManager();
        String resultado;
        Funcionario f;
        try {

            Query query = em.createNativeQuery("SELECT u.NOME_FUNC FROM FUNCIONARIO u WHERE u.USUARIO_FUNC=" +"'"+usuario+"'");
            resultado = query.getSingleResult().toString();
             

        } catch (Exception e) {
            return null;
        }
        return resultado;
    }


    @Override
    public boolean validaLogin(String login, String senha) {

        em = null;
        em = emf.createEntityManager();
        //String comando = "SELECT u.nome FROM CLIENTES u WHERE u.NOME="+"'"+login+"'";

        try {

            Query query = em.createQuery("SELECT f.usuarioFunc FROM Funcionario f WHERE f.usuarioFunc=" + "'" + login + "'" + " AND " + "f.senhaFunc=" + "'" + senha + "'");
            String result = query.getSingleResult().toString();

            return true;

        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public String toString() {
        return funcionario.toString();
    }
}
