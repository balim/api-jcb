package com.jcb.domain

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class HolidayRequest {
    Long id //PK
    Long employeeId
    String employeeName
    Date startDate
    Date endDate
}
