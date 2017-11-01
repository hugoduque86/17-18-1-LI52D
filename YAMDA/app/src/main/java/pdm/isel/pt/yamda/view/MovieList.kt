package pdm.isel.pt.yamda.view

import android.app.ListActivity
import android.content.Context

import android.content.Intent
import android.content.Intent.EXTRA_TEXT

import android.os.Bundle

import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast

import pdm.isel.pt.yamda.R
import pdm.isel.pt.yamda.domain.model.MovieSearch
import pdm.isel.pt.yamda.domain.operations.MovieAppOperations
import pdm.isel.pt.yamda.utils.HttpRequest
import pdm.isel.pt.yamda.view.adapters.MovieListAdapter

class MovieList : ListActivity() {


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

        HttpRequest.CheckConection(this){Toast.makeText(this,"No Internet",Toast.LENGTH_SHORT).show()
        finish()}

        listView.emptyView=layoutInflater.inflate(R.layout.empty_list,null ,false)
        root.addView(listView.emptyView)
        MovieAppOperations.getMovies(intent.extras[EXTRA_TEXT] as String , intent.extras["TypeOfQuery"] as String){
            listAdapter=MovieListAdapter(it,
                    {it.title},
                    {it.poster},
                    {it.posterUrl},
                    layoutInflater)
        }

    }

    override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {
        var intent = Intent(this,MovieInfo::class.java!!)
        intent.putExtra("Item",(listAdapter.getItem(position) as MovieSearch).id )
        startActivity(intent)
    }


}


