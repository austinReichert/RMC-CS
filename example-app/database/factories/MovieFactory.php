<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;
use App\Models\People;
use App\Models\Watched;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Movie>
 */
class MovieFactory extends Factory
{
    public function definition()
    {
        return [
            'title' => $this->faker->sentence(1),
            'releaseyear' => $this->faker->year(),
            'rating' =>  $this->faker->randomElement(['G', 'PG', 'PG-13', 'R', 'NR', 'NC-17'])
        ];
    }
}
