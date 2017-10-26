package pdm.isel.pt.yamda

import android.app.Application
import pdm.isel.pt.yamda.data.MovieApiRepo
import pdm.isel.pt.yamda.domain.operations.MovieAppOperations
import pdm.isel.pt.yamda.utils.HttpRequest

/**
 * Created by Hugo on 26/10/2017.
 */
class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        HttpRequest.init(applicationContext)
        MovieAppOperations.MovieRepo = MovieApiRepo
    }
}