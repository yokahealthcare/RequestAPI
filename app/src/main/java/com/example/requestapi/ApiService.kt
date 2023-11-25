package com.example.requestapi

import android.util.Log
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {

    private val BASE_URL = "https://dcd9-139-255-100-170.ngrok-free.app/"
    private val TAG = "CHECKOUT"
    fun load_car(automotive_id: String, callback: (LoadCar?) -> Unit) {
        val stmt = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)

        stmt.load_car(automotive_id).enqueue(object : Callback<LoadCar> {
            override fun onResponse(call: Call<LoadCar>, response: Response<LoadCar>) {
                // Handle the response
                if (response.isSuccessful) {
                    val data = response.body()
                    data?.let {
                        callback(it)
                    }
                } else {
                    // Handle unsuccessful response
                    Log.i(TAG, "Unsuccessful response: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<LoadCar>, t: Throwable) {
                // Handle the failure
                callback(null)
            }

        })
    }

    fun delete_car(automotive_id: String, callback: (DeleteCar?) -> Unit) {
        val stmt = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)

        stmt.delete_car(automotive_id).enqueue(object : Callback<DeleteCar> {
            override fun onResponse(call: Call<DeleteCar>, response: Response<DeleteCar>) {
                // Handle the response
                if (response.isSuccessful) {
                    val data = response.body()
                    data?.let {
                        callback(it)
                    }
                } else {
                    // Handle unsuccessful response
                    Log.i(TAG, "Unsuccessful response: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<DeleteCar>, t: Throwable) {
                // Handle the failure
                callback(null)
            }
        })
    }


    fun add_car(name: String, plate: String, vin: String, distance: Int, uid: String, cid: String, data: Map<String, Map<String, String>>, callback: (AddCar?) -> Unit) {
        val jsonMediaType = "application/json; charset=utf-8".toMediaType()

        val addCarObject = JSONObject()
        addCarObject.put("name", name)
        addCarObject.put("plate", plate)
        addCarObject.put("vin", vin)
        addCarObject.put("distance", distance)
        addCarObject.put("cid", cid)
        addCarObject.put("uid", uid)

        // Create a nested JSONObject for the "data" field
        val dataObject = JSONObject()
        for ((key, innerMap) in data) {
            val innerDataObject = JSONObject()
            for ((innerKey, innerValue) in innerMap) {
                innerDataObject.put(innerKey, innerValue)
            }
            dataObject.put(key, innerDataObject)
        }

        // Add the "data" field to the main object
        addCarObject.put("data", dataObject)

        val request_body = addCarObject.toString().toRequestBody(jsonMediaType)

        val stmt = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)

        stmt.add_car(request_body).enqueue(object : Callback<AddCar> {
            override fun onResponse(call: Call<AddCar>, response: Response<AddCar>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    data?.let {
                        callback(it)
                    }
                } else {
                    // Handle unsuccessful response
                    Log.i(TAG, "Unsuccessful response: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<AddCar>, t: Throwable) {
                callback(null)
            }


        })
    }

    fun signup(username: String, password: String, phone: String, email: String, callback: (Signup?) -> Unit) {
        val jsonMediaType = "application/json; charset=utf-8".toMediaType()

        val signupObject = JSONObject()
        signupObject.put("username", username)
        signupObject.put("password", password)
        signupObject.put("phone", phone)
        signupObject.put("email", email)

        val jsonObject = JSONObject()
        jsonObject.put("signup_account", signupObject)
        val request_body = jsonObject.toString().toRequestBody(jsonMediaType)

        val stmt = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)

        stmt.signup(request_body).enqueue(object : Callback<Signup> {
            override fun onResponse(call: Call<Signup>, response: Response<Signup>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    data?.let {
                        callback(it)
                    }
                } else {
                    // Handle unsuccessful response
                    Log.i(TAG, "Unsuccessful response: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<Signup>, t: Throwable) {
                callback(null)
            }

        })
    }

    fun login(username: String, password: String, callback: (Login?) -> Unit) {
        val jsonMediaType = "application/json; charset=utf-8".toMediaType()

        val jsonObject = JSONObject()
        val loginObject = JSONObject()
        loginObject.put("username", username)
        loginObject.put("password", password)
        jsonObject.put("login_account", loginObject)

        val request_body = jsonObject.toString().toRequestBody(jsonMediaType)

        val stmt = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)

        stmt.login(request_body).enqueue(object : Callback<Login> {
            override fun onResponse(call: Call<Login>, response: Response<Login>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    data?.let {
                       callback(it)
                    }
                } else {
                    // Handle unsuccessful response
                    Log.i(TAG, "Unsuccessful response: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<Login>, t: Throwable) {
                callback(null)
            }

        })
    }


    fun get_all_car(callback: (ListAllCar?) -> Unit) {
        val stmt = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)

        stmt.list_all_car().enqueue(object : Callback<ListAllCar> {
            override fun onResponse(call: Call<ListAllCar>, response: Response<ListAllCar>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    data?.let {
                        callback(it)
                    }
                } else {
                    // Handle unsuccessful response
                    Log.i(TAG, "Unsuccessful response: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<ListAllCar>, t: Throwable) {
                callback(null)
            }
        })
    }
}