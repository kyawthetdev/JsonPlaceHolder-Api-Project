package my.com.jsonplaceholderapiproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*

class Details : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_details)

        /**
         * intent မှာ ပါလာတဲ့ currentAlbum ကို
         * AlbumAdapter.ALBUM_KEY သုံးပြီး
         * getParcelableExtra<Formatter> နဲ့ ထုတ်ယူတာ။
         */
        val receiveAlbum = intent.getParcelableExtra<Formatter>(AlbumAdapter.ALBUM_KEY)

        details_title.text = receiveAlbum?.title

        details_id.text = receiveAlbum?.id.toString()
        details_title.isSelected = true

        details_url.text = receiveAlbum?.url

        details_url.isSelected = true

        Picasso.get().load(receiveAlbum?.thumbnailUrl).into(details_imageView)


    }
}
