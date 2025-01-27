package com.rts.tap.daoimplementation;

import org.springframework.stereotype.Repository;

import com.rts.tap.constants.MessageConstants;
import com.rts.tap.dao.LoginCredentialsDao;
import com.rts.tap.model.LoginCredentials;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LoginCredentialsDaoImpl implements LoginCredentialsDao {
    

	private EntityManager entityManager;
	
    public LoginCredentialsDaoImpl(EntityManager entityManager) {
//		super();
		this.entityManager = entityManager;
	}

	@Override
    public LoginCredentials save(LoginCredentials loginCredentials) {
        if (loginCredentials.getUserId() == null) {
        	entityManager.persist(loginCredentials);
            return loginCredentials;
        } else {
            return entityManager.merge(loginCredentials);
        }
    }
    
    public LoginCredentials findEmail(String email) {
    	String hql = "FROM LoginCredentials WHERE userEmail = :email";
        TypedQuery<LoginCredentials> query = entityManager.createQuery(hql, LoginCredentials.class);
        query.setParameter("email", email);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null; 
        } 
    }
    
    @Override
    public void updateFailedAttempts(LoginCredentials loginCredentials) {
        entityManager.merge(loginCredentials); // This will update failedAttempts and lockoutTime
    }

    public String getRole(Long userId) {
    	  String jpql = "SELECT r.roleName FROM LoginCredentials lc " + "JOIN lc.employee e " + "JOIN e.role r " + "WHERE lc.userId = :userId";
    	  return entityManager.createQuery(jpql, String.class).setParameter("userId", userId).getSingleResult();
    }
    
    public LoginCredentials findById(Long userId) {
        return entityManager.find(LoginCredentials.class, userId);
    }

	@Override
	public String updatePassword(LoginCredentials loginCredentials) {
		
		LoginCredentials loginCredentials2 = entityManager.merge(loginCredentials);

		if(loginCredentials2!=null) {
			return MessageConstants.SUCCESS_MESSAGE;			
		} else {
			return MessageConstants.FAILURE_MESSAGE;
		}
				
	}
	
	

}
