/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Guide;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

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
    
    public Guide authentifierGuide(Guide guideRequest) {
        try {
            Guide loadedGuide = (Guide) em.createQuery("SELECT g FROM Guide g WHERE g.mail='"+guideRequest.getMail()+"'").getSingleResult();
            if(guideRequest.getPassword().equals(loadedGuide.getPassword())){
                return loadedGuide;
            }else{
                return null;
            }
        } catch (NoResultException ex) {
            return null;
        }
    }
    
}
