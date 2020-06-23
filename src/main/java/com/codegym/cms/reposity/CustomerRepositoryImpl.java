package com.codegym.cms.reposity;

import com.codegym.cms.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query= em.createQuery("select c from Customer c",Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(long id) {
        TypedQuery<Customer> query = em.createQuery("select c from Customer c where c.id=:id",Customer.class);
        query.setParameter("id",id);
        try {
            return query.getSingleResult();

        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void save(Customer model) {
      em.merge(model);

    }

    @Override
    public void remove(long id) {
        Customer customer = findById(id);
        if(customer!=null){
            em.remove(customer);
        }

    }
}
