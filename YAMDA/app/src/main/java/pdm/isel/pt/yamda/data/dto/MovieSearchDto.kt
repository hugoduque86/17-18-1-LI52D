package pdm.isel.pt.yamda.data.dto

/**
 * Created by Hugo on 26/10/2017.
 */
data class MovieResultDto(val results : List<MovieSearchDto>)
data class MovieSearchDto(val id: Int, val title: String, val poster_path: String? )

data class MovieDto(val id:Int, val title: String ,val poster_path: String?, val overview : String , val release_date : String)

