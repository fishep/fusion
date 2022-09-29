package com.fishep.fusion.product.interfaces.converter;

import com.fishep.fusion.product.application.dto.ProductDTO;
import com.fishep.fusion.product.interfaces.response.ProductResponse;

import java.util.List;

public interface ProductConverter {

    List<ProductResponse> toProductResponse(List<ProductDTO> pDTOs);

}
