/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package g35099.adi3g.eVente.entite;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Florian
 */
@Entity
@Table(name = "LIGNECOMMANDE")
@NamedQueries({
    @NamedQuery(name = "Lignecommande.findAll", query = "SELECT l FROM Lignecommande l")})
public class Lignecommande implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LignecommandePK lignecommandePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "PRIX")
    private BigDecimal prix;
    @Basic(optional = false)
    @Column(name = "QUANTITE")
    private short quantite;
    @JoinColumn(name = "PRODUIT", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Produit produit;
    @JoinColumn(name = "COMMANDE", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Commande commande1;

    public Lignecommande() {
    }

    public Lignecommande(LignecommandePK lignecommandePK) {
        this.lignecommandePK = lignecommandePK;
    }

    public Lignecommande(LignecommandePK lignecommandePK, BigDecimal prix, short quantite) {
        this.lignecommandePK = lignecommandePK;
        this.prix = prix;
        this.quantite = quantite;
    }

    public Lignecommande(long commande, short ligneno) {
        this.lignecommandePK = new LignecommandePK(commande, ligneno);
    }

    public LignecommandePK getLignecommandePK() {
        return lignecommandePK;
    }

    public void setLignecommandePK(LignecommandePK lignecommandePK) {
        this.lignecommandePK = lignecommandePK;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public short getQuantite() {
        return quantite;
    }

    public void setQuantite(short quantite) {
        this.quantite = quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Commande getCommande1() {
        return commande1;
    }

    public void setCommande1(Commande commande1) {
        this.commande1 = commande1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lignecommandePK != null ? lignecommandePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lignecommande)) {
            return false;
        }
        Lignecommande other = (Lignecommande) object;
        if ((this.lignecommandePK == null && other.lignecommandePK != null) || (this.lignecommandePK != null && !this.lignecommandePK.equals(other.lignecommandePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "g35099.adi3g.eVente.entite.Lignecommande[ lignecommandePK=" + lignecommandePK + " ]";
    }

}
