<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:mainLayout title="Регистрация">

    <div class="container">

        <form:form class="register-form" method="POST" modelAttribute="user">

            <div id="reg-title">Регистрация</div>

            <t:input label="Имя" path="firstName" />

            <t:input label="Фамилия" path="secondName" />

            <t:input label="Номер телефона" path="phone" pattern="^((8|\+7)[\- ]?)?(\(?\d{3}\)?[\- ]?)?[\d\- ]{7,10}$" />

            <div class="mb-3">
                <t:input label="E-Mail" path="email" pattern="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$"/>
                <div id="emailHelp" class="form-text">Никто не узнает ваши данные</div>
            </div>

            <div class="mb-3">
                <t:password label="Пароль" path="password" pattern="^.{8,}$" />
            </div>

            <button type="submit" class="submit-button">Зарегестрироваться</button>

        </form:form>

    </div>




</t:mainLayout>
