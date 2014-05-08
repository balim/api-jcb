package com.jcb.controller

import com.jcb.domain.HolidayRequest
import com.jcb.service.HolidayRequestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/holiday-requests")
class HolidayRequestController {

    @Autowired HolidayRequestService holidayRequestService

//    def requests = new Vector()

	@RequestMapping
//	def findAll(@RequestParam(required = false) Integer start = 0, @RequestParam(required = false) Integer size = 50) {
	def findAll() {
        int start = 0, size = 50
        ["requests": holidayRequestService.findAll(start, size)]
	}

    @RequestMapping(method = RequestMethod.POST)
    def saveHolidayRequest(@RequestBody HolidayRequest holidayRequest){
        def dbEntity = holidayRequestService.save(holidayRequest)

        return [request: dbEntity]
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    def getHolidayRequest(@PathVariable Long id){
        HolidayRequest hr = holidayRequestService.findById(id)
        if(null == hr){ //not found
            throw new RuntimeException("No resource found with id " + id);
        }

        return [request: hr]
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    def deleteHolidayRequest(@PathVariable Long id){
        HolidayRequest hr = holidayRequestService.findById(id)
        if(null == hr){ //not found
            throw new RuntimeException("No resource found with id " + id);
        }

        holidayRequestService.delete(hr)
    }

    @RequestMapping(method = RequestMethod.PUT)
    def updateHolidayRequest(@RequestBody HolidayRequest hr){

        HolidayRequest dbEntity = holidayRequestService.update(hr)
        return [request: dbEntity]
    }
}