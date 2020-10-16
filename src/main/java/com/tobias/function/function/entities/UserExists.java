package com.tobias.function.function.entities;

import com.tobias.function.function.layer.LoginSampleException;

public class UserExists extends Exception {
    public UserExists(String name) throws LoginSampleException {
        //super("User already exists: " + name);
        String msg = "User already exists: " + name;
        throw new LoginSampleException(msg);
    }
}