/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g35099.adi3g.eVente.entite;

import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

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

        em = emf.createEntityManager();
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
                        "Marque", prod.getMarque().getLibelle(),
                        "Disponible", prod.getDisponible());
            }
        }

        System.out.println("====================================================");
        EntityTransaction transac = em.getTransaction();
        transac.begin();

        Client cli = new Client();
        cli.setLogin("Mims");
        cli.setNom("Desneux");
        cli.setPrenom("Florian");
        cli.setPassword("Flo");
        cli.setMail("flo@flo.be");
        System.out.println("Nouveau client : \n" + cli);

        Produit prod = new Produit();
        prod.setCategorie(em.find(Categorie.class, 1L));
        prod.setMarque(em.find(Marque.class, 1L));
        prod.setPrix(new BigDecimal(200));
        prod.setLibelle("UltraBook");
        System.out.println("Nouveau produit : \n" + prod);

        em.persist(cli);
        em.persist(prod);

        transac.commit();
        em.close();
        emf.close();
    }
}
