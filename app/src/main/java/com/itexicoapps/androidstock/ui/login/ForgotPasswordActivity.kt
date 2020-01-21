package com.itexicoapps.androidstock.ui.login

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import com.itexicoapps.androidstock.R
import com.itexicoapps.androidstock.base.BaseActivity
import com.itexicoapps.androidstock.extensions.addImage
import com.itexicoapps.androidstock.extensions.applySkinStyle
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPasswordActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        supportActionBar?.hide()

        /*skinRepository = LCSkinServiceRepository(this.application)

        with (skinRepository) {
            this?.applyBundleSkinLocal(confFileName)?.let {
                applyChanges(it)
            }
        }*/

        contact_clickable_text.setOnClickListener {
            var contactActivityIntent = Intent(this, ContactActivity::class.java)
            startActivity(contactActivityIntent)
        }
    }

    override fun applyChanges(skin: HashMap<String, String>) {
        super.applyChanges(skin)

        logo_fp_image.addImage(false, userSession!!.materialImages.loginImage)

        username_input_layout.applySkinStyle(materialColors.colorPrimary,
            materialColors.colorSecondary,
            materialColors.colorOnError)
        username_edit_text.setHintTextColor(Color.parseColor(materialColors.colorOnPrimaryVariant))
        var iconShape = resources.getDrawable(R.drawable.ic_profile_shape, theme)
        iconShape.setTint(Color.parseColor(materialColors.colorOnPrimaryVariant))
        username_edit_text.setCompoundDrawablesWithIntrinsicBounds(null, null, iconShape,null)

        loan_input_layout.applySkinStyle(materialColors.colorPrimary,
            materialColors.colorSecondary,
            materialColors.colorOnError)
        loan_edit_text.setHintTextColor(Color.parseColor(materialColors.colorOnPrimaryVariant))
        var iconLoan = resources.getDrawable(R.drawable.ic_home_black, theme)
        iconLoan.setTint(Color.parseColor(materialColors.colorOnPrimaryVariant))
        loan_edit_text.setCompoundDrawablesWithIntrinsicBounds(null, null, iconLoan,null)

        ssn_tin_input_layout.applySkinStyle(materialColors.colorPrimary,
            materialColors.colorSecondary,
            materialColors.colorOnError)
        ssn_tin_edit_text.setHintTextColor(Color.parseColor(materialColors.colorOnPrimaryVariant))
        var iconSsn = resources.getDrawable(R.drawable.ic_ssn_image, theme)
        iconSsn.setTint(Color.parseColor(materialColors.colorOnPrimaryVariant))
        ssn_tin_edit_text.setCompoundDrawablesWithIntrinsicBounds(null, null, iconSsn,null)

        /*reset_password_button.applySkinColors(materialColors.colorOnPrimary,
            materialColors.colorPrimary,
            materialColors.colorSecondary,
            materialColors.colorPrimaryVariant)*/

        contact_clickable_text.applySkinStyle(materialColors.colorSecondary, materialColors.colorOnSecondary)
        var contactIcon = resources.getDrawable(R.drawable.ic_contact_shape, theme)
        contactIcon.setTint(Color.parseColor(materialColors.colorPrimary))
        contact_clickable_text.setCompoundDrawablesWithIntrinsicBounds(contactIcon, null,null,null)
        contact_clickable_text.setOnClickListener {
            var contactActivityIntent = Intent(this, ContactActivity::class.java)
            startActivity(contactActivityIntent)
        }
    }
}
