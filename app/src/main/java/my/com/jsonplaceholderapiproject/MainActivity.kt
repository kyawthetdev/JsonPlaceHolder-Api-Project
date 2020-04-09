package my.com.jsonplaceholderapiproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        doAsync {

            /**Json place holder က Link ကို java.net URL နဲ့ readText()ဆိုပြီးဖတ်တယ်။**/
            val placeHolderJsonPhoto = URL("https://jsonplaceholder.typicode.com/photos").readText()

            uiThread {

                /**
                 * placeHolderJsonPhoto ကို Google ရဲ့ .Gson() သုံးပြီး Array ပြောင်းတယ်။
                 * နောက်ဆုံးမှာ .toList() နဲ့ ArrayList ပြောင်းထားတယ်။
                 */
                val changeArrayList =
                    Gson().fromJson(placeHolderJsonPhoto, Array<Formatter>::class.java).toList()


                /**
                 * RecyclerView အတွက် layoutManager ဖန်တီးတယ်။
                 */
                val layoutManager = GridLayoutManager(this@MainActivity, 2)

                /**
                 * RecyclerView မှာ layoutManager တပ်တယ်။
                 */
                albumRecycler.layoutManager = layoutManager


                /**
                 * RecyclerView အတွက် adapter ဖန်တီးတယ်။
                 */
                val adp = AlbumAdapter(this@MainActivity, changeArrayList)


                /**
                 * RecyclerView မှာ  adapter တပ်တယ်။
                 */
                albumRecycler.adapter = adp


            }
        }
    }
}
