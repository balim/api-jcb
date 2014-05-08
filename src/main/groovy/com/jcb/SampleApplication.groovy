/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jcb

import com.jcb.domain.HolidayRequest
import com.jcb.repository.HolidayRequestRepository
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Configuration
@EnableAutoConfiguration
@ComponentScan
@RestController
class SampleApplication {

	@RequestMapping("/")
	def helloWorld() {
		[message: "Hello World"]
	}

	static void main(String[] args) throws Exception {
        def context = SpringApplication.run(SampleApplication.class, args)
        def repository = context.getBean(HolidayRequestRepository.class)

        repository.save(new HolidayRequest(employeeName: "Kelly Smith", employeeId: 123, startDate: new Date()-15, endDate: new Date() - 7))
        repository.save(new HolidayRequest(employeeName: "Bebo Norman", employeeId: 234, startDate: new Date()-9, endDate: new Date() - 6))
        repository.save(new HolidayRequest(employeeName: "Little Snitch", employeeId: 345, startDate: new Date()+15, endDate: new Date() + 18))
        repository.save(new HolidayRequest(employeeName: "Jay Leno", employeeId: 456, startDate: new Date(), endDate: new Date() + 7))

        assert repository.count() > 0
	}

}
