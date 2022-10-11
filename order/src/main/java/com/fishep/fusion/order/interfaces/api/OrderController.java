package com.fishep.fusion.order.interfaces.api;

import com.fishep.fusion.common.annotation.ResultHandler;
import com.fishep.fusion.common.response.Result;
import com.fishep.fusion.common.type.AccountId;
import com.fishep.fusion.common.type.Currency;
import com.fishep.fusion.common.type.ProductId;
import com.fishep.fusion.common.type.Quantity;
import com.fishep.fusion.order.application.cqe.PlaceOrderCommand;
import com.fishep.fusion.order.application.dto.OrderDTO;
import com.fishep.fusion.order.application.service.ShopService;
import com.fishep.fusion.order.interfaces.converter.OrderConverter;
import com.fishep.fusion.order.interfaces.request.CreateOrderRequest;
import com.fishep.fusion.order.interfaces.response.CreateOrderResponse;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    ShopService shopService;

    @Autowired
    OrderConverter orderConverter;

    @ResultHandler
    @PostMapping("/orders")
    public Result<CreateOrderResponse> one(@RequestBody CreateOrderRequest request){

        List<PlaceOrderCommand.Product> products = new ArrayList<>();
        for (CreateOrderRequest.Product p : request.getProducts()){
            products.add(new PlaceOrderCommand.Product(new ProductId(p.getId()), new Quantity(p.getUnit(), p.getCount())));
        }

        PlaceOrderCommand command = new PlaceOrderCommand(new AccountId(request.getAccountId()), new Currency(request.getCurrency()), products);

        OrderDTO orderDTO = shopService.placeOrder(command);

        CreateOrderResponse data = orderConverter.toCreateOrderResponse(orderDTO);

        return new Result<>(200, "Create Order Response", data);
    }

}
