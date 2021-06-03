package com.bernal.inditex.domain.repository;

import com.bernal.inditex.domain.entity.Price;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PricesRepository extends JpaRepository<Price, Long> {

	@Query(value = "select p.* from PUBLIC.PRICES p where p.BRAND_ID = :brandId AND p.PRODUCT_ID = :productId AND (p.START_DATE <= :date AND p.END_DATE >= :date) order by p.PRIORITY desc", nativeQuery = true)
	List<Price> findWithPeriodTime(@Param("date") Long date,
		@Param("brandId") Long brandId, @Param("productId") Long productId);

}
