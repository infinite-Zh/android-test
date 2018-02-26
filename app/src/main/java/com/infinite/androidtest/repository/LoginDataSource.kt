package com.infinite.androidtest.repository

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

/**
 * Created by kfzhangxu on 2018/1/31.
 */
class LoginDataSource : ILoginDataSource {
    override fun login(email: String, password: String, callBack: ILoginDataSource.LoginCallBack) {

        // TODO() multi thread

        object : Thread() {
            override fun run() {
                Looper.prepare()
                super.run()
//                Thread.sleep(2000)
//                val handler=MyHandler(callBack)
//                val message=handler.obtainMessage()
                var result:Boolean
                var msg:String
                val bundle=Bundle()
                if (email != "abc@163.com") {
                    callBack.callBack(false, "用户名错误")
                    result=false
                    msg="用户名错误"
                    bundle.putBoolean("result",result)
                    bundle.putString("msg",msg)
//                    message.data=bundle
//                    handler.sendMessage(message)
                    return
                }
                if (password != "123abc") {
                    callBack.callBack(false, "密码错误")
                    result=false
                    msg="密码错误"
                    bundle.putBoolean("result",result)
                    bundle.putString("msg",msg)
//                    message.data=bundle
//                    handler.sendMessage(message)
                    return
                }

                result=true
                msg="登陆成功"
                bundle.putBoolean("result",result)
                bundle.putString("msg",msg)
//                message.data=bundle
//                handler.sendMessage(message)
                callBack.callBack(true, "登陆成功")
            }
        }.start()

    }

    class MyHandler() : Handler() {
        private lateinit var callback: ILoginDataSource.LoginCallBack

        constructor(callBack: ILoginDataSource.LoginCallBack) : this() {
            this.callback = callBack
        }

        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            val b=msg!!.data
            val result=b.getBoolean("result")
            val msg=b.getString("msg")
            callback!!.callBack(result,msg)
        }
    }
}