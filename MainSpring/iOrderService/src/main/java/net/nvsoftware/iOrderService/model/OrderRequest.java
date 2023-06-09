package net.nvsoftware.iOrderService.model;

import lombok.Data;

@Data
public class OrderRequest {

    private long productId;
    private long orderQuantity;
    private long totalAmount;
    //enum mode of the payment method, all capitalized
    private PaymentMode paymentMode;


}
