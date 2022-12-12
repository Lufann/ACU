package models

class Estudiante(
    val codigo_estudiante: String,
    val correo: String,
    val password: String,
    val nombres: String,
    val apellido_pat: String,
    val apellido_mat: String,
    val foto_url: String,
    val esta_penalizado: Boolean,
    val es_jedi: Boolean
)