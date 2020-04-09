package my.com.jsonplaceholderapiproject

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/**
 * Formatter data class တည်ဆောက်တာ။
 * currentAlbum တစ်ခုလုံး ကို Details Activity ကို ပို့ချင်တာ ဖြစ်လို့  @Parcelize ထည့်ပေးရတယ်။
 * Parcelable နဲ့ extends လုပ်ပေးရတယ်။
 * build.gradle(Module:app) မှာ လည်း
 * androidExtensions {
 * experimental = true
 * } ထည့်ပေးရတယ်။
 */

@Parcelize
data class Formatter(val id: Int, val title: String, val url: String, val thumbnailUrl: String) :
    Parcelable