package com.fishep.fusion.product.application.assembler.impl;

import com.fishep.fusion.product.application.assembler.ProductAssembler;
import com.fishep.fusion.product.application.dto.ProductDTO;
import com.fishep.fusion.product.domain.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductAssemblerImpl implements ProductAssembler {

    @Override
    public List<ProductDTO> toProductDTO(List<Product> products) {

        List<ProductDTO> pds = new ArrayList<>();

        for (Product p : products) {
            pds.add(
                    new ProductDTO(
                            p.getId(),
                            p.getName(),
                            p.getPrice(),
                            p.getUnit(),
                            p.getCreatedAt(),
                            p.getUpdatedAt()
                    )
            );
        }

        return pds;
    }
}
