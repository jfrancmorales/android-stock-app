package com.itexicoapps.androidstock.ui.login

import android.graphics.Color
import android.os.Bundle
import com.itexicoapps.androidstock.R
import com.itexicoapps.androidstock.base.BaseActivity
import com.itexicoapps.androidstock.extensions.applySkinColors
import com.itexicoapps.androidstock.extensions.applySkinStyle
import com.lc.skinService.repository.LCSkinServiceRepository
import kotlinx.android.synthetic.main.activity_contact.*

class ContactActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        supportActionBar?.hide()

        /*skinRepository = LCSkinServiceRepository(this.application)

        with (skinRepository) {
            this?.applyBundleSkinLocal(confFileName)?.let {
                applyChanges(it)
            }
        }*/

        back_arrow_image.setOnClickListener {
            onBackPressed()
        }
    }

    override fun applyChanges(skin: HashMap<String, String>) {
        super.applyChanges(skin)

        contact_title.applySkinStyle(materialColors.colorSecondary, materialColors.colorOnSecondary)
        var contactIcon = resources.getDrawable(R.drawable.ic_contact_shape, null)
        contactIcon.setTint(Color.parseColor(materialColors.colorPrimary))
        contact_title.setCompoundDrawablesWithIntrinsicBounds(contactIcon, null,null,null)

        first_name_input_layout.applySkinStyle(materialColors.colorPrimary,
            materialColors.colorSecondary,
            materialColors.colorOnError)
        first_name_edit_text.setHintTextColor(Color.parseColor(materialColors.colorOnPrimaryVariant))
        last_name_input_layout.applySkinStyle(materialColors.colorPrimary,
            materialColors.colorSecondary,
            materialColors.colorOnError)
        last_name_edit_text.setHintTextColor(Color.parseColor(materialColors.colorOnPrimaryVariant))
        email_address_input_layout.applySkinStyle(materialColors.colorPrimary,
            materialColors.colorSecondary,
            materialColors.colorOnError)
        email_address_edit_text.setHintTextColor(Color.parseColor(materialColors.colorOnPrimaryVariant))
        company_input_layout.applySkinStyle(materialColors.colorPrimary,
            materialColors.colorSecondary,
            materialColors.colorOnError)
        company_edit_text.setHintTextColor(Color.parseColor(materialColors.colorOnPrimaryVariant))
        city_input_layout.applySkinStyle(materialColors.colorPrimary,
            materialColors.colorSecondary,
            materialColors.colorOnError)
        city_edit_text.setHintTextColor(Color.parseColor(materialColors.colorOnPrimaryVariant))
        state_input_layout.applySkinStyle(materialColors.colorPrimary,
            materialColors.colorSecondary,
            materialColors.colorOnError)
        state_edit_text.setHintTextColor(Color.parseColor(materialColors.colorOnPrimaryVariant))
        zip_input_layout.applySkinStyle(materialColors.colorPrimary,
            materialColors.colorSecondary,
            materialColors.colorOnError)
        zip_edit_text.setHintTextColor(Color.parseColor(materialColors.colorOnPrimaryVariant))
        phone_input_layout.applySkinStyle(materialColors.colorPrimary,
            materialColors.colorSecondary,
            materialColors.colorOnError)
        phone_edit_text.setHintTextColor(Color.parseColor(materialColors.colorOnPrimaryVariant))

        loan_label.applySkinStyle(materialColors.colorSecondary, materialColors.colorOnSecondary)
        loan_number.applySkinStyle(materialColors.colorSecondary, materialColors.colorOnSecondary)

        contact_button.applySkinColors(materialColors.colorOnPrimary,
            materialColors.colorPrimary,
            materialColors.colorSecondary,
            materialColors.colorPrimaryVariant)

    }
}
