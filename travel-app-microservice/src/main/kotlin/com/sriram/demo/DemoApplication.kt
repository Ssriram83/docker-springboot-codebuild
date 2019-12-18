package com.sriram.demo

import org.hibernate.annotations.GenericGenerator
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.util.*
import javax.persistence.*

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}

@Entity
@Table(name = "bookings_table")

data class Bookings(@Id  @GeneratedValue(generator = "system-uuid")
                    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
                    val id: String? = null,
                    val bookedBy: String? = null,
                    val bookedOn: Date? = null,
                    val travelling_from: String? = null,
                    val travelling_to: String? = null
)

@RepositoryRestResource(collectionResourceRel = "bookings", path = "bookings")
public interface BookingsRepository : PagingAndSortingRepository<Bookings, Long>
