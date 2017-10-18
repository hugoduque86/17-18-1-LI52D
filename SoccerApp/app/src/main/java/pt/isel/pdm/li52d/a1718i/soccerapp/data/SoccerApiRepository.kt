package pt.isel.pdm.li52d.a1718i.soccerapp.data

import pt.isel.pdm.li52d.a1718i.soccerapp.data.dtos.LeagueDto
import pt.isel.pdm.li52d.a1718i.soccerapp.utils.HttpRequests
import pt.isel.pdm.li52d.a1718i.soccerapp.utils.JsonConverter

/**
 * Created by lfalcao on 16/10/2017.
 */




object SoccerApiRepository : SoccerRepository {
    val BASE_URI = "http://api.football-data.org/v1/";
    override fun searchLeagues(searchStr: String, cb: (List<LeagueDto>) -> Unit) : Unit {
        HttpRequests.get(
                "$BASE_URI/soccerseasons",
                {str -> cb(JsonConverter.convert<List<LeagueDto>>(str).filter { it.caption.contains(searchStr, true) })})

    }

//    private inline fun <reified T: Any> convertStringToDtoAndFilter(str: String, cb: (T) -> Unit) {
//        val res: T = JsonConverter.convert<T>(str)
//        cb(res)
//    }
}


