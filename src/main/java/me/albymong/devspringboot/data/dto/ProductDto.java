package me.albymong.devspringboot.data.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import me.albymong.devspringboot.data.entity.ProductEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDto {

  //@Size(min=8, max=15)
  @NotNull
  private String productId;

  @NotNull
  private String productName;

  @NotNull
  @Min(value = 500)
  @Max(value = 3000000)
  private int productPrice;
  
  @NotNull
  @Min(value = 0)
  @Max(value = 9999)
  private int productStock;

  public ProductEntity toEntity(){
    return ProductEntity.builder()
        .productId(productId)
        .productName(productName)
        .productPrice(productPrice)
        .productStock(productStock)
        .build();
  }

}
