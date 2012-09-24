/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario;

import java.util.List;
import javax.ejb.Remote;
import sistemarodoviario.jpa.Parada;

/**
 *
 * @author Bruno
 */

@Remote
public interface ParadaSessionBeanRemote {
    
    public void init();
    
    public List retornaParadas();
    
    public void salvar (Parada p);
    
    public List retornaParadas (String cidadeOrigem, String cidadeDestino);
    
}
