package com.jcb.domain

import groovy.transform.EqualsAndHashCode

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import java.text.SimpleDateFormat

@EqualsAndHashCode
@Entity
class HolidayRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
