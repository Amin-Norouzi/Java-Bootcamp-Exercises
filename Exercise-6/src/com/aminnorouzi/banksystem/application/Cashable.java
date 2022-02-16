package com.aminnorouzi.banksystem.application;

import java.math.BigDecimal;

public interface Cashable {
    void deposit(BigDecimal amount, String description);
    void withdraw(BigDecimal amount, String description);
}
