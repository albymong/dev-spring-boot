package me.albymong.devspringboot.data.handler;

import me.albymong.devspringboot.data.entity.ProductEntity;

public interface ProductDataHandler {

  ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock);

  ProductEntity getProductEntity(String productId);

}
