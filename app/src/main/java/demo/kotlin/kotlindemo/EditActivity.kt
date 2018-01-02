package demo.kotlin.kotlindemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.list_items.*

class EditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val nameExtra: String = intent.extras["name"].toString()
        val ageExtra: String = intent.extras["age"].toString()
        etNameEdit.setText(nameExtra)
        etAgeEdit.setText(ageExtra)

        val handler : SqliteHandler
        handler = SqliteHandler(this@EditActivity)

        btnBackEdit.setOnClickListener{
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
        }

        btnDelete.setOnClickListener{
            handler.deletePerson(nameExtra)
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
        }

        btnUpdate.setOnClickListener{ view ->
            val name: String = etNameEdit.text.toString()
            val age: Int = etAgeEdit.text.toString().toInt()

            handler.updatePerson(name,age,nameExtra)

            Snackbar.make(view, "Edit person successful", Snackbar.LENGTH_LONG)
                    .setAction("Edit", null).show()
        }
    }
}
