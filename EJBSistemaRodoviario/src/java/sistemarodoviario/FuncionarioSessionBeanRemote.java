/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario;

import java.util.List;
import javax.ejb.Remote;
import sistemarodoviario.jpa.*;

/**
 *
 * @author Bruno
 */
@Remote
public interface FuncionarioSessionBeanRemote {
    
    
    public void init();

    public int RetornaFuncionario();
    
    public Funcionario recebeFuncionarioPorID(Long id);
    
    public Funcionario getFuncionario();

    public void setFuncionario(Funcionario funcionario);

    public boolean validaLogin(String login, String senha);

    public void salvar();

    public void salvar(Funcionario f);

    public String getNomeFuncionario(String usuario);

    public void trocarSenha(String s);

    @Override
    public String toString();
    
    
}
