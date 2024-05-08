package com.hacen.evenements.service;

import com.hacen.evenements.model.Role;
import com.hacen.evenements.model.User;

public interface UserService {
void deleteAllusers();
void deleteAllRoles();
User saveUser(User user);
User findUserByUsername (String username);
Role addRole(Role role);
User addRoleToUser(String username, String rolename);
}
