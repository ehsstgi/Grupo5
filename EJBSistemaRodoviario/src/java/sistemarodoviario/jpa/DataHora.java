/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "DATA_HORA", catalog = "", schema = "APP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DataHora.findAll", query = "SELECT d FROM DataHora d"),
    @NamedQuery(name = "DataHora.findByIdDataHora", query = "SELECT d FROM DataHora d WHERE d.idDataHora = :idDataHora"),
    @NamedQuery(name = "DataHora.findByData", query = "SELECT d FROM DataHora d WHERE d.data = :data"),
    @NamedQuery(name = "DataHora.findByHoraPartida", query = "SELECT d FROM DataHora d WHERE d.horaPartida = :horaPartida"),
    @NamedQuery(name = "DataHora.findByHoraChegada", query = "SELECT d FROM DataHora d WHERE d.horaChegada = :horaChegada")})
public class DataHora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_DATA_HORA", nullable = false)
    private Long idDataHora;
    @Size(max = 255)
    @Column(name = "DATA", length = 255)
    private String data;
    @Size(max = 255)
    @Column(name = "HORA_PARTIDA", length = 255)
    private String horaPartida;
    @Size(max = 255)
    @Column(name = "HORA_CHEGADA", length = 255)
    private String horaChegada;
    @JoinColumn(name = "LINHA_FK", referencedColumnName = "ID_LINHA")
    @ManyToOne
    private Linha linhaFk;
    @Transient
    @OneToMany(mappedBy = "dataHoraFk")
    private List<Onibus> onibusList;
    @Transient
    @OneToMany(mappedBy = "dataHoraFk")
    private List<Pedido> pedidoList;

    public DataHora() {
    }

    public DataHora(Long idDataHora) {
        this.idDataHora = idDataHora;
    }

    public DataHora(String data, String horaPartida, String horaChegada, Linha linhaFk) {
        this.data = data;
        this.horaPartida = horaPartida;
        this.horaChegada = horaChegada;
        this.linhaFk = linhaFk;
    }    

    public Long getIdDataHora() {
        return idDataHora;
    }

    public void setIdDataHora(Long idDataHora) {
        this.idDataHora = idDataHora;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHoraPartida() {
        return horaPartida;
    }

    public void setHoraPartida(String horaPartida) {
        this.horaPartida = horaPartida;
    }

    public String getHoraChegada() {
        return horaChegada;
    }

    public void setHoraChegada(String horaChegada) {
        this.horaChegada = horaChegada;
    }

    public Linha getLinhaFk() {
        return linhaFk;
    }

    public void setLinhaFk(Linha linhaFk) {
        this.linhaFk = linhaFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDataHora != null ? idDataHora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DataHora)) {
            return false;
        }
        DataHora other = (DataHora) object;
        if ((this.idDataHora == null && other.idDataHora != null) || (this.idDataHora != null && !this.idDataHora.equals(other.idDataHora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemarodoviario.jpa.DataHora[ idDataHora=" + idDataHora + " ]";
    }

    @XmlTransient
    public List<Onibus> getOnibusList() {
        return onibusList;
    }

    public void setOnibusList(List<Onibus> onibusList) {
        this.onibusList = onibusList;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }
    
}
