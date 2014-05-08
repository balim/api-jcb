package com.jcb.service

import com.jcb.domain.HolidayRequest

public interface HolidayRequestService {

    List<HolidayRequest> findAll(int start, int size)
    HolidayRequest findById(Long id)
    HolidayRequest save(HolidayRequest holidayRequest)
    void delete(HolidayRequest holidayRequest)

    HolidayRequest update(HolidayRequest holidayRequest)
}