package pdm.isel.pt.yamda.domain.operations

import android.graphics.Bitmap
import pdm.isel.pt.yamda.data.MovieRepo
import pdm.isel.pt.yamda.data.dto.MovieSearchDto
import pdm.isel.pt.yamda.domain.convert
import pdm.isel.pt.yamda.domain.model.Movie
import pdm.isel.pt.yamda.domain.model.MovieSearch

/**
 * Created by Hugo on 26/10/2017.
 */

object MovieAppOperations{
    var  MovieRepo : MovieRepo?=null

    fun getMovies(str: String , query : String, movieCb: (List<MovieSearch>) -> Unit) {
        val movies = ArrayList<MovieSearch>().toMutableList()

        MovieRepo?.searchMovies(str,query ){
            it.forEach { movies.add(it.convert(null)) }
            movieCb(movies)
        }

    }


    fun getPoster(imageUrl: String?, width: Int, height: Int, arg: (Bitmap?) -> Unit) {
        if (imageUrl==null) return
        MovieRepo?.getPoster(imageUrl,width,height,arg)
    }

    fun getDetails(id: Int, width: Int, height: Int, details: (Movie) -> Unit) {
        MovieRepo?.searchDetails(id){
            val aux = it
            if (it.poster_path != null) {
                getPoster(it.poster_path,width,height){details(aux.convert(it))}

            }else
                details(aux.convert(null))
            }
    }



}