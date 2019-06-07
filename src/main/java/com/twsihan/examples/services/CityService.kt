package com.twsihan.examples.services

import com.twsihan.examples.mappers.CityMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.twsihan.examples.entities.City
import com.github.pagehelper.PageHelper

@Service
class CityService
{
    @Autowired
    private lateinit var cityMapper: CityMapper


    fun getAll(city: City): List<City>
    {
        if (city.page != null && city.rows != null) {
            PageHelper.startPage<Any>(city.page, city.rows)
        }
        return cityMapper.selectAll()
    }

    fun getById(id: Int?): City
    {
        return cityMapper.selectByPrimaryKey(id)
    }

    fun deleteById(id: Int?)
    {
        cityMapper.deleteByPrimaryKey(id)
    }

    fun save(country: City)
    {
        if (country.id != null) {
            cityMapper.updateByPrimaryKey(country)
        } else {
            cityMapper.insert(country)
        }
    }
}
