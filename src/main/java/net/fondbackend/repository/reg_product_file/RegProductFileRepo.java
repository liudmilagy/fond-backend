package net.fondbackend.repository.reg_product_file;

import net.fondbackend.model.RegProductFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegProductFileRepo extends JpaRepository<RegProductFile, Long> {
}
