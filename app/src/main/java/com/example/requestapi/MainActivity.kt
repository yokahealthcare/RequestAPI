package com.example.requestapi

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = ApiService()




//        api.get_all_car { result ->
//            if (result != null) {
//                // Handle the result when it's not null (successful response)
//                Log.i("CHECKOUT", "onResponse : ${result.data["1"]}")
//            } else {
//                // Handle the case when the result is null (failed response)
//                Log.i("CHECKOUT", "LOAD CAR BAD ASS")
//            }
//        }








//        api.login("erwinyonata", "spaceshuttle") { result ->
//            if (result != null) {
//                // Handle the result when it's not null (successful response)
//                Log.i("CHECKOUT", "onResponse : ${result.detail}")
//            } else {
//                // Handle the case when the result is null (failed response)
//                Log.i("CHECKOUT", "LOGIN BAD ASS")
//            }
//        }





//        api.signup("mia", "123", "123456", "mia@gmail.com") { result ->
//            if (result != null) {
//                // Handle the result when it's not null (successful response)
//                Log.i("CHECKOUT", "onResponse : ${result.detail}")
//            } else {
//                // Handle the case when the result is null (failed response)
//                Log.i("CHECKOUT", "SIGNUP BAD ASS")
//            }
//        }


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




//        api.add_car(name, plate, vin, distance, uid, cid, data) { result ->
//            if (result != null) {
//                // Handle the result when it's not null (successful response)
//                Log.i("CHECKOUT", "onResponse : ${result.detail}")
//            } else {
//                // Handle the case when the result is null (failed response)
//                Log.i("CHECKOUT", "ADD NEW CAR BAD ASS")
//            }
//        }




//        val automotive_id = "4f0608be-4088-43be-b349-e6c0bbeebf78"
//        api.delete_car(automotive_id) { result ->
//            if (result != null) {
//                // Handle the result when it's not null (successful response)
//                Log.i("CHECKOUT", "onResponse : ${result.detail}")
//            } else {
//                // Handle the case when the result is null (failed response)
//                Log.i("CHECKOUT", "DELETE CAR BAD ASS")
//            }
//        }




//        val automotive_id = "66cf7d24-5aae-4f36-867b-288807b8ffaf"
//        api.load_car(automotive_id) { result ->
//            if (result != null) {
//                // Handle the result when it's not null (successful response)
//                Log.i("CHECKOUT", "onResponse : ${result.detail}")
//            } else {
//                // Handle the case when the result is null (failed response)
//                Log.i("CHECKOUT", "LOAD CAR BAD ASS")
//            }
//        }

    }


}
