<!DOCTYPE html>
<html>
<head>
    <title>
    People Creation
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

<h1>People Creation</h1>
<br>
<form method="post" action="{{ route('person.store') }}">
    @csrf
    Enter persons full name: <input name="name" />
    <p>Enter when they were born: <input type="date" name="birthdate" />
    <button type="submit">Save</button>

    @error('name')
        <br>
        <h1><u>ERROR</u></h1>
            <h3><b>Enter a correct name!</b></h3>
    @enderror
    @error('birthdate')
        <br>
        <h1><u>ERROR</u></h1>
            <h3><b>Enter a correct birthdate!</b></h3>
    @enderror
</form>
</body>
</html>
