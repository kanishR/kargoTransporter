package com.example.kargopaipo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kargopaipo.R
import com.example.kargopaipo.model.Job
import com.example.kargopaipo.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mViewModel: MainViewModel
    private lateinit var mAdapter: ListRecylerAdapter
    private  var rvJobList:List<Job>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mViewModel.fetchListData()
        rv_job_list.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        registerObserver()
        initView()

    }

    private fun initView() {
        but_sort.setOnClickListener {
            mViewModel.sortByCost()
        }
    }

    private fun registerObserver() {

        mViewModel.rootResponse?.observe(this, Observer {root->
                if (root!=null){
                    rvJobList=root.jobs
                    mAdapter = ListRecylerAdapter(rvJobList, this)
                    rv_job_list.adapter=mAdapter
                }

            }
            )



        mViewModel.errorData.observe(this, Observer {
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        })

        mViewModel.jobListChange?.observe(this, Observer {
            rvJobList=it
            mAdapter.notifyDataSetChanged()
        })
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
