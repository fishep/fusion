package com.fishep.fusion.product.application.service;

import com.fishep.fusion.product.application.cqe.ProductQuery;
import com.fishep.fusion.product.application.dto.ProductDTO;

import javax.validation.Valid;
import java.util.List;

public interface ProductService {

    List<ProductDTO> query(@Valid ProductQuery query);

}
