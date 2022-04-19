<!DOCTYPE html>
<html>
<head>
    <title>
    Movies Editing
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

<h1>Movies Editing</h1>
<br>
<form method="post" action="{{ route('movie.update', ['movie'=>$movie->id]) }}">
    @csrf
    @method('put')
    Enter the movies title: <input name="title" value="{{$movie->title}}" />
    <p>Enter when the movie was released: <input name="releaseyear" value="{{$movie->releaseyear}}"/>
    <p>Enter the movies rating: <input name="rating" value="{{$movie->rating}}"/>
    <button type="submit">Save</button>

    @error('title')
        <br>
        <h1><u>ERROR</u></h1>
            <h3><b>Enter a correct title!</b></h3>
    @enderror
    @error('releaseyear')
        <br>
        <h1><u>ERROR</u></h1>
            <h3><b>Enter a correct release year!</b></h3>
    @enderror
    @error('rating')
        <br>
        <h1><u>ERROR</u></h1>
            <h3><b>Enter a correct rating!</b></h3>
    @enderror
</form>
</body>
</html>
