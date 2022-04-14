<?php

namespace App\Http\Controllers;

use App\Models\Movie;
use Illuminate\Http\Request;
use Illuminate\Http\Response;

class movieController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return Response
     */
    public function index(){
        $movies = Movie::whereNotNull('id')
            ->orderBy('title')
            ->get();
        return view('movie.index', ['movies' => $movies]);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return Response
     */
    public function create(){
        return view('movie.create');
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return Response
     */
    public function store(Request $request){
       $validated = $request->validate([
        'title' => 'required|max:255',
        'releaseyear' => 'required|max:4',
        'rating' => 'required|max:12',
    ]);
    Movie::create([
        'title' => $validated['title'],
        'releaseyear' => $validated['releaseyear'],
        'rating' => $validated['rating']
    ]);
    return redirect(url(route('movie.index')));
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Movie  $movie
     * @return Response
     */
    public function show(Movie $movie) {
        dd($movie);
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\Movie  $movie
     * @return Response
     */
    public function edit(Movie $movie){
        return view('movie.edit',['movie' => $movie]);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Movie  $movie
     * @return Response
     */
    public function update(Request $request, Movie $movie){
        $validated = $request->validate([
         'title' => 'required|max:255',
        'releaseyear' => 'required|max:4',
        'rating' => 'required|max:12',
    ]);
        $movie->title = $validated['title'];
        $movie->releaseyear = $validated['releaseyear'];
        $movie->rating = $validated['rating'];
        $movie->save();
        return redirect(url(route('movie.index')));
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Movie  $movie
     * @return Response
     */
    public function destroy(Movie $movie){
        $movie->delete();
        return redirect(url(route('movie.index')));
    }
}
