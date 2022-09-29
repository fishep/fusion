package com.fishep.fusion.product.interfaces.converter.impl;

import com.fishep.fusion.product.application.dto.ProductDTO;
import com.fishep.fusion.product.interfaces.converter.ProductConverter;
import com.fishep.fusion.product.interfaces.response.ProductResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductConverterImpl implements ProductConverter {

    @Override
    public List<ProductResponse> toProductResponse(List<ProductDTO> pDTOs) {

        List<ProductResponse> prs = new ArrayList<>();
        for (ProductDTO ps : pDTOs){
            ProductResponse pr = new ProductResponse();
            pr.setId(ps.getId().getValue());
            pr.setName(ps.getName());
            pr.setCurrency(ps.getPrice().getCurrency().getCodeName());
            pr.setPrice(ps.getPrice().getValue());
            pr.setUnit(ps.getUnit().name());
            pr.setCreatedAt(ps.getCreatedAt().toString());
            pr.setUpdatedAt(ps.getUpdatedAt().toString());

            prs.add(pr);
        }

        return prs;
    }
}
