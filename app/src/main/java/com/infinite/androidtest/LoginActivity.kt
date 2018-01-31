package com.infinite.androidtest

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.infinite.androidtest.repository.ILoginDataSource
import com.infinite.androidtest.repository.LoginDataSource
import kotlinx.android.synthetic.main.activity_login.*

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity() {

    lateinit var loginDataSource: LoginDataSource
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginDataSource = LoginDataSource()
        email_sign_in_button.setOnClickListener({
            performLogin()
        })
    }

    public fun performLogin() {
        val emailText = email.text.toString()
        val passwordText = password.text.toString()
        if (emailText.isEmpty()) {
            Snackbar.make(email, getString(R.string.email_empty), Snackbar.LENGTH_LONG).show()
            return
        }
        if (!emailText.contains("@")) {
            Snackbar.make(email, getString(R.string.email_illegal), Snackbar.LENGTH_LONG).show()
            return
        }

        if (passwordText.isEmpty()) {
            Snackbar.make(email, getString(R.string.password_empty), Snackbar.LENGTH_LONG).show()
            return
        }

        loginDataSource.login(emailText, passwordText, object : ILoginDataSource.LoginCallBack {
            override fun callBack(result: Boolean, message: String) {
                if (result) {
                    intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Snackbar.make(email_login_form, message, Snackbar.LENGTH_LONG).show()
                }
            }
        })
    }
}
