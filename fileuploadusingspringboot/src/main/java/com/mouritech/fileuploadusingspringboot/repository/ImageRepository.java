package com.mouritech.fileuploadusingspringboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.fileuploadusingspringboot.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long>{
	
	Optional<Image> findByItem_ItemId(Long itemId);
	Optional<Image> findByImageIdAndItem_ItemId(Long imageId, Long itemId);

}
