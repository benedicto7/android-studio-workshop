package com.example.affirmationslist.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

// Data class to hold and represent data
// Represents 1 block/unit of a data in Datasource() class
// Easier for Datasource() class to hold data,
// an array inside an array
data class Affirmation(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int)
