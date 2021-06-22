package com.wutsi.stats.dto

import java.time.OffsetDateTime
import kotlin.Int
import kotlin.Long
import kotlin.String

public data class View(
  public val id: Long = 0,
  public val storyId: Long = 0,
  public val userId: Long? = null,
  public val deviceId: String? = null,
  public val hitId: String = "",
  public val source: String? = null,
  public val medium: String? = null,
  public val campaign: String? = null,
  public val referer: String? = null,
  public val viewDateTime: OffsetDateTime = OffsetDateTime.now(),
  public val traffic: String? = null,
  public val readTimeSeconds: Int = 0
)
