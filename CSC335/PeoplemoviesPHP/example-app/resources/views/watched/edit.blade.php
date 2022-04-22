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

<h1>Watched Records Editing</h1>
<br>
<form method="post" action="{{ route('watched.update', ['watched'=>$watched->id]) }}">
    @csrf
    @method('put')
     <p> Add a person to edit:
        <select name="people_id">
            @foreach($people as $person)
                <option value="{{ $person->id }}" {{ $watched->people_id === $person->id ? 'selected':''}}>{{ $person->name }}</option>
            @endforeach
        </select>
    <p> Add a movie to edit:
        <select name="movie_id">
            @foreach($movies as $movie)
                <option value="{{ $movie->id }}" {{ $watched->movie_id === $movie->id ? 'selected':''}}>{{ $movie->title }}</option>
            @endforeach
        </select>
    <p> Enter stars voted: <select name="stars">
            <option value="1" {{$watched->stars === 1 ? 'selected':''}}>1</option>
            <option value="2" {{$watched->stars === 2 ? 'selected':''}}>2</option>
            <option value="3" {{$watched->stars === 3 ? 'selected':''}}>3</option>
            <option value="4" {{$watched->stars === 4 ? 'selected':''}}>4</option>
            <option value="5" {{$watched->stars === 5 ? 'selected':''}}>5</option>
    </select>
    <p> Enter their comment: <input name="comments" value="{{$watched->comments}}"/>
    <button type="submit">Save</button>

    @error('comments')
        <br>
        <h1><u>ERROR</u></h1>
            <h3><b>Enter a correct sized comment!</b></h3>
    @enderror
</form>
</body>
</html>
