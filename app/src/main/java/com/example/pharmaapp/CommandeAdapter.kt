package com.example.pharmaapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CommandeAdapter(val ctx: Context, val items: List<Commande>): BaseAdapter() {

    private class ViewHolder(val textView1: TextView)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val viewHolder: ViewHolder
        if (view == null) {

            view = LayoutInflater.from(ctx).inflate(R.layout.command_layout,parent,false)
            val textView1 = view?.findViewById(R.id.nom_commande) as TextView
            viewHolder = ViewHolder(textView1)
            view?.setTag(viewHolder)

        } else {
            viewHolder = view.tag as ViewHolder
        }

        viewHolder.textView1.setText(items.get(position).nom)
        return view
    }


    override fun getItem(position: Int): Any {
        return items.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }

}