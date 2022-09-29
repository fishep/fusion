package com.fishep.fusion.product.interfaces.api;

import com.fishep.fusion.common.annotation.ResultHandler;
import com.fishep.fusion.common.response.Result;
import com.fishep.fusion.product.application.cqe.ProductQuery;
import com.fishep.fusion.product.application.dto.ProductDTO;
import com.fishep.fusion.product.application.service.ProductService;
import com.fishep.fusion.product.interfaces.converter.ProductConverter;
import com.fishep.fusion.product.interfaces.request.ProductRequest;
import com.fishep.fusion.product.interfaces.response.ProductResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Value("${server.port}")
    private String port;

    @Autowired
    ProductService productService;

    @Autowired
    ProductConverter productConverter;

    @ResultHandler
    @PostMapping("/products/query")
    public Result<List<ProductResponse>> list(@RequestBody ProductRequest request) {

        ProductQuery query = new ProductQuery(request.getId());

        List<ProductDTO> dtos = productService.query(query);

        List<ProductResponse> data = productConverter.toProductResponse(dtos);

        return new Result<>(200, "product query success!", data);
    }

}
