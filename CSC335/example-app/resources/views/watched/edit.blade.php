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
    <p> Enter the persons id <input name="people_id"/>
    <p> Enter the movies id <input name="movies_id"/>
    <p> Enter how many stars they voted: <input name="stars" />
    <p> Enter their comment: <input name="comments" />
    <button type="submit">Save</button>
</form>
</body>
</html>
