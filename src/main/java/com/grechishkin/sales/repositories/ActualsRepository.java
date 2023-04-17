package com.grechishkin.sales.repositories;

import com.grechishkin.sales.entities.Actual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface ActualsRepository extends JpaRepository<Actual, Long> {

/*    //TODO check it implementation
    default List<Actual> findBy(OffsetDateTime offsetDateTime, String chainName, Product product) {
        Actual actual = new Actual();
        actual.setDate(offsetDateTime);
        actual.setChainName(chainName);
        actual.setProduct(product);

        List<Actual> actuals = this.findAll(Example.of(actual));
        return actuals;
    }

    */

    List<Actual> findByChainNameInAndProductInAndDate(
            List<String> chainNames,
            List<Integer> products,
            OffsetDateTime date);
}