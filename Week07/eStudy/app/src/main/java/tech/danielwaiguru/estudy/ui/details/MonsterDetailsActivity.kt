package tech.danielwaiguru.estudy.ui.details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_monster_details.*
import tech.danielwaiguru.estudy.R
import tech.danielwaiguru.estudy.models.Monster

class MonsterDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monster_details)
        getIncomingIntent()
    }
    private fun getIncomingIntent(){
        val intent = Intent()
        if (intent.hasExtra("monster")){
            intent.getParcelableExtra<Monster>("monster")?.apply {
                Picasso.get().load(this.thumbNail).into(monster_image)
                monster_name.text = this.monsterName
                monster_caption.text = this.caption
                monster_description.text = this.description
                monster_price.text = this.price.toString()
                ratingBar.rating = this.scariness.toFloat()
            }
        }
    }
}