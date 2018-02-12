package com.infinite.androidtest.repository

import android.support.v4.content.ContextCompat
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

/**
 * Created by kfzhangxu on 2018/1/31.
 */
class LoginDataSource : ILoginDataSource {
    override fun login(email: String, password: String, callBack: ILoginDataSource.LoginCallBack) {

        // TODO() multi thread

        Thread()
        if (email != "abc@163.com") {
            callBack.callBack(false, "用户名错误")
            return
        }
        if (password != "123abc") {
            callBack.callBack(false, "密码错误")
            return
        }

        callBack.callBack(true, "登陆成功")
    }



}