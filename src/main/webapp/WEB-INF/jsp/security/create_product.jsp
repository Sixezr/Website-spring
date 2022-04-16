<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:mainLayout title="Добавить">
    <div class="container">
        <form:form enctype="multipart/form-data" cssClass="product-form" method="post" modelAttribute="productForm">

            <h3>Добавить товар</h3>

            <div class="mb-3">
                <t:input label="Введите название" path="name" required="true" />
            </div>

            <div class="mb-3">
                <t:input label="Введите цену" path="price" required="true" />
            </div>

            <div class="mb-3">
                <label for="photo" class="form-label">Выберите фотографию</label>
                <input class="form-control" id="photo" type="file" name="file" accept="image/*,image/jpeg" required>
            </div>

            <c:if test="${message != null}">
                <div class="alert-success">Продукт сохранен</div>
                <br>
            </c:if>

            <input type="submit" value="Добавить">

        </form:form>

</t:mainLayout>
