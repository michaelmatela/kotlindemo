package demo.kotlin.kotlindemo

import android.content.Context
import android.content.Intent
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat.createDeviceProtectedStorageContext
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_items.view.*

/**
 * Created by phmima on 1/2/2018.
 */
class CustomRecyclerAdapter(val personList: ArrayList<Person>) : RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomRecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_items, parent, false)
        return ViewHolder(v,parent.context)
    }

    override fun onBindViewHolder(holder: CustomRecyclerAdapter.ViewHolder, position: Int) {
        holder.bindItems(personList[position])
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    class ViewHolder(itemView: View,val context: Context) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(person: Person) {

            itemView.tvName.text=person.name
            itemView.tvAge.text=person.age.toString()


            itemView.btnEdit.setOnClickListener{
                val addIntent = Intent(context, EditActivity::class.java ).apply {
                    putExtra("name", person.name)
                    putExtra("age", person.age)
                }
                context.startActivity(addIntent)
            }
        }
    }

}