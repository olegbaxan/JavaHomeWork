package com.step.PersonManagerSpringBackend.repository;

import com.step.PersonManagerSpringBackend.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository  extends JpaRepository<Invoice, Integer> {
}
