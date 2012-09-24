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
public interface LinhaSessionBeanRemote {
    
    public void init();   
    
    public Linha retornaLinhaPorId (Long id);
    
    public Linha retornaLinha (String cidadeOrigem, String cidadeDestino);
    
    public List retornaLinhas (String cidadeOrigem, String cidadeDestino);
    
    public List retornaPorLinha (Long idLinha);
    
    public void salvar (Linha l);
    
    public Linha retornaLinhaToda (String cidadeOrigem, String cidadeDestino);
    
    public List todasLinhas();
    
    public DataHora retornaDataHora (Linha linha, String data, String horaPartida);   
        
}
