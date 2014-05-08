package com.jcb.service

import com.jcb.domain.HolidayRequest
import com.jcb.repository.HolidayRequestRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class HolidayRequestServiceImpl implements HolidayRequestService {
    @Autowired HolidayRequestRepository repository

    @Override
    List<HolidayRequest> findAll(int start, int size) {
        return repository.findAll(new PageRequest(start, size)) as List<HolidayRequest>
    }

    @Override
    HolidayRequest findById(Long id) {
        return repository.findOne(id)
    }

    @Override
    HolidayRequest save(HolidayRequest holidayRequest) {
        return repository.save(holidayRequest)
    }

    @Override
    void delete(HolidayRequest holidayRequest) {
        repository.delete(holidayRequest)
    }

    @Override
    HolidayRequest update(HolidayRequest holidayRequest) {
        return repository.save(holidayRequest)
    }
}
