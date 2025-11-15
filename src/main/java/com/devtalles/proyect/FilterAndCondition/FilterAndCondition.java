package com.devtalles.proyect.FilterAndCondition;

import io.reactivex.rxjava3.core.Observable;

public class FilterAndCondition {
    public static void main(String[] args) {

        //filter
        Observable<Integer> ages = Observable.just(10, 20, 30, 12, 14, 18, 60, 70);

        ages.filter((age) -> age >= 21).subscribe(System.out::println);

        //distinc
        ages.distinct().subscribe(System.out::println);

        //take
        ages.take(2).subscribe(System.out::println);

        //take while
        ages.takeWhile((age) -> age < 20).subscribe(System.out::println);



    }
}
