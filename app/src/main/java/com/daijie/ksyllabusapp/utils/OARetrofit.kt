package com.daijie.ksyllabusapp.utils

import com.daijie.ksyllabusapp.App
import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by daidaijie on 2017/10/18.
 */
object OARetrofit {

    @JvmStatic
    val retrofit: Retrofit by lazy {
        val builder = OkHttpClient.Builder()
                .addInterceptor(ChuckInterceptor(App.context))
                .addInterceptor(HttpLoggingInterceptor())

        Retrofit.Builder()
                .baseUrl("http://wechat.stu.edu.cn/webservice_oa/oa_stu_/")
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
    }
}