package com.example.navigationexample.network.model

import com.google.gson.annotations.SerializedName


data class SeoOnPage (

  @SerializedName("titleHead"       ) var titleHead       : String?           = null,
  @SerializedName("descriptionHead" ) var descriptionHead : String?           = null,
  @SerializedName("og_type"         ) var ogType          : String?           = null,
  @SerializedName("og_image"        ) var ogImage         : ArrayList<String> = arrayListOf()

)