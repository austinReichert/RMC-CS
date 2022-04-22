<!DOCTYPE html>
    <head>
            <title>
            Movies Watched Table
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
        tr:last-child{
            background: blanchedalmond;
            font-size: 30px;
        }
        h2, label {
            text-align: center;
        }
        a {
            text-align: center;
            margin-left: auto;
            margin-right: auto;
            text-decoration: none;
        }

    </style>
    <body>

    <h2>Total Movies: {{ $movies->count() }}</h2>
    <table>
        <tr>
            <th><h3>Movie Title</h3></th>
            <th><h3>Release Year</h3></th>
            <th><h3>Movie Rating</h3></th>
        </tr>

        @foreach($movies as $movie)
        <tr>
            <td>{{ $movie->title }}</td>
            <td>{{ $movie->releaseyear }}</td>
            <td>{{ $movie->rating }}</td>
        </tr>
        @endforeach
        <tr>
            <td colspan="3">
                <a href="{{route('movie.index')}}">Go to movie index</a>
            </td>
        </tr>
    </table>

    <br>

    <h2>Total People: {{ $people->count() }}</h2>
    <table>
            <tr>
                <th><h3>Person's Full Name</h3></th>
                <th><h3>Birthdate</h3></th>
            </tr>
            @foreach($people as $person)
            <tr>
                <td>{{ $person->name }}</td>
                <td>{{ $person->birthdate }}</td>
            </tr>
            @endforeach
            <tr>
                <td colspan="2">
                    <a href="{{route('person.index')}}">Go to person index</a>
                </td>
            </tr>
    </table>
    <br>

    <h2>Total Watched Records: {{$allWatched->count()}}</h2>
    <table>
        <tr>
            <th><h3>Person's Full Name</h3></th>
            <th><h3>Movie They Watched</h3></th>
            <th><h3>Person's Stars</h3></th>
        </tr>
        @foreach($allWatched as $watched)
        <tr>
            <td>{{ $watched->person->name }}</td>
            <td>{{ $watched->movie->title }}</td>
            <td>{{ $watched->stars }}</td>
        </tr>
        @endforeach
        <tr>
            <td colspan="3">
                <a href="{{route('watched.index')}}">Go to watched records index</a>
            </td>
        </tr>
    </table>

    </body>
</html>