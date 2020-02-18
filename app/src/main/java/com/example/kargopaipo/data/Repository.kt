package com.example.kargopaipo.data

import androidx.lifecycle.MutableLiveData
import com.example.kargopaipo.model.RootResponse

/**
 * Created by Kanish Roshan on 2020-02-17.
 */
class Repository( private val service: NwService) {
  //  private  var   data: RootResponse?=null
    public  var   data: MutableLiveData<RootResponse>?=MutableLiveData()

    private val networkErrors = MutableLiveData<String>()


    /**
     * get Data
     */
    fun getData(){

        getList(service, { response: RootResponse ->
         //   data=response

            data?.postValue(response)

        }, { error ->

        })
      // return  data
    }





    companion object {
        private const val NETWORK_PAGE_SIZE = 50
    }





}
