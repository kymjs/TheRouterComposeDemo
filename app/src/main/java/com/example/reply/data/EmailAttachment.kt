package com.example.reply.data

import androidx.annotation.DrawableRes

/**
 * An object class to define an attachment to email object.
 */
data class EmailAttachment(@DrawableRes val resId: Int, val contentDesc: String)
