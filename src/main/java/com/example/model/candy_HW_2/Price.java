package com.example.model.candy_HW_2;

import java.math.BigDecimal;
import java.util.StringJoiner;

/**
 * @author Nadia  Filatova
 * @since 5/13/23
 */

public class Price {
    private BigDecimal amount;
    private Currency currency;

    public Price() {
    }

    public Price(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Price.class.getSimpleName() + "[", "]")
           .add("amount=" + amount)
           .add("currency=" + currency)
           .toString();
    }
}
