package com.tnicacio.aulajpatads01.em;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tnica
 */
public class EM {
    
    private static EntityManagerFactory emf;
    private static EntityManager em;
    
    public static EntityManager getEntityManager() {
        try {
          //Obtém o factory a partir da unidade de persistência.
          emf = Persistence.createEntityManagerFactory("com.tnicacio_AulaJpaTads01PU");
          //Cria um entity manager.
          em = emf.createEntityManager();
          //Fecha o factory para liberar os recursos utilizado.
        } finally {
            if (emf != null){
                emf.close();
            }
        }
        return em;
    }
    
}
