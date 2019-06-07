package com.twsihan.examples.controllers

import org.springframework.ui.ModelMap
import com.twsihan.examples.entities.City
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PathVariable
import com.github.pagehelper.PageInfo
import com.twsihan.examples.services.CityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cities")
class CityController
{
    @Autowired
    private lateinit var cityService: CityService


    @RequestMapping
    fun getAll(city: City): PageInfo<City>
    {
        val countryList = cityService.getAll(city)
        return PageInfo(countryList)
    }

    @RequestMapping("/add")
    fun add(): City
    {
        return City()
    }

    @RequestMapping("/view/{id}")
    fun view(@PathVariable id: Int?): City
    {
        return cityService.getById(id)
    }

    @RequestMapping("/delete/{id}")
    fun delete(@PathVariable id: Int?): ModelMap
    {
        val result = ModelMap()
        cityService.deleteById(id)
        result["msg"] = "删除成功!"
        return result
    }

    @RequestMapping(value = ["/save"], method = [RequestMethod.POST])
    fun save(city: City): ModelMap
    {
        val result = ModelMap()
        val msg = if (city.id == null) "新增成功!" else "更新成功!"
        cityService.save(city)
        result["city"] = city
        result["msg"] = msg
        return result
    }
}
