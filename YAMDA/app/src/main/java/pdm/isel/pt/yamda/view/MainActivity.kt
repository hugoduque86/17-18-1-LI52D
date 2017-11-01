package pdm.isel.pt.yamda.view

/**
 * Created by Hugo on 09/10/2017.
 */
import android.content.Intent
import android.content.Intent.EXTRA_TEXT
import android.graphics.Point
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import pdm.isel.pt.yamda.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

//        startActivity(Intent(this,MovieList::class.java))

    }
    fun search (v : View){
        val itent = Intent(this,MovieList::class.java)
        itent.putExtra("TypeOfQuery",(v as Button).text.toString())
        itent.putExtra(EXTRA_TEXT,movie.text.toString())
        startActivity(itent)
    }
}
