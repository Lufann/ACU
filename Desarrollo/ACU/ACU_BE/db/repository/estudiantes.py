from sqlalchemy.orm import Session
from schemas.Estudiante import EstudianteCreate
from db.models.Estudiante import Estudiante
from core.hashing import Hasher


def create_new_estudiante(estudiante: EstudianteCreate, db: Session):
    estudiante = Estudiante(
        email=estudiante.email,
        hashed_password=Hasher.get_password_hash(estudiante.password),
        code=estudiante.code,
        names=estudiante.names,
        lastnames=estudiante.lastnames,
        profile_photo_url=estudiante.profile_photo_url,
        is_banned=False,
        is_superestudiante=estudiante.is_superestudiante
    )
    db.add(estudiante)
    db.commit()
    db.refresh(estudiante)
    return estudiante


def get_estudiante_by_code(code: str, db: Session):
    estudiante = db.query(Estudiante).filter(Estudiante.code == code).first()
    return estudiante


def get_estudiante_by_email(email: str, db: Session):
    estudiante = db.query(Estudiante).filter(Estudiante.email == email).first()
    return estudiante
