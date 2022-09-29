package com.fishep.fusion.product.application.service.impl;

import com.fishep.fusion.common.type.ProductId;
import com.fishep.fusion.product.application.assembler.ProductAssembler;
import com.fishep.fusion.product.application.cqe.ProductQuery;
import com.fishep.fusion.product.application.dto.ProductDTO;
import com.fishep.fusion.product.application.service.ProductService;
import com.fishep.fusion.product.domain.entity.Product;
import com.fishep.fusion.product.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Component
@Validated
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductAssembler productAssembler;

    @Override
    public List<ProductDTO> query(@Valid ProductQuery query) {

        List<ProductId> pids = new ArrayList<>();
        for (Long id : query.getId()){
            pids.add(
                    new ProductId(id)
            );
        }

        List<Product> products = productRepository.find(pids);

        List<ProductDTO> pDTOs = productAssembler.toProductDTO(products);

        return pDTOs;
    }
}
