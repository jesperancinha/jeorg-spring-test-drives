package org.jesperancinha.std.model

data class Film(
    var id: String = "",
    var title: String,
    var genre: FilmGenre,
    var nationality: String
)

