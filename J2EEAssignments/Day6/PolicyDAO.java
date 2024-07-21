import com.insurance.entities.Policy; 
import com.insurance.entities.Claim; 
import org.hibernate.SessionFactory; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Repository; 
import org.springframework.transaction.annotation.Transactional; 
import javax.persistence.criteria.CriteriaBuilder; 
import javax.persistence.criteria.CriteriaQuery; 
import javax.persistence.criteria.Root; 
import java.util.List; 
@Repository 
public class PolicyDAO { 
    @Autowired 
    private SessionFactory sessionFactory; 
    @Transactional 
    public List<Policy> getPoliciesByPolicyholderName(String policyholderName) { 
        return sessionFactory.getCurrentSession() 
                .createQuery("from Policy where policyholderName = :policyholderName", Policy.class) 
                .setParameter("policyholderName", policyholderName) 
                .list(); 
    } 
    @Transactional 
    public List<Policy> getPoliciesByAmountGreaterThan(Double amount) { 
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder(); 
        CriteriaQuery<Policy> criteria = builder.createQuery(Policy.class); 
        Root<Policy> root = criteria.from(Policy.class); 
        criteria.select(root).where(builder.greaterThan(root.get("amount"), amount)); 
        return sessionFactory.getCurrentSession().createQuery(criteria).getResultList(); 
    } 
} 