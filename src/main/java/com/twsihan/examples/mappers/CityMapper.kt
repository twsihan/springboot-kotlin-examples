package com.twsihan.examples.mappers

import com.twsihan.examples.entities.City
import com.twsihan.examples.components.base.BaseMapper
import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Repository

@Mapper
@Repository
interface CityMapper : BaseMapper<City>
