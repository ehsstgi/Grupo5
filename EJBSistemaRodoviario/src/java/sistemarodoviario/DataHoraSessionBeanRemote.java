/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario;

import java.util.List;
import javax.ejb.Remote;
import sistemarodoviario.jpa.DataHora;

/**
 *
 * @author Bruno
 */

@Remote
public interface DataHoraSessionBeanRemote {
    
    public void init();
    
    public void salvar (DataHora dh);
    
    public List retornaDataHoras();
    
    public DataHora retornaUltimoSalvo();
    
}
