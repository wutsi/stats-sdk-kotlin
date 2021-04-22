package com.wutsi.stats

import kotlin.String

public enum class Environment(
  public val url: String
) {
  SANDBOX("https://wutsi-stats-test.herokuapp.com"),
  PRODUCTION("https://wutsi-stats-prod.herokuapp.com"),
  ;
}
