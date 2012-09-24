/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarodoviario.jpa;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "ASSENTO", catalog = "", schema = "APP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assento.findAll", query = "SELECT a FROM Assento a"),
    @NamedQuery(name = "Assento.findByIdAssento", query = "SELECT a FROM Assento a WHERE a.idAssento = :idAssento"),
    @NamedQuery(name = "Assento.findByNumeroAssento", query = "SELECT a FROM Assento a WHERE a.numeroAssento = :numeroAssento"),
    @NamedQuery(name = "Assento.findByDisponibilidade", query = "SELECT a FROM Assento a WHERE a.disponibilidade = :disponibilidade")})
public class Assento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_ASSENTO", nullable = false)
    private Long idAssento;
    @Column(name = "DISPONIBILIDADE")
    private Short disponibilidade;
    @Size(max = 255)
    @Column(name = "NUMERO_ASSENTO", length = 255)
    private String numeroAssento;
    @JoinColumn(name = "ONIBUS_FK", referencedColumnName = "ID_ONIBUS")
    @ManyToOne
    private Onibus onibusFk;

    public Assento() {
    }

    public Assento(Long idAssento) {
        this.idAssento = idAssento;
    }

    public Assento(Short disponibilidade, String numeroAssento, Onibus onibusFk) {
        this.disponibilidade = disponibilidade;
        this.numeroAssento = numeroAssento;
        this.onibusFk = onibusFk;
    }   

    public Long getIdAssento() {
        return idAssento;
    }

    public void setIdAssento(Long idAssento) {
        this.idAssento = idAssento;
    }

    public String getNumeroAssento() {
        return numeroAssento;
    }

    public void setNumeroAssento(String numeroAssento) {
        this.numeroAssento = numeroAssento;
    }

    public Short getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Short disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Onibus getOnibusFk() {
        return onibusFk;
    }

    public void setOnibusFk(Onibus onibusFk) {
        this.onibusFk = onibusFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAssento != null ? idAssento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assento)) {
            return false;
        }
        Assento other = (Assento) object;
        if ((this.idAssento == null && other.idAssento != null) || (this.idAssento != null && !this.idAssento.equals(other.idAssento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemarodoviario.jpa.Assento[ idAssento=" + idAssento + " ]";
    }
    
}
