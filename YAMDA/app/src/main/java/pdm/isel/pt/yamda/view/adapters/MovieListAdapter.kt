package pdm.isel.pt.yamda.view.adapters

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import pdm.isel.pt.yamda.R
import pdm.isel.pt.yamda.domain.operations.MovieAppOperations

/**
 * Created by Hugo on 25/10/2017.
 */

const val MAX_WIDTH = 144
const val MAX_HEIGHT = 144

class MovieListAdapter <T>(val list: List<T>, val textExtrator: (T )-> String, val image: (T)-> Bitmap?, val imageUrl: (T) -> String?, val inflater: LayoutInflater):BaseAdapter(){

    val TAG : String = MovieListAdapter::class.simpleName!!
    override fun getItem(position: Int)=list[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getCount(): Int = list.size

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var aux = convertView
        if (aux==null)
            aux = inflater.inflate( R.layout.list_item,parent,false)

        val ret = aux!!
        val item = list[position]
        ret.tag=item
        val image = aux?.findViewById<ImageView>(R.id.image_item)
        val tag =ret.tag


        MovieAppOperations.getPoster(imageUrl(item), MAX_WIDTH, MAX_HEIGHT)
        {

            if(tag==ret.tag)
                image.setImageBitmap(it)

        }


        image.setImageResource(R.mipmap.ic_launcher)
        aux?.findViewById<TextView>(R.id.text_item)?.text=textExtrator(item)

        return aux!!


    }

}