/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Grupos;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Orlando Vasquez
 */
public class GruposCtrl {
    
    public List<Grupos>  ConsTodo()
    {
        List<Grupos> resp = new ArrayList<>();
          EntityManagerFactory emf = Persistence.createEntityManagerFactory("POPOO");
           EntityManager em = emf.createEntityManager();
        try
        {
          TypedQuery<Grupos> query =em.createNamedQuery("Grupos.findAll", Grupos.class);
           resp = query.getResultList();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return resp;
       
    }
    
    public static Grupos get(Integer empId){        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POPOO");
        EntityManager em = emf.createEntityManager();
        Grupos resp = null;        
        try{
            resp = em.find(Grupos.class, empId);
            
        }catch(Exception e){
            e.printStackTrace();
        }                
        return resp;
    }
    
}
