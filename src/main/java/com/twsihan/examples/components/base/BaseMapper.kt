package com.twsihan.examples.components.base

import tk.mybatis.mapper.common.Mapper
import tk.mybatis.mapper.common.MySqlMapper

interface BaseMapper<T>: Mapper<T>, MySqlMapper<T>
