package com.twsihan.examples.services

import com.github.pagehelper.PageHelper
import org.springframework.beans.factory.annotation.Autowired
import com.twsihan.examples.entities.UserInfo
import com.twsihan.examples.mappers.UserInfoMapper
import org.springframework.stereotype.Service

@Service
class UserInfoService
{
    @Autowired
    private lateinit var userInfoMapper: UserInfoMapper


    fun getAll(userInfo: UserInfo): List<UserInfo>
    {
        if (userInfo.page != null && userInfo.rows != null) {
            PageHelper.startPage<Any>(userInfo.page, userInfo.rows)
        }
        return userInfoMapper.selectAll()
    }

    fun getById(id: Int?): UserInfo
    {
        return userInfoMapper.selectByPrimaryKey(id)
    }

    fun deleteById(id: Int?)
    {
        userInfoMapper.deleteByPrimaryKey(id)
    }

    fun save(country: UserInfo)
    {
        if (country.id != null) {
            userInfoMapper.updateByPrimaryKey(country)
        } else {
            userInfoMapper.insert(country)
        }
    }
}
