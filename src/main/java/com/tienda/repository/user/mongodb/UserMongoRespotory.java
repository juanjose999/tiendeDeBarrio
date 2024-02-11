package com.tienda.repository.user.mongodb;

import com.tienda.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoRespotory extends MongoRepository<User, String> {
}
