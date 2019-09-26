package psoft.lab02.util;

import psoft.lab02.entities.disciplina.Disciplina;

import java.util.Comparator;

public class DisciplinaComparatorLike implements Comparator {
    @Override
    public int compare(Object o1, Object o2){
        Disciplina d1 = (Disciplina) o1;
        Disciplina d2 = (Disciplina) o2;
        return d2.getLikes().compareTo(d1.getLikes());
    }
}
