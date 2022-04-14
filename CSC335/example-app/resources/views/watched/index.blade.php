<head>
    <title>
    Watched Records Index
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
    h2, h1{
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
    }
    tr:last-child{
        background: blanchedalmond;
        font-size: 20px;
    }
    a {
        text-decoration: none;
    }
</style>

<h1>Watched Records Index</h1>
<h2><a href="\"><i>Return to main page</i></a></h2>
<h2>Total Watched Records: {{$allWatched->count()}}</h2>
<table>
    <tr>
        <th><h3>Person's Full Name</h3></th>
        <th><h3>Movie They Watched</h3></th>
        <th><h3>Person's Stars</h3></th>
        <th><h3>Person's Review</h3></th>
        <th><h3>Delete Watched Record</h3></th>
        <th><h3>Edit Watched Record</h3></th>
    </tr>
    @foreach($allWatched as $watched)
    <tr>
        <td>{{ $watched->person->name }}</td>
        <td>{{ $watched->movie->title }}</td>
        <td>{{ $watched->stars }}</td>
        <td>{{$watched->comments}}</td>
        <td>
             <form action="{{ route('watched.destroy', ['watched' => $watched->id]) }}" method="post">
                @csrf
                @method('delete')
            <button type="submit" style="color:red">delete</button>
            </form>
        </td>
        <td>
            <a href="{{ route('watched.edit', ['watched' => $watched->id]) }}" style="color:green">edit</a>
        </td>
    </tr>
    @endforeach

    <tr>
        <td colspan="6"><h2><a href="{{ route('watched.create') }}">Create a new watched record</a></h2></td>
    </tr>
</table>
