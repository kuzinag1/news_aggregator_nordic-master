package ru.newsfront.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class AtomicIntegerService {
    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    public AtomicInteger increment() {
        return new AtomicInteger(atomicInteger.incrementAndGet());
    }
    public AtomicInteger decrement() {
        return new AtomicInteger(atomicInteger.decrementAndGet());
    }

    public void setAtomicIntegerDefaultValue() {
        atomicInteger.set(0);
    }
}
