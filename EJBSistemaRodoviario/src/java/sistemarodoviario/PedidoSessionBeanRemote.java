/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario;

import javax.ejb.Remote;
import sistemarodoviario.jpa.Pedido;

/**
 *
 * @author Bruno
 */
@Remote
public interface PedidoSessionBeanRemote {
    
    public void init();
    
    public void salvar (Pedido p);
    
}
