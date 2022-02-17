package com.navercorp.kotlin.domain.mapper

import com.navercorp.kotlin.domain.dto.UserRequest
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
        @Param("id") id: Int
    ): User

    @Insert(
        """
        Insert into User
        (
            name,
            email,
            password, 
            age, 
            gender
        )
        values
        (
            #{name, jdbcType=VARCHAR}, 
            #{email, jdbcType=VARCHAR}, 
            #{password, jdbcType=VARCHAR},
            #{age, jdbcType=NUMERIC}, 
            #{gender, jdbcType=VARCHAR}
        )
        """
    )
    fun insertUser(
        param: UserRequest
    )
}
