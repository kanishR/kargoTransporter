package com.example.kargopaipo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.kargopaipo.Injection
import com.example.kargopaipo.Util
import com.example.kargopaipo.data.Repository
import com.example.kargopaipo.model.Job
import com.example.kargopaipo.model.RootResponse
import java.util.*

/**
 * Created by Kanish Roshan on 2020-02-17.
 */
class MainViewModel (application:Application) :AndroidViewModel(application) {
    private var repo:Repository
  //  public lateinit var listData:MutableLiveData<RootResponse>
    var rootResponse:MutableLiveData<RootResponse> ?
    public var jobListChange:MutableLiveData<List<Job>> ?
    public lateinit var errorData:MutableLiveData<String>
    init {
       repo= Injection().getRepository()
        rootResponse= repo.data
        jobListChange= MutableLiveData()
       errorData= MutableLiveData()
    }


    fun fetchListData(){
        repo.getData()



    }

    fun sortByCost(){
        if (rootResponse!=null){
            var jobList:List<Job>? =rootResponse?.value?.jobs
//        Collections.sort(kotlin.Comparator())
            jobList=  Util.sortFunction(jobList)
            jobListChange?.postValue(jobList)


        }

    }

}