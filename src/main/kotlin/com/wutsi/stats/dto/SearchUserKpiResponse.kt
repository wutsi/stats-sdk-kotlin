package com.wutsi.stats.dto

import kotlin.collections.List

public data class SearchUserKpiResponse(
  public val kpis: List<UserKpi> = emptyList()
)
