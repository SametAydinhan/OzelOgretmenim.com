package com.example.SoftwareEngineeringProject.Repository;

import com.example.SoftwareEngineeringProject.Entity.Notice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CriteriaApiQueryRepository {


        @PersistenceContext
        private EntityManager entityManager;
        private Notice notice;

        public List<Notice> findByParameters(String city,String gender,String subject){
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Notice> cq = cb.createQuery(Notice.class);
            Root<Notice> root = cq.from(Notice.class);

            List<Predicate> predicates = new ArrayList<>();

            if(gender != null){
                predicates.add(cb.like(root.get("gender"),"%"+gender+"%"));
            }

            if(city != null){
                predicates.add(cb.like(root.get("city"),"%"+city+"%"));
            }

            if(subject != null){
                predicates.add(cb.like(root.get("subject"),"%"+subject+"%"));
            }

            cq.where(predicates.toArray(new Predicate[0]));

            TypedQuery<Notice> query = entityManager.createQuery(cq);

            return query.getResultList();
        }



}
