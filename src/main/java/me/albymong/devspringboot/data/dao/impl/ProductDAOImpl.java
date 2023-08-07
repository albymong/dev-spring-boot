package me.albymong.devspringboot.data.dao.impl;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import me.albymong.devspringboot.data.dao.ProductDAO;
import me.albymong.devspringboot.data.entity.ProductEntity;
import me.albymong.devspringboot.data.repository.ProductRepository;

@Service
public class ProductDAOImpl implements ProductDAO {

    //private final Logger LOGGER = LoggerFactory.getLogger(ProductDAOImpl.class);

    
    ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity saveProduct(ProductEntity product) {
        ProductEntity product1 = productRepository.save(product);
        return product1;
    }

    @Override
    public ProductEntity getProduct(String productId) {
        ProductEntity product = productRepository.getReferenceById(productId);
        return product;
    }

}
