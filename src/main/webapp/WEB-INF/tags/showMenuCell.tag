<%@tag description="Default Layout Tag" pageEncoding="UTF-8" %>
<%@attribute name="product" type="ru.sixzr.models.Product" required="true" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="col">
    <div class="card shadow-sm">
        <img src="<spring:url value = "/img/products/${product.getImage()}"/>" alt="${product.getName()}" width="100%"
             height="200px">
        <div class="card-body">
            <p>${product.getName()}</p>
            <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                    <form class="add-product-from" method="POST">
                        <input name="product_id" value="${product.getId()}" hidden>
                        <button type="submit" class="btn btn-sm btn-outline-secondary" name="action"
                                value="add">В корзину
                        </button>
                    </form>

                        <form action="<spring:url value="/menu/change"/>">
                            <input name="product_id" value="${product.getId()}" hidden>
                            <button type="submit" name="action" value="change"
                                    class="btn btn-sm btn-outline-secondary">Изменить
                            </button>
                        </form>

                </div>
                <small class="text-muted">${product.getPrice()} р</small>
            </div>
        </div>
    </div>
</div>

