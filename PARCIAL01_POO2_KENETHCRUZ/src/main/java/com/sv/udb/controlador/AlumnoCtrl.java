/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Alumnos;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Orlando Vasquez
 */
public class AlumnoCtrl {
    
    public boolean guar(Alumnos obje)
    {
        boolean resp = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POPOO");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
            em.persist(obje);
            tx.commit();
            resp = true;
        }
        catch(Exception ex)
        {
            tx.rollback();
        }
        em.close();
        emf.close();
        return resp;
    }
     public List<Alumnos>  ConsTodo()
    {
        List<Alumnos> resp = new ArrayList<>();
          EntityManagerFactory emf = Persistence.createEntityManagerFactory("POPOO");
           EntityManager em = emf.createEntityManager();
        try
        {
          TypedQuery<Alumnos> query =em.createNamedQuery("Alumnos.findAll", Alumnos.class);
           resp = query.getResultList();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return resp;
       
    }
//     public List<Alumnos> consTodos(){
//      List <Unidad> resp = new ArrayList<>();
//     
//      Connection cn = new Conexion().getConn();
//      try{
//           String Consulta="select codi_unid_orga, nomb_unid_orga from unid_orga";
//           PreparedStatement cmd = cn.prepareStatement(Consulta);
//           ResultSet rs = cmd.executeQuery();
//           while(rs.next()){
//               System.out.println(rs.getString(2));
//               resp.add(new Unidad(rs.getInt(1), rs.getString(2)));
//           }
//        }
//        catch(Exception ex){
//            ex.printStackTrace();
//        }
//        finally{
//            if(cn!=null){
//                try{
//                if(!cn.isClosed()){
//                    cn.close();
//                }
//                }
//                catch(Exception ex){
//                    ex.printStackTrace();
//                }
//            }
//        }
//        return resp;  
//    }
    
    public static Alumnos get(Integer empId){        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        Alumnos resp = null;        
        try{
            resp = em.find(Alumnos.class, empId);
            
        }catch(Exception e){
            e.printStackTrace();
        }                
        return resp;
    }
}
