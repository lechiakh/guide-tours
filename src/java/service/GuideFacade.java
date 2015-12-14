/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Guide;
import bean.Utilisateur;
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
public class GuideFacade extends AbstractFacade<Guide> {
    @PersistenceContext(unitName = "guide_touristiquePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GuideFacade() {
        super(Guide.class);
    }
    
    public Guide authentifierGuide(Utilisateur guideRequest) {
        String q = "SELECT g FROM Guide g WHERE g.mail = :mail";
        Query query = em.createQuery(q);
        query.setParameter("mail", guideRequest.getMail());
        try {
            Guide g = (Guide) query.getSingleResult();
            if(guideRequest.getPassword().equals(g.getPassword())){
                return g;
            }else{
                return null;
            }
        } catch (NoResultException ex) {
            return null;
        }
    }
    
}
