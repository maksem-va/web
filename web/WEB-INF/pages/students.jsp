<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>

    <title>Students</title>

</head>
<body>

<div class="container">
    <table>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Group Name</th>
        </tr>
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.firstName}</td>
                <td>${student.lastName}</td>
                <td>${student.group}</td>
            </tr>
        </c:forEach>

    </table>



</div>

</body>
</html>