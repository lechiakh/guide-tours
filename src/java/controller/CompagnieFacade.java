/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Compagnie;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Khalid
 */
@Stateless
public class CompagnieFacade extends AbstractFacade<Compagnie> {
    @PersistenceContext(unitName = "guide_touristiquePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompagnieFacade() {
        super(Compagnie.class);
    }
    
}
