package com.fishep.fusion.order.application.service;

import com.fishep.fusion.common.type.*;
import com.fishep.fusion.order.application.assembler.OrderAssembler;
import com.fishep.fusion.order.application.assembler.impl.OrderAssemblerImpl;
import com.fishep.fusion.order.application.cqe.PlaceOrderCommand;
import com.fishep.fusion.order.application.dto.OrderDTO;
import com.fishep.fusion.order.application.service.impl.ShopServiceImpl;
import com.fishep.fusion.order.domain.entity.*;
import com.fishep.fusion.order.domain.producer.OrderMessageProducer;
import com.fishep.fusion.order.domain.repository.AccountRepository;
import com.fishep.fusion.order.domain.repository.OrderRepository;
import com.fishep.fusion.order.domain.repository.ProductRepository;
import com.fishep.fusion.order.domain.repository.StockRepository;
import com.fishep.fusion.order.domain.service.ExchangeRateService;
import com.fishep.fusion.order.domain.service.OrderService;
import com.fishep.fusion.order.domain.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ShopServiceUnitTest {

    @Mock
    AccountRepository accountRepository;

    @Mock
    OrderRepository orderRepository;

    @Mock
    ProductRepository productRepository;

    @Mock
    StockRepository stockRepository;

    @Mock
    ExchangeRateService exchangeRateService;

    @Mock
    OrderMessageProducer orderMessageProducer;

    @Mock
    OrderService orderService = new OrderServiceImpl();

    @Mock
    OrderAssembler orderAssembler = new OrderAssemblerImpl();

    @InjectMocks
    ShopService shopService = new ShopServiceImpl();

    @Test
    void placeOrderTest() {

        Currency cny = new Currency("CNY");
        Currency usd = new Currency("USD");

        Product product1 = new Product(new ProductName("光模块1", Lang.zh_CN), new Money("CNY", 10000));
        Product product2 = new Product(new ProductName("光模块2", Lang.zh_CN), new Money("CNY", 20000));
        Product product3 = new Product(new ProductName("SFP3", Lang.en_US), new Money("USD", 1426));

        Account account = new Account(new Money("CNY", 100));

        List<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock(product1.getId(), new Quantity(Unit.PCS, 10)));
        stocks.add(new Stock(product2.getId(), new Quantity(Unit.PCS, 20)));

        List<OrderProduct> orderProducts = new ArrayList<>();
        orderProducts.add(new OrderProduct(product1.getId(), new Quantity(Unit.PCS, 1), product1.getPrice()));
        orderProducts.add(new OrderProduct(product2.getId(), new Quantity(Unit.PCS, 2), product2.getPrice()));

        ExchangeRate exchangeRate = new ExchangeRate(cny, cny, BigDecimal.ONE);

        // -------------------------------------------------------------------------------------------------------------

        when(accountRepository.find(any(AccountId.class))).thenReturn(account);
        assertEquals(account, accountRepository.find(account.getId()));
        verify(accountRepository).find(account.getId());

        when(accountRepository.save(any(Account.class))).thenReturn(Boolean.TRUE);
        assertEquals(Boolean.TRUE, accountRepository.save(account));
        verify(accountRepository).save(account);

        when(orderRepository.save(any(Order.class))).thenReturn(Boolean.TRUE);
        Order order = new Order(new Currency("CNY"), account.getId());
        assertTrue(orderRepository.save(order));
        verify(orderRepository).save(order);

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

        assertNull(orderDTO);
    }
}