<%@tag description="Extended password tag to allow for sophisticated errors and Bootstrap theming" pageEncoding="UTF-8"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@attribute name="path" required="true" type="java.lang.String"%>
<%@attribute name="cssClass" required="false" type="java.lang.String"%>
<%@attribute name="label" required="false" type="java.lang.String"%>
<%@attribute name="pattern" required="false" type="java.lang.String"%>


<div class="mb-3">

    <spring:bind path="${path}">

        <div class="form-group${status.error ? ' has-error' : '' }">

            <label class="control-label col-sm-3" for="${path}">${label} </label>

            <div class="mb-3">

                <form:password pattern="${pattern}" required="required" path="${path}" cssClass="${empty cssClass ? 'form-control' : cssClass}"/>

                <c:if test="${status.error}">
                    <span class="help-block">${status.errorMessage}</span>
                </c:if>

            </div>

        </div>

    </spring:bind>

</div>

