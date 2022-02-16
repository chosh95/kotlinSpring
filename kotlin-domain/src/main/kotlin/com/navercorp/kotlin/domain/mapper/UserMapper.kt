package com.navercorp.kotlin.domain.mapper

import com.navercorp.kotlin.domain.model.User
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
interface UserMapper {

    @Select(
        """
        Select * 
        FROM USER
        WHERE USER.id = #{id};
        """
    )
    fun selectUser(
        @Param("id") id: String
    ): User

    @Insert(
        """
        Insert into User(name, email, password, age, gender)
        values(#{name}, #{email}, #{password}, #{age}, #{gender}
        """
    )
    fun insertUser(
        @Param("name") name: String,
        @Param("email") email: String,
        @Param("password") password: String,
        @Param("age") age: Int,
        @Param("gender") gender: String
    );
}
