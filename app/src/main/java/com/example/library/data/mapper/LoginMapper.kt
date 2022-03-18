package com.example.library.data.mapper

import com.example.library.data.model.LibraryEntity
import com.example.library.data.model.UserEntity
import com.example.library.domain.model.Library
import com.example.library.domain.model.LoginForm

class LoginMapper(): Mapper<LoginForm, UserEntity> {

    override fun mapToEntity(data: LoginForm): UserEntity {
        return UserEntity(id = data.id, userName = data.userName, userLogin = data.userLogin, hashPassword = data.userPassword)
    }

    override fun mapToModel(data: UserEntity): LoginForm {
        return LoginForm(id = data.id, userName = data.userName, userLogin = data.userLogin, userPassword = data.hashPassword)
    }

}