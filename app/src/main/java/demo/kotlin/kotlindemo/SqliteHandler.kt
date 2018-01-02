package demo.kotlin.kotlindemo

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Created by phmima on 1/2/2018.
 */
class SqliteHandler(context: Context) : SQLiteOpenHelper(context, dbname, factory, version){

    companion object {
        internal val dbname = "mydb"
        internal val factory = null
        internal val version = 1
    }

    fun addPerson(name: String, age: Int){
        val db: SQLiteDatabase = writableDatabase
        val values:ContentValues
        values = ContentValues()
        values.put("name", name)
        values.put("age",age)

        db.insert("Person",null, values)
    }

    fun updatePerson(name:String, age: Int, newName:String){
        val db: SQLiteDatabase = writableDatabase
        db.execSQL("UPDATE Person SET name='$name', age=${age.toString()} WHERE name='$newName'")
    }

    fun deletePerson(name: String){
        val db: SQLiteDatabase = writableDatabase
        db.execSQL("DELETE FROM Person WHERE name='$name'")
    }

    fun getPersons():ArrayList<Person>{
        var people:ArrayList<Person>
        val db: SQLiteDatabase = readableDatabase

        people = ArrayList<Person>()

        var rawPeople = db.rawQuery("SELECT * FROM Person", null)

        while(rawPeople.moveToNext()) {
            var person:Person
            person = Person("",0)

            person.name = rawPeople.getString(rawPeople.getColumnIndex("name"))
            person.age = rawPeople.getInt(rawPeople.getColumnIndex("age"))

            people.add(person)
        }

        return people
    }


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE Person (name varchar(20) , age integer )")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

}