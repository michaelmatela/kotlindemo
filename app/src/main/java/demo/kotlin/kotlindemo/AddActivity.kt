package demo.kotlin.kotlindemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_add.*
import java.sql.SQLClientInfoException

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val handler : SqliteHandler
        handler = SqliteHandler(this@AddActivity)

        btnBack.setOnClickListener{
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
        }

        btnAdd.setOnClickListener{ view ->
            val name: String = etName.text.toString()
            val age: Int = etAge.text.toString().toInt()

            handler.addPerson(name,age)

            Snackbar.make(view, "Add person successful", Snackbar.LENGTH_LONG)
                    .setAction("Add", null).show()
        }
    }
}
