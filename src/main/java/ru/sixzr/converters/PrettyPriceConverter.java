package ru.sixzr.converters;

import org.springframework.core.convert.converter.Converter;

public class PrettyPriceConverter implements Converter<Double, String>{

    @Override
    public String convert(Double price) {
        if (price > 1_000) {
            String convertedPrice = String.valueOf(Math.round(price));
            return convertedPrice.substring(0, convertedPrice.length() - 3)
                    + " "
                    + convertedPrice.substring(convertedPrice.length() - 3);
        }
        return String.valueOf(price);
    }
}
