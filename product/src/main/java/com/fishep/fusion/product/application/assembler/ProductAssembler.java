package com.fishep.fusion.product.application.assembler;

import com.fishep.fusion.product.application.dto.ProductDTO;
import com.fishep.fusion.product.domain.entity.Product;

import java.util.List;

public interface ProductAssembler {

    List<ProductDTO> toProductDTO(List<Product> products);

}
