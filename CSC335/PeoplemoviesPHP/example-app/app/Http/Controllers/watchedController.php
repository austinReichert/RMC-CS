<?php

namespace App\Http\Controllers;

use App\Models\Movie;
use App\Models\Watched;
use App\Models\People;
use Illuminate\Http\Request;
use Illuminate\Http\Response;

class watchedController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return Response
     */
    public function index(){
       $allWatched = Watched::whereNotNull('id')
            ->orderBy('id')
            ->get();
        return view('watched.index', ['allWatched' => $allWatched]);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return Response
     */
    public function create(){
        return view('watched.create', ['movies'=>Movie::all(), 'people'=>People::all()]);
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return Response
     */
    public function store(Request $request){
      $validated = $request->validate([
          'people_id' => 'required',
          'movie_id' => 'required',
          'stars' => 'required|max:1',
          'comments' => 'required|max:255',
    ]);
    Watched::create([
        'people_id' => $validated['people_id'],
        'movie_id' => $validated['movie_id'],
        'stars' => $validated['stars'],
        'comments' => $validated['comments']
    ]);
    return redirect(url(route('watched.index')));
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Watched  $watched
     * @return Response
     */
    public function show(Watched $watched){
        dd($watched);
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\Watched  $watched
     * @return Response
     */
    public function edit(Watched $watched){
        return view('watched.edit',['watched' => $watched], ['movies'=>Movie::all(), 'people'=>People::all()]);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Watched  $watched
     * @return Response
     */
    public function update(Request $request, Watched $watched){
        $validated = $request->validate([
            'people_id' => 'required',
            'movie_id' => 'required',
            'stars' => 'required|max:1',
            'comments' => 'required|max:255',
        ]);
        $watched->people_id = $validated['people_id'];
        $watched->movie_id = $validated['movie_id'];
        $watched->stars = $validated['stars'];
        $watched->comments = $validated['comments'];
        $watched->save();
        return redirect(url(route('watched.index')));
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Watched  $watched
     * @return Response
     */
    public function destroy(Watched $watched){
        $watched->delete();
        return redirect(url(route('watched.index')));
    }
}
