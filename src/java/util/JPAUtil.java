package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory FACTORY;
    
    static{
        FACTORY = Persistence.createEntityManagerFactory("HospitalPU");
    }
    
    public static EntityManager getEntityManager(){
        return FACTORY.createEntityManager();
    }
    
    
}
