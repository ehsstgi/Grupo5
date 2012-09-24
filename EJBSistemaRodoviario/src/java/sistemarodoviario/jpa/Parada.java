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
@Table(name = "PARADA", catalog = "", schema = "APP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parada.findAll", query = "SELECT p FROM Parada p"),
    @NamedQuery(name = "Parada.findByIdParada", query = "SELECT p FROM Parada p WHERE p.idParada = :idParada")})
public class Parada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_PARADA", nullable = false)
    private Long idParada;
    @JoinColumn(name = "LINHA_FK", referencedColumnName = "ID_LINHA")
    @ManyToOne
    private Linha linhaFk;
    @JoinColumn(name = "CIDADE_FK", referencedColumnName = "ID_CIDADE")
    @ManyToOne
    private Cidade cidadeFk;

    public Parada() {
    }

    public Parada(Long idParada) {
        this.idParada = idParada;
    }

    public Parada(Linha linhaFk, Cidade cidadeFk) {
        this.linhaFk = linhaFk;
        this.cidadeFk = cidadeFk;
    }   

    public Long getIdParada() {
        return idParada;
    }

    public void setIdParada(Long idParada) {
        this.idParada = idParada;
    }

    public Linha getLinhaFk() {
        return linhaFk;
    }

    public void setLinhaFk(Linha linhaFk) {
        this.linhaFk = linhaFk;
    }

    public Cidade getCidadeFk() {
        return cidadeFk;
    }

    public void setCidadeFk(Cidade cidadeFk) {
        this.cidadeFk = cidadeFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParada != null ? idParada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parada)) {
            return false;
        }
        Parada other = (Parada) object;
        if ((this.idParada == null && other.idParada != null) || (this.idParada != null && !this.idParada.equals(other.idParada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemarodoviario.jpa.Parada[ idParada=" + idParada + " ]";
    }
    
}
