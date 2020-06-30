package com.example.BillMS.infrastructure;
import com.example.BillMS.domain.Bill;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BillRepository extends MongoRepository<Bill, String> {
}
