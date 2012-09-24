/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario;

import java.util.List;
import sistemarodoviario.jpa.Estado;
import javax.ejb.Remote;

/**
 *
 * @author Bruno
 */
@Remote
public interface EstadoSessionBeanRemote {

    public void init();

    public void salvar();

    public void salvar(Estado e);

    public Estado getEstado();

    public void setEstado(Estado estado);

    public Estado findEstado(Long id);

    public List<Estado> listarCidades();
    
    public Estado estadoPeloNome (String nomeEstado);
    
    public List retornaEstado();

    @Override
    public String toString();
}
