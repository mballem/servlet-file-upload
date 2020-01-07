<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>List Of Files</title>
</head>
<body>
<h3>List of Files | <a href="index.html">Home</a></h3>

<h2>${requestScope.message}</h2>
<c:if test="${!empty fileEntities}">
<table>
    <tr bgcolor=#f5f5dc>
        <th align="center" width="80px">File</th>
        <th align="center" width="150px">File ContentType</th>
        <th align="center" width="150px">File Year</th>
        <th align="center" width="150px">File Month</th>
        <th align="center" width="150px">File Name</th>
    </tr>
    <c:forEach items="${fileEntities}" var="file" varStatus="id">
        <tr bgcolor="#${id.count % 2 != 0 ? 'f0f8ff' : 'ffffff' }">
            <td align="center" width="100px">
                <a href="<c:url value="load?year=${file.year}&month=${file.month}&name=${file.name}"/>">
                    <c:choose>
                        <c:when test="${file.type eq 'application/pdf'}">
                            <img width="30" height="30"
                                 src="<c:url value="/image/pdf.png"/>"
                                 title="Download - ${file.name}"
                                 border="1"/>
                        </c:when>
                        <c:when test="${file.type eq 'application/octet-stream'}">
                            <img width="30" height="30"
                                 src="<c:url value="/image/rar.jpg"/>"
                                 title="Download - ${file.name}"
                                 border="1"/>
                        </c:when>
                        <c:when test="${file.type eq 'application/msword'}">
                            <img width="30" height="30"
                                 src="<c:url value="/image/doc.jpg"/>"
                                 title="Download - ${file.name}"
                                 border="1"/>
                        </c:when>
                        <c:otherwise>
                            <img width="30" height="30"
                                 src="<c:url value="/load?year=${file.year}&month=${file.month}&name=${file.name}"/>"
                                 title="Download - ${file.name}"
                                 border="1"/>
                        </c:otherwise>
                    </c:choose>
                </a>
            </td>
            <td align="center" width="150px"><c:out value="${file.type}"/></td>
            <td align="center" width="150px"><c:out value="${file.year}"/></td>
            <td align="center" width="150px"><c:out value="${file.month}"/></td>
            <td align="center" width="150px"><c:out value="${file.name}"/></td>
        </tr>
    </c:forEach>
</table>
</c:if>
</body>
</html>