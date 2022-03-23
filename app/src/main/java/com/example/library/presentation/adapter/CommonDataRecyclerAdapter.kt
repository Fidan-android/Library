package com.example.library.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.library.R
import com.example.library.domain.model.Book

class CommonDataRecyclerAdapter(private val bookList: ArrayList<Book>):
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
        private val authorOfBook = itemView.findViewById<TextView>(R.id.book_author)

        fun bind(book: Book) {
            nameOfBook.text = book.title
            authorOfBook.text = book.author        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun show(data: ArrayList<Book>) {
        bookList.clear()
        bookList.addAll(data)
        notifyDataSetChanged()
    }
}