/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g35099.adi3g.eVente.entite;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Florian
 */
@Embeddable
public class LignecommandePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COMMANDE")
    private long commande;
    @Basic(optional = false)
    @Column(name = "LIGNENO")
    private short ligneno;

    public LignecommandePK() {
    }

    public LignecommandePK(long commande, short ligneno) {
        this.commande = commande;
        this.ligneno = ligneno;
    }

    public long getCommande() {
        return commande;
    }

    public void setCommande(long commande) {
        this.commande = commande;
    }

    public short getLigneno() {
        return ligneno;
    }

    public void setLigneno(short ligneno) {
        this.ligneno = ligneno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) commande;
        hash += (int) ligneno;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LignecommandePK)) {
            return false;
        }
        LignecommandePK other = (LignecommandePK) object;
        if (this.commande != other.commande) {
            return false;
        }
        if (this.ligneno != other.ligneno) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "g35099.adi3g.eVente.entite.LignecommandePK[ commande=" + commande + ", ligneno=" + ligneno + " ]";
    }
    
}
