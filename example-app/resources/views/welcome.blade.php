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

    <form method="GET" action="">
        @csrf
        <label>Add ???&#x2192;</label><input type="text"> <input type="submit" value="Submit">
    </form>
    <br>

    <form method="GET" action="">
        @csrf
        <label>Remove ???&#x2192;</label><input type="text"> <input type="submit" value="Submit">
    </form>
    <br>

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

    </table>

    </body>
</html>
