package pdm.isel.pt.yamda

import android.app.Activity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class MovieList : Activity() {

   val test : Array<String> = arrayOf("a","v","de")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)
        var list = findViewById<LinearLayout>(R.id.movieList)
        for ( i in test){
            val j = TextView(this)
            j.text = i
            list.addView(j)
        }
    }
}
