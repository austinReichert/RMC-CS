<!DOCTYPE html>
<html>
<head>
        <title>
        Watched Records Editing
        </title>
</head>

<style>
    body{
        background: #edf2f7;
    }
    h2, label {
        text-align: center;
    }
    form {
        text-align: center;
        margin-left: auto;
        margin-right: auto;
    }

</style>
<body>

<h1>Watched Records Editing</h1>
<br>
<form method="post" action="{{ route('watched.update', ['watched'=>$watched->id]) }}">
    @csrf
    @method('put')
    <p> Enter the persons id <input name="people_id" value="{{$watched->people_id}}"/>
    <p> Enter the movies id <input name="movie_id" value="{{$watched->movie_id}}"/>
    <p> Enter how many stars they voted: <input name="stars" value="{{$watched->stars}}"/>
    <p> Enter their comment: <input name="comments" value="{{$watched->comments}}"/>
    <button type="submit">Save</button>
</form>
</body>
</html>
