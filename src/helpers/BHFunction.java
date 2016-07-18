package helpers;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import customTools.DBUtil;
import model.Bhpost;
import model.Bhuser;

public class BHFunction {
	public static Bhpost getPostById(String id){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Bhpost u where u.postid="
				+ ":postid";
		TypedQuery<Bhpost> q = em.createQuery(qString, Bhpost.class);
		q.setParameter("postid",Long.parseLong(id));
		Bhpost post = null;
		try{
			post = q.getSingleResult();
		}catch(NoResultException e){
			System.out.println(e);
		}finally{
			em.close();
		}
		
		return post;
	}
	public static boolean isValidUser(Bhuser user,String password){
		if(user==null)return false;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "Select count(b.bhuserid) from Bhuser b where "
				+ "b.useremail = :useremail "
				+ "and b.userpassword = :userpass";
		TypedQuery<Long> q = em.createQuery(qString, Long.class);
		boolean result=false;
		q.setParameter("useremail", user.getUseremail());
		q.setParameter("userpass", password);
		
		try{
			long userId = q.getSingleResult();
			if(userId>0)result=true;
		}catch (Exception e){
			result = false;
		} finally{
			em.close();
		}
		return result;
	}
}
