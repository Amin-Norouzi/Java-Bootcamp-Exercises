package com.aminnorouzi.banksystem.application;

import java.math.BigDecimal;

public interface Chargeable {
    void buyCharge(BigDecimal amount);
}
