package pdm.isel.pt.yamda.view

import android.app.Activity
import android.app.ListActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import pdm.isel.pt.yamda.R

class MovieList : ListActivity() {

   val test : Array<String> = arrayOf("a","v","de")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
  //      setContentView(R.layout.activity_movie_list)
        val root =findViewById<View>(android.R.id.content) as ViewGroup
      //  var list = findViewById<LinearLayout>(R.id.movieList)
    /*    for ( i in test){
            val j = TextView(this)
            j.text = i
            list.addView(j)
        }*/
        listView.emptyView=layoutInflater.inflate(R.layout.empty_list,root,true)

    }
}
