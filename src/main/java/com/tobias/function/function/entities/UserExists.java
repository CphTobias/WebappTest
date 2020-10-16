package com.tobias.function.function.entities;

import com.tobias.function.function.layer.LoginSampleException;

public class UserExists extends Exception {
    public UserExists(String name) throws LoginSampleException {
        /*
        Called when creating a new user in Register, LogicFacade and UserHandler respectively
         */
        super("User already exists: " + name);
    }
}