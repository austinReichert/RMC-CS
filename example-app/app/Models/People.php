<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Notifications\Notifiable;
use Laravel\Sanctum\HasApiTokens;

class People extends Model
{
    use HasFactory;

    public $timestamps = false;
    protected $table = 'people';
    protected $primaryKey = 'id';
    protected $fillable = [
        'name',
        'birthdate',
    ];

    protected $casts = [
        'birthdate' => 'date',
    ];
}
