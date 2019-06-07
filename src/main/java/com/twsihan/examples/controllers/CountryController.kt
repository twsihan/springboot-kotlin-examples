package com.twsihan.examples.controllers

import org.springframework.web.servlet.ModelAndView
import com.twsihan.examples.entities.Country
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import org.springframework.web.bind.annotation.PathVariable
import com.github.pagehelper.PageInfo
import com.twsihan.examples.services.CountryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller

@Controller
class CountryController
{
    @Autowired
    private lateinit var countryService: CountryService


    @RequestMapping
    fun getAll(country: Country): ModelAndView
    {
        val result = ModelAndView("index")
        val countryList = countryService.getAll(country)
        result.addObject("pageInfo", PageInfo(countryList))
        result.addObject("queryParam", country)
        result.addObject("page", if (country.page != null) country.page else 1)
        result.addObject("rows", if (country.rows != null) country.rows else 0)
        return result
    }

    @RequestMapping("/add")
    fun add(): ModelAndView
    {
        val result = ModelAndView("view")
        result.addObject("country", Country())
        return result
    }

    @RequestMapping("/view/{id}")
    fun view(@PathVariable id: Int?): ModelAndView
    {
        val result = ModelAndView("view")
        val country = countryService.getById(id)
        result.addObject("country", country)
        return result
    }

    @RequestMapping("/delete/{id}")
    fun delete(@PathVariable id: Int?, ra: RedirectAttributes): ModelAndView
    {
        val result = ModelAndView("redirect:/countries")
        countryService.deleteById(id)
        ra.addFlashAttribute("msg", "删除成功!")
        return result
    }

    @RequestMapping(value = ["/save"], method = [RequestMethod.POST])
    fun save(country: Country): ModelAndView
    {
        val result = ModelAndView("view")
        val msg = if (country.id == null) "新增成功!" else "更新成功!"
        countryService.save(country)
        result.addObject("country", country)
        result.addObject("msg", msg)
        return result
    }
}
