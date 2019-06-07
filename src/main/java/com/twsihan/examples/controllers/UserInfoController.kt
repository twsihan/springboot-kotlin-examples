package com.twsihan.examples.controllers

import org.springframework.ui.ModelMap
import com.twsihan.examples.entities.UserInfo
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PathVariable
import com.github.pagehelper.PageInfo
import com.twsihan.examples.services.UserInfoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserInfoController
{
    @Autowired
    private lateinit var userInfoService: UserInfoService


    @RequestMapping
    fun getAll(userInfo: UserInfo): PageInfo<UserInfo>
    {
        val userInfoList = userInfoService.getAll(userInfo)
        return PageInfo(userInfoList)
    }

    @RequestMapping("/add")
    fun add(): UserInfo
    {
        return UserInfo()
    }

    @RequestMapping("/view/{id}")
    fun view(@PathVariable id: Int?): UserInfo
    {
        return userInfoService.getById(id)
    }

    @RequestMapping("/delete/{id}")
    fun delete(@PathVariable id: Int?): ModelMap
    {
        val result = ModelMap()
        userInfoService.deleteById(id)
        result["msg"] = "删除成功!"
        return result
    }

    @RequestMapping(value = ["/save"], method = [RequestMethod.POST])
    fun save(userInfo: UserInfo): ModelMap
    {
        val result = ModelMap()
        val msg = if (userInfo.id == null) "新增成功!" else "更新成功!"
        userInfoService.save(userInfo)
        result["userInfo"] = userInfo
        result["msg"] = msg
        return result
    }
}
