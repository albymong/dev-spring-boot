package me.albymong.devspringboot.service;

import me.albymong.devspringboot.data.dto.ProductDto;

public interface ProductService {

  ProductDto saveProduct(String productId, String productName, int productPrice, int productStock);

  ProductDto getProduct(String productId);

}
