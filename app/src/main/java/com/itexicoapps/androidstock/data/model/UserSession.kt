package com.itexicoapps.androidstock.data.model

import com.itexicoapps.androidstock.base.materialdesign.MaterialColors
import com.itexicoapps.androidstock.base.materialdesign.MaterialImages

class UserSession (var isConfSaved: Boolean,
                   var userActive: Boolean,
                   var filename: String = "bundledskinitexico",
                   var materialColors: MaterialColors,
                   var materialImages: MaterialImages,
                   var currentSkin: String)