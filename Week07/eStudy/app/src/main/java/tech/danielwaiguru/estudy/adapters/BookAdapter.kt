package tech.danielwaiguru.estudy.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import tech.danielwaiguru.estudy.R
import tech.danielwaiguru.estudy.models.Book

class BookAdapter: ListAdapter<Book, BookAdapter.BookViewHolder>(BooksDiffCallback()) {
    inner class BookViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val book_cover: ImageView = itemView.findViewById(R.id.book_cover)
        val title: TextView = itemView.findViewById(R.id.book_title)
        val subtitle: TextView = itemView.findViewById(R.id.book_subtitle)
        val publisher: TextView = itemView.findViewById(R.id.book_publisher)
        val date: TextView = itemView.findViewById(R.id.date_published)
    }
    class BooksDiffCallback: DiffUtil.ItemCallback<Book>() {
        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookViewHolder {
        return BookViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.book_item,
            parent,
            false
        ))
    }


    override fun onBindViewHolder(
        holder: BookViewHolder,
        position: Int
    ) {
        val book = getItem(position)
        Picasso.get().load(book.volumeInfo.imageLinks.imageLinks).into(holder.book_cover)
        holder.title.text = book.volumeInfo.title
        holder.subtitle.text = book.volumeInfo.subtitle
        holder.publisher.text = book.volumeInfo.publisher
        holder.date.text = book.volumeInfo.publishedDate
    }
}