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
    <p> Add a person:
        <select name="people_id">
            @foreach($people as $person)
                <option value="{{ $person->id }}">{{ $person->name }}</option>
            @endforeach
        </select>
    <p> Add a movie:
        <select name="movie_id">
            @foreach($movies as $movie)
                <option value="{{ $movie->id }}">{{ $movie->title }}</option>
            @endforeach
        </select>
    <p> Enter stars voted: <select name="stars">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
    </select>
    <p> Enter their comment: <input name="comments"/>
    <button type="submit">Save</button>

    @error('comments')
        <br>
        <h1><u>ERROR</u></h1>
            <h3><b>Enter a correct sized comment!</b></h3>
    @enderror
</form>
</body>
</html>
