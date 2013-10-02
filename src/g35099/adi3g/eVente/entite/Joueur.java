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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Florian
 */
@Entity
@Table(name = "JOUEUR")
@NamedQueries({
    @NamedQuery(name = "Joueur.findAll", query = "SELECT j FROM Joueur j")})
public class Joueur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ACRO")
    private String acro;
    @Basic(optional = false)
    @Column(name = "NOM")
    private String nom;
    @Basic(optional = false)
    @Column(name = "PRENOM")
    private String prenom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "joueur")
    private Collection<Partie> partieCollection;

    public Joueur() {
    }

    public Joueur(String acro) {
        this.acro = acro;
    }

    public Joueur(String acro, String nom, String prenom) {
        this.acro = acro;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getAcro() {
        return acro;
    }

    public void setAcro(String acro) {
        this.acro = acro;
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

    public Collection<Partie> getPartieCollection() {
        return partieCollection;
    }

    public void setPartieCollection(Collection<Partie> partieCollection) {
        this.partieCollection = partieCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acro != null ? acro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Joueur)) {
            return false;
        }
        
        Joueur other = (Joueur) object;
        return Objects.equals(this.acro, other.acro);

    }

    @Override
    public String toString() {
        return "g35099.adi3g.eVente.entite.Joueur[ acro=" + acro + " ]";
    }

}
