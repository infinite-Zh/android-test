package com.infinite.androidtest.repository

/**
 * Created by kfzhangxu on 2018/1/31.
 */
interface ILoginDataSource {
    fun login(email: String, password: String)
}