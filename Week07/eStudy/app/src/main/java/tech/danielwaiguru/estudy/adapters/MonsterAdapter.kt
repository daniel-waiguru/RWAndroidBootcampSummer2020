package tech.danielwaiguru.estudy.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import tech.danielwaiguru.estudy.R
import tech.danielwaiguru.estudy.models.Monster

class MonsterAdapter: RecyclerView.Adapter<MonsterAdapter.MonsterViewHolder>() {
    private var monsters: List<Monster> = emptyList()
    inner class MonsterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val monsterImage: ImageView = itemView.findViewById(R.id.monster_image)
        val monsterName: TextView = itemView.findViewById(R.id.monster_name)
        val monsterCaption: TextView = itemView.findViewById(R.id.monster_caption)
        val rating: RatingBar = itemView.findViewById(R.id.rating)

    }

    override fun getItemCount(): Int {
        return monsters.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MonsterViewHolder {
        return MonsterViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.monster_item,
            parent,
            false
        ))
    }


    override fun onBindViewHolder(
        holder: MonsterViewHolder,
        position: Int
    ) {
        val monster = monsters[position]
        Picasso.get().load(monster.thumbNail).into(holder.monsterImage)
        holder.monsterName.text = monster.monsterName
        holder.monsterCaption.text = monster.caption
        holder.rating.rating = monster.scariness.toFloat()
    }
    internal fun setData(monsters: List<Monster>){
        this.monsters = monsters
        notifyDataSetChanged()
    }
}