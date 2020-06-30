package com.example.CheckoutTS.infrastructure;
import com.example.CheckoutTS.domain.CheckOut;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CheckoutRepository extends MongoRepository<CheckOut, String> {
}
