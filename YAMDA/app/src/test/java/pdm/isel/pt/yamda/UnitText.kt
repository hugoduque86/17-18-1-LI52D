package pdm.isel.pt.yamda

import org.junit.Test
import pdm.isel.pt.yamda.data.MovieApiRepo
import pdm.isel.pt.yamda.data.dto.MovieDto
import pdm.isel.pt.yamda.data.dto.MovieSearchDto
import pdm.isel.pt.yamda.domain.model.Movie
import pdm.isel.pt.yamda.domain.operations.MovieAppOperations
import pdm.isel.pt.yamda.utils.HttpRequest
import pdm.isel.pt.yamda.utils.JsonConverter
import java.io.BufferedReader
import java.net.HttpURLConnection
import java.net.URL
import java.util.*

/**
 * Created by Hugo on 27/10/2017.
 */

class UnitText {
    @Test
    fun  test() {

      /*  val URL = URL("${MovieApiRepo.BASE_URL}/movie/85${MovieApiRepo.KEY}")
        val A : HttpURLConnection  = URL.openConnection() as HttpURLConnection
        A.requestMethod="GET"
        val buffer = Scanner(A.inputStream)
        var t =""
        while (buffer.hasNextLine())
            t+=buffer.nextLine()
        println(JsonConverter.convert<MovieDto>(t).toString())*/

       // val aux = "[{\"id\": 40 ,\"title\":\"ds\", \"poster_path\":\"dadsads\"}, {\"id\":60,\"title\":\"fer\",\"poster_path\":\"ds\"}]"
       // val b = JsonConverter.convert<List<MovieSearchDto>>(aux)
         // /assert(b[1].id==60&&b[0].id==40)
    }
}