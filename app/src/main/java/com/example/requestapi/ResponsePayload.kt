package com.example.requestapi;

data class Signup(
    val is_success: Boolean,
    val info: String,
    val detail: String,
)

data class Login(
    val is_success: Boolean,
    val info: String,
    val detail: String,
    val data: UserDataLogin
)

data class UserDataLogin(
    val uid: String,
    val username: String,
    val password: String,
    val phone: String,
    val email: String,
    val verified: Int
)


data class ListAllCar(
    val is_success: Boolean,
    val info: String,
    val data: Map<String, List<String>>
)

data class AddCar(
    val is_success: Boolean,
    val info: String,
    val detail: String
)

data class LoadCar (
    val is_success: Boolean,
    val info: String,
    val detail: String,
    val data: LoadInformationCar
)

data class LoadInformationCar(
    val aid: String,
    val name: String,
    val plate: String,
    val vin: String,
    val distance: Int,
    val cid: String,
    val uid: String,
    val data: LoadCarComponents
)

data class LoadCarComponents(
    val oil: Component,
    val oil_filter: Component,
    val fuel_filter: Component,
    val air_filter: Component,
    val breakpad: Component
)

data class Component(
    val compid: String,
    val name: String,
    val last_change: String
)


data class DeleteCar(
    val is_success: Boolean,
    val info: String,
    val detail: String
)