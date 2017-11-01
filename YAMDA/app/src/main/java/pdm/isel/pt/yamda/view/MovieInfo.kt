package pdm.isel.pt.yamda.view

import android.app.Activity
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_movie_info.*
import pdm.isel.pt.yamda.R
import pdm.isel.pt.yamda.domain.operations.MovieAppOperations
import pdm.isel.pt.yamda.utils.HttpRequest

class MovieInfo : Activity() {

    private  val MARGIN = 8
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        HttpRequest.CheckConection(this){
            Toast.makeText(this,"No Internet", Toast.LENGTH_SHORT).show()
            finish()}
        var screenSize = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(screenSize)
        setContentView(R.layout.activity_movie_info)
        val id = intent.extras["Item"] as Int


        MovieAppOperations.getDetails(id,screenSize.widthPixels- MARGIN*2,screenSize.heightPixels- MARGIN*2){
            if (it.poster != null) {

                poster.setImageBitmap(it.poster)
            }
            movie_title.text=it.title
            synopsis.text = it.synopsis
        }
    }
}
