/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario;

import java.util.List;
import sistemarodoviario.jpa.Cidade;
import javax.ejb.Remote;

/**
 *
 * @author Bruno
 */
@Remote
public interface CidadeSessionBeanRemote {

    public void init();

    public void salvar();

    public void salvar(Cidade c);

    public Cidade getCidade();

    public void setCidade(Cidade cidade);

    public Cidade findCidade(Long id);
    
    public List retornaCidade();
    
    public List retornaCidades(String cidadeOrigem, String cidadeDestino);
    
    public Cidade cidadePeloNome (String nomeCidade);
    
    @Override
    public String toString();
}
