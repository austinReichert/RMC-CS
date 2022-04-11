<!DOCTYPE html>
<html>
<head>
    <title>
    Movie Creation
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

<h1>Movie Creation</h1>
<br>
<form method="post" action="{{ route('movie.store') }}">
    @csrf
    Enter the movies title: <input name="title" />
    <p>Enter the year the movie was released: <input name="releaseyear"/>
    <p>Enter the movies rating: <input name="rating"/>
    <button type="submit">Save</button>
</form>
</body>
</html>
