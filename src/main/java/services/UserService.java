package services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRepository;
import entities.User;
import exceptions.ResourceNotFoundException;

@Service
public class UserService {
    
	@Autowired
    private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
    }

	public void delete(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
    }

	public <S extends User> S save(S entity) {
		return userRepository.save(entity);
	}
	
	public User update(Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            return userRepository.save(user);
        } else {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
    }

}
