package com.steelzack.b2b2bwebapp.model;

/**
 * Created by joao on 15-5-16.
 */
public class DetailConverter {

    public static Detail toDetail(DetailEntity detailEntity) {
        final Detail detail = Detail.builder().name(detailEntity.getName()).city(detailEntity.getCity()).build();
        return detail;
    }
}
