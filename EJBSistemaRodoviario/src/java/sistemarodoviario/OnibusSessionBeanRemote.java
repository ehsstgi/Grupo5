/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario;

import java.util.List;
import javax.ejb.Remote;
import sistemarodoviario.jpa.Assento;
import sistemarodoviario.jpa.Onibus;

/**
 *
 * @author Bruno
 */
@Remote
public interface OnibusSessionBeanRemote {
    
    public void init();
    
    public void salvar (Onibus o);
    
    public List retornaOnibus();
    
    public Onibus retornaUltimoSalvo();
    
    public void salvarAssento (Assento a);
    
    
}
