package me.albymong.devspringboot.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import me.albymong.devspringboot.data.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

}
