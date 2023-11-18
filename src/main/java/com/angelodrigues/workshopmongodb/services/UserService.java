package com.angelodrigues.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angelodrigues.workshopmongodb.domain.User;
import com.angelodrigues.workshopmongodb.dto.UserDTO;
import com.angelodrigues.workshopmongodb.repository.UserRepository;
import com.angelodrigues.workshopmongodb.services.expection.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }


    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj){
        return repo.insert(obj);
    }

    public void delete(String id){
        repo.deleteById(id);
    }

    public User update(User obj){
        User newObj = findById(obj.getId());
        updateData(newObj,obj);
        return repo.save(newObj);
    }

    public void updateData(User newObj, User obj){
        newObj.setEmail(obj.getEmail());
        newObj.setName(obj.getName());
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}