package resources;

import org.springframework.beans.factory.annotation.Autowired;

import services.UserService;

@RestController
@RequestMapping(value = "/users")

public class UserResource {
	@Autowired
    private UserService userService;

}
