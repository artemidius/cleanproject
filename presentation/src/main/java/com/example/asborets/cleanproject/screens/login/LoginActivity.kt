package com.example.asborets.cleanproject.screens.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import com.example.asborets.cleanproject.R
import com.example.domain.model.LoginScreenViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.Screen {

    lateinit var presenter:LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter()
        presenter.onCreate(this)

        login_button.setOnClickListener{ presenter.onLoginButtonPressed(getCurrentViewModel()) }
    }

    override fun showSnack(message: String) {
        Snackbar.make(login_screen, message, Snackbar.LENGTH_LONG).show()
    }

    override fun deactivateLoginButton(state: Boolean) {
        login_button.isClickable = !state
    }

    private fun getCurrentViewModel() = LoginScreenViewModel (
            email.text.toString(),
            password.text.toString(),
            user_agreement.isChecked,
            mail_list.isChecked
    )
}
