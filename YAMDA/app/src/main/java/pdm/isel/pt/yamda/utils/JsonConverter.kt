package pdm.isel.pt.yamda.utils

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule

/**
 * Created by Hugo on 25/10/2017.
 */
object JsonConverter {
    val mapper: ObjectMapper = ObjectMapper().registerKotlinModule()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)

    inline fun <reified T : Any>  convert (str : String): T = mapper.readValue(str)

}