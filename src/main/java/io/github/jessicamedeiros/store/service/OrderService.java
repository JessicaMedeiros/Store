package io.github.jessicamedeiros.store.service;

import io.github.jessicamedeiros.store.enums.PaymentStatus;
import io.github.jessicamedeiros.store.model.LineItem;
import io.github.jessicamedeiros.store.model.payment.Order;
import io.github.jessicamedeiros.store.model.payment.Payment;
import io.github.jessicamedeiros.store.model.payment.PaymentByBoleto;
import io.github.jessicamedeiros.store.repository.LineItemRepository;
import io.github.jessicamedeiros.store.repository.OrderRepository;
import io.github.jessicamedeiros.store.repository.PaymentRepository;
import io.github.jessicamedeiros.store.repository.ProductRepository;
import io.github.jessicamedeiros.store.service.exceptions.ObjectNotFoundException;
import io.github.jessicamedeiros.store.service.validation.BoletoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private BoletoService boletoService;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private LineItemRepository lineItemRepository;

    public Order find(Integer id){
        Optional<Order> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Client não encontrado! Id: " + id + ", Tipo: " + Order.class.getName()));

    }

    public Order create(Order order){
        order.setId(null);
        order.setInstante(new Date());
        order.getPayment().setStatus(PaymentStatus.PENDENTE);
        order.getPayment().setOrder(order);
        if(order.getPayment() instanceof PaymentByBoleto){
            PaymentByBoleto pay = (PaymentByBoleto) order.getPayment();
            boletoService.fillOutPaymentByBoleto(pay, order.getInstante());
        }

        order = repository.save(order);
        paymentRepository.save(order.getPayment());
        for(LineItem i : order.getItems()){
            i.setDiscount(0.0);
            i.setPrice(productRepository.findById(i.getProduct().getId()).get().getPrice());
            i.setOrder(order);
        }
        lineItemRepository.saveAll(order.getItems());
        return order;
    }
}
