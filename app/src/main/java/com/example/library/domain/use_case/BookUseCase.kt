package com.example.library.domain.use_case

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.library.data.repository.ApiRepositoryImpl
import com.example.library.data.repository.BookRepositoryImpl
import com.example.library.domain.model.Book
import com.example.library.presentation.adapter.CommonDataRecyclerAdapter


class BookUseCase(
    private val applicationContext: Context,
    private val bookRepositoryImpl: BookRepositoryImpl,
    private val apiRepositoryImpl: ApiRepositoryImpl
) {

    fun getBooksFromRoom(): ArrayList<Book> {
        val books = bookRepositoryImpl.getBooks()
        return if (books == null) ({
            emptyList<Book>()
        }) as ArrayList<Book> else {
            ArrayList(books.map { it })
        }
    }

    suspend fun downloadBooks(): ArrayList<Book> {
        val books = apiRepositoryImpl.getBooks()
        bookRepositoryImpl.insertBooks(books)

        return ArrayList(books.map { it })
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun checkInternet(): Boolean {
        val cm = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return cm!!.activeNetwork != null && cm.activeNetworkInfo!!.isConnected
    }

    fun getAdapter(list: ArrayList<Book>, onClickListener: (Book) -> Unit): CommonDataRecyclerAdapter = CommonDataRecyclerAdapter(list) {
        onClickListener(it)
    }
}