package sample

import com.jcb.domain.HolidayRequest
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/holiday-requests")
class HolidayRequestController {

    def requests = new Vector()

	@RequestMapping
	def findAll() {
		["requests": getAll()]
	}

    @RequestMapping(method = RequestMethod.POST)
    def saveHolidayRequest(@RequestBody HolidayRequest holidayRequest){
        if(!requests.contains(holidayRequest)){
            holidayRequest.id = System.nanoTime()
            requests.add(holidayRequest)
        }

        return [request: holidayRequest]
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    def getHolidayRequest(@PathVariable Long id){
        HolidayRequest hr = requests.find{ it.id == id } as HolidayRequest
        if(null == hr){ //not found
            throw new RuntimeException("No resource found with id " + id);
        }

        return [request: hr]
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    def deleteHolidayRequest(@PathVariable Long id){
        HolidayRequest hr = requests.find{ it.id == id } as HolidayRequest
        if(null == hr){ //not found
            throw new RuntimeException("No resource found with id " + id);
        }

        requests.remove(hr)
    }

    @RequestMapping(method = RequestMethod.PUT)
    def updateHolidayRequest(@RequestBody HolidayRequest hr){

        requests.removeAll{ it.id == hr.id }
        requests.add(hr)
        return [request: hr]

    }

    //TODO, read from DB
    def getAll(){
        requests
    }

}