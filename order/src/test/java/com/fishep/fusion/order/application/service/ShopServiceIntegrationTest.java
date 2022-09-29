package com.fishep.fusion.order.application.service;

import com.fishep.fusion.common.type.*;
import com.fishep.fusion.order.application.cqe.PlaceOrderCommand;
import com.fishep.fusion.order.application.dto.OrderDTO;
import com.fishep.fusion.order.domain.entity.*;
import com.fishep.fusion.order.domain.producer.OrderMessageProducer;
import com.fishep.fusion.order.domain.repository.AccountRepository;
import com.fishep.fusion.order.domain.repository.OrderRepository;
import com.fishep.fusion.order.domain.repository.ProductRepository;
import com.fishep.fusion.order.domain.repository.StockRepository;
import com.fishep.fusion.order.domain.service.ExchangeRateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ShopServiceIntegrationTest {

//    @MockBean
//    AccountRepository accountRepository;

//    @MockBean
//    OrderRepository orderRepository;

    @MockBean
    ProductRepository productRepository;

    @MockBean
    StockRepository stockRepository;

    @MockBean
    ExchangeRateService exchangeRateService;

    @MockBean
    OrderMessageProducer orderMessageProducer;

    @Autowired
    ShopService shopService;

    @Test
    void placeOrderTest() {

        Currency cny = new Currency("CNY");
        Currency usd = new Currency("USD");

        Product product1 = new Product(new ProductName("光模块1", Lang.zh_CN), new Money("CNY", 1));
        Product product2 = new Product(new ProductName("光模块2", Lang.zh_CN), new Money("CNY", 2));
        Product product3 = new Product(new ProductName("SFP3", Lang.en_US), new Money("USD", 1426));

//        Account account = new Account(new Money("CNY", 100));
        Account account = new Account(new AccountId(1572870916451594444L), new Money("CNY", 0));

        List<Stock> stocks = new ArrayList<>();
        Stock stock1 = new Stock(product1.getId(), new Quantity(Quantity.Unit.PCS, 10));
        Stock stock2 = new Stock(product2.getId(), new Quantity(Quantity.Unit.PCS, 20));
        stocks.add(stock1);
        stocks.add(stock2);

        List<OrderProduct> orderProducts = new ArrayList<>();
        orderProducts.add(new OrderProduct(product1.getId(), new Quantity(Quantity.Unit.PCS, 1), product1.getPrice()));
        orderProducts.add(new OrderProduct(product2.getId(), new Quantity(Quantity.Unit.PCS, 2), product2.getPrice()));

        ExchangeRate exchangeRate = new ExchangeRate(cny, cny, BigDecimal.ONE);

        // -------------------------------------------------------------------------------------------------------------

//        when(accountRepository.find(any(AccountId.class))).thenReturn(account);
//        assertEquals(account, accountRepository.find(account.getId()));
//        verify(accountRepository).find(account.getId());
//
//        when(accountRepository.save(any(Account.class))).thenReturn(Boolean.TRUE);
//        assertEquals(Boolean.TRUE, accountRepository.save(account));
//        verify(accountRepository).save(account);

//        when(orderRepository.save(any(Order.class))).thenReturn(Boolean.TRUE);
//        Order order = new Order(new Currency("CNY"), account.getId());
//        assertTrue(orderRepository.save(order));
//        verify(orderRepository).save(order);

        when(productRepository.flush(any(List.class))).thenReturn(orderProducts);
        assertNotNull(productRepository.flush(orderProducts));
        verify(productRepository).flush(orderProducts);

        when(stockRepository.find(any(List.class))).thenReturn(stocks);
        assertNotNull(stockRepository.find(orderProducts));
        verify(stockRepository).find(orderProducts);

        when(stockRepository.save(any(List.class))).thenReturn(Boolean.TRUE);
        assertTrue(stockRepository.save(stocks));
        verify(stockRepository).save(stocks);

        when(exchangeRateService.getExchangeRate(any(Currency.class), any(Currency.class))).thenReturn(exchangeRate);
        assertNotNull(exchangeRateService.getExchangeRate(cny, cny));
        verify(exchangeRateService).getExchangeRate(cny, cny);
        assertEquals(exchangeRateService.getExchangeRate(cny, cny).getRate(), BigDecimal.ONE);

        // -------------------------------------------------------------------------------------------------------------

        List<PlaceOrderCommand.Product> ps = new ArrayList<>();
        PlaceOrderCommand.Product p1 = new PlaceOrderCommand.Product(product1.getId().getValue(), "PCS", 1);
        PlaceOrderCommand.Product p2 = new PlaceOrderCommand.Product(product2.getId().getValue(), "PCS", 2);
        ps.add(p1);
        ps.add(p2);
        PlaceOrderCommand placeOrderCommand = new PlaceOrderCommand(account.getId().getValue(), "CNY", ps);

        OrderDTO orderDTO = shopService.placeOrder(placeOrderCommand);

        assertNotNull(orderDTO);
        assertEquals(5, orderDTO.getAmount().getValue());
//        assertEquals(95, account.getAmount().getValue());
        assertEquals(9, stock1.getCount().getValue());
        assertEquals(18, stock2.getCount().getValue());
    }
}