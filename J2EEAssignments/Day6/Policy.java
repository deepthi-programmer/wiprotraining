import javax.persistence.*; 
@Entity 
@Table(name = "policy") 
public class Policy { 
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "policy_id") 
    private Long policyId; 
    @Column(name = "policy_number", nullable = false) 
    private String policyNumber; 
    @Column(name = "policyholder_name", nullable = false) 
    private String policyholderName; 
    @Column(name = "amount", nullable = false) 
    private Double amount; 
    
    // Getters and Setters 
    public Long getPolicyId() { 
        return policyId; 
    } 
    public void setPolicyId(Long policyId) { 
        this.policyId = policyId; 
    } 
    public String getPolicyNumber() { 
        return policyNumber; 
    } 
    public void setPolicyNumber(String policyNumber) { 
        this.policyNumber = policyNumber; 
    } 
    public String getPolicyholderName() { 
        return policyholderName; 
    } 
    public void setPolicyholderName(String policyholderName) { 
        this.policyholderName = policyholderName; 
    } 
    public Double getAmount() { 
        return amount; 
    } 
    public void setAmount(Double amount) { 
        this.amount = amount; 
    } 
} 