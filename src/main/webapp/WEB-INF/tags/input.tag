<%@tag description="Extended input tag to allow for sophisticated errors and Bootstrap theming" pageEncoding="UTF-8"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@attribute name="path" required="true" type="java.lang.String"%>
<%@attribute name="cssClass" required="false" type="java.lang.String"%>
<%@attribute name="label" required="false" type="java.lang.String"%>
<%@attribute name="pattern" required="false" type="java.lang.String"%>
<%@attribute name="required" required="false" type="java.lang.Boolean"%>


<div class="mb-3${status.error ? ' has-error' : '' }">
    <c:if test="${empty label}">
        <c:set var="label" value="${fn:toUpperCase(fn:substring(path, 0, 1))}${fn:toLowerCase(fn:substring(path, 1,fn:length(path)))}" />
    </c:if>

    <spring:bind path="${path}">

        <label class="control-label col-sm-3" for="${path}">${label} <span class="required">*</span> </label>

        <div class="mb-3">

            <form:input pattern="${pattern}" required="required" path="${path}" cssClass="${empty cssClass ? 'form-control' : cssClass}"/>

            <c:if test="${status.error}">
                <span class="help-block">${status.errorMessage}</span>

            </c:if>

        </div>


    </spring:bind>

</div>
