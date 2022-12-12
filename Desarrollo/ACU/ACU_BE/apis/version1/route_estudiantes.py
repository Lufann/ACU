from fastapi import APIRouter
from sqlalchemy.orm import Session
from fastapi import Depends

from db.models.Estudiante import Estudiante
from schemas.Estudiante import EstudianteCreate, ShowEstudiante, ShowFullEstudiante
from db.session import get_db
from db.repository.estudiantes import create_new_estudiante, get_estudiante_by_code
from apis.version1.route_login import get_current_estudiante_from_token
from fastapi import status, HTTPException

router = APIRouter()


@router.post("/create-Estudiante/", response_model=ShowEstudiante)
def create_estudiante(estudiante: EstudianteCreate, db: Session = Depends(get_db), current_estudiante: Estudiante = Depends(get_current_estudiante_from_token)):
    if current_estudiante.is_superEstudiante:
        estudiante = create_new_estudiante(estudiante=estudiante, db=db)
        return estudiante
    raise HTTPException(
        status_code=status.HTTP_401_UNAUTHORIZED,
        detail=f"Usuario con codigo {current_estudiante.code} no tiene autorizacion para crear nuevos usuarios"
    )


@router.get("/read-Estudiante", response_model=ShowFullEstudiante)
def read_estudiante_from_token(db: Session = Depends(get_db), current_estudiante: Estudiante = Depends(get_current_estudiante_from_token)):
    estudiante = get_estudiante_by_code(current_estudiante.code, db=db)
    return estudiante
