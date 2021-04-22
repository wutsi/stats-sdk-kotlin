package com.wutsi.stats.dto

import kotlin.collections.List

public data class SearchStoryKpiResponse(
  public val kpis: List<StoryKpi> = emptyList()
)
