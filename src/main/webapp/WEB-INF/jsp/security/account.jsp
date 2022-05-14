12E<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:mainLayout title="Мой аккаунт">

    <form:form class="account-form" modelAttribute="user">

        <c:if test="${not empty message}">
            <div class="global-message alert-success">${message}</div>
        </c:if>

        <div class="row">

            <div class="col">
                <t:input label="Имя" path="firstName" disabled="true"> ${user.getFirstName()} </t:input>
            </div>

            <div class="col">
                <t:input label="Фамилия" path="secondName" disabled="true"> ${user.getSecondName()} </t:input>
            </div>

        </div>

        <div class="row">

            <div class="col">
                <t:input label="E-Mail" path="email" disabled="true"> ${user.getEmail()} </t:input>
            </div>

            <div class="col">
                <t:input label="Телефон" path="phone" disabled="true"> ${user.getPhone()} </t:input>
            </div>

        </div>

        <div class="d-grid gap-2">

            <a class="btn btn-primary btn-secondary" href="${spring:mvcUrl('AC#editIndex').build()}">Изменить данные</a>

            <a class="btn btn-primary btn-danger" href="<spring:url value="/logout" />">Выйти</a>

        </div>

    </form:form>

</t:mainLayout>
