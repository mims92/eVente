/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package g35099.adi3g.eVente.entite;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Florian
 */
@Entity
@Table(name = "PARTIE")
@NamedQueries({
    @NamedQuery(name = "Partie.findAll", query = "SELECT p FROM Partie p")})
public class Partie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDPARTIE")
    private Integer idpartie;
    @Basic(optional = false)
    @Column(name = "DATEPARTIE")
    @Temporal(TemporalType.DATE)
    private Date datepartie;
    @Basic(optional = false)
    @Column(name = "NBCOUPS")
    private short nbcoups;
    @JoinColumn(name = "JOUEUR", referencedColumnName = "ACRO")
    @ManyToOne(optional = false)
    private Joueur joueur;

    public Partie() {
    }

    public Partie(Integer idpartie) {
        this.idpartie = idpartie;
    }

    public Partie(Integer idpartie, Date datepartie, short nbcoups) {
        this.idpartie = idpartie;
        this.datepartie = datepartie;
        this.nbcoups = nbcoups;
    }

    public Integer getIdpartie() {
        return idpartie;
    }

    public void setIdpartie(Integer idpartie) {
        this.idpartie = idpartie;
    }

    public Date getDatepartie() {
        return datepartie;
    }

    public void setDatepartie(Date datepartie) {
        this.datepartie = datepartie;
    }

    public short getNbcoups() {
        return nbcoups;
    }

    public void setNbcoups(short nbcoups) {
        this.nbcoups = nbcoups;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpartie != null ? idpartie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Partie)) {
            return false;
        }
        
        Partie other = (Partie) object;
        return Objects.equals(this.idpartie, other.idpartie);
    }

    @Override
    public String toString() {
        return "g35099.adi3g.eVente.entite.Partie[ idpartie=" + idpartie + " ]";
    }

}
