package com.fishep.fusion.order.domain.service.impl;

import com.fishep.fusion.common.type.ExchangeRate;
import com.fishep.fusion.common.type.Money;
import com.fishep.fusion.order.domain.entity.Account;
import com.fishep.fusion.order.domain.entity.Order;
import com.fishep.fusion.order.domain.entity.OrderProduct;
import com.fishep.fusion.order.domain.entity.Stock;
import com.fishep.fusion.order.domain.service.OrderService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class OrderServiceImpl implements OrderService {

    @Override
    public Boolean generate(Order order, Account account, ExchangeRate exchangeRate, List<Stock> stocks) {

        Money money = exchangeRate.exchange(order.getAmount());

        account.deduct(money);

        for (OrderProduct p : order.getProducts()){
            for (Stock s : stocks){
                if (Objects.equals(s.getProductId().getValue(), p.getProductId().getValue())){
                    s.deduct(p.getCount());
                }
            }
        }

        return Boolean.TRUE;
    }
}
