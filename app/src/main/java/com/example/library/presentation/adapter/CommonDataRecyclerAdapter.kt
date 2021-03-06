package com.example.library.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.library.R
import com.example.library.domain.model.Book

class CommonDataRecyclerAdapter(private val bookList: ArrayList<Book>, private val onClickListener: (Book) -> Unit):
    RecyclerView.Adapter<CommonDataRecyclerAdapter.CommonDataViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonDataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.common_data_item, parent, false)
        return CommonDataViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommonDataViewHolder, position: Int) {
        holder.bind(bookList[position])
    }

    override fun getItemCount() = bookList.size

    inner class CommonDataViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val nameOfBook = itemView.findViewById<TextView>(R.id.book_name)
        private val descriptionOfBook = itemView.findViewById<TextView>(R.id.book_description)
        private val authorOfBook = itemView.findViewById<TextView>(R.id.book_author)
        private val layoutOfBook = itemView.findViewById<CardView>(R.id.book_layout)

        fun bind(book: Book) {
            nameOfBook.text = book.title
            descriptionOfBook.text = book.description
            authorOfBook.text = book.author
            layoutOfBook.setOnClickListener {
                onClickListener(book)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun show(data: ArrayList<Book>) {
        bookList.clear()
        bookList.addAll(data)
        notifyDataSetChanged()
    }
}