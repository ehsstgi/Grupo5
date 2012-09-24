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
public interface AssentoSessionBeanRemote {
    
    public void init();
    
    public List retornaAssentos (Linha linha, DataHora dataHora);
    
    public void mudaAssento (Linha linha, DataHora dataHora, String numeroAssento);
    
}
