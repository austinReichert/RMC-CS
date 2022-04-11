<!DOCTYPE html>
<html>
<head>
    <title>
    Watched Records Creation
    </title>
</head>

<style>
    body{
        background: #edf2f7;
    }
    h2, h1 {
        text-align: center;
    }
    form {
        text-align: center;
        margin-left: auto;
        margin-right: auto;
    }

</style>
<body>

<h1>Watched Records Creation</h1>
<br>
<form method="post" action="{{ route('watched.store') }}">
    @csrf
    <p> Enter new people id: <input name="people_id"/>
    <p> Enter new movie id: <input name="movie_id"/>
    <p> Enter how many stars they voted: <input name="stars" />
    <p> Enter their comment: <input name="comments" />
    <button type="submit">Save</button>
</form>
</body>
</html>
