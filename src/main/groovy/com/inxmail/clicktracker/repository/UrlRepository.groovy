package com.inxmail.clicktracker.repository

import com.inxmail.clicktracker.entity.Url
import org.springframework.data.repository.CrudRepository
import javax.transaction.Transactional

@Transactional
public interface UrlRepository extends CrudRepository<Url, Long> {


}
