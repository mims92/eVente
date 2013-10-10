/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g35099.adi3g.eVente.entite;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Florian
 */
@Entity
@Table(name = "COMMANDE")
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c")
})
public class Commande implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "DAT")
    @Temporal(TemporalType.DATE)
    private Date dat;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "MONTANTTOTAL")
    private BigDecimal montanttotal;
    @Basic(optional = false)
    @Column(name = "TRAITEE")
    private char traitee;
    @JoinColumn(name = "CLIENT", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Client client;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commande1")
    private Collection<Lignecommande> lignecommandeCollection;

    public Commande() {
    }

    public Commande(Long id) {
        this.id = id;
    }

    public Commande(Long id, Date dat, BigDecimal montanttotal, char traitee) {
        this.id = id;
        this.dat = dat;
        this.montanttotal = montanttotal;
        this.traitee = traitee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDat() {
        return dat;
    }

    public void setDat(Date dat) {
        this.dat = dat;
    }

    public BigDecimal getMontanttotal() {
        return montanttotal;
    }

    public void setMontanttotal(BigDecimal montanttotal) {
        this.montanttotal = montanttotal;
    }

    public char getTraitee() {
        return traitee;
    }

    public void setTraitee(char traitee) {
        this.traitee = traitee;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Collection<Lignecommande> getLignecommandeCollection() {
        return lignecommandeCollection;
    }

    public void setLignecommandeCollection(Collection<Lignecommande> lignecommandeCollection) {
        this.lignecommandeCollection = lignecommandeCollection;
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
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "g35099.adi3g.eVente.entite.Commande[ id=" + id + " ]";
    }
    
}
