package pdm.isel.pt.yamda.domain.model

import android.graphics.Bitmap

/**
 * Created by Hugo on 26/10/2017.
 */
data class MovieSearch (val id: Int , val title : String , val posterUrl : String?, val poster : Bitmap?)

data class Movie (val id: Int,val title: String,val posterUrl: String?, val poster: Bitmap?, val synopsis : String , val release : String)