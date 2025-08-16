package com.BookStore.service;

import com.BookStore.dto.PublisherRequestDTO;
import com.BookStore.dto.PublisherResponseDTO;
import com.BookStore.entity.Publisher;

import java.util.List;

public interface PublisherService {
    List<PublisherResponseDTO> getAllPublisher();
    PublisherResponseDTO getAllPublisherById(Long id);
    Publisher savePublisher(PublisherRequestDTO b);
    Boolean deletePublisherById(Long id);

}
