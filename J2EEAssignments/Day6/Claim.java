import javax.persistence.*; 
import java.util.Date; 
@Entity 
@Table(name = "claim") 
public class Claim { 
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "claim_id") 
    private Long claimId; 
    @ManyToOne 
    @JoinColumn(name = "policy_id", nullable = false) 
    private Policy policy; 
    @Column(name = "claim_date", nullable = false) 
    @Temporal(TemporalType.DATE) 
    private Date claimDate; 
    @Column(name = "claim_amount", nullable = false) 
    private Double claimAmount; 
    @Column(name = "status", nullable = false) 
    private String status; 
    
    // Getters and Setters 
    public Long getClaimId() { 
        return claimId; 
    } 
    public void setClaimId(Long claimId) { 
        this.claimId = claimId; 
    } 
    public Policy getPolicy() { 
        return policy; 
    } 
    public void setPolicy(Policy policy) { 
        this.policy = policy; 
    } 
    public Date getClaimDate() { 
        return claimDate; 
    } 
    public void setClaimDate(Date claimDate) { 
        this.claimDate = claimDate; 
    } 
    public Double getClaimAmount() { 
        return claimAmount; 
    } 
    public void setClaimAmount(Double claimAmount) { 
        this.claimAmount = claimAmount; 
    } 
    public String getStatus() { 
        return status; 
    } 
    public void setStatus(String status) { 
        this.status = status; 
    } 
} 