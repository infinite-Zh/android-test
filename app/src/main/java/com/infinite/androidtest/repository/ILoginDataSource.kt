package com.infinite.androidtest.repository

/**
 * Created by kfzhangxu on 2018/1/31.
 */
interface ILoginDataSource {
    interface LoginCallBack {
        fun callBack(result: Boolean, message: String)
    }

    fun login(email: String, password: String,callBack: LoginCallBack)
}