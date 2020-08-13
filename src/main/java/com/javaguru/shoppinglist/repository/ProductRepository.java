package com.javaguru.shoppinglist.repository;
import com.javaguru.shoppinglist.domain.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    Optional<ProductEntity> findByName(String name);

}
