package pdm.isel.pt.yamda.utils

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.net.ConnectivityManager
import android.net.Network
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import com.android.volley.*
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

/**
 * Created by Hugo on 25/10/2017.
 */
object HttpRequest{
    val TAG = HttpRequest::class.simpleName!!
    private var queue: RequestQueue? = null
    fun init (ctx : Context) {
        queue = Volley.newRequestQueue(ctx)

    }

    fun get(url: String, res: (String) -> Unit): Unit {
        val stringRequest = StringRequest(Request.Method.GET,url,
                Response.Listener<String>{
                    res(it)
                }, Response.ErrorListener { requestError(it) })

        queue?.add(stringRequest);
    }

    fun getImages(url: String, width  : Int, height : Int,  res: (Bitmap) -> Unit): Unit
    {
        val imageRequest = ImageRequest(url,
                Response.Listener<Bitmap> { res(it) },
                width,height,
                ImageView.ScaleType.CENTER,
                Bitmap.Config.ALPHA_8,
                Response.ErrorListener { requestError(it) }
                )
        queue?.add(imageRequest)
    }

    private fun requestError(error: VolleyError) {

        Log.e(TAG, "The Http response could not be obtained because of the following error: $error")
    }

    fun CheckConection(ctx: Activity,function: () -> Unit)  {
        if((ctx.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo==null)
            function()
        return

    }


}