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
@Table(name = "CIDADE", catalog = "", schema = "APP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c"),
    @NamedQuery(name = "Cidade.findByIdCidade", query = "SELECT c FROM Cidade c WHERE c.idCidade = :idCidade"),
    @NamedQuery(name = "Cidade.findByCidadeNome", query = "SELECT c FROM Cidade c WHERE c.cidadeNome = :cidadeNome")})
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_CIDADE", nullable = false)
    private Long idCidade;
    @Size(max = 255)
    @Column(name = "CIDADE_NOME", length = 255)
    private String cidadeNome;
    @Transient
    @OneToMany(mappedBy = "cidadeOrigem")
    private List<Linha> linhaList;
    @Transient
    @OneToMany(mappedBy = "cidadeDestino")
    private List<Linha> linhaList1;
    @Transient
    @OneToMany(mappedBy = "cidadeFk")
    private List<Parada> paradaList;
    @JoinColumn(name = "ESTADO_FK", referencedColumnName = "ID_ESTADO")
    @ManyToOne
    private Estado estadoFk;

    public Cidade() {
    }

    public Cidade(Long idCidade) {
        this.idCidade = idCidade;
    }

    public Cidade(String cidadeNome, Estado estadoFk) {
        this.cidadeNome = cidadeNome;
        this.estadoFk = estadoFk;
    }   

    public Long getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Long idCidade) {
        this.idCidade = idCidade;
    }

    public String getCidadeNome() {
        return cidadeNome;
    }

    public void setCidadeNome(String cidadeNome) {
        this.cidadeNome = cidadeNome;
    }

    @XmlTransient
    public List<Linha> getLinhaList() {
        return linhaList;
    }

    public void setLinhaList(List<Linha> linhaList) {
        this.linhaList = linhaList;
    }

    @XmlTransient
    public List<Linha> getLinhaList1() {
        return linhaList1;
    }

    public void setLinhaList1(List<Linha> linhaList1) {
        this.linhaList1 = linhaList1;
    }

    @XmlTransient
    public List<Parada> getParadaList() {
        return paradaList;
    }

    public void setParadaList(List<Parada> paradaList) {
        this.paradaList = paradaList;
    }

    public Estado getEstadoFk() {
        return estadoFk;
    }

    public void setEstadoFk(Estado estadoFk) {
        this.estadoFk = estadoFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCidade != null ? idCidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.idCidade == null && other.idCidade != null) || (this.idCidade != null && !this.idCidade.equals(other.idCidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemarodoviario.jpa.Cidade[ idCidade=" + idCidade + " ]";
    }
    
}
