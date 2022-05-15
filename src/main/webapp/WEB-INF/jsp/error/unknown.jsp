<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>

<t:mainLayout title="Ошибка">
    <div class="container not-found">
        Ошибка, повторите попытку позже
        <img src="<c:url value = "/img/not-found.png"/>" alt="logo" width="160" height="160">
    </div>
</t:mainLayout>
