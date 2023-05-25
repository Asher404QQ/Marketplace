package ru.kors.marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kors.marketplace.models.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
