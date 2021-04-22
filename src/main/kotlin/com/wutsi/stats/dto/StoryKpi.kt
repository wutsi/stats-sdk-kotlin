package com.wutsi.stats.dto

import java.time.LocalDate
import kotlin.Long
import kotlin.String

public data class StoryKpi(
  public val id: Long = 0,
  public val storyId: Long = 0,
  public val type: String = "",
  public val date: LocalDate = LocalDate.now(),
  public val value: Long = 0
)
