package me.albymong.devspringboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import me.albymong.devspringboot.common.Constants.ExceptionClass;
import me.albymong.devspringboot.common.exception.AlbymongException;
import me.albymong.devspringboot.data.dto.ProductDto;
import me.albymong.devspringboot.service.ProductService;

@RestController
@RequestMapping("/api/v1/product-api")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // http://localhost:8080/api/v1/product-api/product/{productId}
    @GetMapping(value = "/product/{productId}")
    public ProductDto getProduct(@PathVariable String productId) {
        
        long startTime = System.currentTimeMillis();
        LOGGER.info("[getProduct] perform {} of Around Hub API.", "getProduct");

        ProductDto productDto = productService.getProduct(productId);

        LOGGER.info(
            "[getProduct] Response :: productId = {}, productName = {}, productPrice = {}, productStock = {}, Response Time = {}ms",
            productDto.getProductId(),
            productDto.getProductName(), 
            productDto.getProductPrice(), 
            productDto.getProductStock(),
            (System.currentTimeMillis() - startTime));
            
        return productDto;
    }

    //dto에 정의한 어노테이션 validation을 적용하기 위해서는 @Valid 를 선언하면 된다.
    // http://localhost:8080/api/v1/product-api/product
    @PostMapping(value = "/product")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {

        // Validation Code Example
        // 아래코드는 지양을 하고 어노테이션을 사용한다.
        if (productDto.getProductId().equals("") || productDto.getProductId().isEmpty()) {
            LOGGER.error("[createProduct] failed Response :: productId is Empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(productDto);
        }

        String productId = productDto.getProductId();
        String productName = productDto.getProductName();
        int productPrice = productDto.getProductPrice();
        int productStock = productDto.getProductStock();

        ProductDto response = productService
            .saveProduct(productId, productName, productPrice, productStock);

        LOGGER.info(
            "[createProduct] Response >> productId : {}, productName : {}, productPrice : {}, productStock : {}",
            response.getProductId(), response.getProductName(), response.getProductPrice(),
            response.getProductStock());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // http://localhost:8080/api/v1/product-api/product/{productId}
    @DeleteMapping(value = "/product/{productId}")
    public ProductDto deleteProduct(@PathVariable String productId) {
        return null;
    }

    @PostMapping(value="/log-test")
    public void logTest(){
        LOGGER.trace("Trace Log");
        LOGGER.debug("Debug Log");
        LOGGER.info("Info Log");
        LOGGER.warn("Warn Log");
        LOGGER.error("Error Log");
    }

    @PostMapping(value="/exception")
    public void exceptionTest() throws Exception{
        throw new Exception();
    }
    /*
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Map<String,String>> ExceptionHandler(Exception e){
        HttpHeaders responseHeaders = new HttpHeaders();
        //responseHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        LOGGER.info(e.getMessage());
        LOGGER.info("Controller 내 ExceptionHandler 호출");

        Map<String, String> map = new HashMap<>();
        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("message", "에러 발생");

        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }
    */

    @PostMapping(value = "/product/exception")
    public void exceptionTest2() throws AlbymongException {
        throw new AlbymongException(ExceptionClass.PRODUCT, HttpStatus.FORBIDDEN, "접근이 금지되었습니다.");
    }

}
