<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:mainLayout title="Меню" jsUrl="/js/scripts.js">

    <div class="album py-5">

        <div class="container">

            <c:if test="${not empty message}">
                <div class="global-message alert-success">${message}</div>
            </c:if>

            <sec:authorize access="isAuthenticated()">
              <sec:authorize access="hasAuthority('ROLE_ADMIN')">
                  <a href="${spring:mvcUrl('MC#createIndex').build()}" class="btn btn-secondary" > Добавить товар</a>
                </sec:authorize>
            </sec:authorize>

            <c:if test="${!products.isEmpty()}">

                <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">

                    <c:forEach items="${products}" var="product">
                        <t:showMenuCell product="${product}"/>
                    </c:forEach>

                </div>

            </c:if>

            <c:if test="${products.isEmpty()}">
                <p class="fs-1 fst-italic">Пока здесть пусто :с <img src="<c:url value="/img/logo.png"/>" width="100" height="100" alt="logo"></p>
            </c:if>
        </div>

    </div>

</t:mainLayout>
