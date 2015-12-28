/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Voyageur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Khalid
 */
@Stateless
public class VoyageurFacade extends AbstractFacade<Voyageur> {

    @PersistenceContext(unitName = "guide_touristiquePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VoyageurFacade() {
        super(Voyageur.class);
    }

    public Voyageur authentifierVoyageur(Voyageur voyageurRequest) {
        String q = "SELECT v FROM Voyageur v WHERE v.mail = :mail";
        Query query = em.createQuery(q);
        query.setParameter("mail", voyageurRequest.getMail());
        try {
            Voyageur v = (Voyageur) query.getSingleResult();
            if(voyageurRequest.getPassword().equals(v.getPassword())){
                return v;
            }else{
                return null;
            }
        } catch (NoResultException ex) {
            return null;
        }
    }

}
