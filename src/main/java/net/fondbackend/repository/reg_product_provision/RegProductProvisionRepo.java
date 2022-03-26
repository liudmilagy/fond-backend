package net.fondbackend.repository.reg_product_provision;

import net.fondbackend.model.RegProductProvision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegProductProvisionRepo extends JpaRepository<RegProductProvision, Long> {

    @Query(value = "select rpp " +
            "from RegProductProvision rpp " +
            "join fetch rpp.product " +
            "join fetch rpp.provision " +
            "where rpp.product.isHidden = false")
    List<RegProductProvision> getProvisionsOfNotHiddenProducts();
}
