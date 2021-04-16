<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<body>
<form action="/save" method="post">
    <label>Movie ID</label><br>
    <input type="number" name="movieID" value="${selectedMovies.getMovieID()}" readonly>
    <br>
    <label>Name</label>
    <br>
    <input type="text" name="name" value="${selectedMovies.getName()}"><br>
    <label>Release Year</label>
    <br>
    <input type="text" name="release_year" value="${selectedMovies.getRelease_year()}"><br>
    <label>Rating</label>
    <br>
    <input type="text" name="rating" value="${selectedMovies.getRating()}"><br>
    <label>Genre</label>
    <br>
    <input type="text" name="genre" value="${selectedMovies.getGenre()}"><br>
    <label>Description</label>
    <br>
    <input type="text" name="description" value="${selectedMovies.getDescription()}"><br>
    <input type="submit" value="Save"><br>
</form>
</body>
</html>