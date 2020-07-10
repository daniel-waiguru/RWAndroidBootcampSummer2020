package tech.danielwaiguru.estudy.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import tech.danielwaiguru.estudy.R
import tech.danielwaiguru.estudy.models.Book

class BookAdapter: RecyclerView.Adapter<BookAdapter.BookViewHolder>() {
    private val booksList = mutableListOf<Book>()
    inner class BookViewHolder(private val itemView: View): RecyclerView.ViewHolder(itemView) {

    }
    class BooksDiffCallback: DiffUtil.ItemCallback<Book>() {
        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
            TODO("Not yet implemented")
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

    override fun getItemCount(): Int = booksList.size

    override fun onBindViewHolder(
        holder: BookViewHolder,
        position: Int
    ) {
        TODO("Not yet implemented")
    }
}