<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;
use App\Models\Movie;
use App\Models\People;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Watched>
 */
class WatchedFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition()
    {

        return [
            # takes in person/movie id
            'stars' => $this->faker->numberBetween(1,5),
            'comments' => $this->faker->text(6)
        ];
    }
}
