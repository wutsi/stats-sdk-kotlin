package com.wutsi.stats

import com.wutsi.stats.dto.SearchStoryKpiResponse
import com.wutsi.stats.dto.SearchStoryTrafficResponse
import com.wutsi.stats.dto.SearchUserKpiResponse
import com.wutsi.stats.dto.SearchUserTrafficResponse
import com.wutsi.stats.dto.SearchViewResponse
import feign.Param
import feign.RequestLine
import java.time.LocalDate
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Unit

public interface StatsApi {
  @RequestLine("GET /v1/views?story-id={story-id}&user-id={user-id}&device-id={device-id}&start-date={start-date}&end-date={end-date}&limit={limit}&offset={offset}")
  public fun views(
    @Param("story-id") storyId: Long? = null,
    @Param("user-id") userId: Long? = null,
    @Param("device-id") deviceId: String? = null,
    @Param("start-date") startDate: LocalDate? = null,
    @Param("end-date") endDate: LocalDate? = null,
    @Param("limit") limit: Int = 20,
    @Param("offset") offset: Int = 0
  ): SearchViewResponse

  @RequestLine("GET /v1/replay/daily?start-date={start-date}&end-date={end-date}")
  public fun replayDaily(@Param("start-date") startDate: LocalDate, @Param("end-date")
      endDate: LocalDate? = null): Unit

  @RequestLine("GET /v1/replay/monthly?start-date={start-date}&end-date={end-date}")
  public fun replayMonthly(@Param("start-date") startDate: LocalDate, @Param("end-date")
      endDate: LocalDate? = null): Unit

  @RequestLine("GET /v1/kpis/stories/daily?story-id={story-id}&user-id={user-id}&type={type}&start-date={start-date}&end-date={end-date}&limit={limit}&offset={offset}")
  public fun storyDailyKpis(
    @Param("story-id") storyId: Long? = null,
    @Param("user-id") userId: Long? = null,
    @Param("type") type: String? = null,
    @Param("start-date") startDate: LocalDate? = null,
    @Param("end-date") endDate: LocalDate? = null,
    @Param("limit") limit: Int = 20,
    @Param("offset") offset: Int = 0
  ): SearchStoryKpiResponse

  @RequestLine("GET /v1/kpis/stories/monthly?story-id={story-id}&user-id={user-id}&type={type}&year={year}&month={month}&limit={limit}&offset={offset}")
  public fun storyMonthlyKpis(
    @Param("story-id") storyId: Long? = null,
    @Param("user-id") userId: Long? = null,
    @Param("type") type: String? = null,
    @Param("year") year: Int,
    @Param("month") month: Int? = null,
    @Param("limit") limit: Int = 20,
    @Param("offset") offset: Int = 0
  ): SearchStoryKpiResponse

  @RequestLine("GET /v1/kpis/users/{user-id}/monthly?user-id={user-id}&type={type}&year={year}&month={month}&limit={limit}&offset={offset}")
  public fun userMonthlyKpis(
    @Param("user-id") userId: Long,
    @Param("type") type: String,
    @Param("year") year: Int,
    @Param("month") month: Int? = null,
    @Param("limit") limit: Int = 20,
    @Param("offset") offset: Int = 0
  ): SearchUserKpiResponse

  @RequestLine("GET /v1/traffics/users/{user-id}/monthly?user-id={user-id}&year={year}&month={month}&limit={limit}&offset={offset}")
  public fun userMonthlyTraffic(
    @Param("user-id") userId: Long,
    @Param("year") year: Int,
    @Param("month") month: Int? = null,
    @Param("limit") limit: Int = 20,
    @Param("offset") offset: Int = 0
  ): SearchUserTrafficResponse

  @RequestLine("GET /v1/traffics/stories/{story-id}/monthly?story-id={story-id}&year={year}&month={month}&limit={limit}&offset={offset}")
  public fun storyMonthlyTraffic(
    @Param("story-id") storyId: Long,
    @Param("year") year: Int,
    @Param("month") month: Int? = null,
    @Param("limit") limit: Int = 20,
    @Param("offset") offset: Int = 0
  ): SearchStoryTrafficResponse

  @RequestLine("GET /v1/stories/import")
  public fun importStories(): Unit
}
