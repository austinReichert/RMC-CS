<?php

use Illuminate\Support\Facades\Route;
use App\Models\Watched;
use App\Models\People;
use App\Models\Movie;


/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    $allWatched = Watched::all();
    $people = People::all();
    $movies = Movie::all();
    return view('welcome', ['people' => $people, 'movies' => $movies, 'allWatched' => $allWatched]);
});
