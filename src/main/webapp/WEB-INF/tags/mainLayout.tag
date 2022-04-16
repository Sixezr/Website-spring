<%@tag description="Default Layout Tag" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@attribute name="title" %>
<%@attribute name="jsUrl" type="java.lang.String" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>${title}</title>
  <link rel="shortcut icon" href="<spring:url value = "/img/logo.png"/>" type="image/x-icon">
  <link rel="stylesheet" href="<spring:url value = "/css/bootstrap.min.css"/>">
  <link rel="stylesheet" href="<spring:url value = "/css/style.css"/>">
  <c:if test="${jsUrl != null}">
    <script src="<spring:url value = "${jsUrl}"/>"></script>
  </c:if>
</head>
<body>

<jsp:include page="/WEB-INF/jsp/blocks/navigation.jsp"/>

<jsp:doBody/>

<jsp:include page="/WEB-INF/jsp/blocks/footer.jsp"/>

</body>
</html>
