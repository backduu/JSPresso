<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css' />" />
</head>


<body>
<tiles:insertAttribute name="header"/>
    <div>
        <%-- 	<aside>
                    <tiles:insertAttribute name="side"/>
                </aside>
         --%>
        <div class="content">
            <div class="content-area">
                <tiles:insertAttribute name="body"/>
            </div>
        </div>
    </div>
<tiles:insertAttribute name="footer"/>
</body>
</html>
