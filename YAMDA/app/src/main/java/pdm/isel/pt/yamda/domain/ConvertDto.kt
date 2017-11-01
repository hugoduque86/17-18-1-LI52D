package pdm.isel.pt.yamda.domain

import android.graphics.Bitmap
import pdm.isel.pt.yamda.data.dto.MovieDto
import pdm.isel.pt.yamda.data.dto.MovieSearchDto
import pdm.isel.pt.yamda.domain.model.Movie
import pdm.isel.pt.yamda.domain.model.MovieSearch

/**
 * Created by Hugo on 26/10/2017.
 */
fun MovieSearchDto.convert(poster : Bitmap?) = MovieSearch(this.id,this.title,this.poster_path,poster)

fun MovieDto.convert(poster: Bitmap?) = Movie(this.id,this.title,this.poster_path,poster,this.overview,this.release_date)