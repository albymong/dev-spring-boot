package me.albymong.devspringboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import me.albymong.devspringboot.data.dto.ProductDto;
import me.albymong.devspringboot.data.entity.ProductEntity;
import me.albymong.devspringboot.data.handler.ProductDataHandler;
import me.albymong.devspringboot.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    ProductDataHandler productDataHandler;

    @Autowired    
    public ProductServiceImpl(ProductDataHandler productDataHandler) {
        this.productDataHandler = productDataHandler;
    }

    @Override
    public ProductDto saveProduct(String productId, String productName, int productPrice,int productStock) {
        ProductEntity product = productDataHandler.saveProductEntity(productId, productName,productPrice, productStock);
        ProductDto productDto = new ProductDto(product.getProductId(),product.getProductName(), product.getProductPrice(),product.getProductStock());
        return productDto;
    }

    @Override
    public ProductDto getProduct(String productId) {
        ProductEntity product = productDataHandler.getProductEntity(productId);
        ProductDto productDto = new ProductDto(product.getProductId(),product.getProductName(), product.getProductPrice(),product.getProductStock());
        return productDto;
    }
}
