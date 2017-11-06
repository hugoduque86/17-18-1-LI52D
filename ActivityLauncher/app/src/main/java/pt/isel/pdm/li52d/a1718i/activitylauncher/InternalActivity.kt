package pt.isel.pdm.li52d.a1718i.activitylauncher

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_internal.*
import kotlinx.android.synthetic.main.team_view.*
import pt.isel.pdm.li52d.a1718i.activitylauncher.adapters.TeamAdapter
import pt.isel.pdm.li52d.a1718i.activitylauncher.model.SoccerRepository

/**
 * Created by lfalcao on 04/10/2017.
 */
class InternalActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internal)

        val adapter: TeamAdapter = TeamAdapter(SoccerRepository.getTeams(), layoutInflater)
        listView.adapter = adapter
    }
}