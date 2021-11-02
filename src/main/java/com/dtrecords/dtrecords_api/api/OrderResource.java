package com.dtrecords.dtrecords_api.api;

import com.dtrecords.dtrecords_api.domain.Cart;
import com.dtrecords.dtrecords_api.domain.Order;
import com.dtrecords.dtrecords_api.service.OrderService;
import com.dtrecords.dtrecords_api.service.VinylService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
class CustomerInformation {
    private String customerName;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;
}

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderResource {
    private final VinylService vinylService;
    private final OrderService orderService;
    ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping(value = "/ProceedToCheckout")
    public ResponseEntity<Void> ConfirmOrder(@RequestParam("customerInformation") String customerInformationJson, @RequestParam("cart") String cartJson, UriComponentsBuilder ucBuilder) throws JsonProcessingException {
        List<Cart> cartList = objectMapper.readValue(cartJson, new TypeReference<List<Cart>>() {});
        Cart firstCart = cartList.iterator().next();
        CustomerInformation customer = objectMapper.readValue(customerInformationJson, CustomerInformation.class);
        System.out.println(customer.getCustomerName());
        Long OrderId = null;
//        float totalPrice = 0;
        for (final Cart cart: cartList) {
            Order order = new Order();
            order.setCustomerName(customer.getCustomerName());
            order.setCustomerPhone(customer.getCustomerPhone());
            order.setCustomerEmail(customer.getCustomerEmail());
            order.setCustomerAddress(customer.getCustomerAddress());
            order.setPrice((float) Math.round((cart.getVinyl().getRealPrice()*cart.getQuantity()) * 100)/100);
            order.setDelivery("Đang xử lý");
            order.setDateTime(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
            order.setVinyl(cart.getVinyl());
            order.setQuantity(cart.getQuantity());
            System.out.println("cartprev");
            System.out.println(cart.getVinyl().getQuantity());
            cart.getVinyl().setQuantity(cart.getVinyl().getQuantity() - cart.getQuantity());
            System.out.println("cartnew");
            System.out.println(cart.getVinyl().getQuantity());
            vinylService.save(cart.getVinyl());
            if (cart == firstCart) {
                orderService.save(order);
                OrderId = order.getId();
            }
            order.setOrderCode(DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(LocalDateTime.now())+OrderId);
            orderService.save(order);
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
