package com.twsihan.examples.services

import com.twsihan.examples.entities.Country
import tk.mybatis.mapper.weekend.Weekend
import com.github.pagehelper.PageHelper
import tk.mybatis.mapper.entity.Example
import com.twsihan.examples.mappers.CountryMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CountryService
{
    @Autowired
    private lateinit var countryMapper: CountryMapper


    fun getAll(country: Country): List<Country>
    {
        if (country.page != null && country.rows != null) {
            PageHelper.startPage<Any>(country.page, country.rows)
        }
        val example = Example(Country::class.java)
        val criteria = example.createCriteria()
        if (country.countryname!!.isNotEmpty()) {
            criteria.andLike("countryname", "%" + country.countryname + "%")
        }
        if (country.countrycode!!.isNotEmpty()) {
            criteria.andLike("countrycode", "%" + country.countrycode + "%")
        }
        return countryMapper.selectByExample(example)
    }

    fun getAllByWeekend(country: Country): List<Country>
    {
        if (country.page != null && country.rows != null) {
            PageHelper.startPage<Any>(country.page, country.rows)
        }
        val weekend = Weekend.of(Country::class.java)
        val criteria = weekend.weekendCriteria()
        if (country.countryname!!.isNotEmpty()) {
            criteria.andLike(country.countryname, "%" + country.countryname + "%")
        }
        if (country.countrycode!!.isNotEmpty()) {
            criteria.andLike(country.countrycode, "%" + country.countrycode + "%")
        }
        return countryMapper.selectByExample(weekend)
    }

    fun getById(id: Int?): Country
    {
        return countryMapper.selectByPrimaryKey(id)
    }

    fun deleteById(id: Int?)
    {
        countryMapper.deleteByPrimaryKey(id)
    }

    fun save(country: Country)
    {
        if (country.id != null) {
            countryMapper.updateByPrimaryKey(country)
        } else {
            countryMapper.insert(country)
        }
    }
}
