package com.example.kargopaipo.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kargopaipo.R
import com.example.kargopaipo.model.Job
import kotlinx.android.synthetic.main.itemjoblist.view.*
import org.w3c.dom.Text


/**
 * Created by Kanish Roshan on 2020-02-17.
 */
class ListRecylerAdapter(val listJobs: List<Job>?,val mContext:Context) :
    RecyclerView.Adapter<ListRecylerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(mContext).inflate(R.layout.itemjoblist,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (!listJobs.isNullOrEmpty()){
            listJobs.size
        }else{
            0
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        if (listJobs!!.size>position){
            val vHolder=holder.itemView
            val job= listJobs[position]
            if (!job.ocity.isNullOrEmpty())
            vHolder.tv_o_city.text=job.ocity
            if (!job.dcity.isNullOrEmpty())
            vHolder.tv_d_city.text=job.dcity
            if (!job.ltime.isNullOrEmpty())
            vHolder.tv_load_time.text=mContext.getString(R.string.loading_time,job.ltime)
            if (!job.ultime.isNullOrEmpty())
            vHolder.tv_un_load_time.text=mContext.getString(R.string.loading_time,job.ultime)
            if (!job.cost.isNullOrEmpty())
            vHolder.tv_price.text=job.cost

        }

    }
   inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       private lateinit  var tvOcity:TextView
       private lateinit  var tvdCity:TextView
       private lateinit  var tvLoadTime:TextView
       private lateinit  var tvUnLoadTime:TextView
       private lateinit var     tvPrice:TextView
       init {
            tvOcity=itemView.findViewById(R.id.tv_o_city)
           tvdCity=itemView.findViewById(R.id.tv_d_city)
           tvLoadTime=itemView.findViewById(R.id.tv_load_time)
           tvUnLoadTime=itemView.findViewById(R.id.tv_un_load_time)
           tvPrice=itemView.findViewById(R.id.tv_price)

       }


    }
}