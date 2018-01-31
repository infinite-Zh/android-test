package com.infinite.androidtest.repository

import android.support.v4.content.ContextCompat

/**
 * Created by kfzhangxu on 2018/1/31.
 */
class LoginDataSource : ILoginDataSource {
    override fun login(email: String, password: String, callBack: ILoginDataSource.LoginCallBack) {
        var result: Boolean
        var message: String
    }

}