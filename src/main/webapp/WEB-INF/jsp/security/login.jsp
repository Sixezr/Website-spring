<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:mainLayout title="Вход">

    <div class="container">

        <form:form class="register-form" method="POST" modelAttribute="loginForm">

            <t:input label="E-Mail" path="email" pattern="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$"/>

            <div id="emailHelp" class="form-text">Никто не узнает ваши данные</div>

            <t:password label="Пароль" path="password" pattern="^.{8,}$"/>

            <c:if test="${error != null}">
                <div id="error">Неверный E-Mail или пароль.</div>
            </c:if>

            <div><a href="${spring:mvcUrl('RC#index').build()}" id="register-href">Нет аккаунта? Создайте его!</a></div>

            <div>
                <input type="checkbox" id="remember" name="rememberMe">
                <label for="remember">Запомнить меня</label>
            </div>

            <button type="submit" class="submit-button">Войти</button>

        </form:form>

    </div>

</t:mainLayout>
