package com.wutsi.stats.dto

import kotlin.collections.List

public data class SearchViewResponse(
  public val views: List<View> = emptyList()
)
