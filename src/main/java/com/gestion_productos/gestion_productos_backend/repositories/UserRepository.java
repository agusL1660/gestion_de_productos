package com.gestion_productos.gestion_productos_backend.repositories;

import com.gestion_productos.gestion_productos_backend.models.entities.Category;
import com.gestion_productos.gestion_productos_backend.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
