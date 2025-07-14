package com.ra.ss4.repository;

import com.ra.ss4.model.entity.BookB1;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookB1Repository extends JpaRepository<BookB1, String> {
    Page<BookB1> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}
