package com.tobias.function.api.factories;

import com.tobias.function.exceptions.ValidationError;

import javax.validation.ValidationException;
import java.time.LocalDateTime;

public class UserFactory {

    /*
    private final int id;
    private final String name;
    private final String email;
    private final LocalDateTime createdAt;
    private final byte[] salt;
    private final byte[] secret;
    private String role;
    private final double bank;
    private boolean banned;
    private int ranked;
     */

    private int id;
    private String name;
    private String password;
    private String password2;
    private String email;
    private LocalDateTime createdAt;
    private byte[] salt;
    private byte[] secret;
    private String role;
    private double bank;
    private boolean banned;
    private int ranked;
    private String answer;

    public boolean isValid(UserFactory userFactory){
        if(userFactory == null){
            return false;
        } else {
            return true;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws ValidationError {
        if(id < 0) throw new ValidationError("The id cannot be less than 0");
        this.id = id;
    }

    public void setId(String number) throws ValidationError {
        try {
            setId(Integer.parseInt(number));
        } catch (NumberFormatException e) {
            throw new ValidationError(e.toString());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getPassword2() {
        return password2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedAt(String ldt) throws ValidationError {
        try {
            setCreatedAt(LocalDateTime.parse(ldt));
        } catch (NumberFormatException e) {
            throw new ValidationError(e.toString());
        }
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public byte[] getSecret() {
        return secret;
    }

    public void setSecret(byte[] secret) {
        this.secret = secret;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getBank() {
        return bank;
    }

    public void setBank(double bank) throws ValidationError {
        if(bank < 0) throw new ValidationError("You are not supposed to have less than 0 $ in your bank");
        this.bank = bank;
    }

    public void setBank(String number) throws ValidationError {
        try {
            setBank(Double.parseDouble(number));
        } catch (NumberFormatException e) {
            throw new ValidationError(e.toString());
        }
    }

    public void setBank(String amount, String userbank) throws ValidationError {
        if(getAnswer().equals("add")){
            setBank(Double.parseDouble(amount) + Double.parseDouble(userbank));
        } else {
            double remove = Double.parseDouble(userbank) - Double.parseDouble(amount);
            if (remove < 0) {
                remove = 0;
            }
            setBank(remove);
        }
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public void setBanned(String banned) throws ValidationError {
        try {
            setBanned(banned.equals("1") || banned.equals("true"));
        } catch (IllegalArgumentException e) {
            throw new ValidationError(e.getMessage());
        }
    }

    public int getRanked() {
        return ranked;
    }

    public void setRanked(int ranked) throws ValidationError {
        if(ranked < 0) throw new ValidationError("You somehow managed to get a rank of less than 0");
        this.ranked = ranked;
    }

    public void setRanked(String number) throws ValidationError {
        try {
            setRanked(Integer.parseInt(number));
        } catch (NumberFormatException e) {
            throw new ValidationError(e.toString());
        }
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
}
