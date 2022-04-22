<head>
    <title>
    Movies Index
    </title>
</head>

<style>
    body{
        background: #edf2f7;
    }
    table, th, td {
        border: 2px solid #1a202c;
        border-collapse: collapse;
        text-align: center;
        margin-left: auto;
        margin-right: auto;
    }
    th {
        background: white;
        padding: 5px;
    }

    tr:nth-child(even){
        background: aliceblue;
    }
    tr:nth-child(odd):not(:first-child){
        background: cornsilk;
    }
    h2, h1 {
        text-align: center;
    }
    form {
        text-align: center;
        margin-left: auto;
        margin-right: auto;
    }
    button {
        border: none;
        background: none;
        cursor: pointer;
    }
    tr:last-child{
        background: blanchedalmond;
        font-size: 20px;
    }
    a {
        text-decoration: none;
    }
</style>

<h1>Movies Index</h1>
<h2><a href="\"><i>Return to main page</i></a></h2>
<h2>Total Movies: {{ $movies->count() }}</h2>
    <table>
        <tr>
            <th><h3>Movie Title</h3></th>
            <th><h3>Release Year</h3></th>
            <th><h3>Movie Rating</h3></th>
            <th><h3>Delete Movie</h3></th>
            <th><h3>Edit Movie</h3></th>
        </tr>

        @foreach($movies as $movie)
        <tr>
            <td>{{ $movie->title }}</td>
            <td>{{ $movie->releaseyear }}</td>
            <td>{{ $movie->rating }}</td>
             <td>
                 <form action="{{ route('movie.destroy', ['movie' => $movie->id]) }}" method="post">
                    @csrf
                    @method('delete')
                <button type="submit" style="color:red">delete</button>
            </form>
            </td>
            <td>
                <form action="{{ route('movie.edit', ['movie' => $movie->id]) }}"><button type="submit" style="color:green">edit</button></form>
            </td>
        </tr>
        @endforeach
        <tr>
            <td colspan="5"><h2><a href="{{ route('movie.create') }}">Create a new movie</a></h2></td>
        </tr>
    </table>
