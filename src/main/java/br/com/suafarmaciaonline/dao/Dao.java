package br.com.suafarmaciaonline.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class Dao {
    
      //Método sem retorno para salvar
    public void salvar(Object obj) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("SuaFarmaciaOnlinePU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        try {
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    //Método para ler
    public Object ler(Class classe, long id) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("SuaFarmaciaOnlinePU");
        EntityManager em = emf.createEntityManager();

        Object obj = null;
        em.getTransaction().begin();
        try {
            obj = em.find(classe, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return obj;
    }
    
    
}
