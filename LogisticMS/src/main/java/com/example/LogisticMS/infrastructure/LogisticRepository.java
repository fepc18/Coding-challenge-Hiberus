package com.example.LogisticMS.infrastructure;
import com.example.LogisticMS.domain.Logistic;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogisticRepository extends MongoRepository<Logistic, String> {
}
