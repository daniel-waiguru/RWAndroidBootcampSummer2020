package tech.danielwaiguru.estudy.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import tech.danielwaiguru.estudy.R
import tech.danielwaiguru.estudy.models.Book

class BookAdapter: ListAdapter<Book, BookAdapter.BookViewHolder>(BooksDiffCallback()) {
    private val booksList = mutableListOf<Book>()
    inner class BookViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val book_cover = itemView.findViewById<ImageView>(R.id.book_cover)
        val title = itemView.findViewById<TextView>(R.id.book_title)
        val subtitle = itemView.findViewById<TextView>(R.id.book_subtitle)
        val publisher = itemView.findViewById<TextView>(R.id.book_publisher)
        val date = itemView.findViewById<TextView>(R.id.date_published)
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
        val book = booksList[position]
        //holder.book_cover.setImageResource()
        holder.title.text = book.volumeInfo.title
        holder.publisher.text = book.publisher
        holder.date.text = book.publishedDate
    }
}