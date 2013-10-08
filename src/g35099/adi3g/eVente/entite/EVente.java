/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g35099.adi3g.eVente.entite;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author Florian
 */
public class EVente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf =
                javax.persistence.Persistence.createEntityManagerFactory("eVentePU");
        EntityManager em = emf.createEntityManager();
   
           /* Client cli = new Client(0L, "flor", "flor", "flo@flor.be", "desn", "flon", true);
            
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(cli);
            tx.commit();*/
        
        String id = args[0];
        Client client = em.find(Client.class, Long.parseLong(id));
        if (client == null) {
            System.out.println(id + " est inconnu !");
        } else {
            System.out.format("%10s : %20d%n", "Id", client.getId());
            System.out.format("%10s : %20s%n", "Nom", client.getNom());
            System.out.format("%10s : %20s%n", "Prénom", client.getPrenom());
            System.out.format("%10s : %20s%n", "Email", client.getMail());
            System.out.format("%10s : %20s%n", "Actif", client.getActif());
            System.out.println("Listes des livres commandé :");
            for (Commande com : client.getCommandeCollection()) {
                System.out.format("%3s : %3s / %4s : %10s / %7s : %5s / %7s : %2s%n",
                        "Id", com.getId(),
                        "Date", com.getDat(),
                        "Montant", com.getMontanttotal(),
                        "Traitée", com.getTraitee());
                System.out.println("Livre(s) commandé(s) :");
                for (Lignecommande lig : com.getLignecommandeCollection()) {
                    System.out.format("%8s : %20s / %8s : %3s / %4s : %5s %n",
                            "Produit", lig.getProduit().getLibelle(),
                            "Quantité", lig.getQuantite(),
                            "Prix", lig.getPrix());
                }
            }
        }

        System.out.println("====================================================");

        String cat = args[1];
        Categorie categ = em.find(Categorie.class, Long.parseLong(cat));
        if (categ == null) {
            System.out.println(cat + " est inconnu !");
        } else {
            System.out.println(categ.getLibelle());
            for (Produit prod : categ.getProduitCollection()) {
                System.out.format("%3s : %3s / %3s : %10s / %7s : %5s / %5s : %10s / %10s : %1s%n",
                        "Id", prod.getId(),
                        "Nom", prod.getLibelle(),
                        "Montant", prod.getPrix(),
                        "Marque", prod.getMarque(),
                        "Disponible", prod.getDisponible());
            }
        }

        System.out.println("====================================================");
        Query q = em.createNamedQuery("Client.findAllasc");
        List<Client> c = q.getResultList();
        System.out.println("Affichage des clients par ordre : ");
        for (Client clii : c) {
            System.out.println(clii.getNom());
        }
        
        System.out.println("====================================================");
        q = em.createNamedQuery("Client.findDayCom");
        q.setParameter("date", new java.util.Date(), TemporalType.DATE);
        c = q.getResultList();
        System.out.println("Affichage des clients qui ont des commandes aujourd'hui : ");
        for (Client clii : c) {
            System.out.println(clii.getNom());
        }
        
        System.out.println("====================================================");
        q = em.createNamedQuery("Client.findNotTreated");
        q.setParameter("seuil", 10);
        c = q.getResultList();
        System.out.println("Affichage des clients qui dépasse un seuil et dont la commande est non traitée : ");
        for (Client clii : c) {
            System.out.println(clii.getNom());
        }
        
        System.out.println("====================================================");
        q = em.createNamedQuery("Lignecommande.findProd");
        List<Lignecommande> p = q.getResultList();
        System.out.println("Affichage des produits de commandes non traitées : ");
        for (Lignecommande pp : p) {
            System.out.println(pp.getProduit().getLibelle());
        }
        
        System.out.println("====================================================");
        q = em.createNamedQuery("Lignecommande.findMax");
        c = q.getResultList();
        System.out.println("Affichage des clients avec le plus de commandes : ");
        for (Client pp : c) {
            System.out.println(pp.getNom());
        }
        
        em.close();
        emf.close();
    }
}
