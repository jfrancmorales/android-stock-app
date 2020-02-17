package com.itexicoapps.androidstock.ui.login

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.annotation.StringRes
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate.*
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.google.android.gms.auth.api.phone.SmsRetrieverClient
import com.itexicoapps.androidstock.NavMenuActivity

import com.itexicoapps.androidstock.R
import com.itexicoapps.androidstock.base.BaseActivity
import com.itexicoapps.androidstock.extensions.addImage
import com.itexicoapps.androidstock.extensions.afterTextChanged
import com.itexicoapps.androidstock.extensions.applySkinStyle
import com.itexicoapps.androidstock.extensions.applySkinColors
import com.itexicoapps.androidstock.smsservices.MessageListener
import com.itexicoapps.androidstock.smsservices.MessageReceiver
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

/*        skinRepository = LCSkinServiceRepository(this.application)

        with (skinRepository) {
            this?.applyBundleSkinLocal(confFileName)?.let {
                applyChanges(it)
            }
        }*/

        MessageReceiver.bindListener {
            Toast.makeText(this, "New Message Received: $it", Toast.LENGTH_SHORT).show()
        }

        val client: SmsRetrieverClient = SmsRetriever.getClient(this)

        val task = client.startSmsRetriever()

        task.addOnSuccessListener {
            // Successfully started retriever, expect broadcast intent
            Toast.makeText(this, "New Message Received: $it", Toast.LENGTH_SHORT).show()
        }

        task.addOnFailureListener {
            // Failed to start retriever, inspect Exception for more details
            Toast.makeText(this, "New Message Received: $it", Toast.LENGTH_SHORT).show()
        }

        loginViewModel = ViewModelProviders.of(this, LoginViewModelFactory())
            .get(LoginViewModel::class.java)

        loginViewModel.loginFormState.observe(this@LoginActivity, Observer {
            val loginState = it ?: return@Observer

            // disable login button unless both username / password is valid
            contact_button.isEnabled = loginState.isDataValid

            if (loginState.usernameError != null) {
                //username_input_layout.error = getString(loginState.usernameError)
                username_edit_text.error = getString(loginState.usernameError)
            }
            if (loginState.passwordError != null) {
                //password_input_layout.error = getString(loginState.passwordError)
                password_edit_text.error = getString(loginState.passwordError)
            }
        })

        loginViewModel.loginResult.observe(this@LoginActivity, Observer {
            val loginResult = it ?: return@Observer

            loading.visibility = View.GONE
            if (loginResult.error != null) {
                showLoginFailed(loginResult.error)
            }
            if (loginResult.success != null) {
                updateUiWithUser(loginResult.success)
                //There is a better way to do this, kotlin can help on this, however, for the moment
                //this is ok.
            }
            setResult(Activity.RESULT_OK)

            var args = Bundle()
            //args.putString(CONFIG_BUNDLE_FILE_NAME, confFileName)
            launchActivity(NavMenuActivity::class.java, args)
            //Complete and destroy login activity once successful
            finish()
        })

        login_logo_image.setOnClickListener {
            //Testing chameleon color changes
            //showDialog()
            //setDefaultNightMode(MODE_NIGHT_FOLLOW_SYSTEM)
        }

        username_edit_text.afterTextChanged {
            loginViewModel.loginDataChanged(
                username_edit_text.text.toString(),
                password_edit_text.text.toString()
            )
        }

        password_edit_text.apply {
            afterTextChanged {
                loginViewModel.loginDataChanged(
                    username_edit_text.text.toString(),
                    password_edit_text.text.toString()
                )
            }

            setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_DONE ->
                        loginViewModel.login(
                            username_edit_text.text.toString(),
                            password_edit_text.text.toString()
                        )
                }
                false
            }

            contact_button.setOnClickListener {
                loading.visibility = View.VISIBLE
                loginViewModel.login(username_edit_text.text.toString(), password_edit_text.text.toString())
            }
        }

        forgot_your_password_clickable_text.setOnClickListener {
            var forgotActivityIntent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(forgotActivityIntent)
        }

        contact_clickable_text.setOnClickListener {
            var contactActivityIntent = Intent(this, ContactActivity::class.java)
            startActivity(contactActivityIntent)
        }
    }

    override fun applyChanges(skin: HashMap<String,String>) {
        super.applyChanges(skin)
        skin.let {
            this.window?.applySkinStyle(materialColors.colorPrimary, materialColors.colorPrimary)
            supportActionBar?.applySkinStyle(materialColors.colorPrimary)
            container.applySkinStyle(materialColors.colorBackground)

            materialImages.loginImage?.let {
                login_logo_image.addImage(false, it)
            }

            username_input_layout.applySkinStyle(materialColors.colorPrimary, materialColors.colorSecondary, materialColors.colorOnError)
            username_edit_text.setHintTextColor(Color.parseColor(materialColors.colorOnPrimaryVariant))
            password_input_layout.applySkinStyle(materialColors.colorPrimary, materialColors.colorSecondary, materialColors.colorOnError)
            password_edit_text.setHintTextColor(Color.parseColor(materialColors.colorOnPrimaryVariant))
            contact_button.applySkinColors(materialColors.colorPrimary, materialColors.colorOnPrimary, materialColors.colorSecondary, materialColors.colorPrimaryVariant)

            forgot_your_password_clickable_text.applySkinStyle(materialColors.colorSecondary, materialColors.colorOnSecondary)
            contact_clickable_text.applySkinStyle(materialColors.colorSecondary, materialColors.colorOnSecondary)
            var contactIcon = resources.getDrawable(R.drawable.ic_contact_shape, theme)
            contactIcon.setTint(Color.parseColor(materialColors.colorPrimary))
            contact_clickable_text.setCompoundDrawablesWithIntrinsicBounds(contactIcon, null,null,null)
            app_version_label.applySkinStyle(materialColors.colorSecondary, materialColors.colorOnSecondary)
        }
    }

    private fun updateUiWithUser(model: LoggedInUserView) {
        val welcome = getString(R.string.welcome)
        val displayName = model.displayName
        // TODO : initiate successful logged in experience
        // TODO : New Bottom Nav Activity will Run From here
        Toast.makeText(
            applicationContext,
            "$welcome $displayName",
            Toast.LENGTH_LONG
        )
    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        Toast.makeText(applicationContext, errorString, Toast.LENGTH_SHORT).show()
    }
}
