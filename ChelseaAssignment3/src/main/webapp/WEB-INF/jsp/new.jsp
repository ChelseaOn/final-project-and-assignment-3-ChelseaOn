<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Movies Database</title>
</head>
<body>
<table>
    <tr>
        <th>Movie ID</th>
        <th>Movie Name</th>
        <th>Release Year</th>
        <th>Rating</th>
        <th>Genre</th>
        <th>Description</th>

    </tr>
    <c:forEach var="m" items="${movies}">
        <tr>
            <td>${m.getmovieID()}</td>
            <td>${m.getName()}</td>
            <td>${m.getRelease_year()}</td>
            <td>${m.getRating()}</td>
            <td>${m.getGenre()}</td>
            <td>${m.getDescription}</td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
