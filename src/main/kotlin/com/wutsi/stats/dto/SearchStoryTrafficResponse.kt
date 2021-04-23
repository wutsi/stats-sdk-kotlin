package com.wutsi.stats.dto

import kotlin.collections.List

public data class SearchStoryTrafficResponse(
  public val traffics: List<StoryTraffic> = emptyList()
)
