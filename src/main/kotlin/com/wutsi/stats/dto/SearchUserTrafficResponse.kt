package com.wutsi.stats.dto

import kotlin.collections.List

public data class SearchUserTrafficResponse(
  public val traffics: List<UserTraffic> = emptyList()
)
