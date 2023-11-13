package com.example.requestapi

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface MyApi {
    @POST("signup_account")
    fun signup(@Body requestBody: RequestBody): Call<Signup>

    @POST("login_account")
    fun login(@Body requestBody: RequestBody): Call<Login>



    @POST("car/add")
    fun add_car(@Body requestBody: RequestBody): Call<AddCar>

    @GET("car/load")
    fun load_car(@Query("automotive_id") automotive_id: String): Call<LoadCar>

    @DELETE("car/delete")
    fun delete_car(@Query("automotive_id") automotive_id: String): Call<DeleteCar>

    @GET("car/list_all_car")
    fun list_all_car(): Call<ListAllCar>
}