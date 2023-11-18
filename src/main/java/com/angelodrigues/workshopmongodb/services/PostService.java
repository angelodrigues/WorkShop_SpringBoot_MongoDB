package com.angelodrigues.workshopmongodb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angelodrigues.workshopmongodb.domain.Post;
import com.angelodrigues.workshopmongodb.repository.PostRepository;
import com.angelodrigues.workshopmongodb.services.expection.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}