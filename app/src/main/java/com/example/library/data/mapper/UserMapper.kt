package com.example.library.data.mapper

import com.example.library.data.model.UserEntity
import com.example.library.domain.model.UserForm

class UserMapper(): Mapper<UserForm, UserEntity> {

    override fun mapToEntity(data: UserForm): UserEntity {
        return UserEntity(id = data.id, userName = data.userName, userLogin = data.userLogin, hashPassword = data.userPassword)
    }

    override fun mapToModel(data: UserEntity): UserForm {
        return UserForm(id = data.id, userName = data.userName, userLogin = data.userLogin, userPassword = data.hashPassword)
    }

}