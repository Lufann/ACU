
from sqlalchemy.orm import Session
from schemas.Platillo import PlatilloCreate
from db.models.Platillo import Platillo


def create_new_platillo(Platillo: PlatilloCreate, db: Session):
    Platillo_object = Platillo(**Platillo.dict())
    db.add(Platillo_object)
    db.commit()
    db.refresh(Platillo_object)
    return Platillo_object


def retreive_platillo(id: int, db: Session):
    item = db.query(Platillo).filter(Platillo.id == id).first()
    return item


def retreive_all_platillos(db: Session):
    Platillos = db.query(Platillo).all()
    return Platillos
