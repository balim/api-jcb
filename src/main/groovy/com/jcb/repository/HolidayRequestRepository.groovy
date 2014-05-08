package com.jcb.repository

import com.jcb.domain.HolidayRequest
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository

//public interface HolidayRequestRepository extends CrudRepository<HolidayRequest, Long> {
public interface HolidayRequestRepository extends PagingAndSortingRepository<HolidayRequest, Long> {
}