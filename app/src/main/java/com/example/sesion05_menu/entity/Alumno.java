package com.example.sesion05_menu.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Alumno {

    private String nombre;
    private String apellido;
    private String dni;
    private String correo;
    private String fechanac;
    private String fechareg;


}
