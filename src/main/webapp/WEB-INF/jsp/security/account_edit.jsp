<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:mainLayout title="Мой аккаунт - Изменить">

    <form:form class="account-form" modelAttribute="accountEditForm">

        <div class="row">

            <div class="col">
                <t:input label="Имя" path="firstName" />
            </div>

            <div class="col">
                <t:input label="Фамилия" path="secondName" />
            </div>

        </div>

        <div class="row">

            <div class="col">
                <t:password label="Пароль" path="password" placeholder="Новый пароль" pattern="^.{8,}$" />
            </div>

            <div class="col">
                <t:input label="Телефон" path="phone" pattern="^((8|\+7)[\- ]?)?(\(?\d{3}\)?[\- ]?)?[\d\- ]{7,10}$" />
            </div>

        </div>

        <div class="d-grid gap-2">

            <button type="submit" class="btn btn-primary btn-success">Сохранить</button>

            <a class="btn btn-primary btn-dark" href="${spring:mvcUrl('AC#index').build()}">Отмена</a>

        </div>

    </form:form>

</t:mainLayout>
