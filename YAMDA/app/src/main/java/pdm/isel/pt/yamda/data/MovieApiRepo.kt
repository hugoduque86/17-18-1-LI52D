package pdm.isel.pt.yamda.data

import pdm.isel.pt.yamda.data.dto.MovieSearchDto
import pdm.isel.pt.yamda.utils.HttpRequest
import pdm.isel.pt.yamda.utils.JsonConverter

/**
 * Created by Hugo on 26/10/2017.
 */

interface  MovieRepo {


    fun searchMovies (str : String, cb : (List<MovieSearchDto>) -> Unit)
}
object MovieApiRepo :MovieRepo{
    val KEY ="?api_key=6f19e21bc3e2952f8d1c4d7e139695fd"
    val BASE_URL : String = "https://api.themoviedb.org/3"


    /**
     *
     */
    override fun searchMovies(str: String, cb: (List<MovieSearchDto>) -> Unit) {
        var str = str
        if (str.isEmpty())
            str=" "
        HttpRequest.get("$BASE_URL/search/movie$KEY&query=$str"){str -> cb(JsonConverter.convert<List<MovieSearchDto>>(str))}
    }


}