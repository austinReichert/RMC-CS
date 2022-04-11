<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Watched extends Model
{
    public $timestamps = false;
    protected $table = 'watched';
    protected $primaryKey = 'id';
    protected $fillable = [
        'people_id',
        'movie_id',
        'stars',
        'comments'
    ];
    use HasFactory;

    public function person(): \Illuminate\Database\Eloquent\Relations\belongsTo
    {
        return $this->belongsTo(People::class, 'people_id', 'id');
    }
    public function movie(): \Illuminate\Database\Eloquent\Relations\belongsTo
    {
        return $this->belongsTo(Movie::class, 'movie_id', 'id');
    }
}
