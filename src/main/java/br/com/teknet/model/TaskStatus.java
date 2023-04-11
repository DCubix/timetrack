package br.com.teknet.model;

import lombok.ToString;

@ToString
public enum TaskStatus {
    DOING,
    DONE,
    CANCELLED,
    DELETED
}
