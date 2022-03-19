package com.example.exercise9.controller;

import com.example.exercise9.model.Deposit;
import com.example.exercise9.model.Status;
import com.example.exercise9.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/app/v1/deposit")
public class DepositController {

    @Autowired
    private DepositService depositService;

    @PostMapping("/create")
    public Deposit createDeposit(@RequestParam("customerId") Long customerId,
                                 @RequestParam("balance") BigDecimal balance) {
        return depositService.createDeposit(customerId, balance);
    }

    @PostMapping("/change-status")
    public Deposit changeStatus(@RequestParam("id") Long id,
                                @RequestParam("status") Status status) {
        return depositService.changeStatus(id, status);
    }

    @PostMapping("/delete")
    public void deleteDeposit(@RequestParam("id") Long id) {
        depositService.deleteDeposit(id);
    }

    @GetMapping("/balance")
    public BigDecimal showBalance(@RequestParam("id") Long id) {
        return depositService.showBalance(id);
    }

    @GetMapping("/list")
    public List<Deposit> showDepositsList(@RequestParam("customerId") Long customerId) {
        return depositService.showDepositsList(customerId);
    }

    @PostMapping("/transfer")
    public Deposit transferAmount(@RequestParam("id") Long id,
                                  @RequestParam("amount") BigDecimal amount,
                                  @RequestParam("receiverId") Long receiverId) {
        return depositService.transferAmount(id, amount, receiverId);
    }
}
