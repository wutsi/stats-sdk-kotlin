package com.wutsi.stats.dto

import java.time.LocalDate
import kotlin.Long
import kotlin.String

public data class StoryTraffic(
  public val name: String? = null,
  public val storyId: Long = 0,
  public val date: LocalDate = LocalDate.now(),
  public val value: Long = 0
)
