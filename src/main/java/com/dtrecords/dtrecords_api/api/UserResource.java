package com.dtrecords.dtrecords_api.api;

import com.dtrecords.dtrecords_api.domain.Role;
import com.dtrecords.dtrecords_api.domain.User;
import com.dtrecords.dtrecords_api.service.RoleService;
import com.dtrecords.dtrecords_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "https://detran-records.netlify.app")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserResource {
    private final RoleService roleService;
    private final UserService userService;

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getRoles() {
        return ResponseEntity.ok().body(roleService.findAll());
    }

    @GetMapping("/admin/users")
    public ResponseEntity<List<User>> listAllUser() {
        List<User> users = userService.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        Optional<User> user = userService.findById(id);
        if (!user.isPresent()) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user.get(), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        user.setRoles(new ArrayList<>());
        userService.save(user);
        userService.addRoleToUser(user.getEmail(),"ROLE_USER");
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        Optional<User> currentUser = userService.findById(id);
        if (!currentUser.isPresent()) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        currentUser.get().setName(user.getName());
        currentUser.get().setUserName(user.getUserName());
        currentUser.get().setPassword(user.getPassword());
        currentUser.get().setEmail(user.getEmail());
        currentUser.get().setAddress(user.getAddress());

        userService.save(currentUser.get());
        return new ResponseEntity<User>(currentUser.get(), HttpStatus.OK);
    }

    @PutMapping("/admin/user/setAdmin/{id}")
    public ResponseEntity<User> setAdminRole(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        if (!user.isPresent()) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        userService.addRoleToUser(user.get().getEmail(),"ROLE_ADMIN");
        return new ResponseEntity<User>(user.get(), HttpStatus.OK);
    }

    @PutMapping("/admin/user/removeAdmin/{id}")
    public ResponseEntity<User> removeAdminRole(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        if (!user.isPresent()) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        userService.deleteRoleToUser(user.get().getEmail(),"ROLE_ADMIN");
        return new ResponseEntity<User>(user.get(), HttpStatus.OK);
    }

    @DeleteMapping("/admin/user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        if (!user.isPresent()) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        userService.remove(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
}
