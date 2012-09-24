/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario.jpa;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "PEDIDO", catalog = "", schema = "APP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findByIdPedido", query = "SELECT p FROM Pedido p WHERE p.idPedido = :idPedido")})
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID_PEDIDO", nullable = false)
    private Long idPedido;
    @JoinColumn(name = "LINHA_FK", referencedColumnName = "ID_LINHA")
    @ManyToOne
    private Linha linhaFk;
    @JoinColumn(name = "DATA_HORA_FK", referencedColumnName = "ID_DATA_HORA")
    @ManyToOne
    private DataHora dataHoraFk;
    @JoinColumn(name = "CLIENTE_FK", referencedColumnName = "ID_CLIENTE")
    @ManyToOne
    private Cliente clienteFk;

    public Pedido() {
    }

    public Pedido(Linha linhaFk, DataHora dataHoraFk) {
        this.linhaFk = linhaFk;
        this.dataHoraFk = dataHoraFk;
    }   

    public Pedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Linha getLinhaFk() {
        return linhaFk;
    }

    public void setLinhaFk(Linha linhaFk) {
        this.linhaFk = linhaFk;
    }

    public DataHora getDataHoraFk() {
        return dataHoraFk;
    }

    public void setDataHoraFk(DataHora dataHoraFk) {
        this.dataHoraFk = dataHoraFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemarodoviario.jpa.Pedido[ idPedido=" + idPedido + " ]";
    }

    public Cliente getClienteFk() {
        return clienteFk;
    }

    public void setClienteFk(Cliente clienteFk) {
        this.clienteFk = clienteFk;
    }
    
}
