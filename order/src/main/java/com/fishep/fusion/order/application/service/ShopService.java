package com.fishep.fusion.order.application.service;

import com.fishep.fusion.order.application.cqe.PlaceOrderCommand;
import com.fishep.fusion.order.application.dto.OrderDTO;

import javax.validation.Valid;

public interface ShopService {

    OrderDTO placeOrder(@Valid PlaceOrderCommand placeOrderCommand);

}
