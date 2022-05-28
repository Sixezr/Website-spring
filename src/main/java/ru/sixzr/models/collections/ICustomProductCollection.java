package ru.sixzr.models.collections;

import java.util.Collection;

public interface ICustomProductCollection<T> extends Collection<T> {
    int getCurrentIndex();

    int getCurrentProductCount();

    double getCurrentPriceForProducts();

    void removeProductById(long id);
}
