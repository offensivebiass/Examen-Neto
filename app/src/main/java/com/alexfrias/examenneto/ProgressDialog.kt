package com.alexfrias.examenneto

import android.app.Activity
import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat

class ProgressDialog {

    lateinit var dialog: Dialog

    fun showDialog(activity: Activity) {
        dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_progress)
        dialog.window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        dialog.window!!.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        dialog.window!!.setBackgroundDrawable(
            ColorDrawable(
                ContextCompat.getColor(
                    activity,
                    R.color.dialog_bg
                )
            )
        )

        dialog.show()
    }

    fun dismissDialog() {
        dialog.dismiss()
    }

}