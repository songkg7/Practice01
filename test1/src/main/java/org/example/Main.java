package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("study");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Agent agent = new Agent();
            // ID는 자동 생성되도록 했으므로 이름만 SET 해본다.
            agent.setName("evohjo");

            // 영속화
            em.persist(agent);

            //트랜잭션 커밋!
            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally{
            em.close();
        }
        emf.close();
    }
}
