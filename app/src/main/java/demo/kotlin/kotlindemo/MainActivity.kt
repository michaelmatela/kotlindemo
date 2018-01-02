package demo.kotlin.kotlindemo

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->

            val addIntent = Intent(this, AddActivity::class.java )
            startActivity(addIntent)
            //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            //        .setAction("Action", null).show()
        }
        val handler : SqliteHandler
        handler = SqliteHandler(this@MainActivity)
        val people: ArrayList<Person> = handler.getPersons()

        if(people.size != 0) {
            val personAdapter = CustomRecyclerAdapter(handler.getPersons())
            rvPeople.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
            rvPeople.adapter = personAdapter
        }

    }
}

