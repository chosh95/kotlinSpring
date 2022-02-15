package com.navercorp.kotlinspring.repository

import com.navercorp.kotlinspring.Model.Tmp
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface TmpRepository {
    @Select(
        """ 
        SELECT 
            * 
        FROM 
            tmp;
        """
    )
    fun findAll(): List<Tmp>
}
