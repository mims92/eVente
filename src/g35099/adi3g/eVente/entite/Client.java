/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g35099.adi3g.eVente.entite;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import org.eclipse.persistence.annotations.ConversionValue;
import org.eclipse.persistence.annotations.Convert;
import org.eclipse.persistence.annotations.ObjectTypeConverter;

/**
 *
 * @author Florian
 */
@Entity
@Table(name = "CLIENT")
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findAllasc", query = "SELECT c FROM Client c ORDER BY c.nom ASC"),
    @NamedQuery(name = "Client.findDayCom", query = "SELECT c FROM Client c JOIN c.commandeCollection p WHERE p.dat = :date"),
    @NamedQuery(name = "Client.findNotTreated", query = "SELECT c FROM Client c JOIN c.commandeCollection AS p WHERE p.montanttotal > :seuil AND p.traitee = '0'")
})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Client")
    @TableGenerator(name = "Client", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "LOGIN")
    private String login;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "MAIL")
    private String mail;
    @Basic(optional = false)
    @Column(name = "NOM")
    private String nom;
    @Basic(optional = false)
    @Column(name = "PRENOM")
    private String prenom;
    @Basic(optional = false)
    @Column(name = "ACTIF")
    @ObjectTypeConverter(
            name = "acPactConverter",
            dataType = java.lang.String.class,
            objectType = java.lang.Boolean.class,
            conversionValues = {
        @ConversionValue(dataValue = "1", objectValue = "true"),
        @ConversionValue(dataValue = "0", objectValue = "false")
    })
    @Convert("acPactConverter")
    private boolean actif;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Collection<Commande> commandeCollection;

    public Client() {
    }

    public Client(Long id) {
        this.id = id;
    }

    public Client(Long id, String login, String password, String mail, String nom, String prenom, boolean actif) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.mail = mail;
        this.nom = nom;
        this.prenom = prenom;
        this.actif = actif;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public boolean getActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public Collection<Commande> getCommandeCollection() {
        return commandeCollection;
    }

    public void setCommandeCollection(Collection<Commande> commandeCollection) {
        this.commandeCollection = commandeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "g35099.adi3g.eVente.entite.Client[ id=" + id + " ]";
    }
}
