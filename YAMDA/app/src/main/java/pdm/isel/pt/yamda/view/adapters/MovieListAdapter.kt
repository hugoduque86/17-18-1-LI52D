package pdm.isel.pt.yamda.view.adapters

import android.graphics.Bitmap
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

/**
 * Created by Hugo on 25/10/2017.
 */
class MovieListAdapter <T>(val list: List<T>,val textExtrator : ( String )-> T , val image : (T)-> Bitmap?  ):BaseAdapter(){
    override fun getItem(position: Int)=list[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getCount(): Int = list.size

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}