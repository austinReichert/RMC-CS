<!DOCTYPE html>
    <head>
            <title>
            Movies Watched Table
            </title>
    </head>

    <style>
        table{
            border: 2px solid #1a202c;
            border-collapse: collapse;
            text-align: center;
        }
        th, td {
            border: 2px solid #1a202c;
            border-collapse: collapse;
            text-align: center;
            padding: 3px;
        }
        tr:nth-child(even){
            background: aliceblue;
        }
        tr:nth-child(odd):not(:first-child){
            background: cornsilk;
        }

    </style>
    <body>

    <form method="GET" action="">
        @csrf
        <label>Add Person&#x2192;</label><input type="text"> <input type="submit" value="Submit">
    </form>
    <br>

    <form method="GET" action="">
        @csrf
        <label>Remove Person&#x2192;</label><input type="text"> <input type="submit" value="Submit">
    </form>
    <br>

    <table>
        <tr>
            <th>
                <h3>Person's Full Name</h3>
            </th>
            <th>
                <h3>Movie They Watched</h3>
            </th>
            <th>
                <h3>Person's Stars</h3>
            </th>
        </tr>
        @foreach($allWatched as $watched)
        <tr>
            <td>
                {{ $watched->person->name }}
           </td>
            <td>
                {{ $watched->movie->title }}
            </td>
            <td>
                {{ $watched->stars }}
            </td>
        </tr>
        @endforeach

    </table>

    <table>
               
    </table>

    </body>
</html>
