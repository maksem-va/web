<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>

    <title>Groups</title>

</head>
<body>

<div class="container">
    <table>
        <tr>
            <th>Number</th>
            <th>Name</th>
        </tr>
        <c:forEach items="${groups}" var="group">
            <tr>
                <td>${group.number}</td>
                <td>${group.name}</td>
            </tr>
        </c:forEach>

    </table>



</div>

</body>
</html>
