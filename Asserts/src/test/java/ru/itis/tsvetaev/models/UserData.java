package ru.itis.tsvetaev.models;

public record UserData(
        String login,
        String password,
        String path
) {
}
