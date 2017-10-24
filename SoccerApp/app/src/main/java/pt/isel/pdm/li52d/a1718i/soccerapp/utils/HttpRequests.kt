package pt.isel.pdm.li52d.a1718i.soccerapp.utils

import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import android.widget.ImageView
import com.android.volley.Request
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.ImageRequest


/**
 * Created by lfalcao on 16/10/2017.
 */
object HttpRequests {
    val TAG: String = HttpRequests::class.simpleName!!;

    private var queue: RequestQueue? = null

    public fun init(context: Context) {
        // Instantiate the RequestQueue.
        queue = Volley.newRequestQueue(context)
    }

    fun get(url: String, responseCb: (String) -> Unit): Unit {
        Log.i(TAG, "Http Request to text Url ${url}");
        // Request a string response from the provided URL.
        val stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener<String> { response: String -> processResponse(response, responseCb) },
                Response.ErrorListener { requestError(it) })
        // Add the request to the RequestQueue.
        queue?.add(stringRequest)

    }

    fun getImage(url: String, width: Int, height: Int, responseCb: (Bitmap) -> Unit): Unit {
        // Request a an Image response from the provided URL.
        Log.i(TAG, "Http Request to image Url ${url}");
        val imageRequest = ImageRequest(
                url,
                Response.Listener<Bitmap> { bm -> responseCb(bm) },
                width,
                height,
                ImageView.ScaleType.CENTER_INSIDE,
                Bitmap.Config.ALPHA_8,
                Response.ErrorListener { requestError(it) })
        queue?.add(imageRequest)

    }

    private fun processResponse(response: String, responseCb: (String) -> Unit) {
        Log.i(TAG, "Response is: $response")
        responseCb(response)
    }

    private fun requestError(error: VolleyError) {
        Log.e(TAG, "The Http response could not be obtained because of the following error: $error")
    }
}


