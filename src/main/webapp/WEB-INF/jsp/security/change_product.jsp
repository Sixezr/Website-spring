<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:mainLayout title="Изменить">

    <form:form enctype="multipart/form-data" cssClass="product-form" method="post" modelAttribute="productForm">

        <c:if test="${not empty message}">
            <div class="global-message alert-success">${message}</div>
        </c:if>

        <div class="mb-3">
            <t:input label="Введите название" path="name" required="true" />
        </div>

        <div class="mb-3">
            <t:input label="Введите цену" path="price" required="true" />
        </div>

        <div class="mb-3">
            <label for="photo" class="form-label">Выберите новую фотографию</label>
            <input class="form-control" id="photo" type="file" name="file" accept="image/*,image/jpeg">
        </div>

        <div>
            <button type="submit" name="action" value="change" class="btn btn-outline-secondary">Изменить</button>
            <button type="submit" name="action" value="delete" class="btn btn-outline-danger">Удалить</button>
        </div>

    </form:form>

</t:mainLayout>
