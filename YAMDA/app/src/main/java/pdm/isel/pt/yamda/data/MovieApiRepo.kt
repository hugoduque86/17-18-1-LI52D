package pdm.isel.pt.yamda.data

import android.graphics.Bitmap
import pdm.isel.pt.yamda.data.dto.MovieDto
import pdm.isel.pt.yamda.data.dto.MovieResultDto
import pdm.isel.pt.yamda.data.dto.MovieSearchDto
import pdm.isel.pt.yamda.domain.model.Movie
import pdm.isel.pt.yamda.domain.model.MovieSearch
import pdm.isel.pt.yamda.utils.HttpRequest
import pdm.isel.pt.yamda.utils.JsonConverter

/**
 * Created by Hugo on 26/10/2017.
 */

interface  MovieRepo {


    fun searchMovies (str : String, queryType: String, cb : (List<MovieSearchDto>) -> Unit)
    fun getPoster(imageUrl: String, width: Int, height: Int, arg: (Bitmap?) -> Unit)
    fun searchDetails(id: Int, arg: (MovieDto) -> Unit)
}
object MovieApiRepo :MovieRepo{
    override fun searchDetails(id: Int, arg: (MovieDto) -> Unit) {
        HttpRequest.get("$BASE_URL/movie/$id$KEY"){arg(JsonConverter.convert(it))}
    }

    override fun getPoster(imageUrl: String, width: Int, height: Int, arg: (Bitmap?) -> Unit) {
        HttpRequest.getImages("$BASE_POSTER_URI$imageUrl",width,height,arg)
    }

    val KEY ="?api_key=6f19e21bc3e2952f8d1c4d7e139695fd"
    val BASE_URL : String = "https://api.themoviedb.org/3"
    val BASE_POSTER_URI ="https://image.tmdb.org/t/p/original"


    /**
     *
     */
    override fun searchMovies(str: String, queryType : String ,cb: (List<MovieSearchDto>) -> Unit) {
        var st  =""
        var query = queryType
        if (queryType == "Search") {
            st = "&query=$str"
            query="/search/movie"
        }
        else
            query="/movie/${query.replace(" ","_").toLowerCase()}"

        HttpRequest.get("$BASE_URL$query$KEY${st.replace(" ","%20")}"){

            cb(JsonConverter.convert<MovieResultDto>(it).results)

        }
    }


}