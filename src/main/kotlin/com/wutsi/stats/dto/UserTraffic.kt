package com.wutsi.stats.dto

import java.time.LocalDate
import kotlin.Long
import kotlin.String

public data class UserTraffic(
  public val name: String? = null,
  public val userId: Long = 0,
  public val date: LocalDate = LocalDate.now(),
  public val `value`: Long = 0
)
