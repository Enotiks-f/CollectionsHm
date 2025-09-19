package com.example.collectionhm.exception;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException() {
        super("Хранилище для сотрудников заполнено");
    }

    public EmployeeStorageIsFullException(String message) {
        super(message);
    }
}
