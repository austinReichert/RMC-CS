<?php

namespace App\Http\Controllers;

use App\Models\People;
use Illuminate\Http\Request;
use Illuminate\Http\Response;

class personController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return Response
     */
    public function index(){
       $people = People::whereNotNull('id')
            ->orderBy('name')
            ->get();
        return view('person.index', ['people' => $people]);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return
     */
    public function create(){
        return view('person.create');
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  Request  $request
     * @return Response
     */
    public function store(Request $request){
        $validated = $request->validate([
            'name' => 'required|max:255',
            'birthdate' => 'required|date',
        ]);
        People::create([
            'name' => $validated['name'],
            'birthdate' => $validated['birthdate']
        ]);
        return redirect(url(route('person.index')));
    }

    /**
     * Display the specified resource.
     *
     * @param  People  $people
     * @return Response
     */
    public function show(People $person) {
        dd($person);
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  People  $person
     * @return Response
     */
    public function edit(People $person){
         return view('person.edit',['person' => $person]);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  Request  $request
     * @param  People  $person
     * @return Response
     */
    public function update(Request $request, People $person){
        $validated = $request->validate([
            'name' => 'required|max:255',
            'birthdate' => 'required|date',
        ]);
        $person->name = $validated['name'];
        $person->birthdate = $validated['birthdate'];
        $person->save();
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  People  $people
     * @return Response
     */
    public function destroy(People $person){
        $person->delete();
        return redirect(url(route('person.index')));
    }
}
