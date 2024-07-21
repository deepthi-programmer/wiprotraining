import com.insurance.claim.entity.Claim;
import com.insurance.claim.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/claims")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @GetMapping
    public List<Claim> getAllClaims() {
        return claimService.getAllClaims();
    }

    @GetMapping("/{id}")
    public Claim getClaimById(@PathVariable Long id) {
        return claimService.getClaimById(id);
    }

    @PostMapping
    public Claim createClaim(@RequestBody Claim claim) {
        return claimService.createClaim(claim);
    }

    @PutMapping("/{id}")
    public Claim updateClaim(@PathVariable Long id, @RequestBody Claim claim) {
        return claimService.updateClaim(id, claim);
    }

    @DeleteMapping("/{id}")
    public void deleteClaim(@PathVariable Long id) {
        claimService.deleteClaim(id);
    }
}
