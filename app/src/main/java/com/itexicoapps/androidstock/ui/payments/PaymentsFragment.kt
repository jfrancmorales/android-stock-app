package com.itexicoapps.androidstock.ui.payments

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

import com.itexicoapps.androidstock.R
import com.itexicoapps.androidstock.base.BaseFragment
import com.itexicoapps.androidstock.extensions.addImage
import com.itexicoapps.androidstock.extensions.applySkinColors
import com.itexicoapps.androidstock.extensions.applySkinStyle
import kotlinx.android.synthetic.main.fragment_payments.*

class PaymentsFragment : BaseFragment() {

    private lateinit var paymentsViewModel: PaymentsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        paymentsViewModel =
            ViewModelProviders.of(this).get(PaymentsViewModel::class.java)
        return inflater.inflate(R.layout.fragment_payments, container, false)
    }

    override fun applyChanges() {
        super.applyChanges()
        payment_detail_container.applySkinStyle(materialColors.colorBackground)
        payments_dropdown_edit_text.setHintTextColor(Color.parseColor(materialColors.colorOnPrimaryVariant))
        house_text_view.background.setTint(Color.parseColor(materialColors.colorOnPrimaryVariant))
        icon_arrow_down.background.setTint(Color.parseColor(materialColors.colorOnPrimaryVariant))

        total_amount_due_container.applySkinStyle(materialColors.colorBackground)

        //calendar_circle_icon.background.setTint(Color.parseColor(materialColors.colorPrimary))

        total_amount_due_text.applySkinStyle(materialColors.colorSecondary, materialColors.colorPrimaryVariant)
        total_amount_value.applySkinStyle(materialColors.colorSecondary, materialColors.colorPrimary)
        due_date_payments.applySkinStyle(materialColors.colorSecondary, materialColors.colorPrimary)

        amount_due_button.applySkinColors(materialColors.colorPrimary,
            materialColors.colorOnPrimary, materialColors.colorSecondary,
            materialColors.colorPrimaryVariant)
        scheduled_payments_container.applySkinStyle(materialColors.colorBackground)
        scheduled_payment_text.applySkinStyle(materialColors.colorSecondary, materialColors.colorPrimary)
        for (drawable in scheduled_payment_text.compoundDrawables) {
            if (drawable != null) {
                with(drawable) {
                    setTint(Color.parseColor(materialColors.colorPrimary))
                }
            }
        }

        //clock_icon.background.setTint(Color.parseColor(materialColors.colorSecondary))

        amount_scheduled.applySkinStyle(materialColors.colorSecondary, materialColors.colorPrimary)
        property_image.addImage(false , materialImages.whitePopupImage)
        property_image.background = ColorDrawable(Color.parseColor(materialColors.colorPrimary))

    }
}