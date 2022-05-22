<%@tag description="Default Layout Tag" pageEncoding="UTF-8" %>
<%@attribute name="product" type="ru.sixzr.models.Product" required="true" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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

                    <sec:authorize access="isAuthenticated()">
                        <sec:authorize access="hasAuthority('ROLE_ADMIN')">
                            <a href="<spring:url value="/menu/edit/${product.getId()}"/>" class="btn btn-sm btn-outline-secondary">Изменить</a>
                        </sec:authorize>
                    </sec:authorize>

                </div>
                <small class="text-muted">${product.getFormattedPrice()} р</small>
            </div>
        </div>
    </div>
</div>

