<head>
    <title>
    People Index
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
    }
</style>

<h1>People Index</h1>
<br>
 <h2>Total People: {{ $people->count() }}</h2>
    <table>
        <tr>
            <th><h3>Person's Full Name</h3></th>
            <th><h3>Birthdate</h3></th>
            <th><h3>Delete Person</h3></th>
            <th><h3>Edit Person</h3></th>
        </tr>
        @foreach($people as $person)
        <tr>
            <td>{{ $person->name }}</td>
            <td>{{ $person->birthdate }}</td>
            <td>
                 <form action="{{ route('person.destroy', ['person' => $person->id]) }}" method="post">
                    @csrf
                    @method('delete')
                <button type="submit" style="color:red">delete</button>
            </form>
            </td>
            <td>
                <form action="{{ route('person.edit', ['person' => $person->id]) }}"><button type="submit" style="color:green">edit</button></form>
            </td>
        </tr>
        @endforeach
        <tr>
            <td colspan="4"><h2><a href="{{ route('person.create') }}">Create a new person</a></h2></td>
        </tr>
    </table>
