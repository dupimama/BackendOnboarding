package net.nvsoftware.iOrderService.service;

import lombok.extern.log4j.Log4j2;
import net.nvsoftware.iOrderService.entity.OrderEntity;
import net.nvsoftware.iOrderService.model.OrderRequest;
import net.nvsoftware.iOrderService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService{
    //update on order table
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public long placeOrder(OrderRequest orderRequest) {//TODO: make this method as transaction


        //call order service(this) to create order entity with status CREATED, save to orderDB
        log.info("OrderService placeOrder - save to orderdb start");
        OrderEntity orderEntity = OrderEntity.builder()
                .productId(orderRequest.getProductId())
                .orderQuantity(orderRequest.getOrderQuantity())
                .totalAmount(orderRequest.getTotalAmount())
                .orderDate(Instant.now())   //server received request time
                .orderStatus("CREATED")
                .paymentMode(orderRequest.getPaymentMode().name())
                .build();
        orderEntity = orderRepository.save(orderEntity);    //cache the result
        log.info("OrderService placeOrder - save to orderdb done");

        //Call ProductService to check quantity and reduceQuantity if ok


        //Call PaymentService to charge paymentMode, mark order COMPLETED if success, otherwise mark CANCELLED

        return orderEntity.getOrderId();
    }
}
