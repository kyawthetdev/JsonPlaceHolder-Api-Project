package my.com.jsonplaceholderapiproject

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.album_row.view.*


/**
 *RecyclerView.Adapter ကို extends လုပ်တယ်။
 */
class AlbumAdapter(private val context: Context, private val albums: List<Formatter>) :
    RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    companion object{
        /**
         * currentAlbum ကို detailsAlbum Activity မှာ သုံးဖို့ အတွက်
         * companion object နဲ့ ALBUM_KEY တစ်ခုတည်ဆောက်တယ်။
         */
        val ALBUM_KEY="ALBUM_KEY"


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        /**
         * album_row.xml ကို view တစ်ခုအဖြစ်  inflate လုပ်သုံးတာ။
         */
        val view = LayoutInflater.from(context).inflate(R.layout.album_row, parent, false)


        return ViewHolder(view)
    }

    override fun getItemCount(): Int = albums.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        /**
         * currentAlbum ကို ယူတာ။
         */
        val currentAlbum = albums[position]

        holder.itemView.album_textView.text = currentAlbum.title.substring(0, 10)
        /**
         *  Picasso lib နဲ့ ပုံကို ဆွဲယူပြတာ။
         */
        Picasso.get().load(currentAlbum.thumbnailUrl).into(
            holder.itemView.album_imageView
        )

        /**
         * button click ဖမ်းတာ။
         */

        holder.itemView.album_button.setOnClickListener {


            val detailsIntent = Intent(context, Details::class.java)

            /**
             * Intent နဲ့ currentAlbum ကိုထည့်ပေးတာ။
             */
            detailsIntent.putExtra(ALBUM_KEY,currentAlbum)

            context.startActivity(detailsIntent)




        }


    }

    /**
     * ViewHolder class တည်ဆောက်ပေးတယ်။
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)


}