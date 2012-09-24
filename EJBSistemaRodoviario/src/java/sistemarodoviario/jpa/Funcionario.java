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
@Table(name = "FUNCIONARIO", catalog = "", schema = "APP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByIdFuncionario", query = "SELECT f FROM Funcionario f WHERE f.idFuncionario = :idFuncionario"),
    @NamedQuery(name = "Funcionario.findByNomeFunc", query = "SELECT f FROM Funcionario f WHERE f.nomeFunc = :nomeFunc"),
    @NamedQuery(name = "Funcionario.findBySenhaFunc", query = "SELECT f FROM Funcionario f WHERE f.senhaFunc = :senhaFunc"),
    @NamedQuery(name = "Funcionario.findByUsuarioFunc", query = "SELECT f FROM Funcionario f WHERE f.usuarioFunc = :usuarioFunc")})
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_FUNCIONARIO", nullable = false)
    private Long idFuncionario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NOME_FUNC", nullable = false, length = 255)
    private String nomeFunc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "SENHA_FUNC", nullable = false, length = 255)
    private String senhaFunc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "USUARIO_FUNC", nullable = false, length = 255)
    private String usuarioFunc;

    public Funcionario() {
    }

    public Funcionario(String nomeFunc, String senhaFunc, String usuarioFunc) {
        this.nomeFunc = nomeFunc;
        this.senhaFunc = senhaFunc;
        this.usuarioFunc = usuarioFunc;
    }

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeFunc() {
        return nomeFunc;
    }

    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    public String getSenhaFunc() {
        return senhaFunc;
    }

    public void setSenhaFunc(String senhaFunc) {
        this.senhaFunc = senhaFunc;
    }

    public String getUsuarioFunc() {
        return usuarioFunc;
    }

    public void setUsuarioFunc(String usuarioFunc) {
        this.usuarioFunc = usuarioFunc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuncionario != null ? idFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.idFuncionario == null && other.idFuncionario != null) || (this.idFuncionario != null && !this.idFuncionario.equals(other.idFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemarodoviario.jpa.Funcionario[ idFuncionario=" + idFuncionario + " ]";
    }
    
}
