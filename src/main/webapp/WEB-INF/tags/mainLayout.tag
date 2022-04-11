<%@tag description="Default Layout Tag" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@attribute name="title" %>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${title}</title>


    <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/css/style.css" />" rel="stylesheet">
  </head>
  <body>
    <jsp:include page="/WEB-INF/jsp/blocks/menu_main.jsp"/>
    <div class="container">
      <c:if test="${not empty message}">
        <div class="global-message ${empty messageClass ? '' :  messageClass}">${message}</div>
      </c:if>
      <jsp:doBody/>
    </div>
  </body>
</html>
