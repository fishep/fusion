package com.fishep.fusion.order.domain.service;

import com.fishep.fusion.common.type.ExchangeRate;
import com.fishep.fusion.order.domain.entity.Account;
import com.fishep.fusion.order.domain.entity.Order;
import com.fishep.fusion.order.domain.entity.Stock;

import java.util.List;

public interface OrderService {

    Boolean generate(Order order, Account account, ExchangeRate exchangeRate, List<Stock> stocks);

}
