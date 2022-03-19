package com.example.exercise9.service;

import com.example.exercise9.model.Deposit;
import com.example.exercise9.model.Status;
import com.example.exercise9.repository.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DepositService {

    @Autowired
    private DepositRepository depositRepository;

    public Deposit createDeposit(Long customerId, BigDecimal balance) {
        Deposit deposit = new Deposit();
        deposit.setCustomerId(customerId);
        deposit.setBalance(balance);
        deposit.setStatus(Status.OPEN);
        return depositRepository.save(deposit);
    }

    public Deposit changeStatus(Long id, Status status) {
        Deposit deposit = findDepositById(id);
        deposit.setStatus(status);
        return depositRepository.save(deposit);
    }

    public void deleteDeposit(Long id) {
        Deposit deposit = findDepositById(id);
        depositRepository.delete(deposit);
    }

    public BigDecimal showBalance(Long id) {
        Deposit deposit = findDepositById(id);
        return deposit.getBalance();
    }

    public List<Deposit> showDepositsList(Long customerId) {
        return depositRepository.findAllByCustomerId(customerId);
    }

    @Transactional
    public Deposit transferAmount(Long id, BigDecimal amount, Long receiverId) {
        updateBalance(findDepositById(receiverId), amount);
        return updateBalance(findDepositById(id), amount.negate());
    }

    private Deposit updateBalance(Deposit deposit, BigDecimal amount) {
        deposit.setBalance(deposit.getBalance().add(amount));
        return depositRepository.save(deposit);
    }

    private Deposit findDepositById(Long id) {
        return depositRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Deposit: " + id + " not found!"));
    }
}
