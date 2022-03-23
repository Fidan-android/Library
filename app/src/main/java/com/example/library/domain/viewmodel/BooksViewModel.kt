package com.example.library.domain.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.library.domain.model.Book
import com.example.library.domain.use_case.BookUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.launch
import java.util.*

@RequiresApi(Build.VERSION_CODES.M)
class BooksViewModel(
    private val bookUseCase: BookUseCase
): ViewModel() {

    private var books: MutableLiveData<ArrayList<Book>> = MutableLiveData()
    private var isNetwork: MutableLiveData<Boolean> = MutableLiveData(false)

    fun getBooks() = books
    fun getIsNetwork() = isNetwork

    init {
        Timer().scheduleAtFixedRate(
            object: TimerTask() {
                override fun run() {
                    isNetwork.postValue(bookUseCase.checkInternet())
                }
        }, 0, 2000)
    }

    fun downloadBooks() {
        viewModelScope.launch(Dispatchers.IO) {
            books.postValue(bookUseCase.execute())
        }
    }
}