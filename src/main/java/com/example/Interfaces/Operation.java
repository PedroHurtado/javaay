package com.example.Interfaces;

/*
 * Una inreface con un solo metodo en java se considera
 * interfae funcional
 * Operation<int> suma = (a,b)->a+b
 * suma.run(5,3) retorna un 8
 */
public interface Operation<T> {
    T run(T a,T b);
}
