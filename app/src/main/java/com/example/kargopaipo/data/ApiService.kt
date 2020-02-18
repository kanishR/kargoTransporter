package com.example.kargopaipo.data

import com.example.kargopaipo.model.RootResponse

import android.util.Log

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Kanish Roshan on 2020-02-17.
 */



fun getList(service: NwService,onSuccess: (repos: RootResponse) -> Unit,
            onError: (error: String) -> Unit){
    service.searchRepos().enqueue(
        object : Callback<RootResponse> {
            override fun onFailure(call: Call<RootResponse>?, t: Throwable) {
                Log.d("kanish", "fail to get data$t")
                onError(t.message ?: "unknown error")
            }

            override fun onResponse(
                call: Call<RootResponse>?,
                response: Response<RootResponse>
            ) {
                Log.d("kanish", "got a response $response")
                if (response.isSuccessful) {

                    response.body()?.let {
                        onSuccess(it) }
                } else {
                    onError(response.message() ?: "Unknown error")
                }
            }
        }
    )

}



interface NwService {
    /**
     * Get list.
     */
    @GET("pairprog")
    fun searchRepos(
    ): Call<RootResponse>

    companion object {
        private const val BASE_URL = "http://demo7967833.mockable.io/"

        fun create(): NwService {
            val logger = HttpLoggingInterceptor()
            logger.level = Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NwService::class.java)
        }
    }
}