package com.fatec.ite.Concessionaria.exceptions.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Calendar;

@Data
@AllArgsConstructor
public class StandardError {

    private Integer status;
    private String msg;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Calendar timeStamp;
}
