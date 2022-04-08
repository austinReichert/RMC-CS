<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use App\Models\Movie;
use App\Models\People;
use App\Models\Watched;

class DatabaseSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run(){
        $movies = Movie::factory()->count(3)->create();

        $people = People::factory()->count(10)->create();

        foreach ($movies as $movie){
            foreach ($people as $person) {
                Watched::factory()->create(['movie_id' => $movie->id, 'people_id' => $person->id]);
            }
        }
    }
}
