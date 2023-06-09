package net.nvsoftware.iOrderService.controller;

import net.nvsoftware.iOrderService.model.OrderRequest;
import net.nvsoftware.iOrderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")

public class OrderController {
    @Autowired
    private OrderService orderService;

    //placeOrder(): use other microservice, get in order id in long
    @PostMapping("/placeOrder")
    public ResponseEntity<Long> placeOrder(@RequestBody OrderRequest orderRequest){
        long orderId = orderService.placeOrder(orderRequest);
        return new ResponseEntity<>(orderId, HttpStatus.OK);

    }
}
