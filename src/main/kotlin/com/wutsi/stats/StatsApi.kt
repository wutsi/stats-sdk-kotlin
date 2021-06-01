package com.wutsi.stats

import com.wutsi.stats.dto.SearchStoryKpiResponse
import com.wutsi.stats.dto.SearchStoryTrafficResponse
import com.wutsi.stats.dto.SearchUserKpiResponse
import com.wutsi.stats.dto.SearchUserTrafficResponse
import com.wutsi.stats.dto.SearchViewResponse
import feign.Headers
import feign.Param
import feign.RequestLine
import java.time.LocalDate
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Unit

public interface StatsApi {
  @RequestLine("GET /v1/views?story-id={story-id}&user-id={user-id}&device-id={device-id}&start-date={start-date}&end-date={end-date}&limit={limit}&offset={offset}")
  @Headers("Content-Type: application/json")
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
  @Headers("Content-Type: application/json")
  public fun replayDaily(@Param("start-date") startDate: LocalDate, @Param("end-date")
      endDate: LocalDate? = null): Unit

  @RequestLine("GET /v1/replay/monthly?start-date={start-date}&end-date={end-date}")
  @Headers("Content-Type: application/json")
  public fun replayMonthly(@Param("start-date") startDate: LocalDate, @Param("end-date")
      endDate: LocalDate? = null): Unit

  @RequestLine("GET /v1/kpis/stories/daily?story-id={story-id}&user-id={user-id}&type={type}&start-date={start-date}&end-date={end-date}&limit={limit}&offset={offset}")
  @Headers("Content-Type: application/json")
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
  @Headers("Content-Type: application/json")
  public fun storyMonthlyKpis(
    @Param("story-id") storyId: Long? = null,
    @Param("user-id") userId: Long? = null,
    @Param("type") type: String? = null,
    @Param("year") year: Int,
    @Param("month") month: Int? = null,
    @Param("limit") limit: Int = 20,
    @Param("offset") offset: Int = 0
  ): SearchStoryKpiResponse

  @RequestLine("GET /v1/kpis/users/{user-id}/monthly?type={type}&year={year}&month={month}&limit={limit}&offset={offset}")
  @Headers("Content-Type: application/json")
  public fun userMonthlyKpis(
    @Param("user-id") userId: Long,
    @Param("type") type: String,
    @Param("year") year: Int,
    @Param("month") month: Int? = null,
    @Param("limit") limit: Int = 20,
    @Param("offset") offset: Int = 0
  ): SearchUserKpiResponse

  @RequestLine("GET /v1/kpis/users/{user-id}/monthly/email?date={date}")
  @Headers("Content-Type: application/json")
  public fun emailUserMonthlyKpis(@Param("user-id") userId: Long, @Param("date") date: LocalDate):
      Unit

  @RequestLine("GET /v1/kpis/users/monthly/email?date={date}")
  @Headers("Content-Type: application/json")
  public fun emailMonthlyKpis(@Param("date") date: LocalDate): Unit

  @RequestLine("GET /v1/traffics/users/{user-id}/monthly?year={year}&month={month}&limit={limit}&offset={offset}")
  @Headers("Content-Type: application/json")
  public fun userMonthlyTraffic(
    @Param("user-id") userId: Long,
    @Param("year") year: Int,
    @Param("month") month: Int? = null,
    @Param("limit") limit: Int = 20,
    @Param("offset") offset: Int = 0
  ): SearchUserTrafficResponse

  @RequestLine("GET /v1/traffics/stories/{story-id}/monthly?year={year}&month={month}&limit={limit}&offset={offset}")
  @Headers("Content-Type: application/json")
  public fun storyMonthlyTraffic(
    @Param("story-id") storyId: Long,
    @Param("year") year: Int,
    @Param("month") month: Int? = null,
    @Param("limit") limit: Int = 20,
    @Param("offset") offset: Int = 0
  ): SearchStoryTrafficResponse

  @RequestLine("GET /v1/stories/import")
  @Headers("Content-Type: application/json")
  public fun importStories(): Unit
}
