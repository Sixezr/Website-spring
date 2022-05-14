package ru.sixzr.models.collections;

import ru.sixzr.models.Product;

import java.util.*;

public class CustomProductCollections implements ICustomProductCollection<Product> {

    private final List<Product> products;
    private final List<Integer> counterOfProducts;
    private int size;
    private int collectionCursor;

    public CustomProductCollections() {
        products = new ArrayList<>();
        counterOfProducts = new ArrayList<>();
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<Product> iterator() {
        return new CustomIterator();
    }

    @Override
    public int getCurrentIndex() {
        return collectionCursor;
    }

    @Override
    public int getCurrentProductCount() {
        return counterOfProducts.get(collectionCursor - 1);
    }

    @Override
    public double getCurrentPriceForProducts() {
        return products.get(collectionCursor - 1).getPrice() * counterOfProducts.get(collectionCursor - 1);
    }

    @Override
    public boolean add(Product productModel) {
        for (int i = 0; i < size; i++) {
            if (products.get(i).equals(productModel)) {
                counterOfProducts.set(i, counterOfProducts.get(i) + 1);
                return true;
            }
        }
        products.add(productModel);
        counterOfProducts.add(1);
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (products.get(i).equals(o)) {
                if (counterOfProducts.get(i) > 1) {
                    counterOfProducts.set(i, counterOfProducts.get(i) - 1);
                } else {
                    products.remove(i);
                    counterOfProducts.remove(i);
                    size--;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeProductById(long id) {
        for (int i = 0; i < size; i++) {
            if (products.get(i).getId() == id) {
                if (counterOfProducts.get(i) > 1) {
                    counterOfProducts.set(i, counterOfProducts.get(i) - 1);
                } else {
                    products.remove(i);
                    counterOfProducts.remove(i);
                    size--;
                }
                return;
            }
        }
    }

    @Override
    public void clear() {
        size = 0;
        products.clear();
        counterOfProducts.clear();
    }

    @Override
    public String toString() {
        return "CustomProductCollections{" +
                "products=" + products +
                ", counterOfProducts=" + counterOfProducts +
                ", size=" + size +
                ", collectionCursor=" + collectionCursor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomProductCollections products1 = (CustomProductCollections) o;
        return size == products1.size && collectionCursor == products1.collectionCursor && Objects.equals(products, products1.products) && Objects.equals(counterOfProducts, products1.counterOfProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products, counterOfProducts, size, collectionCursor);
    }

    // Unsupported operations
    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends Product> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    class CustomIterator implements Iterator<Product> {
        private int cursor;

        public CustomIterator() {
            cursor = 0;
            collectionCursor = 0;
        }

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public Product next() {
            if (cursor >= size) {
                throw new IndexOutOfBoundsException("There aren't any elements");
            }
            collectionCursor++;
            return products.get(cursor++);
        }
    }
}
