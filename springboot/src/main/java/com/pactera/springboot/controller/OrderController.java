package com.pactera.springboot.controller;

import com.pactera.springboot.mapper.ProductMapper;
import com.pactera.springboot.model.Member;
import com.pactera.springboot.model.Order;
import com.pactera.springboot.model.Product;
import com.pactera.springboot.service.OrderService;
import com.pactera.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author Karen
 * @Date 2020/10/30 16:43
 * @DoSomeThing
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;

    /**
     * 下单前的页面跳转
     *
     * @return
     */
    @GetMapping("/toAddOrder")
    public String toAddOrder(Product product, Model model) {
        Product product1 = productService.findByPrimaryKey(product.getCode());
        model.addAttribute("product", product1);
        return "/order/addOrder";
    }

    @Transactional
    @PostMapping("/addOrder")
    public String addOrder(Order order, Model model) {
        Product product = productService.findByPrimaryKey(order.getProductCode());
        int i = product.getStockNumber() - order.getNumber();
        if (i < 0) {
            model.addAttribute("msg", "库存不足");
            model.addAttribute("product", product);
            model.addAttribute("order", order);
            return "/order/addOrder";
        }
        product.setStockNumber(i);

        productService.update(product);
        order.setName(order.getMemberName() + product.getName());
        order.setOrderNo(UUID.randomUUID().toString().replace("-", ""));
     //   System.out.println(order.getOrderNo().toString());
        order.setDateTime(new Date());
        order.setRemark(null);
        orderService.insert(order);
        return "redirect:/order/list/orders";
    }

    @GetMapping("/list/orders")
    public String listOrders(Model model, HttpServletRequest request) {
        Member member = (Member) request.getSession().getAttribute("member");
        List<Order> ordersByMemberName = orderService.findOrdersByMemberName(member.getName());
        model.addAttribute("order", ordersByMemberName);
        return "/order/listOrders";
    }


}
