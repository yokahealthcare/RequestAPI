package com.example.requestapi

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody


class MainActivity : ComponentActivity() {

    private val BASE_URL = "http://192.168.0.5:8000/"
    private val TAG = "CHECKOUT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get_all_car()
        // login("adawong", "123")
        // signup("mia", "123", "123456", "mia@gmail.com")

        val name = "ferrari"
        val plate = "L2110EY"
        val vin = "1312HDFKSA832024"
        val distance = 3204
        val uid = "bb53a2d7-0bb3-49e1-9a01-134bc5c3fc59"
        val cid = "2"
        val data = mapOf(
            "oil" to mapOf("name" to "GS Astra", "last_change" to "02/11/2023"),
            "oil_filter" to mapOf("name" to "Loper Bear", "last_change" to "09/04/2023"),
            "fuel_filter" to mapOf("name" to "Peroz Utips", "last_change" to "01/01/2023"),
            "air_filter" to mapOf("name" to "Winder Premium", "last_change" to "01/09/2023"),
            "breakpad" to mapOf("name" to "Stop Car", "last_change" to "03/05/2023")
        )
        // add_car(name, plate, vin, distance, uid, cid, data)

        // delete_car("4ad5a33d-4aff-4992-a473-9ecbe27e40b1")

        // load_car("66cf7d24-5aae-4f36-867b-288807b8ffaf")
    }

    private fun load_car(automotive_id: String) {
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
                        if (it.is_success) {
                            // Handle successful
                            Log.i(TAG, it.detail)
                        } else {
                            // Handle unsuccessful
                            Log.i(TAG, it.detail)
                        }
                    }
                } else {
                    // Handle unsuccessful response
                    Log.i(TAG, "Unsuccessful response: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<LoadCar>, t: Throwable) {
                // Handle the failure
                Log.i(TAG, "LOAD CAR FAILURE: ${t.message}")
            }

        })
    }

    private fun delete_car(automotive_id: String) {
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
                        if (it.is_success) {
                            // Handle successful deletion
                            Log.i(TAG, it.detail)
                        } else {
                            // Handle unsuccessful deletion
                            Log.i(TAG, it.detail)
                        }
                    }
                } else {
                    // Handle unsuccessful response
                    Log.i(TAG, "Unsuccessful response: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<DeleteCar>, t: Throwable) {
                // Handle the failure
                Log.i(TAG, "DELETE CAR FAILURE: ${t.message}")
            }
        })
    }


    private fun add_car(name: String, plate: String, vin: String, distance: Int, uid: String, cid: String, data: Map<String, Map<String, String>>) {
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
                        if(it.is_success) {
                            Log.i(TAG, it.detail)
                        } else {
                            Log.i(TAG, it.detail)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<AddCar>, t: Throwable) {
                Log.i("CHECKOUT", "ADD CAR BAD ASS ${t.message}")
            }


        })
    }

    private fun signup(username: String, password: String, phone: String, email: String) {
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
                        if(it.is_success) {
                            Log.i(TAG, it.detail)
                            Log.i(TAG, "Verification has been sent to you email")
                        } else {
                            Log.i(TAG, it.detail)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<Signup>, t: Throwable) {
                Log.i("CHECKOUT", "SIGNUP BAD ASS ${t.message}")
            }

        })
    }

    private fun login(username: String, password: String) {
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
                        // if the credential ok
                        if(it.is_success) {
                            Log.i(TAG, it.data.uid)
                            // store to session
                            // changing intent to dashboard activity
                        } else {
                            Log.i(TAG, it.detail)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<Login>, t: Throwable) {
                Log.i("CHECKOUT", "LOGIN BAD ASS ${t.message}")
            }


        })
    }


    private fun get_all_car() {
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
                        Log.i("CHECKOUT", "onResponse : ${it.data}")
                    }
                }
            }

            override fun onFailure(call: Call<ListAllCar>, t: Throwable) {
                Log.i("CHECKOUT", "LOAD CAR BAD ASS")
            }

        })
    }
}
