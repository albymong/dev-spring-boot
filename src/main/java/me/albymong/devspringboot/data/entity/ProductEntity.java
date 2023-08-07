package me.albymong.devspringboot.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.albymong.devspringboot.data.dto.ProductDto;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Product") //테이블이름 자동생성
public class ProductEntity{

  @Id
  String productId;

  String productName;

  Integer productPrice;

  Integer productStock;

  /*
  @Column
  String sellerId;

  @Column
  String sellerPhoneNumber;
   */

  public ProductDto toDto(){
    return ProductDto.builder()
        .productId(productId)
        .productName(productName)
        .productPrice(productPrice)
        .productStock(productStock)
        .build();
  }

}
