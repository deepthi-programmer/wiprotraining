import com.insurance.claim.entity.Claim;
import com.insurance.claim.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    public Claim getClaimById(Long id) {
        return claimRepository.findById(id).orElse(null);
    }

    public Claim createClaim(Claim claim) {
        return claimRepository.save(claim);
    }

    public Claim updateClaim(Long id, Claim claim) {
        Claim existingClaim = claimRepository.findById(id).orElse(null);
        if (existingClaim != null) {
            existingClaim.setDescription(claim.getDescription());
            existingClaim.setStatus(claim.getStatus());
            existingClaim.setPolicyId(claim.getPolicyId());
            return claimRepository.save(existingClaim);
        }
        return null;
    }

    public void deleteClaim(Long id) {
        claimRepository.deleteById(id);
    }
}
