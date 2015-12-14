/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Guide;
import bean.Utilisateur;
import bean.Voyageur;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Khalid
 */
@ManagedBean(name="userSession")
@SessionScoped
public class SessionController {
    private Utilisateur utilisateur;

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    public boolean isAuthentifier(){
        return utilisateur != null;
    }
    
    public boolean isGuide(){
        return isAuthentifier() && utilisateur instanceof Guide;
    }
    
    public boolean isVoyageur(){
        return isAuthentifier() && utilisateur instanceof Voyageur;
    }
}
