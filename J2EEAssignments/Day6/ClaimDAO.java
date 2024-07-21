import com.insurance.entities.Claim; 
import com.insurance.entities.Policy; 
import org.hibernate.SessionFactory; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Repository; 
import org.springframework.transaction.annotation.Transactional; 
import javax.persistence.criteria.CriteriaBuilder; 
import javax.persistence.criteria.CriteriaQuery; 
import javax.persistence.criteria.Root; 
import java.util.List; 
@Repository 
public class ClaimDAO { 
    @Autowired 
    private SessionFactory sessionFactory; 
    @Transactional 
    public List<Claim> getClaimsByPolicyNumber(String policyNumber) { 
        return sessionFactory.getCurrentSession() 
                .createQuery("from Claim c where c.policy.policyNumber = :policyNumber", Claim.class) 
                .setParameter("policyNumber", policyNumber) 
                .list(); 
    } 
    @Transactional 
    public List<Claim> getClaimsByStatus(String status) { 
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder(); 
        CriteriaQuery<Claim> criteria = builder.createQuery(Claim.class); 
        Root<Claim> root = criteria.from(Claim.class); 
        criteria.select(root).where(builder.equal(root.get("status"), status)); 
        return sessionFactory.getCurrentSession().createQuery(criteria).getResultList(); 
    } 
} 