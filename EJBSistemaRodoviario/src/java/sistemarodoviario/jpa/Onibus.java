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
@Table(name = "ONIBUS", catalog = "", schema = "APP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Onibus.findAll", query = "SELECT o FROM Onibus o"),
    @NamedQuery(name = "Onibus.findByIdOnibus", query = "SELECT o FROM Onibus o WHERE o.idOnibus = :idOnibus")})
public class Onibus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_ONIBUS", nullable = false)
    private Long idOnibus;
    @Transient
    @OneToMany(mappedBy = "onibusFk")
    private List<Assento> assentoList;
    @JoinColumn(name = "LINHA_FK", referencedColumnName = "ID_LINHA")
    @ManyToOne
    private Linha linhaFk;
    @JoinColumn(name = "DATA_HORA_FK", referencedColumnName = "ID_DATA_HORA")
    @ManyToOne
    private DataHora dataHoraFk;

    public Onibus() {
    }

    public Onibus(Long idOnibus) {
        this.idOnibus = idOnibus;
    }

    public Onibus(Linha linhaFk, DataHora dataHoraFk) {
        this.linhaFk = linhaFk;
        this.dataHoraFk = dataHoraFk;
    }   

    public Long getIdOnibus() {
        return idOnibus;
    }

    public void setIdOnibus(Long idOnibus) {
        this.idOnibus = idOnibus;
    }

    @XmlTransient
    public List<Assento> getAssentoList() {
        return assentoList;
    }

    public void setAssentoList(List<Assento> assentoList) {
        this.assentoList = assentoList;
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
        hash += (idOnibus != null ? idOnibus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Onibus)) {
            return false;
        }
        Onibus other = (Onibus) object;
        if ((this.idOnibus == null && other.idOnibus != null) || (this.idOnibus != null && !this.idOnibus.equals(other.idOnibus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemarodoviario.jpa.Onibus[ idOnibus=" + idOnibus + " ]";
    }

    public DataHora getDataHoraFk() {
        return dataHoraFk;
    }

    public void setDataHoraFk(DataHora dataHoraFk) {
        this.dataHoraFk = dataHoraFk;
    }
    
}
