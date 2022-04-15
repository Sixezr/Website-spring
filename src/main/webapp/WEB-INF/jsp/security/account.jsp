<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:mainLayout title="Мой аккаунт">

    <form:form class="account-form" modelAttribute="user">

        <div class="row">

            <div class="col">
                <t:input path="firstName" disabled="true"> ${user.getFirstName()} </t:input>
            </div>

            <div class="col">
                <t:input path="secondName" disabled="true"> ${user.getSecondName()} </t:input>
            </div>

        </div>

        <div class="row">

            <div class="col">
                <t:input path="email" disabled="true"> ${user.getEmail()} </t:input>
            </div>

            <div class="col">
                <t:input path="phone" disabled="true"> ${user.getPhone()} </t:input>
            </div>

        </div>

        <div class="d-grid gap-2">

            <a class="btn btn-primary btn-secondary" href="<spring:url value="/logout" />">Изменить данные</a>

            <a class="btn btn-primary btn-danger" href="<spring:url value="/logout" />">Выйти</a>

        </div>

    </form:form>

</t:mainLayout>
