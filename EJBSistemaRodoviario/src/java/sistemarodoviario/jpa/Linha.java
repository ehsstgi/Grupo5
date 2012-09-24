/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "LINHA", catalog = "", schema = "APP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Linha.findAll", query = "SELECT l FROM Linha l"),
    @NamedQuery(name = "Linha.findByIdLinha", query = "SELECT l FROM Linha l WHERE l.idLinha = :idLinha"),
    @NamedQuery(name = "Linha.findByPreco", query = "SELECT l FROM Linha l WHERE l.preco = :preco")})
public class Linha implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_LINHA", nullable = false)
    private Long idLinha;
    @Column(name = "PRECO")
    private Integer preco;
    @OneToMany(mappedBy = "linhaFk")
    @Transient
    private List<DataHora> dataHoraList;
    @JoinColumn(name = "CIDADE_ORIGEM", referencedColumnName = "ID_CIDADE")
    @ManyToOne
    private Cidade cidadeOrigem;
    @JoinColumn(name = "CIDADE_DESTINO", referencedColumnName = "ID_CIDADE")
    @ManyToOne
    private Cidade cidadeDestino;
    @Transient
    @OneToMany(mappedBy = "linhaFk")
    private List<Parada> paradaList;
    @Transient
    @OneToMany(mappedBy = "linhaFk")
    private List<Onibus> onibusList;
    @Transient
    @OneToMany(mappedBy = "linhaFk")
    private List<Pedido> pedidoList;

    public Linha() {
    }

    public Linha(Long idLinha) {
        this.idLinha = idLinha;
    }

    public Linha(Integer preco, Cidade cidadeOrigem, Cidade cidadeDestino) {
        this.preco = preco;
        this.cidadeOrigem = cidadeOrigem;
        this.cidadeDestino = cidadeDestino;
    }    

    public Long getIdLinha() {
        return idLinha;
    }

    public void setIdLinha(Long idLinha) {
        this.idLinha = idLinha;
    }

    public Integer getPreco() {
        return preco;
    }

    public void setPreco(Integer preco) {
        this.preco = preco;
    }

    @XmlTransient
    public List<DataHora> getDataHoraList() {
        return dataHoraList;
    }

    public void setDataHoraList(List<DataHora> dataHoraList) {
        this.dataHoraList = dataHoraList;
    }

    public Cidade getCidadeOrigem() {
        return cidadeOrigem;
    }

    public void setCidadeOrigem(Cidade cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }

    public Cidade getCidadeDestino() {
        return cidadeDestino;
    }

    public void setCidadeDestino(Cidade cidadeDestino) {
        this.cidadeDestino = cidadeDestino;
    }

    @XmlTransient
    public List<Parada> getParadaList() {
        return paradaList;
    }

    public void setParadaList(List<Parada> paradaList) {
        this.paradaList = paradaList;
    }

    @XmlTransient
    public List<Onibus> getOnibusList() {
        return onibusList;
    }

    public void setOnibusList(List<Onibus> onibusList) {
        this.onibusList = onibusList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLinha != null ? idLinha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Linha)) {
            return false;
        }
        Linha other = (Linha) object;
        if ((this.idLinha == null && other.idLinha != null) || (this.idLinha != null && !this.idLinha.equals(other.idLinha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemarodoviario.jpa.Linha[ idLinha=" + idLinha + " ]";
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }
    
}
