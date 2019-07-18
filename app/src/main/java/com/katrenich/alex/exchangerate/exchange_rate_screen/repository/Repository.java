package com.katrenich.alex.exchangerate.exchange_rate_screen.repository;

public interface Repository<T, V> {

    void loadData(V... vs);

    T getData();
}
