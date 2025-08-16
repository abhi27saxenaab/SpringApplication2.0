package com.BookStore.util;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class CustomIdGenerator implements IdentifierGenerator {

    private static int sequence = 1;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        synchronized (this) {
            int bookId = sequence;
            sequence += 2;
            return bookId;
        }
    }
}
