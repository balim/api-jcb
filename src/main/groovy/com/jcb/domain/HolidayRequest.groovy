package com.jcb.domain

import groovy.transform.EqualsAndHashCode

import java.text.SimpleDateFormat

@EqualsAndHashCode
class HolidayRequest {
    Long id //PK
    Long employeeId
    String employeeName
    Date startDate
    Date endDate


    String getStartDate(){
        new SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss'Z'").format(startDate)
    }

    String getEndDate(){
        new SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss'Z'").format(endDate)
    }
}
