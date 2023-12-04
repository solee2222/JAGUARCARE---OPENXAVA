package com.uam.CLINICA.model;

import javax.persistence.*;

import lombok.*;

@Embeddable
@Getter
@Setter
public class Telefono {

    private String identificadorPais;
    private String numeroTelefono;
}
