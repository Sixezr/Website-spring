<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div class="container">
  <footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
    <div class="col-md-4 d-flex align-items-center">
      <span class="text-muted">&copy; 2021 Официальный сайт ресторана «Myaso».</span>
    </div>

    <ul class="nav col-md-4 justify-content-end list-unstyled d-flex">
      <li class="ms-3"><a class="text-muted" href="#"><img src="<c:url value="/img/vk-logo.png"/>" alt="vk"
                                                           width="32" height="32"></a></li>
      <li class="ms-3"><a class="text-muted" href="#"><img src="<c:url value="/img/tg-logo.png"/>" alt="tg"
                                                           width="32" height="32"></a></li>
      <li class="ms-3"><a class="text-muted" href="#"><img src="<c:url value="/img/insta-logo.png"/>" alt="insta"
                                                           width="32" height="32"></a></li>
    </ul>
  </footer>
</div>
