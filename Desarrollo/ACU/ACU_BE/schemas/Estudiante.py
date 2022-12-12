from typing import Optional
from pydantic import BaseModel, EmailStr


class EstudianteCreate(BaseModel):
    codigo_estudiante: str
    correo: EmailStr
    password: str
    nombres: str
    apellido_pat: str
    apellido_mat: str
    foto_url: str
    esta_penalizado: bool


class ShowEstudiante(BaseModel):
    email: EmailStr
    codigo_estudiante: str
    esta_penalizado: bool

    class Config():  # convert dict or non dict obj to json
        orm_mode = True


class ShowFullEstudiante(BaseModel):
    email: EmailStr
    codigo_estudiante: str
    nombres: str
    apellido_pat: str
    apellido_mat: str
    foto_url: str

    class Config():  # convert dict or non dict obj to json
        orm_mode = True
