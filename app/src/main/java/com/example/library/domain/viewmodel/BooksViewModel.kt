package com.example.library.domain.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.library.domain.model.Book
import com.example.library.domain.use_case.BookUseCase
import com.example.library.presentation.adapter.CommonDataRecyclerAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList

@RequiresApi(Build.VERSION_CODES.M)
class BooksViewModel(
    private val bookUseCase: BookUseCase
): ViewModel() {

    private var books: MutableLiveData<ArrayList<Book>> = MutableLiveData()
    private var isNetwork: MutableLiveData<Boolean> = MutableLiveData(false)
    private var recyclerAdapter: MutableLiveData<CommonDataRecyclerAdapter> = MutableLiveData(null)

    fun getBooks() = books
    fun getIsNetwork() = isNetwork
    fun getRecyclerAdapter() = recyclerAdapter

    init {
        Timer().scheduleAtFixedRate(
            object: TimerTask() {
                override fun run() {
                    isNetwork.postValue(bookUseCase.checkInternet())
                }
        }, 0, 2000)

        if (bookUseCase.getBooksFromRoom().isNotEmpty()) {
            books.value = bookUseCase.getBooksFromRoom()
        }
    }

    fun downloadBooks() {
        viewModelScope.launch(Dispatchers.IO) {
            books.postValue(bookUseCase.downloadBooks())
        }
    }

    fun createAdapter(list: ArrayList<Book>) {
        if (recyclerAdapter.value == null) {
            recyclerAdapter.value = bookUseCase.getAdapter(list)
        } else {
            recyclerAdapter.value!!.show(list)
        }
    }
}