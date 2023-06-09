package net.nvsoftware.iProductService.controller;

import net.nvsoftware.iProductService.model.ProductRequest;
import net.nvsoftware.iProductService.model.ProductResponse;
import net.nvsoftware.iProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

//match controller: RestController
@RestController
//Match Service url: /products: all under this will related to this class
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    //add product (CRUD)
    @PostMapping
    public ResponseEntity<Long> createProduct(@RequestBody ProductRequest productRequest){
        //output:
        long productId = productService.createProduct(productRequest);
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }
    //read : get something out to repository, get ID from parse parameter
    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable long productId){
        ProductResponse productResponse = productService.getProductById(productId);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    //iOrderService
    @PutMapping("/reduceQuantity")//the service with function need to CALL reduce quantity again
    public ResponseEntity<Void> reduceQuantity(@RequestParam long productId, @RequestParam long quantity){
        productService.reduceQuantity(productId, quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
