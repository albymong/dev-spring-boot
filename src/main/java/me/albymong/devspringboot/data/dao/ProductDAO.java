package me.albymong.devspringboot.data.dao;

import me.albymong.devspringboot.data.entity.ProductEntity;

public interface ProductDAO {

    ProductEntity saveProduct(ProductEntity product);

    ProductEntity getProduct(String productId);

}
